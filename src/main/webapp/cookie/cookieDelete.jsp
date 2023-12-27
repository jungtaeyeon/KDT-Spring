<%@ page language="java"	contentType="text/html;charset=UTF-8"	pageEncoding="UTF-8"%>
<%
  // 스크립틀릿
  Cookie c_name = new Cookie("ename","smith");
  c_name.setMaxAge(0); // 60초 동안

  Cookie c_name2 = new Cookie("ename2","");
  c_name2.setMaxAge(0); // 60초 동안

  response.addCookie(c_name); // 쿠키를 클라이언트에 내려줌
  response.addCookie(c_name2); // 쿠키를 클라이언트에 내려줌
%>