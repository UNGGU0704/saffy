/* signup.js */
// js 파일 로딩 확인하기
// alert('loading signup.js');
// console.log('loading signup.js');

/* 비밀번호 보이기/감추기 */

let isShowPw = document.getElementById("isShowMemberPw"); // 패스워드 보이는가?

isShowPw.addEventListener('click', function () {

    let text = ['보이기', '감추기'];
    
    //checkbox 엘리먼트 가져오기 
    
    let isShowTextPw = document.getElementById("isShowMemberPwText");

    //비밀번호, 비밀번호 확인 
    let passwordInput = document.getElementById("memberPw"); // 입력받은 패스워드
    let passwordConfirm = document.getElementById("memberPwConfirm");
    
    if (isShowPw.checked) {
        passwordInput.type = 'text';
        passwordConfirm.type = 'text';
        isShowTextPw.innerText = text[0];
    } else {
        passwordInput.type = 'password';
        passwordConfirm.type = 'password';
        isShowTextPw.innerText = text[1];
    }


}); //이벤트 리스터 부착

let isShowPwimg = document.getElementById('isShowMemberPwImg');
let isShow = true;

isShowPwimg.addEventListener('click', function () {

    let imgFile = ['./img/hide.png', './img/show.png'];
    let imgTitle = ['비밀번호 감추기', '비밀번호 보이기'];

     //비밀번호, 비밀번호 확인 
     let passwordInput = document.getElementById("memberPw"); // 입력받은 패스워드
     let passwordConfirm = document.getElementById("memberPwConfirm");
     
     if (isShow) {
         passwordInput.type = 'text';
         passwordConfirm.type = 'text';
         isShowPwimg.src = imgFile[0];
         isShowPwimg.text = imgTitle[0];
         isShow = false;
     } else {
         passwordInput.type = 'password';
         passwordConfirm.type = 'password';
         isShowPwimg.src = imgFile[1];
         isShowPwimg.text = imgTitle[1];
         isShow = true;
     }
 
});

/* 비밀번호 show/hide 이미지 */

/* 비밀번호, 비밀번호 확인 매핑하기 */

let memberPwElement = document.getElementById("memberPw");
let memberPwConfirmElement = document.getElementById("memberPwConfirm");

memberPwConfirmElement.addEventListener('keyup', function () { 
    let memberPwValue = document.getElementById('memberPw').value;
    let memberPwConfirmValue = document.getElementById('memberPwConfirm').value;

    let memberPwConfirmElement = document.getElementById('memberPwMessage')

    if (memberPwConfirmValue.trim().length > 0) {
        if (memberPwValue == memberPwConfirmValue) {
            memberPwConfirmElement.innerText = "비밀번호 확인이 동일합니다.";
            memberPwConfirmElement.style.color = 'green';
        } else {
            memberPwConfirmElement.innerHTML = "비밀번호가 같지 않습니다."
            memberPwConfirmElement.style.color = 'red';
            memberPwConfirmElement.style.fontWeight = 'bold';
            memberPwConfirmElement.focus();
        }
    } else {
        memberPwElement = '';
    }
});

/* 휴대폰 중간번호 다음 입력항목 이동하기 */

/* 휴대폰 끝번호 다음 입력항목 이동하기 */

/* 이메일 선택 및 이메일 직접입력 */

let email2Element = document.getElementById('email2');
let emailChooseElement = document.getElementById('emailChoose');

emailChooseElement.addEventListener('charge', function () {
    
    let emailElement = document.getElementById('email');
    let emailValue = document.getElementById('email').value.trim();

    if (emailValue == null || email2Element.value.length) {
        emailElement.placeholder = "이메일 아이디를 입력하세요";
        emailElement.focus();

        emailChooseElement.selectIndex = 0;
    } else {

        let emailChooseValue = document.getElementById('emailChoose').value;

        switch (emailChooseValue) {
            case 'NONE':
                email2Element.value = '';
                email2Element.readOnly = true;
            case 'USER_INPUT':
                emailChooseValue.value = '';
                email2Element.readOnly = true;
            default:
                email2Element.value = emailChooseValue;
                email2Element.readOnly = true;
        } 
    }
});


/* ID 중복확인 새창 열기 */

/* 회원 사용자 객체 : 생성자 함수 선언 */

/* 회원객체 정보 */

/* 회원 가입 이벤트 리스너 */

/* 취소버튼 처리 : 회원가입양식 초기화, 아이디 항목 포커스 이동하기 */
