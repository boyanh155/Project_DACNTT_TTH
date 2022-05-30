package com.k19.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.mail.FetchProfile.Item;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.k19.DAO.productJPADAO;
import com.k19.models.*;
@WebServlet(name="CartConTroLler",urlPatterns = { "/CartControLlers","/Product","/addProduct","/removeProduct","/checkOut"})
public class CartController  extends HttpServlet{
    private static final long serialVersionUID = 1L;
  
    private productJPADAO productDao;
    public CartController(){
        productDao=new productJPADAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        String temp = request.getRequestURI().toString();
        String slug = temp.substring(10, temp.length());// heroku 1 , tomcat 8
        System.out.println("------------------------------"+slug+"----------------------------");
        if(slug.equals("Product")){
            ServletContext sc=getServletContext();
            String productId = request.getParameter("productID");
            // String quantityString = request.getParameter("quantity");
            String url="/productCard.jsp";
            try {
                product product=productJPADAO.selectProduct(productId);
                request.setAttribute("product", product);
                System.out.println("Start productcard---------------------------------");
                getServletContext().getRequestDispatcher(url).forward((ServletRequest) request,
                                (ServletResponse) response);
                // getServletContext().getRequestDispatcher(url).forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
               
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/products");
            }
        }
        else if(slug.equals("CartControLlers")){
            ServletContext sc=getServletContext();
            String messRemove="";
            String productId = request.getParameter("productID");
            String quantityString = request.getParameter("quantity");
            System.out.println("---------------------------"+quantityString+"--------------");
            HttpSession session = request.getSession(false);
            cartJPA cart = (cartJPA) session.getAttribute("cart");
            Object price=session.getAttribute("price");
            if(price==null)
            {
                price=new Object();
            }
            if(cart==null){
                cart=new cartJPA();
            }
            int quantity;
            try {
                quantity=Integer.parseInt(quantityString);
                if(quantity<0){
                    quantity=1;
                }
            } catch (NumberFormatException nfe) {
                //TODO: handle exception
                quantity=1;
            }
            product product=null;
            try {
                product=productJPADAO.selectProduct(productId);
                lineItemJPA lineItem=new lineItemJPA();
                lineItem.setProduct(product);
                // System.out.println("---------------------------");
                System.out.println("---------------------------"+quantity+"--------------");
                lineItem.setQuantity(quantity);

                if(quantity>0){
                    cart.addItem(lineItem);
                    System.out.println("---------------------------additem--------------");
                }else if(quantity==0){
                    cart.removeItem(lineItem);
                    messRemove="Đã xóa sản phẩm.";
                    request.setAttribute("messRemove", messRemove);
                }
                Double sum=cart.getSum();
                price=sum;
                session.setAttribute("price", price);
                session.setAttribute("cart", cart);
                System.out.println("---------------------------products--------------");
                sc.getRequestDispatcher("/products").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/products");
            }
        }else if(slug.equals("addProduct")||slug.equals("removeProduct")){
            ServletContext sc=getServletContext();
            String url="/productCard.jsp";
            String productId = request.getParameter("productID");
            String quantityString = request.getParameter("quantity");
            System.out.println("---------------------------"+quantityString+"--------------");
            String messAdd="";
            String messRemove="";
            HttpSession session = request.getSession(false);
            cartJPA cart = (cartJPA) session.getAttribute("cart");
            Object price=session.getAttribute("price");
            if(price==null)
            {
                price=new Object();
            }
            if(cart==null){
                cart=new cartJPA();
            }
            int quantity;
            try {
                quantity=Integer.parseInt(quantityString);
                if(quantity<0){
                    quantity=1;
                }
            } catch (NumberFormatException nfe) {
                //TODO: handle exception
                quantity=1;
            }
            product product=null;
            try {
                product=productJPADAO.selectProduct(productId);
                lineItemJPA lineItem=new lineItemJPA();
                lineItem.setProduct(product);
                // System.out.println("---------------------------");
                System.out.println("---------------------------"+quantity+"--------------");
                lineItem.setQuantity(quantity);
                

                if(quantity>0){
                    cart.addItem(lineItem);
                    messAdd="Đã thêm sản phẩm.";
                    request.setAttribute("messAdd", messAdd);
                    System.out.println("---------------------------additem--------------");
                }else if(quantity==0){
                    cart.removeItem(lineItem);   
                    messRemove="Đã xóa sản phẩm.";
                    messAdd="";
                    request.setAttribute("messRemove", messRemove);
                    request.setAttribute("messAdd", messAdd);
                }
                Double sum=cart.getSum();
                price=sum;
                session.setAttribute("cart", cart);
                session.setAttribute("price", price);
                request.setAttribute("product", product);
                
                System.out.println("---------------------------products--------------");
                sc.getRequestDispatcher(url).forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + url);
            }
        }else if(slug.equals("checkOut")){
            ServletContext sc=getServletContext();
            try {
                String url="/checkOut.jsp";
                HttpSession session = request.getSession(false);
                cartJPA cart = (cartJPA) session.getAttribute("cart");
                Object price=session.getAttribute("price");
                if(price==null)
                {
                    price=new Object();         
                }
                if(cart==null){
                    cart=new cartJPA();
                }
                session.setAttribute("cart", cart);
                session.setAttribute("price", price);
                sc.getRequestDispatcher("/WEB-INF/views/member"+url).forward(request, response);
            } catch (Exception e) {
                //TODO: handle exception
                sc.getRequestDispatcher("/products").forward(request, response);
            }   
        }
       
    
            // int quantity = 1;
            // ServletContext sc = getServletContext();
            // cartJPA cart;
            // String productCode = request.getParameter("productID");
            // String url="";
            // if(productCode==null){
            //    try {
            //        //url="/products";
            //        productJPA product=productJPADAO.selectProduct(productCode);
            //        if(product!=null){ 
            //             HttpSession session = request.getSession();
            //             cart = (cartJPA) session.getAttribute("cart");
            //             if (cart == null) {
            //                 cart = new cartJPA();
            //                 ArrayList<lineItemJPA> list = new ArrayList<lineItemJPA>();
            //                 lineItemJPA item = new lineItemJPA();
            //                 item.setQty(quantity);
            //                 item.setProduct(product);
            //                 list.add(item);
            //             // cart.setItems(list);
            //                 session.setAttribute("cart", cart);
            //             } else {
            //                 ArrayList<lineItemJPA> list = cart.getItems();
            //                 boolean check = false;
            //                 for (lineItemJPA item : list) {
            //                     if (item.getProduct().getCode() == product.getCode()) {
            //                         item.setQty(item.getQty() + quantity);
            //                         // update quantity
            //                         check = true;
            //                     }
            //                 }
            //                 if (!check) {
            //                     lineItemJPA item = new lineItemJPA();
            //                     item.setQty(quantity);
            //                     item.setProduct(product);
            //                     list.add(item);
            //                 }
            //                 session.setAttribute("cart", cart);
            //             }
            //             getServletContext().getRequestDispatcher("/cart").forward(request, response);
            //        }
            //    }
            //    catch (ClassNotFoundException | SQLException e) {
            //      //TODO: handle exception
            //         response.sendRedirect(request.getContextPath() + "/cart");
            //         e.printStackTrace();
            //     }
                
            // }else{
            //     response.sendRedirect(request.getContextPath() + "/products");
            // }
			
	}
}
