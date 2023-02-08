//비동기통신객체 생성해서 담을 변수 선언
let xhrObject = null; //선언
//비동기 통신객체 생성하는 함수 구현 - 단 리턴예약어가 없어서 반환받을 수 없음
function createRequest2() {
  //자바스크립트에서도 예외처리가 가능하다
  try {
    xhrObject = new XMLHttpRequest(); //constructor
  } catch (trymicrosoft) {
    try {
      //MS의 IE사용자 위한 객체 생성
      xhrObject = new ActiveXObject("Msxml2.XML.HTTP");
    } catch (error) {
      xhrObject = null;
    }
  }
  if (xhrObject == null) {
    alert("비동기 통신 객체 생성 에러");
  }
  return xhrObject; //return이 있어야 undefined가 되지않음
} //end of createRequest

//span태그가 가지고 있는 텍스트 노드값을 읽어오기
//<td>100</td> -> 태그이름이 없다 -> 속성을 정의못함 -> 아이디나 클래스를 정의 못함 ->
//-> 접근불가함  -> 어떡하지 -> 해결방법 : 텍스트 노드에 span태그 사용해서 감싸고 아이디 부여함
// document.querySelector("#id")
// document.querySelector(".class")
// document.querySelector("태그이름")
function getText(el) {
  let text = ""; //ES6 -> ECMAScript2015 - 적용안되는 브라우저이면 babel(자바스크립트 컴파일러) 필요하다
  //또는 번들러(HTML, CSS, JS의 코드들을 배포서버로 바꿔주는 것) parcel, webpack(리액트)
  if (el != null) {
    if (el.childNodes) { //el이 null스킵, undefined스킵, "", NaN 스킵
      console.log(el + "," + el.childNodes.length);
      for (let i = 0; i < el.childNodes.length; i++) {//costEl, priceEl
        let childNode = el.childNodes[i];
        //너 텍스트 노드니?
        if (childNode.nodeValue != null) {
          text = text + childNode.nodeValue;
        }
      }
    }
  }
  return text;
}
//기존 TextNode의 값을 다른 문자열로 바꾸기
/***********************************************
	param1 :document.getElementById("boardSold")
	param2 :xhrObject. 
	************************************************/
function replaceText(el, value) { //el -> boardSoldEl(보드 판매량을 계산하는), cahsEl(마진을 계산하는)
  if (el != null) {//span
    clearText(el); //기존에 있던 10을 지워주세요.
    //새로운 텍스트 노드 15를 생성하기
    let newNode = document.createTextNode(value); //15
    //위에서 생성한 텍스트 노드 값을 el에 붙이는 함수 호출하기
    el.appendChild(newNode); //el boardSoldEl -> <span>10</span> 
    //clear Text <span id=boardSold or cash></span> 
    //replace Text <span>20</span>
  }
}
//기존 태그안에 문자열 지우는 함수 구현
function clearText(el) {
  if (el != null) {
    if (el.childNodes) {//자바스크립트에서는 0이 아닌것은 모두 참이다
      for (let i = 0; i < el.childNodes.length; i++) {
        let childNode = el.childNodes[i];
        el.removeChild(childNode); //해당 el삭제하기 - DOM API -> 직관적이지 않다 -> 유지보수 어렵다 -> 쓰기싫다
      }
    }
  }
}
