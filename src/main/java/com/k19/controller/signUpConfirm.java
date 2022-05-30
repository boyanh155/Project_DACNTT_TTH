package com.k19.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import com.k19.models.Users;
import com.k19.DAO.userDao;
import com.k19.models.Register;
import com.k19.DAO.RegisterDao;

@WebServlet(name = "signUpConfirm",urlPatterns = "/sign-up/verify/confirm")
public class signUpConfirm extends HttpServlet{
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
    public signUpConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			System.out.print("-------getauthecode1---------");
	        int Code = Integer.parseInt(request.getParameter("authecode"));
			System.out.print("-------getauthecode---------");
			System.out.print(Code);
	        Register register= RegisterDao.selectUserById(Code);
			if(register!=null){
				System.out.print("--------get user--------");
				Users user = new Users(register.getFirstName(),register.getLastName(),register.getRole(),register.getGentle(),register.getGmail(),register.getPassWord(),register.getContact(),register.getAvt());
				Users check = userDao.selectUser(user.getGmail());
				if(check==null){
					System.out.print("-------insert---------");
					userDao.saveUser(user);
					session.setAttribute("account", user);
					response.sendRedirect(request.getContextPath() + "/sign-in");
				}
				else{
					response.sendRedirect(request.getContextPath() + "/sign-in");
				}
			}
			else{
				System.out.print("--------ERROR--------");
				
			}


	        // if(code.equals(user.getCode())){
			// //	String url="/thanks.jsp";
	        //     userDao.saveUser(user);
	        //     session.setAttribute("newUser", user);
			// 	response.sendRedirect(request.getContextPath() + "/member/sign-in");
	        // }else{
	        //     out.println("Incorrect verification code");
	        
		} catch (ClassNotFoundException e) {
			System.out.print("----------catch1-------");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("----------catch2-------");
			e.printStackTrace();
		}
	}
}
