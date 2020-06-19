<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>계좌조회</title>
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
		 <p><% out.print("계좌조회");%></p>
		 </div>
		<div id="contentborder">
		       <table id="customer_table"> 
				<tr>
					<td class="customerHeader">고객번호</td>
					<td class="customerHeader">지점이름</td>
					<td class="customerHeader">계좌번호</td>
					<td class="customerHeader">계좌잔액</td>					
				</tr>
				<c:forEach var="account" items="${ requestScope.accounts}">
				<tr>
					<td class="customer_No"><a href="customerdetail.action?customer_No=${ account.customer_No }">${ account.customer_No }</a></td>
					<td class="customerName">
					<c:choose>
						<c:when test="${ not account.deleted }">
						${ account.branchName }
						</c:when>
						<c:otherwise>
						<span style="color:lightgray">${ account.branchName } [삭제된 고객]</span>
						</c:otherwise>
						</c:choose>
					</td>
					<td class="customerStreet">${ account.accountNumber }</td>
					<td class="customerCity">${ account.balance }</td>
				</tr>
				</c:forEach>
			</table>            		        
		        <div class="customeradd_buttons">
		        	<input id="accountAdd" onclick="location.href='accountadd.action'" type="button" value="계좌추가하기"  />		        	
		        </div>
		    </div>
		</div>   	
	</div> 
	
</body>
</html>