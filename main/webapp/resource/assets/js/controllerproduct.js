var messAdd;
var messRemove;
var modal = document.getElementById("myModal");
if(document.getElementById("messAdd")!=null){
    messAdd=document.getElementById("messAdd").innerHTML;
}
if(document.getElementById("messRemove") != null){
    messRemove=document.getElementById("messRemove").innerHTML;
}
if(messAdd==='Đã thêm sản phẩm.'||messRemove==='Đã xóa sản phẩm.'){
    modal.style.display = "block";
}


