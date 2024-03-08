/* idcheck.js */

/* 페이지 load 이벤트 핸들러 함수
        메인윈도우 정보 가져오기 :
        window.opener : open() 메소드로 윈도우를 연 문서가 있는 부모윈도우 객체
*/
window.onload = function () {
};

/* 아이디 존재 유무 검사 메서드
        -- 아규먼트로 전달받은 아이디가 존재하는지 검사해서 존재하면 true 반환
*/

/*  "아이디 중복확인" 요청 이벤트 리스너: 콜백함수 바인딩 
    - 함수이름 idCheckClick
    - id="memberIdCheckButton"
*/

/* 검증받은 아이디 사용하기 : 
    idCheck.html (id="idCommitButton")
    함수이름: idCommit()
    검증받은 아이디로 부모윈도우(회원가입)의 아이디를 설정한후에
    현재윈도우(아이디검증) 닫고 부모윈도우(회원가입페이지)으로 이동 

*/


/* 취소 버튼 초기화 */

/* memberIdCheck 키입력 이벤트 */
