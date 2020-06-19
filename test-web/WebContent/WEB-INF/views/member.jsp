<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>관리자페이지</title>
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
		 <p><% out.print("관리자페이지");%></p>
		 </div>
		<div id="contentborder">
		<form action="member.action" 
		        	  method="post">
		       <table id="customer_table"> 
				<tr>
					<td class="customerHeader">아이디</td>
					<td class="customerHeader">이메일</td>
					<td class="customerHeader">등록일자</td>
					<td class="customerHeader">사용자</td>	
					<td class="customerHeader">활성화</td>			
				</tr>
				<c:forEach var="member" items="${ requestScope.members}">
				<tr>				
					<td class="memberId">${ member.memberId }</td>
					<td class="email">${ member.email }</td>
					<td class="regDate">${ member.regDate }</td>
					<td class="userType">${ member.userType }</td>	
					<td class="active">${ member.active }</td>			
				</tr>
				</c:forEach>
			</table>
		        </form>
		    </div>
		</div>   	
	</div> 
</body>
</html>