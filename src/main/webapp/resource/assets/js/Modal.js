// Modal
var modal = document.getElementById("myModal");
var messRemove;
var btn = document.getElementById("cart");

// var mess=document.getElementById("mess").innerHTML;
var close = document.getElementsByClassName("close")[0];
// tại sao lại có [0] như  thế này bởi vì mỗi close là một html colection nên khi mình muốn lấy giá trị html thì phải thêm [0]. 
// Nếu mình có 2 cái component cùng class thì khi [0] nó sẽ hiển thị component 1 còn [1] thì nó sẽ hiển thị component 2.
var close_footer = document.getElementsByClassName("close-footer")[0];
var order = document.getElementsByClassName("order")[0];
function MyOnClick(){
  modal.style.display = "block";
}

if(document.getElementById("delete") !=null){
    var btnDelete=document.getElementById("delete");
    if(btnDelete!=null)
    {
        btnDelete.onclick=function(){
            // alert("Đã xóa sản phẩm")
            modal.style.display="block";
            
        }
    }
}
btn.onclick = function () {
  modal.style.display = "block";
}
close.onclick = function () {
  modal.style.display = "none";
}
close_footer.onclick = function () {
  modal.style.display = "none";
}
order.onclick = function () {
  alert("Còn nhiều đồ đẹp lắm đấy 🙂")
}
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

