<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>계좌 추가하기</title>
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
		 <p><% out.print("계좌 추가하기");%></p>
		 </div>
		<div id="contentborder">
		<form action="customeradd.action" 
		        	  method="post">
		        <table id="customeradd_table">
		            <tr>
		                <th>지점명</th>
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
		                <th>잔액</th>
		                <td>
		                	<input name="balance"></input>
		                </td>
		            </tr>
		        </table>		        
		        <div class="customeradd_buttons">
		        	<input id="cancel" type="button" value="취소"  />
		        	<input type="submit" value="고객추가" />		        	
		        </div>
		        </form>
		    </div>
		</div>   	
	</div> 
	
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#cancel").on('click', function(event) {
			location.href = 'account.action';
			//history.back();
		});
	});
	</script>

</body>
</html>