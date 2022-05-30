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
import com.k19.models.Users;
import com.k19.models.Register;
import com.k19.utils.EmailUtility;
import com.k19.models.gmailconfirm;

@WebServlet(name = "signUpVerify",urlPatterns = "/sign-up/verify")
public class signUpVerify extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegisterDao registerDao;
    private String host;
    private String port;
    private String username;
    private String pass;
    public void init() {
        registerDao = new RegisterDao();
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        username = context.getInitParameter("username");
        pass = context.getInitParameter("pass");
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signUpVerify() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException{
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String url = null;
        if (action == null) {
            System.out.println("action null");

            action = "cancel";
        }
        if(action.equals("submit")){
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            String gentle=request.getParameter("gentle");
            String gmail = request.getParameter("gmail");
            String password = request.getParameter("password");
            String contact=request.getParameter("contact");
            String resultMessage = "";
            String code = EmailUtility.getRandom();
            try {
                Users checkUser= userDao.selectUser(gmail);
                if(checkUser==null)
                {
                    //create new user using all information
                    Register user = new Register(code,firstName,lastName,"user",gentle, gmail, password,contact,"");
                    boolean test;
                    registerDao.saveUser(user);
                    gmailconfirm gmailconfirm = new gmailconfirm();
                    String message = gmailconfirm.getHtml();
                    String html="";
                    html="<!DOCTYPE html>";
                    html+="<html>";
                    html+="<head>";
                    html+="<title></title>";
                    html +="<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />";
                    html+="<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">";
                    html+="<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />";
                    html+="<style type=\"text/css\">";
                    html+="@media screen {";
                    html+=  "@font-face {";
                    html+="font-family: 'Lato';";
                    html+="font-style: normal;";
                    html+="font-weight: 400;";
                    html+="src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');";
                    html+="}";
                    html+="@font-face {";
                    html+="font-family: 'Lato';";
                    html+="font-style: normal;";
                    html+="font-weight: 400;";
                    html+="src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');";
                    html+= "}";
                    html+="@font-face {";
                    html+="font-family: 'Lato';";
                    html+="font-style: normal;";
                    html+="font-weight: 400;";
                    html+="src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');";
                    html+="}";
                    html+="@font-face {";
                    html+="font-family: 'Lato';";
                    html+="font-style: normal;";
                    html+="font-weight: 400;";
                    html+="src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');";
                    html+="}";
                    html+="@font-face {";
                    html+="font-family: 'Lato';";
                    html+="font-style: normal;";
                    html+="font-weight: 400;";
                    html+="src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');";
                    html+="}";
                    html+="@font-face {";
                    html+="font-family: 'Lato';";
                    html+="font-style: normal;";
                    html+="font-weight: 700;";
                    html+="src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');";
                    html+="}";
                    html+="@font-face {";
                    html+="font-family: 'Lato';";
                    html+="font-style: italic;";
                    html+="font-weight: 700;";
                    html+="src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');";
                    html+="}";
                    html+="}";
                    html+=".verifySubmit{";
                    html+="cursor: pointer;";
                    html+="}";
                    html+="body,";
                    html+="table,";
                    html+="td,";
                    html+="a {";
                    html+="        -webkit-text-size-adjust: 100%;";
                    html+= "        -ms-text-size-adjust: 100%;";
                    html+="}";
                    html+="table,";
                    html+="td {";
                    html+="mso-table-lspace: 0pt;";
                    html+="mso-table-rspace: 0pt;";
                    html+="}";
                    html+="img {";
                    html+="-ms-interpolation-mode: bicubic;";
                    html+="}";
                    html+="img {";
                    html+="border: 0;";
                    html+="height: auto;";
                    html+="line-height: 100%;";
                    html+="outline: none;";
                    html+="text-decoration: none;";
                    html+="}";
                    html+="table {";
                    html+="border-collapse: collapse !important;";
                    html+= "}";
                    html+="body {";
                    html+= "height: 100% !important;";
                    html+="margin: 0 !important;";
                    html+= "padding: 0 !important;";
                    html+="width: 100% !important;";
                    html+= "}";
                    html+= "a[x-apple-data-detectors] {";
                    html+="color: inherit !important;";
                    html+="text-decoration: none !important;";
                    html+="font-size: inherit !important;";
                    html+="font-family: inherit !important;";
                    html+="font-weight: inherit !important;";
                    html+="line-height: inherit !important;";
                    html+="}";
                    html+= "@media screen and (max-width:600px) {";
                    html+=" h1 {";
                    html+="font-size: 32px !important;";
                    html+="line-height: 32px !important;";
                    html+="}";
                    html+="}";
                    html+= "div[style*=\"margin: 16px 0;\"] {";
                    html+= "margin: 0 !important;";
                    html+="}";
                    html+="</style>";
                    html+="</head>";
                    html+="<body style=\"background-color: #F9e0f9; margin: 0 !important; padding: 0 !important;\">";
                    html+="<div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\"> We're thrilled to have you here! Get ready to dive into your new account. </div>";
                    html+= "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">";
                    html+=" <tr>";
                    html+=" <td bgcolor=\"#F9e0f9\" align=\"center\">";
                    html+="<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">";
                    html+="<tr>";
                    html+="<td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\"> </td>";
                    html+="</tr>";
                    html+="</table>";
                    html+="</td>";
                    html+="</tr>";
                    html+="<tr>";
                    html+="<td bgcolor=\"#F9e0f9\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">";
                    html+="<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">";
                    html+="<tr>";
                    html+="<td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;\">";
                    html+="<h1 style=\"font-size: 48px; font-weight: 400; margin: 2;\">Welcome!</h1> <img src=\" https://img.icons8.com/clouds/100/000000/handshake.png\" width=\"125\" height=\"120\" style=\"display: block; border: 0px;\" />";
                    html+="</td>";
                    html+="</tr>";
                    html+="</table>";
                    html+="</td>";
                    html+="</tr>";
                    html+="<tr>";
                    html+="<td bgcolor=\"#f4f4f4\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">";
                    html+="<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">";
                    html+="<tr>";
                    html+="<td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">";
                    html+="<p style=\"margin: 0;\">We're excited to have you get started. First, you need to confirm your account. Just press the button below.</p>";
                    html+="</td>";
                    html+="</tr>";
                    html+="<tr>";
                    html+="<td bgcolor=\"#ffffff\" align=\"left\">";
                    html+="<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
                    html+="<tr>";
                    html+= "<td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 30px 60px 30px;\">";
                    html+="<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
                    html+="<tr>";
                    // html+="<form action=\"<%=request.getContextPath()%>/member/sign-up/verify_confirm\"  method=\"POST\" id=\"verify\">";
                    // html+="<i type=\"text\" name=\"authcode\" value=\""+user.getCode()+"\""+"/>";
                    // html+="<i type=\"text\" name=\"authcode\" value=\"\"  >";
                    // html+="<td align=\"center\"  style=\"border-radius: 3px;\" bgcolor=\"#FFA73B\"><input  class=\"verifySubmit\" type=\"submit\" target=\"_blank\" style=\"font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; color: #ffffff; text-decoration: none; padding: 15px 25px; border-radius: 2px; border: 1px solid #FFA73B; display: inline-block;background-color: #F9e0f9;\"  value=\"Account Confirm\" form=\"verify\"></td>";
                    // html+="</form>";
                    html+="<td align=\"center\" style=\"border-radius: 3px;\" bgcolor=\"#FFA73B\"><a href=\"http://localhost:8080/sarkbook/sign-up/verify/confirm?authecode="+user.getId()+"\""+"target=\"_blank\" style=\"font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; color: #ffffff; text-decoration: none; padding: 15px 25px; border-radius: 2px; border: 1px solid #FFA73B; display: inline-block;\">Confirm Account</a></td>";
                    html+="</tr>";
                    html+="</table>";
                    html+="</td>";
                    html+="</tr>";
                    html+="<tr>";
                    html+="<td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 0px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">";
                    html+=" <p style=\"margin: 0;\">If that doesn't work, copy and paste the following link in your browser:</p>";
                    html+="</td>";
                    html+=" </tr>";
                    html+="<tr>";
                    html+="<td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 20px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">";
                    html+="<p style=\"margin: 0;\"><a href=\"#\" target=\"_blank\" style=\"color: #FFA73B;\">https://bit.li.utlddssdstueincx</a></p>";
                    html+="</td>";
                    html+="</tr>";
                    html+="<tr>";
                    html+="<td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 20px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">";
                    html+="<p style=\"margin: 0;\">If you have any questions, just reply to this email—we're always happy to help out.</p>";
                    html+="</td>";
                    html+= "</tr>";
                    html+="<tr>";
                    html+="<td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 40px 30px; border-radius: 0px 0px 4px 4px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">";
                    html+="<p style=\"margin: 0;\">Cheers,<br>BBB Team</p>";
                    html+="</td>";
                    html+="</tr>";
                    html+="</table>";
                    html+="</td>";
                    html+="</tr>";
                    html+="<tr>";
                    html+="<td bgcolor=\"#F9e0f9\" align=\"center\" style=\"padding: 30px 10px 0px 10px;\">";
                    html+="<table border=\"0\" cellpadding=\"0\" cellspacing\"0\" width=\"100%\" style=\"max-width: 600px;\">";
                    html+="<tr>";
                    html+="<td bgcolor=\"#FFECD1\" align=\"center\" style=\"padding: 30px 30px 30px 30px; border-radius: 4px 4px 4px 4px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">";
                    html+="<h2 style=\"font-size: 20px; font-weight: 400; color: #111111; margin: 0;\">Need more help?</h2>";
                    html+= "<p style=\"margin: 0;\"><a href=\"#\" target=\"_blank\" style=\"color: #FFA73B;\">We&rsquo;re here to help you out</a></p>";
                    html+= "</td>";
                    html+="</tr>";
                    html+="</table>";
                    html+="</td>";
                    html+="</tr>";
                    html+="<tr>";
                    html+="<td bgcolor=\"#F9e0f9\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">";
                    html+= "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">";
                    html+="<tr>";
                    html+="<td bgcolor=\"#F9e0f9\" align=\"left\" style=\"padding: 0px 30px 30px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 14px; font-weight: 400; line-height: 18px;\"> <br>";
                    html+="<p style=\"margin: 0;\">If these emails get annoying, please feel free to <a href=\"#\" target=\"_blank\" style=\"color: #111111; font-weight: 700;\">unsubscribe</a>.</p>";
                    html+="</td>";
                    html+="</tr>";
                    html+="</table>";
                    html+="</td>";
                    html+= "</tr>";
                    html+="</table>";
                    html+="</body>";
                    html+="</html>";
                
                    // "<i>Greetings!</i><br>"+"Hi ,"+user.getLastName()+
                    //      "\nWe just need to verify your email address before you can access [customer portal].\n"+
                    //      "Verify your account using this code: "+ user.getCode()+
                    //      "\nThanks! – The Sảk team" 
                    try {

                         test = EmailUtility.sendEmail(host, port, username, pass, gmail, "Email Verification",html);
                    } catch (MessagingException e) {
                        // TODO Auto-generated catch block
                         e.printStackTrace();
                         test = false;
                    }
                    //call the send email method
           
                    //check if the email send successfully
                    if(test){
                        url="/verify.jsp";
                       
                        resultMessage = "We already send a verification  code to your email.";
                    } else{
                        resultMessage = "There were an error. Please try again!";
                        }
                    getServletContext().getRequestDispatcher("/WEB-INF/views" + url).forward((ServletRequest) request,
                                (ServletResponse) response);
                }
                else{
                    url="/regs.jsp";
                    resultMessage="Gmail is invalid or already taken";
                    request.setAttribute("mess", resultMessage);
                    getServletContext().getRequestDispatcher("/WEB-INF/views" +url).forward(request, response);
                }
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }
}

