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
				
				<form action="todo" method="POST">
				
<%-- 				<input type="hidden" name="type" value="${cri.type}"> --%>
<%-- 				<input type="hidden" name="keyword" value="${cri.keyword}"> --%>
<%-- 				<input type="hidden" name="pageNum" value="${cri.pageNum}"> --%>
<%-- 				<input type="hidden" name="amount" value="${cri.amount}"> --%>
				
					<div class="form-group">
						<label>번호</label> 
						<input class="form-control" name="no"
								value='<c:out value="${todo.no}"/>' 
								readonly="readonly">
					</div>
					<div class="form-group">
						<label>목표일자</label> 
						<input class="form-control" name="todoDate"
								value='<fmt:formatDate value="${todo.todoDate}"/>' >
					</div>
				   
					<div class="form-group">
						<label>해야할일</label>
						<textarea class="form-control" name="content" rows="10" 
									value="<c:out value='${todo.content}'/>">
						</textarea>
					</div>
					
					<div class="form-group">
						<label>등록일자</label>
						<input class="form-control" name="regDate"
								value='<fmt:formatDate value="${todo.regDate}"/>' 
								readonly="readonly">
					</div>
					<div class="form-group">
						<label>수정일자</label>
						<input class="form-control" name="updateDate"
								value='<fmt:formatDate value="${todo.updateDate}"/>' 
								readonly="readonly">
					</div>
<!-- 					<div class="form-group"> -->
<!-- 						<label>수정일자</label> -->
<!-- 						<input class="form-control" name="updateDate" -->
<%-- 								value='<fmt:formatDate pattern="yyyy/MM/dd" --%>
<%-- 								value="${todo.updateDate}"/>' readonly> --%>
<!-- 					</div> -->
										
					<button type="submit" data-oper='modify' class="btn btn-default">
									게시글 수정</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">
									게시글 삭제</button>
					<button type="submit" data-oper='list' class="btn btn-info">
									게시글 목록</button>
				</form>
			</div>
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(function(){
	var formObj = $("form");
	
	$('button').on("click", function(e){
		e.preventDefault();
		
		var operation = $(this).data("oper");
		
		console.log(operation);
		
		if(operation === 'remove'){
			formObj.attr("action", "/todo/remove")
					.attr("method", "POST");
		} else if (operation === 'modify'){
			formObj.attr("action","/todo/modify")
					.attr("method", "POST");
		} else if (operation === 'list'){
			formObj.attr("action", "/todo/list").attr("method", "get");
			
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();
			var typeTag = $("input[name='type']").clone();
			var keywordTag = $("input[name='keyword']").clone();

			
			formObj.empty();
			formObj.append(pageNumTag);
			formObj.append(amountTag);
			formObj.append(typeTag);
			formObj.append(keywordTag);
		}
		formObj.submit();
	})
})
</script>

<%@include file="../includes/footer.jsp"%>
