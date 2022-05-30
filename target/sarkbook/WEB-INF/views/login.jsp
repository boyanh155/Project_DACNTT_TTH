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
            <title>Login page</title>
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/main.css">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/member/login.css">
        </head>

        <body>
            <form action="<%=request.getContextPath()%>/sign-in/confirm" method="post">
                <input type="hidden" name="action" value="submit">
                <div class="imgcontainer">
                    <img src="${pageContext.request.contextPath}/resource/assets/img/member/login/avt.png" alt="Avatar" class="avatar">
                </div>

                <div class="container">
                    <label for="email">Email</label>
                    <input id="email" type="text" placeholder="Enter Email" name="email" required>

                    <label for="psw"><b>Password</b></label>
                    <input id="psw" type="password" placeholder="Enter Password" name="password" title="Password at least 8 characters avoid special characters"  required>
                    <%-- pattern="[^\n]{8,}" --%>
                    <%-- clear announce --%>
                    <p class="announce">
                    <c:out value="${sessionScope.message}" />
                    </p>
                    <!-- message -->
                    <p class="message">
                        At least 8 chars
                    </p>
                    <!-- Progress bar -->
                    <div class="progress-bar" style="display: none;">
                        <div class="w3-light-grey">
                            <div id="myBar" class="w3-container w3-red" style="height:24px;width:0%"></div>
                        </div>
                    </div>
                    <button type="submit" class="submit-bt">login</button>

                    <!-- Maybe i will do it next time -->
                    <label> 
                        <input type="checkbox" checked="checked" value="tick" name="remember"> Remember me
                      </label>
                </div>

                <!-- Maybe i will do it next time -->
                <div style="background-color: #F2E1B8;" class="container" style="background-color:#f1f1f1">
                    <a type="button" href="${pageContext.request.contextPath}/" class="cancelbtn">Cancel</a>
                    <span class="psw"> <a href="${pageContext.request.contextPath}/sign-up">Sign Up?</a></span>
                    <span class="psw">Forgot <a href="#">password?</a></span>
                </div>
            </form>
            <script src="${pageContext.request.contextPath}/resource/assets/js/login.js"></script>
        </body>

        </html>