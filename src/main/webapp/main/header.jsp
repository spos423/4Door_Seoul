<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
</head>
<body>
    <!-- Navbar Start -->
    <div class="container-fluid bg-blue sticky-top">
        <div class="container">
            <nav class="navbar navbar-expand-lg bg-white navbar-light py-2 py-lg-0">
                <a href="/" class="navbar-brand">
                    <img class="img-fluid" src="../main/img/logo.png" alt="Logo" style="border-radius:0 0 50px 50px; border-style:solid; border-top-style: none; border-color: #5f5f5f;">
                </a>
                <button type="button" class="navbar-toggler ms-auto me-0" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto">
                        <a href="/" class="nav-item nav-link active">Home</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">사대문</a>
                            <div class="dropdown-menu bg-light rounded-0 m-0">
                                <a href="/event/ForDoor_Intro.jsp" class="dropdown-item">사대문소개</a>
                                <a href="/event/eventlist.do" class="dropdown-item">행사안내</a>
                            </div>
                        </div>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">여행정보</a>
                            <div class="dropdown-menu bg-light rounded-0 m-0">
                                <a href="/t_list.do?ct_u=0&ct_d=0" class="dropdown-item">축제&행사</a>
                                <a href="/t_list.do?ct_u=1&ct_d=9" class="dropdown-item">볼거리</a>
                                <a href="/t_list.do?ct_u=2&ct_d=9" class="dropdown-item">먹거리</a>
                            </div>
                        </div>
                       <div>
                        <a href="/frboard/getBoardList.do" class="nav-item nav-link">커뮤니티</a>
                          </div>
                          <div>
                        <a href="/gmboard/getgmBoardList.do" class="nav-item nav-link">고객센터</a>
                        </div>
                        <a href="contact.html" class="nav-item nav-link"></a>
                        <a href="contact.html" class="nav-item nav-link"></a>
                        <a href="contact.html" class="nav-item nav-link"></a>
                        <a href="contact.html" class="nav-item nav-link"></a>
                        <!-- <a href="contact.html" class="nav-item nav-link">로그아웃</a>
                        <a href="contact.html" class="nav-item nav-link">마이페이지</a> -->
                        
                        
                        
	                        <c:if test="${loginID ne null }">
	                        	<div class="nav-item dropdown">
		                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">마이페이지</a>
		                            <div class="dropdown-menu bg-light rounded-0 m-0">
		                                <a href="/member.mdo?cmd=modifyForm" class="dropdown-item">정보수정</a>
		                                <a href="/member.mdo?cmd=delete" class="dropdown-item">회원탈퇴</a>
		                                <a href="/member.mdo?cmd=logout" class="dropdown-item">로그아웃</a>
		                            </div>
		                        </div>
	                            <a href="/member.mdo?cmd=logout" class="nav-item nav-link">로그아웃</a>                                          
	                        </c:if>
	                         <c:if test="${loginID eq null }">
								<a href="/member/login.jsp" class="nav-item nav-link">로그인</a>
	                        	<a href="javascript:void(0)" class="nav-item nav-link" onclick="javascript:window.location='member.mdo?cmd=regForm'">회원가입</a>
	                        </c:if>
                        
                        <!-- <a href="contact.html" class="nav-item nav-link">회원가입</a> -->
                    </div>
                    <!-- <div class="border-start ps-4 d-none d-lg-block">
                        <button type="button" class="btn btn-sm p-0"><i class="fa fa-search"></i></button>
                    </div> -->
                </div>
            </nav>
        </div>
    </div>
    <!-- Navbar End -->
</body>
</html>