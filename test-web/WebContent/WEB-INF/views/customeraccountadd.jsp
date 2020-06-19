<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>고객 계좌추가하기</title>
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
		 <p><% out.print("고객 계좌추가하기");%></p>
		 </div>
		<div id="contentborder">
		<form action="customeraccountadd.action" 
		        	  method="post">
		        <table id="customeraccountadd_table">
		            <tr>
		                <th>고객번호</th>
		                <td>
		                	<input name="customer_No"></input>
		                </td>
		            </tr> 
		            <tr>
		                <th>고객성함</th>
		                <td>
		                	<input name="customerName"></input>
		                </td>
		            </tr>
		            <tr>
		                <th>거주지역</th>
		                <td>
		                	<input name="customerStreet"></input>
		                </td>
		            </tr>
		            <tr>
		                <th>거주도시</th>
		                <td>
		                	<input name="customerCity"></input>
		                </td>
		            </tr>
		            <tr>
		                <th>지점이름</th>
		                <td>
		                	<input name="branchName"></input>
		                </td>
		            </tr>
		            <tr>
		                <th>계좌번호</th>
		                <td>
		                	<input name="accountNumber"></input>
		                </td>
		            </tr>
		            <tr>
		                <th>계좌잔액</th>
		                <td>
		                	<input name="balance"></input>
		                </td>
		            </tr>
		        </table>		        
		        <div class="customeraccountadd_buttons">
		        	<input id="cancel" type="button" value="취소"  />
		        	<input type="submit" value="고객계좌추가하기" />		        	
		        </div>
		        </form>
		    </div>
		</div>   	
	</div> 
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#cancel").on('click', function(event) {
			location.href = 'customeraccount.action';
			//history.back();
		});
	});
	</script>
</body>
</html>