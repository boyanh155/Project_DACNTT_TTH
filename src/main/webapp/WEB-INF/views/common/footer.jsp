<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <div class="footer">
            <div class="line"></div>
            <div class="grid wide footer__grid">
                <div class="row footer__row1">
                    <div class="col l-3">
                        <div class="footer__contact">
                            <h1>SKULLCANDY VIỆT NAM</h1>
                            <p>
                                B1.00.01 Sarimi, 72 Nguyễn Cơ Thạch,
                                <br> Phường An Lợi Đông, Quận 2, TP.HCM,
                                <br> Việt Nam. 0799.848.919
                            </p>
                        </div>
                    </div>
                    <div class="col l-3">
                        <div class="footet__sp">
                            <h1>HỖ TRỢ</h1>
                            <ul class="sp-list">
                                <li class="sp-list__item">Liên hệ</li>
                                <li class="sp-list__item">Chính sách bảo hành</li>
                                <li class="sp-list__item">Chính sách giao hàng</li>
                                <li class="sp-list__item">Chính sách đổi trả</li>
                                <li class="sp-list__item">Cách thức đặt hàng</li>
                                <li class="sp-list__item">Chính sách trả góp</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col l-3 l-o-3">
                        <div class="footer__email">
                            <h1>ĐĂNG KÝ EMAIL</h1>

                            <form action="/index.html" method="POST" id="email__form">
                                <input type="email" name="email" class="" placeholder="Nhập địa chỉ email">
                                <button form="email_form" value="">ĐĂNG KÝ</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="line"></div>
                <div class="row footer__row2">
                    <div class="col l-12">
                        <div class="footer__icon">
                            <i class="fab fa-facebook-square"></i>
                            <i class="fab fa-instagram"></i>
                        </div>
                    </div>
                    <div class="col l-12">

                    </div>
                </div>
            </div>
        </div>