<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
    <%-- Loc change --%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>SARK</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/fonts/icon_font/font-awesome/css/font-awesome.min.css">
  
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/oneshot/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/layout/cart.css">
</head>

<body>
    <header class="Header">
        <div class="Logo">
            <a href="#"> <img src="${pageContext.request.contextPath}/resource/assets/img/home/logo_200x200.png" height="150" width="150" alt="Amazing" class="reponsive"></a>
        </div>
        <div class="Menu">
            <li class="Menu__Trademark"><a href="">TRADEMARK</a>
                <ul class="Menu__Trademark__List">
                    <li class="Menu__Trademark__List__Babhabit"><a href="category.jsp">Bad Habits</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/logobadhabit.jpg" alt="" class="reponsive">
                            <li> <a href="">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                    <li class="Menu__Trademark__List__Dirtycoins"><a href="category.jsp">Dirty Coins</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/logodirtycoin.png" alt="" class="reponsive">
                            <li><a href="">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                    <li class="Menu__Trademark__List__UnCover"><a href="category.jsp">Un Cover</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/Logouncover.jpg" alt="" class="reponsive">
                            <li><a href="">T-SHIRT</a></li>
                            <li><a href="">SHIRT</a></li>
                            <li><a href="">OUTERWEAR</a></li>
                            <li><a href="">HOODIES</a></li>
                            <li><a href="">SHORT & PANTS</a></li>
                        </ul>
                    </li>
                    <li class="Menu__Trademark__List__DAVIES"><a href="category.jsp">DAVIES</a>
                        <ul class="List">
                            <img src="${pageContext.request.contextPath}/resource/assets/img/home/logodavies.jpg" alt="" class="reponsive">
                            <li><a href="">T-SHIRT</a></li>
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
                            <li><a href="">Hồ Chí Minh</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li class="Menu__Contact"><a href="">CONTACT</a></li>
        </div>

            <input type="hidden" class="JSON" name="JSON" value='${sessionScope.memberJSON}'>

        <div class="Other">

            <!-- user -->
            <%-- TIng --%>
            <!-- member -->
            <div class="member">
                <div class="member__avt">
                                <li class="Other__item Other__User">          
                                    <a class="fa fa-user js__icon--user"  href="${pageContext.request.contextPath}/member"></a>    
                                </li>
                </div>
                <div class="member__name" >
                    <span class="js__membername" >${account.lastName}</span>
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
                <c:if test="${sessionScope.account !=null}">
                    <a class="fa fa-outdent js__icon--user"  href="${pageContext.request.contextPath}/sign-out"></a>
                </c:if > 
                <c:if test="${sessionScope.account == null}">
                    <a class="fa fa-indent js__icon--user"  href="${pageContext.request.contextPath}/sign-in"></a>
                </c:if >        
                                
            </li>
            <!--cart icon -->
            <li id="cart" class="Other__item Other__shoopping-bag">
                <a class="fa fa-shopping-cart" aria-hidden="true"></a>
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
                            
                            <c:forEach var="item" items="${cart.items}" >
                                <div class="cart-row">
                                    <div class="cart-item cart-column">
                                        <img class="cart-item-image" src="${pageContext.request.contextPath}/resource/assets/img/product/${item.product.brand}/${item.product.code}" width="100" height="100">
                                        <span id="cart-item" class="cart-item-title">${item.product.desc}</span>
                                    </div>
                                    <span class="cart-price cart-column">${item.product.price}</span>
                                    <div class="cart-quantity cart-column">
                                        <p class="cart-quantity-input">${item.quantity}</p>
                                        
                                        <form action="${pageContext.request.contextPath}/CartControLlers" method="POST" id="delete">
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
                            <span style="color: black;" class="cart-total-price">${price}</span>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <!-- <p style="color: black;" class="messRemove" id="messRemove">${messRemove}</p> -->
                        <form action="${pageContext.request.contextPath}/products">
                            <button style="background-color: black;"  type="submit" class="btn btn-primary order">Tiếp tục mua sắm</button>
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
    <section id="Slide">
        <div class="row">
            <div class="row-1">
                <div class="row-1-col-1">
                    <div class="aspect-ratio-169">
                        <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide5.jpg" alt=""></a>
                        <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide6.jpg" alt=""></a>
                        <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide7.jpg" alt=""></a>
                        <a href=""> <img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide8.jpg" alt=""></a>
                    </div>
                    <div class="dot-container">
                        <div class="dot active"></div>
                        <div class="dot"></div>
                        <div class="dot"></div>
                        <div class="dot"></div>
                    </div>
                </div>
            </div>
            <div class="row-2">
                <div class="row-2-item">
                    <a href="products?action=display_products"><img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide5.jpg" alt="" class="row-2-item"></a>
                </div>
                <div class="row-2-item">
                    <a href="products?action=display_products"><img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide6.jpg" alt="" class="row-2-item"></a>
                </div>
                <div class="row-2-item">
                    <a href="products?action=display_products"><img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide7.jpg" alt="" class="row-2-item"></a>
                </div>
                <div class="row-2-item">
                    <a href="products?action=display_products"><img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide8.jpg" alt="" class="row-2-item"></a>
                </div>
                <div class="row-2-item">
                    <a href="products?action=display_products"><img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide5.jpg" alt="" class="row-2-item"></a>
                </div>
                <div class="row-2-item">
                    <a href="products?action=display_products"><img src="${pageContext.request.contextPath}/resource/assets/img/home/slide/slide6.jpg" alt="" class="row-2-item"></a>
                </div>
            </div>
            <div class="row-3"></div>
        </div>
    </section>
    <!-------------------app---------------->
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
    <%-- <input type="hidden" class="JSON" name="JSON" value="${member.avt}"> --%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/controllerproduct.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/Modal.js"></script>
<script>
    const header=document.querySelector("header")
    const imgPosition =document.querySelectorAll(".aspect-ratio-169 img") 
    const imgContainer=document.querySelector(".aspect-ratio-169")
    const dotItem=document.querySelectorAll(".dot")
    let imgNumber=imgPosition.length
    index=0
    /*console.log(imgPosition)*/
    imgPosition.forEach(function(image,index){
       image.style.left=index*100+"%"
       dotItem[index].addEventListener("click",function(){
        slider(index)
       })
    })
    function imgSlide(){
        index++;
        console.log(index)
       if(index>=imgNumber)
       {
           index=0;
       }
        imgContainer.style.left="-" +index*100+"%"
        slider(index)
        
    }
    function slider(index){
        imgContainer.style.left="-" +index*100+ "%"
        const dotActive=document.querySelector('.active')
        dotActive.classList.remove("active")
        dotItem[index].classList.add("active")
    }
    setInterval(imgSlide,5000)
</script>
<!-- NEW -->
<!-- <script>
    //container
    const memberAvt = document.querySelector(".member__avt");
    const memberName = document.querySelector(".member__name");
    //JSON
    const dataJSONE = document.querySelector(".JSON");
    const dataJSON = JSON.parse(dataJSONE.value);
    //Icon change
    const userE = document.querySelector(".Other__User")
    const iconUser =  document.querySelector(".js__icon--user");
    const iconEdit =  document.querySelector(".js__icon--edit");
    if(${sessionScope.memberJSON eq null}){
        iconUser.style.display ="block";
    }
    else{
        iconUser.style.display ="none";
        iconEdit.style.display = "block";
    }
    //
    const hideImg = document.querySelector(".js__memberimg");
    const hideName = document.querySelector(".js__membername")
    hideImg.style.display = "none";
    hideName.style.display ="none";
    //handle data
    function getInfo(username,avt) {
        let myAvt = document.createElement("img");
        let myName = document.createElement("span");
        myAvt.setAttribute("src", avt);
        let uname = username || "guest";
        myName.innerHTML ="<span>"+uname+"</span>";
        memberAvt.appendChild(myAvt);
        memberName.appendChild(myName);
    }
    // get data
    const {username,avt} = dataJSON;
    if(username != undefined || avt != undefined){
        getInfo(username,avt);
    }
    else{
        hideImg.style.display = "block";
        hideName.style.display ="inline-block";
    }

</script> -->

</html>