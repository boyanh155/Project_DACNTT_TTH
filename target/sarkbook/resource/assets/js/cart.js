//const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);
//price
const qty_input = $$(".cart-left__qty .qty__input");
const htmlprice = $$(".js__price");
const minus = $$(".js__minus");
const plus = $$(".js__plus");
//name
const imgList = $$(".js__img");
//JSON
const dataJSONE = document.querySelector(".JSON__cart");
// dataJSON = [product={},qty},product={},qty},product={},qty}]
const dataJSON = JSON.parse(dataJSONE.value.product);
console.log(dataJSON);
//fake data
// const data = [{
//         name: `T-shirt`,
//         img: `//product.hstatic.net/1000178923/product/2-go9002-1_5df847aab82b408faac619bcf6d07874_master.jpg`,
//         price: `920.000 VND`,
//     },
//     {
//         name: `T-shirt`,
//         img: `//product.hstatic.net/1000178923/product/cc2b7672a2bb56e50faa6_b514d3d2885643a8bb3918c950f69135_master.jpg`,
//         price: `720.000 VND`,
//     },
//     {
//         name: `T-shirt`,
//         img: `//product.hstatic.net/1000178923/product/73d244f5903c64623d2d4_14d3fd6ea2a34dd4b2c7c5ca411f60a3_master.jpg`,
//         price: `650.000 VND`,
//     },
// ];
const listTotal = $$(".js__total");
// util
function getCurrency(input) {
  return input.toLocaleString("it-IT", { style: "currency", currency: "VND" });
}
//set once price for all product
function defaultPrice() {
  htmlprice.forEach((v, i) => {
    v.innerText = dataJSON[i].price;
  });
  let listPrice = Array.from(htmlprice).map((v, i) => {
    //get 550.000 and split(".")
    return v.innerText.split(" ")[0].split(".");
  });
  qty_input.forEach((v, i) => {
    let qty = v.value;
    let price = qty * parseInt(listPrice[i][0] + listPrice[i][1], 10);
    listTotal[i].innerText = `${getCurrency(price)}`;
  });
}
// set img for all product
// img validation
// "${pageContext.request.contextPath}/resource/assets/img/product/" + brand +"/" + datasrc
function defaultImg() {
  imgList.forEach((v, i) => {
    let datasrc = dataJSON[i].code || "./assets/img/No_Picture.jpg";
    let brand = dataJSON[i].brand;
    v.setAttribute(
      "src",
      "${pageContext.request.contextPath}/resource/assets/img/product/" +
        brand +
        "/" +
        datasrc
    );
    v.onerror = () => {
      v.src =
        "${pageContext.request.contextPath}/resource/assets/img/product/No_Picture.jpg";
    };
  });
}

defaultPrice();
defaultImg();

//List price
const listPrice = Array.from(htmlprice).map((v, i) => {
  //get 550.000 and split(".")
  return v.innerText.split(" ")[0].split(".");
});

// quantity input Area

//prevent enter,prevent zero space
function qtyinputvalid() {
  qty_input.forEach((v, i) => {
    v.addEventListener("keydown", (e) => {
      if (e.key == "Enter") {
        e.preventDefault();
      }
    });
  });
}
//add shake if first qty is 1

function checkShake() {
  qty_input.forEach((v, i) => {
    if (v.value > 1) {
      minus[i].classList.remove("shake");
    } else if (v.value == 1) {
      minus[i].classList.add("shake");
    }
    if (v.value == 19) {
      plus[i].classList.add("shake");
    } else if (v.value < 19) {
      plus[i].classList.remove("shake");
    }
  });
}
//Total handler
//input : qty of inline item
//i     : index of inline item must change
function totalCalc(input, i) {
  let qty = input || 1;
  if (qty === 1) {
    input = 1;
    price1 = parseInt(listPrice[i][0] + listPrice[i][1], 10) * 1;
    listTotal[i].innerText = `${getCurrency(price1)}`;
    checkShake();
  }
  if (qty >= 19) {
    input = 19;
    price1 = parseInt(listPrice[i][0] + listPrice[i][1], 10) * 19;
    listTotal[i].innerText = `${getCurrency(price1)}`;
    checkShake();
  } else {
    price1 = parseInt(listPrice[i][0] + listPrice[i][1], 10) * qty;
    listTotal[i].innerText = `${getCurrency(price1)}`;
    checkShake();
  }
}
//Total
function updateTotalPrice() {
  qty_input.forEach((v, i) => {
    let price1;
    v.addEventListener("input", (e) => {
      totalCalc(e.target.value, i);
    });
    v.addEventListener("focusout", (e) => {
      let input = e.target.value;
      if (input == "" || input == null) {
        e.target.value = 1;
      }
    });
  });
}
updateTotalPrice();
//add qty click button handler
minus.forEach((v, i) => {
  v.addEventListener("click", () => {
    if (qty_input[i].value > 1) {
      qty_input[i].value -= 1;
      let input = qty_input[i].value;
      totalCalc(input, i);
    }
    checkShake();
  });
  plus[i].addEventListener("click", () => {
    let qty = parseInt(qty_input[i].value);
    if (qty < 19) {
      qty_input[i].value = qty + 1;
      let input = qty_input[i].value;
      totalCalc(input, i);
    }
    checkShake();
  });
});

//Load default
window.onload = (e) => {
  checkShake();
  defaultPrice();
  qtyinputvalid();
  console.log("Halo");
};
