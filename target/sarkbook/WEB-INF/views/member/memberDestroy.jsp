<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/grid.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/oneshot/firstpage.css">
    <%-- Font --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,400;0,700;1,300&display=swap" rel="stylesheet">

</head>

<body>
    <div class="session">
        <div class="grid wide">
            <div class="row intro">
                <div class="col l-5 m-5 c-5">
                    <div class="intro__picture">
                        <img src="https://static.nike.com/a/images/f_auto/dpr_1.0/w_415,c_limit/6581f3a5-db55-4a35-8e89-dec548f219b1/nike-just-do-it.jpg" alt="" class="intro__img">

                    </div>
                </div>
                <div class="col l-7 m-7 c-7">
                    <div class="intro__about">
                        <h1>$0.00</h1>
                        <h3>Đăng nhập</h3>
                        <p>Tham gia để trở thành một phần của
                            <br> nhóm chúng tôi K19 THHL.</p>
                        <div class="bt__wrap">
                            <a href="${pageContext.request.contextPath}/member/sign-in" class="intro__button">
                                <h4>
                                    đăng nhập
                                </h4>
                            </a>
                            <a href="${pageContext.request.contextPath}/member/sign-up" class="intro__button intro__button-dk">
                                    <h4>
                                        đăng kí
                                    </h4>
                            </a> 
                        </div>
                        
                        <span class="intro__semibt">
                            <span class="intro__semibt-span">
                            Chưa có tài khoản
                            </span> 
                            <a href="${pageContext.request.contextPath}/member/sign-up">
                            đăng kí
                            </a>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="logo logo--1">
        <img src="${pageContext.request.contextPath}/resource/assets/img/home/covid/logo/healthcare_guidelines-2.png" alt="">
    </div>
    <div class="logo logo--2">
        <img src="${pageContext.request.contextPath}/resource/assets/img/home/covid/logo/healthcare_guidelines-2.png" alt="">
    </div>
</body>

</html>