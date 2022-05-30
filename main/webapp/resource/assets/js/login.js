//password validation
const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);
//pattern
const lowerCaseLetters = /[a-z]/g;
const upperCaseLetters = /[A-Z]/g;
const numbers = /[0-9]/g;

//
const psw = $("#psw");
const message = $(".message");
//progress bar
const pbar = $("#myBar");
const cbar = $(".progress-bar");

//psw
//focus
psw.addEventListener("focus", (e) => {
    message.style.display = "none";
    cbar.style.display = "block";
});
//blur
psw.addEventListener("blur", (e) => {
    message.style.display = "block";
    cbar.style.display = "none";
});

function switchStatus(status) {}
//handler my bar
function updateBar(count, flag) {
    let temp = count;
    if (flag) {
        temp++;
    }
    switch (temp) {
        case 0:
            {
                if (!pbar.classList.contains("w3-red")) {
                    pbar.classList.remove("w3-yellow");
                    pbar.classList.remove("w3-green");
                    pbar.classList.add("w3-red");
                }
                move(0);
                break;
            }
        case 1:
            {
                if (!pbar.classList.contains("w3-red")) {
                    pbar.classList.remove("w3-yellow");
                    pbar.classList.remove("w3-green");
                    pbar.classList.add("w3-red");
                }
                move(25);
                break;
            }
        case 2:
            {
                if (!pbar.classList.contains("w3-yellow")) {
                    pbar.classList.remove("w3-red");
                    pbar.classList.remove("w3-green");
                    pbar.classList.add("w3-yellow");
                }
                move(50);
                break;
            }
        case 3:
            {
                if (!pbar.classList.contains("w3-yellow")) {
                    pbar.classList.remove("w3-red");
                    pbar.classList.remove("w3-green");
                    pbar.classList.add("w3-yellow");
                }
                move(75);
                break;
            }
        case 4:
            {
                if (!pbar.classList.contains("w3-green")) {
                    pbar.classList.remove("w3-red");
                    pbar.classList.remove("w3-yellow");
                    pbar.classList.add("w3-green");
                }
                move(100);
                break;
            }
    }
}
//progress bar
function move(wb) {
    pbar.style.width = wb + "%";
}

//typing
psw.addEventListener("keyup", (e) => {
    var count = 0;
    let mypwd = e.target.value;
    let flagNum = false;
    //lower
    if (mypwd.match(lowerCaseLetters)) {
        count++;
    }
    //upper
    if (mypwd.match(upperCaseLetters)) {
        count++;
    }
    //number
    if (mypwd.match(numbers)) {
        count++;
    }
    //8chars
    if (mypwd.length >= 8) {
        flagNum = true;
    }
    updateBar(count, flagNum);
});