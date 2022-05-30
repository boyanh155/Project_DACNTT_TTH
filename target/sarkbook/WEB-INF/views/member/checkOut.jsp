<%@ page language="java" 
contentType="text/html;charset=utf-8"
pageEncoding="utf-8"
import="java.sql.*"
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/assets/css/member/checkOut.css">

</head>
<body>
  <div class="row">
    <div class="col-75">
      <div class="container">
        <form action="${pageContext.request.contextPath}/order" method="post" id="checkout">
          <div class="row">
            <div class="col-50">
              <h3>Billing Address</h3>
              <label for="fname"><i class="fa fa-user"></i> Full Name</label>
              <input type="text" id="fname" name="fname" placeholder="Nguyễn Thái Hưng">
              <label for="email"><i class="fa fa-envelope"></i> Email</label>
              <input type="text" id="email" name="email" placeholder="hưng@example.com">
                <div class="City">
                  <li class="add1" >
                    <label for="city"><i class="fa fa-institution"></i> City</label>
                    <!-- <input type="text" id="city" name="city" placeholder="New York"> -->
                    <select name="calc_shipping_provinces" class="calc_shipping_provinces" required="">
                      <option value="">Tỉnh / Thành phố</option>
                    </select>     
                    <input name="billing_address_1" class="billing_address_1" id="billing_address_1" type="hidden" value="">     
                  </li>
                  <li class="add2" >
                    <label for="city"><i class="fa fa-institution"></i> District</label>
                    <select name="calc_shipping_district" class="calc_shipping_district" required="">
                      <option value="">Quận / Huyện</option>
                    </select>
                    <input name="billing_address_2" class="billing_address_2" id="billing_address_2" type="hidden" value="">
                    <!-- <input type="text" id="city" name="city" placeholder="New York"> -->
                        
                  </li>
                </div>
                <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                <input type="text" id="address" name="address" placeholder="Thành phố-Quận/huyện-Thị xã">
                <label for="pnum">Phone</label>
                <input type="text" id="pnum" name="pnum" placeholder="0123456789"> 
            </div>
      
            <div class="col-50">
              <h3>Payment</h3>
              <label for="fname">Accepted Cards</label>
              <div class="icon-container">
                <i class="fa fa-cc-visa" style="color:navy;"></i>
                <i class="fa fa-cc-amex" style="color:blue;"></i>
                <i class="fa fa-cc-mastercard" style="color:red;"></i>
                <i class="fa fa-cc-discover" style="color:orange;"></i>
              </div>
            </div>
          </div>
            <label>
            <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
            </label>
            <input type="submit" value="Continue to checkout" class="btn" form="checkout">
        </form>
      </div>
    </div>
        <div class="col-25">
            <div class="container">
             <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> </span></h4>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
             <c:forEach var="item" items="${cart.items}">
                 <p>${item.product.desc}<span class="quantity">${item.quantity}</span><span class="price">${item.product.price}</span> </p>
                 <hr>
             </c:forEach>
             <hr>
             <hr>
             <p>Total <span class="price" style="color: black;"> <b>${price}</b></span></p>
            </div>
        </div>
  </div>
   
</body>
<script  src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
    
    <script  src='https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js'></script>
<script>
if (address_2 = localStorage.getItem('address_2_saved')) {
  $('select[name="calc_shipping_district"] option').each(function() {
    if ($(this).text() == address_2) {
      $(this).attr('selected', '')
    }
  })
  $('input.billing_address_2').attr('value', address_2)
}
if (district = localStorage.getItem('district')) {
  $('select[name="calc_shipping_district"]').html(district)
  $('select[name="calc_shipping_district"]').on('change', function() {
    var target = $(this).children('option:selected')
    target.attr('selected', '')
    $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
    address_2 = target.text()
    $('input.billing_address_2').attr('value', address_2)
    district = $('select[name="calc_shipping_district"]').html()
    localStorage.setItem('district', district)
    localStorage.setItem('address_2_saved', address_2)
  })
}
$('select[name="calc_shipping_provinces"]').each(function() {
  var $this = $(this),
    stc = ''
  c.forEach(function(i, e) {
    e += +1
    stc += '<option value=' + e + '>' + i + '</option>'
    $this.html('<option value="">Tỉnh / Thành phố</option>' + stc)
    if (address_1 = localStorage.getItem('address_1_saved')) {
      $('select[name="calc_shipping_provinces"] option').each(function() {
        if ($(this).text() == address_1) {
          $(this).attr('selected', '')
        }
      })
      $('input.billing_address_1').attr('value', address_1)
    }
    $this.on('change', function(i) {
      i = $this.children('option:selected').index() - 1
      var str = '',
        r = $this.val()
      if (r != '') {
        arr[i].forEach(function(el) {
          str += '<option value="' + el + '">' + el + '</option>'
          $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>' + str)
        })
        var address_1 = $this.children('option:selected').text()
        var district = $('select[name="calc_shipping_district"]').html()
        localStorage.setItem('address_1_saved', address_1)
        localStorage.setItem('district', district)
        $('select[name="calc_shipping_district"]').on('change', function() {
          var target = $(this).children('option:selected')
          target.attr('selected', '')
          $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
          var address_2 = target.text()
          $('input.billing_address_2').attr('value', address_2)
          district = $('select[name="calc_shipping_district"]').html()
          localStorage.setItem('district', district)
          localStorage.setItem('address_2_saved', address_2)
        })
      } else {
        $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>')
        district = $('select[name="calc_shipping_district"]').html()
        localStorage.setItem('district', district)
        localStorage.removeItem('address_1_saved', address_1)
      }
    })
  })
})
</script>
</html>
