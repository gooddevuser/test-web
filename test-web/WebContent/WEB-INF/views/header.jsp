<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
    	<link href="https://fonts.googleapis.com/css?family=Nanum+Myeongjo&display=swap" rel="stylesheet">
    	<link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
    	<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core" %>
    	<div id="headercanvas">
    	<div class="links">	           		
	            <c:choose>
            	<c:when test="${ empty loginuser }">
            	<a href="/test-web/register.action">회원가입</a>
            	<a href="/test-web/login.action">로그인</a>                
            	</c:when>
            	<c:otherwise>
            	<a href="/test-web/logout.action">로그아웃</a>
            	<a href="/test-web/update.action">
                	${ loginuser.memberId } 님 환영합니다.
                </a>                
            	</c:otherwise>
            	</c:choose>
	            </div> 
	    	<div id="header">
	    	  
	            <div class="title">
	                <a href="/test-web/home.action">
	                은행 고객관리 시스템
	                </a>
	            </div>
	        <div id="menu">
	            <div>
	            	<ul>
	                    <li><a href="/test-web/home.action">고객관리</a></li>						
						<li><a href="/test-web/account.action">계좌조회</a></li>
						<li><a href="/test-web/customeraccount.action">고객계좌조회</a></li>
						<li><a href="/test-web/member.action">관리자페이지</a></li>
	                </ul>
	            </div>
			</div>
    	</div>
    	
    	</div>