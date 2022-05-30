package com.k19.controller;

import javax.servlet.http.HttpServlet;
import javax.swing.text.Document;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.persistence.Convert;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.k19.models.product;
import com.k19.DAO.productJPADAO;

@WebServlet(name = "products" ,urlPatterns = { "/products" })
public class ProductsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String url = "/category.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "display_products"; // default action
        }
        // perform action and set URL to appropriate page
        
        if (action.equals("display_products")) {
            // get list of products
            List<product> products = productJPADAO.selectProducts(null,null);
            request.setAttribute("products", products);
            request.setAttribute("show", "Tất cả sản phẩm ");
        } else if (action.equals("Tshirt")) {
            List<product> products = productJPADAO.selectProducts("Tshirt",null);
            request.setAttribute("products", products);
            request.setAttribute("show", "T-SHIRT");
        } else if (action.equals("SHIRT")) {
            List<product> products = productJPADAO.selectProducts("Shirt",null);
            request.setAttribute("products", products);
            request.setAttribute("show", "SHIRT");
        }else if(action.equals("ASCall")){  
            List<product> products = productJPADAO.selectProducts(null,"ASC");
            request.setAttribute("products", products);
            request.setAttribute("show", "Tất cả sản phẩm");
        }else if(action.equals("ASC_T-SHIRT")){
            List<product> products=productJPADAO.selectProducts("Tshirt","ASC");
            request.setAttribute("products", products);
            request.setAttribute(("show"), "T-SHIRT");
        }else if(action.equals("ASC_SHIRT")){
            List<product> products=productJPADAO.selectProducts("Shirt","ASC");
            request.setAttribute("products", products);
            request.setAttribute(("show"), "T-SHIRT");
        }else if(action.equals("DESCall")){  
            List<product> products = productJPADAO.selectProducts(null,"DESC");
            request.setAttribute("products", products);
            request.setAttribute("show", "Tất cả sản phẩm");
        }else if(action.equals("DESC_T-SHIRT")){
            List<product> products=productJPADAO.selectProducts("Tshirt","DESC");
            request.setAttribute("products", products);
            request.setAttribute(("show"), "T-SHIRT");
        }else if(action.equals("DESC_SHIRT")){
            List<product> products=productJPADAO.selectProducts("Shirt","DESC");
            request.setAttribute("products", products);
            request.setAttribute(("show"),"SHIRT");
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}