
function login() {

    //아이디 입력
    let userid = prompt('아이디 입력', 'ssafy');
    
    //아이디 데이터 검증
    if (userid == null || userid.trim().length == 0) {
        alert("아이디를 제대로 입력하세요");
        return;
    }
    //비밀번호 입력
    let userpw = prompt('비밀번호 입력', 1234);

    if (userpw == null || userpw.trim().length == 0) {
        alert("비밀번호를 제대로 입력하세요");
        return;
    }

    //로그인 정보 확인

    if (userid == 'ssafy' && userpw == '1234') {
        alert('로그인 성공');
        document.getElementById("profile_img").src = "img/profile.png";
        document.getElementById("header_nav_confirm_off").style.display = "none";
        document.getElementById("header_nav_confirm_on").style.display = "block";
    } else {
        alert('로그인 실패');
    }
}


function logout() {
    document.querySelector('#profile_img').setAttribute('src', 'img/noimg.png');
    document.querySelector('#header_nav_confirm_off').setAttribute('style', 'display:block');
    document.querySelector("#header_nav_confirm_on").setAttribute('style', 'display:none');
}

function allslide(onoff) {
    let subs = document.querySelectorAll(".store_item_sub ul");
    if (onoff === "on") {
        for (let i = 0; i < subs.length; i++) {
            subs[i].style.display = "block";
        }
        document.querySelector(".store_display_on").style.display = "none";
        document.querySelector(".store_display_off").style.display = "block";
    } else {
        for (let i = 0; i < subs.length; i++) {
            subs[i].style.display = "none";
        }
        document.querySelector(".store_display_on").style.display = "block";
        document.querySelector(".store_display_off").style.display = "none";
    }
}
