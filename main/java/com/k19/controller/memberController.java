package com.k19.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.Servlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;
import com.k19.models.Users;
import com.k19.utils.cookieUtil;


@WebServlet(name = "memberController" ,urlPatterns = {"/sign-out","/sign-up","/sign-in","/member"}) 
public class memberController extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String temp = request.getRequestURI().toString();
        String slug = temp.substring(10, temp.length());// heroku 1 , tomcat 8
        String url="";
        System.out.println("---------------------");
        System.out.println(slug);
        if(slug.equals("sign-up")){
            url = "/WEB-INF/views/regs.jsp";
        }
        else if(slug.equals("sign-in")){
            Users acc ;
            HttpSession session = request.getSession();
            acc= (Users) session.getAttribute("account");
            System.out.println(acc);
            System.out.println("--------------------- sign-in---------");
            if(acc==null){
                url="/WEB-INF/views/login.jsp";
                System.out.println("---------------------sign-in--null-----");
            }
            else{
                url="/index.jsp";
            }
        }
        else if(slug.equals("sign-out")){
            HttpSession session=request.getSession();
            session.removeAttribute("account");
            url="/WEB-INF/views/login.jsp";
        }
        else if(slug.equals("member")){
            Users acc ;
            HttpSession session = request.getSession();
            acc= (Users) session.getAttribute("account");
            System.out.println(acc);
            System.out.println("--------------------- sign-in---------");
            if(acc==null){
                url="/WEB-INF/views/login.jsp";
                System.out.println("---------------------sign-in--null-----");
            }
            else{
                url="/WEB-INF/views/member/edit.jsp";
                
            }

        }
        getServletContext().getRequestDispatcher(url).forward((ServletRequest)request,(ServletResponse) response);
    }
}
