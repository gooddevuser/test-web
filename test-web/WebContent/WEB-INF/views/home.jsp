<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Locale" %>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	 
<%!
Calendar cal = Calendar.getInstance();
final String[] week = { "일", "월", "화", "수", "목", "금", "토" };
%>

<!DOCTYPE html>

<html>
<head>
	<meta charset='utf-8' />
	<title>은행 고객관리 시스템</title>
	<link rel='Stylesheet' href='/test-web/styles/default.css' />
</head>
<body>

	<div id='pageContainer'>
		<jsp:include page="/WEB-INF/views/header.jsp">
			<jsp:param value="" name="bgColor"/>
		</jsp:include>
		
		 <div id="homecontentcanvas">
    	 <div id="today">
    	 <p><% out.print("오늘은 " + cal.get(Calendar.YEAR) + "년&nbsp;");%></p>
		 <p><% out.print(cal.get(Calendar.MONTH) + 1 + "월&nbsp;"); %></p>	
		 <p><% out.print(cal.get(Calendar.DATE) + "일&nbsp;"); %></p>
		 <p><% out.print(week[cal.get(Calendar.DAY_OF_WEEK) - 1]+ "요일 입니다."); %></p>
		 </div>
    	 <div id="contentborder">   
    	 	<table id="customer_table">
				<tr>
					<td class="customerHeader">고객번호</td>
					<td class="customerHeader">고객성함</td>
					<td class="customerHeader">거주지역</td>
					<td class="customerHeader">거주도시</td>					
				</tr>
				<c:forEach var="customer" items="${ requestScope.customers}">
				<tr>
					<td class="customer_No">${ customer.customer_No }</td>
					<td class="customerName">
					<c:choose>
						<c:when test="${ not customer.deleted }">
						<a href="customerdetail.action?customer_No=${ customer.customer_No }">${ customer.customerName }</a>
						</c:when>
						<c:otherwise>
						<span style="color:lightgray">${ customer.customerName } [삭제된 고객]</span>
						</c:otherwise>
						</c:choose>
					</td>
					<td class="customerStreet">${ customer.customerStreet }</td>
					<td class="customerCity">${ customer.customerCity }</td>
				</tr>
				</c:forEach>
			</table>    
			<div class="customer_table_buttons">
					<input id="customerAdd" onclick="location.href='customeradd.action'" type="button" value="고객추가하기"  />        	
		    </div>	 
    	        
    	 </div>    	 
    	 </div>
		
	</div>

</body>
</html>









