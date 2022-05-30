<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thanks for enroll</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/oneshot/thanks.css">
    </head>

    <body>
        <h2>Here is your registered information. Thanks for join with us</h2>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Information</th>
                    <th scope="col">First name</th>
                    <th scope="col">Last name</th>
                    <th scope="col">User name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Contact</th>
                    <th scope="col">Gentle</th>
                    <th scope="col">Login</th>
                </tr>
            </thead>
            <c:set var = "login" scope = "session" value = "${sessionScope.username}"/>

            <tbody>
                <tr>
                    <th scope="row">You</th>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.contact}</td>
                    <td>${user.gentle}</td>
                    <td>${user.avt}</td>
                </tr>
            </tbody>
        </table>
                <button type="button" class="btn btn-primary last-bt">
                <a href="${pageContext.request.contextPath}/member/sign-in">Đăng nhập</a>
                </button>
            <%-- Cho khách hàng dến trang mua hàng --%>
                <%-- <c:if test = "${login != null}">
                <button type="button" class="btn btn-primary last-bt">
                <a href="${pageContext.request.contextPath}/home">Về trang chủ</a>
                </button>
                </c:if> --%>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

    </html>