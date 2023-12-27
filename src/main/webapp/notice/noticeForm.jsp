<%@ page language="java"	contentType="text/html;charset=UTF-8"	pageEncoding="UTF-8"%>

<form method="post" id="f_notice" action="/notice/noticeInsert">
  <a href="javascript:noticeInsert()"> 여기 </a>
</form>

<script>
  const noticeInsert = () => {
    console.log("noticeInsert");
    document.querySelector("#f_notice").submit();
  }
</script>