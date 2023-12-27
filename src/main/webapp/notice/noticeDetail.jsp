<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList, java.util.HashMap" %>        
<%
	int size = 0;//지변이니까 초기화를 생략하면 에러발생함.
  List<Map<String, Object>> nList = (List)request.getAttribute("nList");
  Map<String, Object> rmap = null;
    if(nList != null){
      size = nList.size();
      if(size == 1){
      rmap = nList.get(0);
      }
    }
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항상세</title>
<%@include file="/common/bootstrap_common.jsp"%>
<link rel="stylesheet" href="/css/notice.css">
<script type="text/javascript">
	const noticeDelete = () => {
	
	}
	const noticeList = () => {

	}
	const noticeUpdate = () => {

	}	
</script>
</head>
<body>
	<!-- header start -->
	<%@include file="/include/gym_header.jsp"%>
	<!-- header end    -->
	<!-- body start    -->
	<div class="container">
		<div class="page-header">
			<h2>공지사항 <small>공지상세보기</small></h2>
			<hr />
		</div>
		
		<!-- 공지목록 시작 -->


	      <div style="width:58rem;">
	        <div class="card-body">
	          <div class='book-detail'>
	            <div class='book-header'>
	            
				<div class="input-group mb-3">
				<span class="input-group-text">제목</span>
				<div style="width:500px;">
					<input type="text" class="form-control"  value="<%=rmap.get("N_TITLE") %>">
				</div>
				</div>
				
				<div class="input-group mb-3">
				<span class="input-group-text">작성자</span>
				<div class="col-xs-3">
					<input type="text" class="form-control"  value="<%=rmap.get("N_WRITER") %>">
				</div>
				</div>
				
				<div class="input-group mb-3">
				<span class="input-group-text">내용</span>
				<div class="col-xs-8">
					<textarea class="form-control" id="exampleFormControlTextarea1" rows="5" cols="80"><%=rmap.get("N_CONTENT") %></textarea>
				</div>
				</div>
				

	            </div>
	          </div>
	        </div>
			<hr/>
	        <div class='detail-link'>
	          <button class="btn btn-info" data-bs-toggle="modal" data-bs-target="#noticeUpdateForm">
	          	수정
	          </button>
	          &nbsp;
	          <button class="btn btn-warning" onclick="noticeDelete()">
	            삭제
	          </button>
	          &nbsp;
	          <button class="btn btn-success" onclick="noticeList()">
	          공지목록
	          </button>
	        </div>
	      </div>  
		
		<!-- 회원목록   끝  -->		
		
	</div>
	<!-- body end       -->
	<!-- footer start -->
	<%@include file="/include/gym_footer.jsp"%>
	<!-- footer end    -->	
	
	<!-- ========================== [[ 공지사항 수정 Modal ]] ========================== -->
	<div class="modal" id="noticeUpdateForm">
	  <div class="modal-dialog modal-dialog-centered">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">공지사항수정</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	      	<form id="f_notice" method="get" action="./noticeUpdate">
	      	  <input type="hidden" name="n_no" value="<%=rmap.get("N_NO")%>">
	          <div class="form-floating mb-3 mt-3">
	            <input type="text"  class="form-control" id="n_title" name="n_title" placeholder="Enter 제목"  value="<%=rmap.get("N_TITLE")%>"/>
	            <label for="mem_id">제목</label>
	          </div>	      	
	          <div class="form-floating mb-3 mt-3">
	            <input type="text"  class="form-control" id="n_writer" name="n_writer" placeholder="Enter 작성자"   value="<%=rmap.get("N_WRITER")%>"/>
	            <label for="mem_pw">작성자</label>
	          </div>	      		  
	          <div class="form-floating mb-3 mt-3">
	            <textarea rows="5" class="form-control h-25" aria-label="With textarea" id="n_content" name="n_content"><%=rmap.get("N_CONTENT")%></textarea>
	          </div>	      	
	      	</form>
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <input type="button" class="btn btn-warning" data-bs-dismiss="modal" onclick="noticeUpdate()"  value="저장">
	        <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="닫기">
	      </div>
	
	    </div>
	  </div>
	</div>
    <!-- ========================== [[ 회원가입 Modal ]] ========================== -->		
	
</body>
</html>