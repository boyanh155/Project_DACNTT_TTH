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
    <title>Halo</title>
    <!-- bootstrap css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/layout/bootstrap.min.css">
    <!-- style css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/member/member.css">
    <!-- Responsive-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/layout/responsive.css">
    <!--  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/layout/grid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/layout/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/member/memberAdd.css">
</head>

<body>
    <section class="slider_section">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container-fluid padding_dd">
                    <div class="carousel-caption">
                        <div class="row">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                <div class="text-bg">
                                    <span>Welcome To Sark</span>
                                    <h1>Sark Love YalL</h1>
                                    <p> Chào mừng bạn đến với cửa hàng trực tuyến của thương hiệu SARK, chúc bạn có một buổi mua hàng vui vẻ. </p>
                                    <form class="Vegetable">
                                        <input class="Vegetable_fom" placeholder="Coming soon" disabled type="text" name="Vegetable">
                                    </form>
                                    <a href="${pageContext.request.contextPath}/member/sign-in">Đăng nhập</a> 
                                    <a href="${pageContext.request.contextPath}/member/sign-up">Đăng kí</a>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                <div class="images_box">
                                    <!-- <figure><img src="./parker-burchfield-tvG4WvjgsEY-unsplash.jpg"></figure> -->
                                    <figure>
                                        <iframe src="https://www.youtube.com/embed/UGEYaRyLgLg?autoplay=1&loop=1" frameborder="0" allow='autoplay'></iframe>
                                    </figure>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <img class="mario" src="https://i.gifer.com/origin/ac/acf3abb6da430dd78cc99f925bb52d49.gif" alt="">
    <span class="mario mario__name">Lộc</span>
    <img class="mario" src="https://i.pinimg.com/originals/b6/90/40/b69040ba12c1b3a9d9d998e3e67154e9.gif" alt="">
    <span class="mario mario__name">Hưng</span>
</body>

</html>