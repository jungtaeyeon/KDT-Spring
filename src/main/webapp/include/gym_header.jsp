<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="">여기내GYM</a>
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="/auth/loginForm.jsp">로그인</a>
        </li>
        <li class="nav-item">
        <!-- 
        확장자가 jsp이면 서블릿을 경유하지 않는다. - 목록에 보여줄 데이터가 없다?
        조회버튼 -> /notice/noticeList.gd요청하자 -  오라클 서버를 경유함
        확장자가 .gd이면 오라클 서버를 경유하니까 조회결과를 쥐고 있다.
        쥔다 - request.setAttribute() - 화면 출력하기
         -->
          <a class="nav-link active" href="/notice/noticeList">공지사항</a>
        </li>
        <li class="nav-item">
           <a class="nav-link" href="/board/boardList.jsp">게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">회원관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">QnA게시판</a>
        </li>
      </ul>
    </div>

  </div>
</nav>