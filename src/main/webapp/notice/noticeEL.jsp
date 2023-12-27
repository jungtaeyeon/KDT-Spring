<%@ page language="java"	contentType="text/html;charset=UTF-8"	pageEncoding="UTF-8"%>
<!-- 
  테스트 URL : http://localhost:8000/notice/noticeEL.jsp?mem_id=kiwi&pw=111
 -->
 파라미터로 넘어온 값: ${param.mem_id} -> <%= request.getParameter("mem_id")%>
 <br>
 파라미터로 넘어온 값: ${param.pw} -> <%= request.getParameter("pw")%>
 <hr>
 <br>
 쿠키정보 = ${cookie.mem_name}
 <br>
 쿠키정보 = ${cookie.mem_name.name}
 <br>
 쿠키값 = ${cookie.mem_name.value}
 <hr>
 <br>
 쿠키정보 = ${cookie.c_name}
 <br>
 쿠키정보 = ${cookie.c_name.name}
 <br>
 쿠키값 = ${cookie.c_name.value}