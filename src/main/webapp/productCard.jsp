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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/tests/lib/jasmine-1.3.1/jasmine.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/tests/lib/jasmine-1.3.1/jasmine.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/tests/lib/jasmine-1.3.1/jasmine-html.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/tests/lib/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/flaviusmatis-simplePagination.js-da97104/simplePagination.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/categoriess.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/oneshot/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/productCard.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/cart.css">
    <title>SARK</title>
</head>
<body>
    <header class="Header">
        <div class="Logo">
            <a href="#"> <img src="${pageContext.request.contextPath}/resource/assets/img/home/logo_200x200.png" height="150" width="150" alt="Amazing" class="reponsive"></a>
        </div>
        <div class="Menu">
            <li class="Menu__Trademark"><a href="">TRADEMARK</a>
                <ul class="Menu__Trademark__List">
                    <li class="Menu__Trademark__List__Babhabit"><a href="carteogory.html">Bad Habits</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/logobadhabit.jpg" alt="" class="reponsive">
                            <li> <a href="">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                    <li class="Menu__Trademark__List__Dirtycoins"><a href="">Dirty Coins</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/logodirtycoin.png" alt="" class="reponsive">
                            <li><a href="">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                    <li class="Menu__Trademark__List__UnCover"><a href="">Un Cover</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/Logouncover.jpg" alt="" class="reponsive">
                            <li><a href="">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                    <li class="Menu__Trademark__List__DAVIES"><a href="">DAVIES</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/logodavies.jpg" alt=""  class="reponsive">
                            <li><a href="products?action=Tshirt">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="Menu__Store"><a href="">STORE</a>
                <ul class="Menu__Store__List">
                    <li> <a>North</a>
                        <ul class="List">
                            <li><a href="">Hà Nội</a></li>
                        </ul>
                    </li>
                    <li><a>Central</a>
                        <ul class="List">
                            <li><a href="">Huế</a></li>
                            <li><a href="">Đà Nẵng</a></li>
                        </ul>
                    </li>
                    <li><a>Southern</a>
                        <ul class="List">
                            <li><a href="products?action=display_products?">Hồ Chí Minh</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="Menu__Contact"><a href="">CONTACT</a></li>
        </div>
            <input type="hidden" class="JSON" name="JSON" value='${sessionScope.memberJSON}'>
        <div class="Other">

            <!-- user -->

            <!-- member -->
            <div class="member">
                <div class="member__avt">
                    <!-- <img src=""
                                alt="avt" srcset=""> -->
                                <li class="Other__item Other__User">          
                                    <a class="fa fa-user js__icon--user"  href="${pageContext.request.contextPath}/member"></a>    
                                </li>
                </div>
                <div class="member__name">
                    <span class="js__membername">${member}</span>
                </div>
            </div>

            <!-- end user -->
            <!--search icon -->
            <li class="Other__item Other__search">
                <input class="Other__search__input" placeholder="search" type="text">
                <i class="fa fa-search"></i>
            </li>
            <!--user icon -->
            <li class="Other__item Other__User">          
                <a class="fa fa-user js__icon--user"  href="${pageContext.request.contextPath}/member"></a>    
            </li>
            <!--cart icon -->
            <li id="cart" class="Other__item Other__shoopping-bag">
                <i class="fa fa-shopping-cart"  aria-hidden="true"></i>
            </li>
            <div id="myModal" class="modal">
                <div class="modal-content">
                    <div class="modal-header">
                       
                        <h5 style="color: black;" class="modal-title">Giỏ Hàng</h5>
                        <span class="close">&times;</span>
                    </div>
                    <div class="modal-body">
                        <div class="cart-row">
                            <span style="color: black;" class="cart-item cart-header cart-column">Sản Phẩm</span>
                            <span style="color: black;" class="cart-price cart-header cart-column">Giá</span>
                            <span style="color: black;" class="cart-quantity cart-header cart-column">Số Lượng</span>
                        </div>
                        <div class="cart-items">
                            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                            <c:forEach var="item" items="${cart.items}" >
                                <div class="cart-row">
                                    <div class="cart-item cart-column">
                                        <img class="cart-item-image" src="${pageContext.request.contextPath}/resource/assets/img/product/${item.product.brand}/${item.product.code}" width="100" height="100">
                                        <span id="cart-item" class="cart-item-title">${item.product.desc}</span>
                                    </div>
                                    <span class="cart-price cart-column">${item.product.price}</span>
                                    <div class="cart-quantity cart-column">
                                        <p class="cart-quantity-input">${item.quantity}</p>  
                                        <form action="${pageContext.request.contextPath}/removeProduct" method="POST" id="delete">
                                            <input type="hidden" name="productID" 
                                                   value="<c:out value='${item.product.code}'/>">
                                            <input type="hidden" name="quantity" value="0">
                                            <button id="delete" class="btn btn-danger" form="delete" type="submit">Xóa</button>
                                        </form>
                                    </div>
                                </div>                
                            </c:forEach>
                        </div>
                        <div class="cart-total">
                            <strong style="color: black;" class="cart-total-title">Tổng Cộng:</strong>
                            <span id="cart-total-price" style="color: black;" class="cart-total-price">${price}</span>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <p style="color: black;" class="messRemove" id="messRemove">${messRemove}</p>
                        <form action="${pageContext.request.contextPath}/products">
                            <button style="background-color: black;" type="submit" class="btn btn-primary order">Tiếp tục mua sắm</button>
                        </form>
                       <form action="${pageContext.request.contextPath}/checkOut">
                        <button style="background-color: black;" type="submit" class="btn btn-primary order">Thanh Toán</button>
                       </form>
                        <button type="button" class="btn btn-secondary close-footer">Đóng</button>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <section class="product">
        <div class="card">
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <img src="${pageContext.request.contextPath}/resource/assets/img/product/${product.brand}/${product.code}" alt="${product.desc}" style="width:100%">
         <p style="color: black;">${product.desc}</p>
         <p><span class="price" style="color: black;">${product.price}<sub style="color: black;">đ</sub></span></p></p>
         <!-- <p style="color:black;" class="price"><span style="color: black;">${product.price}<sub>đ</sub></span></p> -->
         <form action="${pageContext.request.contextPath}/addProduct" id="cartcontroller" method="POST">
           <div class="buttons_added">
               <!-- <input onclick="var result = document.getElementById('quantity'); var qty = result.value; if( !isNaN(qty) &amp; qty > 1 ) result.value--;return false;" type='button' value='-' />
               <button onclick='MyClickMinus()' class="minus">-</button>
               <p class="count" id="count">1</p>
               <button onclick='MyClickPlus()' class="plus">+</button> -->
               <input style="color: black;" type="hidden" name="productID" 
               value="<c:out value='${product.code}'/>">
               <input style="color: black;" class="minus" onclick="var result = document.getElementById('quantity'); var qty = result.value; if( !isNaN(qty) &amp; qty > 1 ) result.value--;return false;" type='button' value='-' />
               <!-- <p class="count" id="count">1</p> -->
               <input style="color: black;" class="quantity" id='quantity' min='1' name='quantity' type='text'  value='1' />
               <input style="color: black;" class="plus" onclick="var result = document.getElementById('quantity'); var qty = result.value; if( !isNaN(qty)) result.value++;return false;" type='button' value='+' />
               <!-- <button onclick='MyClickPlus()' class="plus">+</button> -->
           </div>
           <div class="cardproduct">
             <p style="color: black;" id="messAdd">${messAdd}</p>
                <p><button type="submit" form="cartcontroller">Thêm vào giỏ hàng</button></p>
                <br>
           </div>
         </form>
         
         <li id="cart"><button onclick='MyOnClick()' id="cart">Xem giỏ hàng</button></li>
         
        </div>
    </section>
    <footer>
        <section class="app-container">
            <p>Tải ứng dụng SARK</p>
            <div class="app-google">
                <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/appstore.png"></a>
                <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/googleplay.png"></a>
            </div>
            <p>Nhận bản tin SARK</p>
            <li> <input placeholder="Email" type="text">
                <i class="fa fa-arrow-left" aria-current="true"></i>
            </li>
            </div>
        </section>
        <!-------------------footer---------------->
        <div class="footer-top">
            <li>
                <a href="https://www.facebook.com/76storee"> <i class="fa-brands fa-facebook" aria-hidden="true"></i></li>
            <li><a href="">Liên Hệ</a></li>
            <li><a href="">Tuyển Dụng</a></li>
            <li><a href="">Giới Thiệu</a></li>
            <li>
                <a class="fa-brands fa-instagram" href="https://www.instagram.com/hi_hungw/?fbclid=IwAR2rgxF_ygWB_qOWBVH2qe1bKdH2uPfFD3HdQ9lnuDyq_GX00t2HxIxbFJM"></a>
            </li>
            <li>
                <i class="fa-brands fa-youtube"></i>
            </li>
        </div>
        <div class="information">
            <p>Shop bán hàng Online với số đăng ký kinh doanh: 0929468214 <br> Địa chỉ đăng ký: S5.02 VinHome Grand Park ,Đường Nguyễn Xiển , P.Long Thạnh Mỹ, Q.9, TP.HCM, Việt Nam - 092946821 <br> Đặt hàng online : <span>0929468214.</span>
            </p>
        </div>
        <div class="footer-bottom">
            <div>@SARK</div>
        </div>
    </footer>   
   
 </div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/controllerproduct.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/Modal.js"></script>

</html>