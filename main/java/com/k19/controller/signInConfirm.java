package com.k19.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.k19.DAO.userDao;
import com.k19.models.Users;
import com.mysql.cj.Session;

@WebServlet(name = "loginConfirm", urlPatterns = { "/sign-in/confirm" })
public class signInConfirm extends HttpServlet {
        // [GET] /member/sign-in/confirm
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        this.doPost(request, response);     
    }
    public  void doPost(final HttpServletRequest request, final HttpServletResponse response)throws ServletException, IOException {
        // action
        String action = request.getParameter("action");
        // remember
        String rem = request.getParameter("remember"); // tick - nontick
        // get info
        String email = request.getParameter("email");
        String passwd = request.getParameter("password");
        String mess=null;
        String url="";
        if(action==null){
            action="cancel";
        }
        if(rem==null){
            rem="nontick";
        }
        if(action.equals("cancel")){
            url = "/sign-in";
        }
        else if(action.equals("submit")){
            final Users u = userDao.checkUser(email, passwd);
            HttpSession session =request.getSession();
            if(u!=null){
               
                session.setAttribute("account", u);
                mess="Success Login";
               
            }
            else{
               try {
                if(userDao.selectUser(email)!=null){
                    mess= "Wrong password, You are " + email + " ?";
                }
                else{
                    mess = "We can not define you on my server, You are new ?";
                }
                session.setAttribute("message", mess);
                }catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                session.setAttribute("message", "Server error, try again");
                }
               
               
            }
            response.sendRedirect(request.getContextPath() + "/sign-in");
        }
        
    }

}
