<%@ page import="vo.Customer"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>${ customer.customerName }고객 계좌 수정하기</title>
	<link rel="Stylesheet" href="/test-web/styles/default.css" />
	<link rel="Stylesheet" href="/test-web/styles/input2.css" />
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/header.jsp">
			<jsp:param value="" name="bgColor"/>
		</jsp:include>
		<div id="customercanvas">
		 <div id="margin">
		 <p>${ customer.customerName }고객 계좌 수정하기</p>
		 </div>
		<div id="contentborder">		
		<form action="accountupdate.action" 
		        	  method="post">
		       <table id="customerdetailtable">
				<tr>
					<td class="customerdetailHeader">고객번호</td>	
					<td class="customerdetailtd">${ account.customer_No }</td>	
					<td class="customerdetailHeader">지점명</td>
					<td class="customerdetailtd">${ account.branchName }</td>	
				</tr>
				<tr>
					<td class="customerdetailHeader">계좌번호</td>
					<td class="customerdetailtd">${ account.accountNumber }</td>
					<td class="customerdetailHeader">잔액</td>
					<td class="customerdetailtd">${ account.balance }</td>
				</tr>
			</table>    
			<div class="customerdetailtable_buttons">
					<input id="customerDelete" type="button" value="삭제"  />  
					<input id="customerUpdate" type="button" value="편집"  />
					<input id="customerList" type="button" value="목록보기"  />          	
		    </div>
		    </form>	
		    </div>
		</div>   	
	</div> 
	
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#customerList").on('click', function(event) {
			location.href = 'account.action';
			//history.back();
		});
		
		$('#customerDelete').on('click', function(event) {
			
			var answer = confirm(${ customer.customer_No } + "번 고객번호의 정보를 삭제할까요?");
			if (!answer) {
				return;
			}
			
			location.href = 'delete.action?customer_No=' + ${ customer.customer_No };
		});
		
		$('#customerUpdate').on('click', function(event) {
			location.href = 'customerupdate.action?customer_No=' + ${ customer.customer_No };
		});
	});
	</script>

</body>
</html>