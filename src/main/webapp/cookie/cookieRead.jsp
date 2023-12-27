<%@ page language="java"	contentType="text/html;charset=UTF-8"	pageEncoding="UTF-8"%>
<%
  Cookie[] cs = request.getCookies();
  for(int i=0; i<cs.length; i++){
    if("ename".equals(cs[i].getName())){ // 쿠키의 이름을 가져오는 메소드 .getName
      out.println(cs[i].getValue());
    };
    if("ename2".equals(cs[i].getName())){ // 쿠키의 이름을 가져오는 메소드 .getName
      out.print(cs[i].getValue());
    };
  };
%>
<!-- 
  http://localhost:8000/cookie/cookieMake.jsp -> 쿠키 생성 후 아래 주소
  http://localhost:8000/cookie/cookieRead.jsp
 -->