<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>관리자 정보</title>
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
		 <p><% out.print("관리자 정보");%></p>
		 </div>
		<div id="contentborder">
		<form action="update.action" 
		        	  method="post">
		        <table id="memberupdate_table">
		            <tr>
		                <th>아이디</th>
		                <td>
		                	<input type="text" id="memberId" name="memberId" 
		                    	   readonly="readonly" 
		                    	   value="${ loginuser.memberId }" />
		                </td>
		            </tr> 
		            <tr>
		                <th>비밀번호</th>
		                <td>
		                	<input type="password" id="passwd" name="passwd" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호 확인</th>
		                <td>
		                	<input type="password" id="confirm" name="confirm"/>
		                </td>
		            </tr>
		            <tr>
		                <th>이메일</th>
		                <td>
		                	<input type="text" id="email" name="email" value="${ loginuser.email }" />
		                </td>
		            </tr>
		            <tr>
		                <th>등록일자</th>
		                <td>
		                	<input type="text" id="regDate" name="regDate" 
		                		readonly="readonly" 
		                		value="${ loginuser.regDate }" />
		                </td>
		            </tr>
		            <tr>
		                <th>사용자구분</th>
		                <td>
		                	<input type="text" id="userType" name="userType" 
		                		   readonly="readonly" 
		                		   value="${ loginuser.userType }" />
		                </td>
		            </tr>
		            <tr>
		                <th>활성화여부</th>
		                <td>
		                	<input type="text" id="active" name="active" 
		                		 readonly="readonly"  value="${ sessionScope.loginuser.active }" />
		                </td>
		            </tr>
		        </table>
		        <div class="customeradd_buttons">
		        	<input id="cancel" type="button" value="취소"  />
		        	<input id="update" type="submit" value="정보수정" />		        	
		        </div>
		        </form>
		    </div>
		</div>   	
	</div> 
	
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#cancel").on('click', function(event) {
			location.href = 'home.action';
			//history.back();
		});
	});
	</script>

</body>
</html>