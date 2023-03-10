import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import { BrowserRouter } from "react-router-dom";
import AuthLogic from "./service/authLogic";
import firebaseApp from "./service/firebase";
import "@fortawesome/fontawesome-free/js/all.js";
//import SampleApp from "./SampleApp";

//공통코드 -> service -> authLogic.js => import를 통해 외부 js를 재사용한다 -> export default '클래스명' 해야함 -> module찾아보면됨
//브라우저에서 import하려면 반드시 babel 필요함
// node.js로 출력되는 것이 있고 브라우저에서 출력되는 것이 있음
const authLogic = new AuthLogic(firebaseApp); //인스턴스화(파라미터가 올 수 있다)
//왜 파라미터가 필요한가? - firebaseApp -> import firebaseApp from "./service/firebase"; -> export default firebaseApp
// = authLogic.파이어베이스에서 제공하는 함수를 호출하겠다

//document.getElementById("root") -> index.html문서에서 DOM정보 수집하는 것임
//const root = ReactDOM.createRoot(document.getElementById("root")); => 옛날 문법
const root = ReactDOM.createRoot(document.querySelector("#root")); // =>최신 문법

root.render(
  <>
    {/* BrowserRouter사이에 있는 jsx 열린다 */}
    <BrowserRouter>
      {/* App컴포넌트를 렌더링할 때 속성자리에 주소번지를 넘길 수 있다 - props */}
      {/* 태그와 JS섞어쓰기 가능함 -  */}
      {<App authLogic={authLogic} />}
      {/* <SampleApp/> */} 
    </BrowserRouter>
  </>
);
