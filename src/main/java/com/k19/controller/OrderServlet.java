package com.k19.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.k19.DAO.productJPADAO;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.k19.models.*;
import com.k19.utils.EmailUtility;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@WebServlet(name="OrderServlet" ,urlPatterns={"/order"})
public class OrderServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private String host;
    private String port;
    private String username;
    private String pass;
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        username = context.getInitParameter("username");
        pass = context.getInitParameter("pass");
    }     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet(){
        super();
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        // System.out.println("Start register---------------------------------");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
       String action = request.getParameter("action");
       String url = null;
       if (action == null) {
           System.out.println("action null");

           action = "submit";
       }
       if(action.equals("submit"))
       {
           String fullname=request.getParameter("fname");
           String email=request.getParameter("email");
           String billing_address_1 = request.getParameter("billing_address_1");
           String billing_address_2 = request.getParameter("billing_address_2");
           String address=request.getParameter("address");
           String pnum=request.getParameter("pnum");
           String resultMessage = "";
           ServletContext sc=getServletContext();
           HttpSession session = request.getSession(false);
           cartJPA cart = (cartJPA) session.getAttribute("cart");
           Object price=session.getAttribute("price");
        //    String code = EmailUtility.getRandom();
           //find email
           try {
                boolean sendEmail;
                try {
                    String mess="Hi:"+fullname+

                    "\n\nWoo hoo! Your order is on its way. Your order details can be found below.\n\n"+
                    
                    "TRACK YOUR ORDER [link]\n\n"+
                    
                    "ORDER SUMMARY:\n\n"+ 
                    
                    "Order #: [number]\n"+
                    "Order Date:"+  java.time.LocalDateTime.now() +"\n" +
                    "Order Total:"+price+"\n"+
                    
                    "SHIPPING ADDRESS:"+address+", "+billing_address_2+", "+billing_address_1+
                    
                    "\nTable with a list of items]"+
                    
                    "\nITEMS SHIPPED\t"+ 			     "QTY\t"+				          "PRICE\t";
                    ArrayList<lineItemJPA> items=cart.getItems();
                    for(int i=0;i<items.size();i++){
                        lineItemJPA item=items.get(i);
                        mess+="\n"+item.getProduct().getDesc() +"\t" +item.getQuantity()+"\t"+ +item.getProduct().getPrice() ; 
                    }
                    sendEmail=EmailUtility.sendEmail(host, port, username, pass, email,"Thông báo xác nhận đơn hàng",mess);
                    // System.out.println("--------------Đã send email đến" +email);
                    // System.out.println("--------------Đã " +mess);
                } catch (Exception e) {
                    //TODO: handle exception
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    sendEmail = false;
                }
                if(sendEmail)
                {
                    url="/products";
                    // System.out.println("--------------Đã send email");
                }
                else{
                    resultMessage="There were an error. Please try again!";
                    url="/WEB-INF/views/member/checkOut.jsp";
                    // System.out.println("--------------Đã send email lỗi ");
                }
                getServletContext().getRequestDispatcher(url).forward((ServletRequest) request,
                               (ServletResponse) response);
            } catch (Exception e1) {
                                // TODO Auto-generated catch block
                                System.out.println("--------------lỗi---------------");
                                e1.printStackTrace();
             }
            //    System.out.println("111111111111111111111111111111");
            //    Users checkUser= UserDAO.selectUser(email);
            //    System.out.println("---------------------------------------------");
            //    if(checkUser==null)
            //    {
            //        //create new user using all information
            //        Users user = new Users(code,firstName,lastName,gentle, email, password,contact);
            //        boolean test;
            //        try {
            //             test = EmailUtility.sendEmail(host, port, username, pass, email, "Email Verification",
            //                    "Registered successfully.Please verify your account using this code: " + user.getCode());
            //        } catch (MessagingException e) {
            //            // TODO Auto-generated catch block
            //             e.printStackTrace();
            //             test = false;
            //        }
            //        //call the send email method
          
            //        //check if the email send successfully
            //        if(sendEmail){
            //            url="/thanks.jsp";
            //            HttpSession session  = request.getSession();
            //            session.setAttribute("user", user);
            //            resultMessage = "We already send a verification  code to your email.";
            //        } else{
            //            resultMessage = "There were an error. Please try again!";
            //            }
            //        getServletContext().getRequestDispatcher("/WEB-INF/views" + url).forward((ServletRequest) request,
            //                    (ServletResponse) response);
            //    }
            //    else{
            //        url="/regs.jsp";
            //        resultMessage="Email is invalid or already taken";
            //        request.setAttribute("mess", resultMessage);
            //        getServletContext().getRequestDispatcher("/WEB-INF/views" +url).forward(request, response);
            //    }
          
       }  
   }
    
}
