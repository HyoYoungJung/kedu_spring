<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">To do list❗</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시글 조회</div>
			<div class="panel-body">
					<div class="form-group">
						<label>번호</label> 
						<input class="form-control" name="no"
								value='<c:out value="${todo.no}"/>' 
								readonly="readonly">
					</div>

 					<div class="form-group">
 						<label>목표일자</label> 
 						<input class="form-control" name="todoDate"
								value="<fmt:formatDate value='${todo.todoDate}'/>"
 								readonly>
 					</div>				 
						
					<div class="form-group">
						<label>해야할일 </label> 
						<input class="form-control" name="content"
								value="${todo.content}" 
								readonly="readonly">
					</div>
					<div class="form-group">
						<label>등록일자 </label>
						<input class="form-control" name="regDate"
								value='<fmt:formatDate value="${todo.regDate}"/>' 
								readonly="readonly">
					</div>
					<div class="form-group">
						<label>수정일자 </label>
						<input class="form-control" name="updateDate"
								value='<fmt:formatDate value="${todo.updateDate}"/>' 
								readonly="readonly">
					</div>					
					
					<button data-oper='modify' class="btn btn-default">
					게시글 수정
					</button>
					<button data-oper='list' class="btn btn-default">
					게시글 목록
					</button>

					<form id='operForm' action="/todo/modify" method="get">
						<input type="hidden" id="no" name="no" value="${todo.no}">
						<input type="hidden" id="pageNum" name="pageNum"
								value="${cri.pageNum }">
						<input type="hidden" id="amount" name="amount" 
								value="${cri.amount }">
						<input type="hidden" id="type" name="type"
								value="${cri.type }">
						<input type="hidden" id="keyword" name="keyword"
								value="${cri.keyword }">
					</form>
			</div>
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<script>
	$(document).ready(function(){
		
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action","/todo/modify").submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#no").remove();
			operForm.attr("action","/todo/list");
			operForm.submit();
		})
		
	})
</script>


<%@include file="../includes/footer.jsp"%>
