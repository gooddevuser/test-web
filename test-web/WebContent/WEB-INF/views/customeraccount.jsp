<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>고객계좌조회</title>
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
		 <p><% out.print("고객계좌조회");%></p>
		 </div>
		<div id="contentborder">
		<form action="customeraccountadd.action" 
		        	  method="post">
		       <table id="customer_table"> 
					<tr>
					<td class="customeraccountHeader">고객번호</td>
					<td class="customer_No">${ account.customer_No }</td>
					</tr>
					<tr>
					<td class="customeraccountHeader">고객성함</td>
					<td class="customerStreet">${ customer.customerName }</td>
					</tr>
					<tr>
					<td class="customeraccountHeader">거주지역</td>
					<td class="customerStreet">${ customer.customerStreet }</td>
					</tr>
					<tr>
					<td class="customeraccountHeader">거주도시</td>
					<td class="customerCity">${ customer.customerCity }</td>
					</tr>
					<tr>
					<td class="customeraccountHeader">지점이름</td>
					<td class="customerCity">${ account.branchName }</td>
					</tr>
					<tr>
					<td class="customeraccountHeader">계좌번호</td>					
					<td class="accountNumber">${ account.accountNumber }</td>
					</tr>
					<tr>
					<td class="customeraccountHeader">계좌잔액</td>
					<td class="balance">${ account.balance }</td>	
					</tr>					
				
			</table>          
		        <div class="customeraccountadd_buttons">
		        	<input id="customeraccountAdd" onclick="location.href='customeraccountadd.action'" type="button"  value="고객계좌추가하기" />		        	
		        </div>
		        </form>
		    </div>
		</div>   	
	</div> 
</body>
</html>