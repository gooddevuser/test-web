<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>로그인</title>
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
		 <p><% out.print("로그인 하기");%></p>
		 </div>
		<div id="contentborder">
		<form action="login.action" 
		        	  method="post">
		        <table id="customerlogin_table">
		            <tr>
		                <th>아이디</th>
		                <td>
		                	<input type="text" name="memberId"/>
		                </td>
		            </tr> 
		            <tr>
		                <th>비밀번호</th>
		                <td>
		                	<input type="password" name="passwd"/>
		                </td>
		            </tr>
		        </table>		        
		        <div class="customeradd_buttons">
		        	<input id="cancel" type="button" value="취소"  />
		        	<input type="submit" value="로그인" />		        	
		        </div>
		        </form>
		    </div>
		</div>   	
	</div> 
</body>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#cancel").on('click', function(event) {
			location.href = 'home.action';
			//history.back();
		});
	});
	</script>
</html>