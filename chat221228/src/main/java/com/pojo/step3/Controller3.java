package com.pojo.step3;
import java.io.IOException;

import javax.servlet.ServletException;
//javascript 기반의 UI API
//바닐라 스크립트를 잘 알아야 리액트를 잘 할 수 있다
//리액트 = 바닐라 스크립트 + ES6(주요이슈 - 스프레드 연산자, module화, arrowfunction), ES7 + html섞어쓰기
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller3 {
	public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res);
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
