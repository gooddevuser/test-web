<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>${ customer.customerName }고객 정보 수정하기</title>
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
		 <p>${ customer.customerName }고객 정보 수정하기</p>
		 </div>
		<div id="contentborder">
		<form action="customerupdate.action" 
		        	  method="post">
		        <table id="customerupdate_table">
		            <tr>
		                <th class="customerupdateHeader">고객번호</th>
		                <td>
		                	<input type="text" id="customer_No" name="customer_No" 
		                    	   readonly="readonly" 
		                    	   value="${ customer.customer_No }" />
		                </td>
		            </tr> 
		            <tr>
		                <th class="customerupdateHeader">고객성함</th>
		                <td>
		                	<input type="text" id="customerName" name="customerName" 
		                    	   readonly="readonly" 
		                    	   value="${ customer.customerName }" />
		                </td>
		            </tr>		           
		            <tr>
		                <th class="customerupdateHeader">거주지역</th>
		                <td>
		                	<input type="text" id="customerStreet" name="customerStreet" value="${ customer.customerStreet }" />
		                </td>
		            </tr>
		            <tr>
		                <th class="customerupdateHeader">거주도시</th>
		                <td>
		                	<input type="text" id="customerCity" name="customerCity" value="${ customer.customerCity }" />
		                </td>
		            </tr>
		        </table>
		        <div class="customeradd_buttons">
		        	<input id="cancel" type="button" value="취소"  />
		        	<input id="customerupdate" type="submit" value="정보수정" />		        	
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