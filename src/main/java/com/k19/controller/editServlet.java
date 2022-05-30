package com.k19.controller;

import java.io.IOException;

import javax.persistence.Entity;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.k19.DAO.userDao;
import com.k19.models.Users;
import com.k19.utils.EmailUtility;

@WebServlet(urlPatterns = { "/editVerify" })
public class editServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String host;
    private String port;
    private String username;
    private String pass;
    private userDao userdao;

    // init
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        username = context.getInitParameter("username");
        pass = context.getInitParameter("pass");
    }     
    public editServlet() {
        this.userdao = new userDao();
    }

    // [GET] /edit/confirm
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    // [POST] /edit/confirm
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        // get action
        String action = request.getParameter("action");
        int _id = Integer.parseInt(request.getParameter("_id"));
        // get entity need edit
        // error do thang session return null
        // memberJPA memberEdit = (memberJPA) session.getAttribute("memberEdit");
        System.out.println(session.getAttribute("memberEdit"));
        // memberJPA memberEdit = this.mjdao.selectMemberbyId(_id);
        Users userEdit = userDao.selectUserById(_id);
        //
        if (userEdit != null) {
            String url="";
            if (action.equals(null)) {
                action = "cancel";
            }
            if (action.equals("edit")) {
                // get data
                String firstName=request.getParameter("firstName");
                String lastName=request.getParameter("lastName");
                String gentle=request.getParameter("gentle");
                String email = request.getParameter("email");
                // String password = request.getParameter("password");
                String contact=request.getParameter("contact");
                String resultMessage = "";
                String code = EmailUtility.getRandom();
                boolean test;
                try {
                    userEdit.setCode(code);
                    test = EmailUtility.sendEmail(host, port, username, pass, email, "Email Verification",
                                 "Registered successfully.Please verify your account using this code: " + userEdit.getCode());
                   
                } catch (Exception e) {
                    //TODO: handle exception
                    test=false;
                }
                if(test)
                {
                    url ="/verifyEdit.jsp";
                    userEdit.setGmail(email);
                    userEdit.setFirstName(firstName);
                    userEdit.setLastName(lastName);
                    userEdit.setContact(contact);
                    userEdit.setGentle(gentle);
                    resultMessage = "We already send a verification  code to your email.";
                }
                else{
                    resultMessage = "There were an error. Please try again!";
                    
                    url="/member/edit.jsp";
                }
                session.setAttribute("userEdit", userEdit);
                request.setAttribute("mess", resultMessage);
                getServletContext().getRequestDispatcher("/WEB-INF/views" + url).forward((ServletRequest) request,
                (ServletResponse) response);
                
            } else if (action.equals("cancel")) {
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else {
            System.out.println("Select member by id method return null");
            getServletContext().getRequestDispatcher("/WEB-INF/views/member/edit.jsp").forward((ServletRequest) request,
            (ServletResponse) response);
            
        }
    }
}
