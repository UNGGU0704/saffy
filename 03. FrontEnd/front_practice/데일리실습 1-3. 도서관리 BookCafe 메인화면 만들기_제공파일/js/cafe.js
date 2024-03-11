//## see: 투표 - 윈도우 load 이벤트 처리 익명 함수 
window.onload = function () {
  // localStorage에서 poll이름의 data 얻기.
  

  // 투표가 보여질 div 만들기: 엘리먼트 가져오기
  var pollDiv = document.querySelector("#vote");

  // localStorage에 진행 투표가 저장되어 있으면 투표 진행 화면 동적 만들기
  if (poll) {
    // localStorage에서 얻은 문자열을 JSON객체로 변환.
    var vote = JSON.parse(poll);

	// JSON 객체에서 정보 가져오기 : 시작일, 종료일, 질문, 답변항목
    var sdate = 1; // 시작일.
    var edate = 2; // 종료일.
    var question = 3; // 질문.
    var answers = 4; // 답변항목.

    // 투표 화면 구성.
    var pollContent = '<div class="vote_title">[ 당신의 선택 ]</div>';
    pollContent += '<div class="vote_question">' + question + "</div>";
    pollContent += '<div class="vote_answer">';
    pollContent += "  <ul>";
    for (var i = 0; i < answers.length; i++) {
      pollContent += "<li>";
      pollContent += "    <label>";
      pollContent += '      <input type="radio" name="vote_answer" value="' + answers[i] + '" />' + answers[i];
      pollContent += "    </label>";
      pollContent += "  </li >";
    }
    pollContent += "</ul>";
    pollContent += "</div>";
    pollContent += '<div class="vote_button">';
    pollContent += '  <button class="button btn_primary" onclick="javascript:poll();">투표하기</button>';
    pollContent += '  <button class="button">결과보기</button>';
    pollContent += "</div>";
    pollContent += '<div class="vote_date">투표기간 : ' + dateFormat(sdate) + " ~ " + dateFormat(edate) + "</div>";

    // 투표 화면에 투표양식 추가. : element.innerText / element.innerHTML
    

  } else {
    // 진행중인 투표가 없을 경우 화면 추가.
    
  }
};

//## see: 투표 
// 투표 시작일과 종료일 날짜 형식
function dateFormat(date) {
  var yymmdd = date.split("-");
  return yymmdd[0].substr(2, 2) + "." + yymmdd[1] + "." + yymmdd[2];
}



// 로그인
function login() {
  // 사용자 정보를 입력받는다.
  var userid = prompt("아이디입력", "ssafy");
  if (userid.length == 0) {
    alert("아이디 입력!!!");
    return;
  }
  var userpass = prompt("비밀번호입력", "1234");
  if (userpass.length == 0) {
    alert("비밀번호 입력!!!");
    return;
  }
  if (userid == "ssafy" && userpass == "1234") {
    alert("로그인 성공!!!");
    // id가 profile_img인 element의 src 속성의 값을 img/profile.png로 설정.
    document.querySelector("#profile_img").src = "img/profile.png";
    document.querySelector("#header_nav_confirm_off").style.display = "none";
    document.querySelector("#header_nav_confirm_on").style.display = "block";
  } else {
    alert("아이디 또는 비밀번호 확인!!!");
  }
}

// 로그아웃
function logout() {
  // id가 profile_img인 element의 src 속성의 값을 img/noimg.png로 설정.
  document.querySelector("#profile_img").setAttribute("src", "img/noimg.png");
  document.querySelector("#header_nav_confirm_on").setAttribute("style", "display: none");
  document.querySelector("#header_nav_confirm_off").setAttribute("style", "display: block");
}

//왼쪽 메뉴
var cnt = 0;
function slideDown(areaid) {
  // 지역별 메뉴를 클릭시 펼치기/접기
  if (areaid.style.display == "none") {
    areaid.style.display = "block";
    cnt++;
  } else if (areaid.style.display == "block") {
    areaid.style.display = "none";
    cnt--;
  }

  if (cnt == 4) {
    // 모든 메뉴가 펼쳐졌다면 전국매장접기 버튼 활성화
    document.querySelectorAll(".store_display_off")[0].style.display = "block";
    document.querySelectorAll(".store_display_on")[0].style.display = "none";
  } else {
    // 모든 메뉴가 접혔다면 전국매장펼치기 버튼 활성화
    document.querySelectorAll(".store_display_off")[0].style.display = "none";
    document.querySelectorAll(".store_display_on")[0].style.display = "block";
  }
}

// 모든 매장 펼치기 / 접기
function allSlide(onoff) {
  if (onoff == "on") {
    // 모든 매장 펼치기
    var subs = document.querySelectorAll(".store_item_sub");
    for (var i = 0; i < subs.length; i++) subs[i].style.display = "block";

    document.querySelectorAll(".store_display_off")[0].style.display = "block";
    document.querySelectorAll(".store_display_on")[0].style.display = "none";
    cnt = 4;
  } else {
    // 모든 매장 접기
    var subs = document.querySelectorAll(".store_item_sub");
    for (var i = 0; i < subs.length; i++) subs[i].style.display = "none";

    document.querySelectorAll(".store_display_off")[0].style.display = "none";
    document.querySelectorAll(".store_display_on")[0].style.display = "block";
    cnt = 0;
  }
}

//## see: 투표 : 
//투표하기
function poll() {
  //var votes = document.getElementsByName("vote_answer");
  var votes = document.querySelectorAll('input[name="vote_answer"]');
  var sel_menu = "";

  for (var i = 0; i < votes.length; i++) {
    if (votes[i].checked == true) {
      sel_menu = votes[i].value;
      break;
    }
  }
  alert(sel_menu + "를 선택했습니다.");
}

//## see: 투표 :
// 투표만들기
function pollMake() {
  // pollmake.html의 창아이디를 poll로 설정하고 가로 500, 세로 300인 창을 열기.
  window.open("pollmake.html", "poll", "width=500,height=300,top=300,left=400");
}

//## see: 투표 
// 답변 항목 추가
function addAnswer() {
  var listDiv = document.querySelector("#poll_answer_list");

  var divEl = document.createElement("div"); // <div></div>
  divEl.setAttribute("class", "poll_answer_item"); // <div class="poll_answer_item"></div>
  var inputEl = document.createElement("input"); // <input/>
  inputEl.setAttribute("type", "text"); // <input type="text"/>
  inputEl.setAttribute("name", "answer"); // <input type="text" name="answer"/>
  var buttonEl = document.createElement("button");
  buttonEl.setAttribute("type", "button");
  buttonEl.setAttribute("class", "button");
  // 버튼에 click 이벤트 리스너 등록.
  buttonEl.addEventListener("click", function (e) {
    var parent = this.parentNode;
    listDiv.removeChild(parent);
  });
  buttonEl.appendChild(document.createTextNode("삭제"));

  divEl.appendChild(inputEl);
  divEl.appendChild(buttonEl);
  listDiv.appendChild(divEl);
}

//## see: 투표 : 
// 투표 생성
function makePoll() {
  if (!document.querySelector("#question").value) {
    alert("질문 내용 입력!!!");
    return;
  }

  var answers = document.getElementsByName("answer");
  for (var i = 0; i < answers.length; i++) {
    if (!answers[i].value) {
      alert("답변 항목 입력!!!");
      return;
    }
  }

  alert("투표를 생성합니다.");
  self.close();




}

Window.onload = function () {
  let poll = localStorage.getItem("poll");

  var pollDiv = document.querySelector("vote"); 

  if (poll) {
    var vore = JSON.parsep(poll);

    var sdate = 1;
    var edate = 2;
    var question = 3;
    var answer = 4;

    var pollContent = '<div class="vote_title"> [ 당신의 선택 ]</div>'
    pollContent +=   '<div class="vote_question">' + question + "</div>"
    pollContent += '<div class = "vote answer">'

    
  }
}
