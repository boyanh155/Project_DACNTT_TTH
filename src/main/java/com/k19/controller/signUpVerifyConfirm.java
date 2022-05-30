package com.k19.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.k19.DAO.userDao;
import com.k19.DAO.RegisterDao;
import com.k19.DAO.userDao;
import com.k19.models.Users;
import com.k19.models.Register;
import com.k19.utils.EmailUtility;
import com.k19.models.gmailconfirm;

@WebServlet(name = "signUpVerifyConfirm",urlPatterns = "/sign-up/verify/con")
public class signUpVerifyConfirm  extends HttpServlet{
    private RegisterDao registerDao;
    private static final long serialVersionUID = 1L;
    private userDao userDao;
    public void init() {
        userDao = new userDao();
		registerDao = new RegisterDao();
    }
        /**
     * @see HttpServlet#HttpServlet()
     */
    public signUpVerifyConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws SecurityException,IOException{
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String url = null;
        if (action == null) {
            System.out.println("action null");

            action = "cancel";
        }
        String gmail = "19110221@student.hcmute.edu.vn";
        System.out.print(gmail);
       Register u = new Register();
       try {
        u = registerDao.selectUser(gmail);
        if(u!=null){
            Users user = new Users();
            user.setId(u.getId());
			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setGmail(u.getLastName());
			user.setContact(u.getContact());
			user.setAvt(u.getAvt());
			user.setRole(u.getRole());
			user.setPassWord(u.getPassWord());
            Users check = userDao.selectUser(gmail);
            if(check==null){
                HttpSession session =request.getSession();
                System.out.print("-------insert---------");
                userDao.saveUser(user);
                session.setAttribute("newUser", user);
                response.sendRedirect(request.getContextPath() + "/member/sign-in");
            }
            else{
                response.sendRedirect(request.getContextPath() + "/member/sign-in");
            }

        }
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}
