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
    <title>Shopping cart</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/layout/grid.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/layout/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/layout/responsive.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/member/cart.css">
</head>

<body class="cart-bg">
    <section>
        <div class="grid wide cart">
            <div class="row cart__info">
                <div class="col l-8">
                    <div class="cart-side cart-left ">
                        <!-- Cart left title -->
                        <div class="row cart-left__about">
                            <div class="col l-3 cart-left__item">
                                <span>Sản phẩm</span>
                            </div>
                            <div class="col l-3 cart-left__item">
                                <span>Giá thành</span>
                            </div>
                            <div class="col l-3 cart-left__item">
                                <span>Số lượng</span>
                            </div>
                            <div class="col l-3 casxrt-left__item">
                                <span>Tổng tiền</span>
                            </div>
                        </div>
                        <!-- Cart left list product -->
                        <%-- Ting --%>
                        <div class="list-wrap">
                        <input type="hidden" class="JSON__cart" value='${sessionScope.cartJSON}' />
                        <%-- Form --%>
                        <form id="editForm" action="${pageContext.request.contextPath}/cart/update" method="POST">
                            <input type="hidden" name="action" value="cart">
                            <c:forEach var="item" items="${sessionScope.cart.items}">
                                <c:set var="product" value="${item.product}"/>
                                <input type="hidden" name="product_code" value="${product.code}" />
                                <div class="row">
                                    <div class="cart-left__list">
                                        <div class="col l-3 cart-left__item">
                                            <img class="js__img" alt="">
                                        </div>
                                        <div class="col l-3 cart-left__item">
                                            <span class="js__price"></span>
                                        </div>
                                        <div class="col l-3 cart-left__item ">
                                            <span class="cart-left__qty">
                                                <i class="fas fa-minus js__minus"></i>
                                                <!-- <span class="qty__input" contenteditable="true">1</span> -->
                                            <input class="qty__input" type="number" class="" name="qty" id="" value="${item.qty}">
                                            <i class="fas fa-plus js__plus"></i>
                                            </span>
                                        </div>
                                        <div class="col l-3 cart-left__item">
                                            <span class="js__total">1</span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </form>
                        </div>
                    </div>
                </div>
                <div class="col l-4">
                        <div class="cart-side cart-right">
                            <div class="line"></div>
                            <div class="cart-right__total">
                                <div class="cart-right__price">
                                    <span>cart total</span>
                                    <h1 style="display: inline-block;">$180</h1>
                                </div>
                                <div class="cart-right__shipping">
                                    <span style="color: rgb(168, 165, 165);">
                                        Shipping & taxes calculated at checkout <br/>
                                    </span>
                                    <label class="cart-right__input-container">
                                        <span style="">
                                            I agree to 
                                            <i style="color: #d19186;letter-spacing: 0.01em;">
                                                Term of Countries
                                            </i>
                                        </span>
                                        <input type="checkbox" style="">
                                        <span class="checkmark"></span>
                                    </label>

                                </div>
                            </div>
                            <%-- submit button --%>
                            <div class="cart-right__checkout">
                                <button form="editForm" class="cart-right__checkout-bt cart-right__checkout-bt--checkout" type="submit">
                                    <a href="#">
                                        <span>check out
                                            <i class="fas fa-shopping-basket"></i>
                                        </span>
                                    </a>
                                </button>
                            <%-- submit button --%>
                                <button form="editForm" class="cart-right__checkout-bt cart-right__checkout-bt--paypal" type="submit">
                                    <a href="#">
                                        <i style="font-size: 20px;" class="fab fa-paypal logo_icon"></i>
                                        <i class="logo_word" style="color: #253b80;">Pay</i>
                                        <i class="logo_word" style="color: #179bd7;">Pal</i>
                                    </a>
                                </button>
                            </div>
                        </div>
                </div>
            </div>
        </div>

    </section>
    <script src="${pageContext.request.contextPath}/resource/assets/js/cart.js"></script>
</body>

</html>