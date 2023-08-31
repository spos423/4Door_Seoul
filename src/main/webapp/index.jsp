<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><meta content="width=device-width, initial-scale=1.0" name="viewport">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Playfair+Display:wght@700;900&display=swap" rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="./main/lib/animate/animate.min.css" rel="stylesheet">
<link href="./main/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

<!-- Bootstrap Stylesheet -->
<link href="./main/css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="./main/css/style.css" rel="stylesheet">

<title>FOR문 SEOUL : 메인</title>
</head>
<body style="display:flex;
		     flex-flow:column;
		     min-height:100vh;
		     padding:0;
		     margin:0;">	   
		    
	<!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" role="status" style="width: 3rem; height: 3rem;"></div>
    </div>
    <!-- Spinner End -->

    
    <!-- Navbar Start -->
    <header>
    <div class="container-fluid bg-blue sticky-top">
        <div class="container">
            <nav class="navbar navbar-expand-lg bg-white navbar-light py-2 py-lg-0">
                <a href="/" class="navbar-brand">
                    <img class="img-fluid" src="./main/img/logo.png" alt="Logo" style="border-radius:0 0 50px 50px; border-style:solid; border-top-style: none; border-color: #5f5f5f;">
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
                                <a href="feature.html" class="dropdown-item">축제&행사</a>
                                <a href="blog.html" class="dropdown-item">볼거리</a>
                                <a href="testimonial.html" class="dropdown-item">먹거리</a>
                            </div>
                        </div>
                        <a href="contact.html" class="nav-item nav-link">커뮤니티</a>
                        <a href="contact.html" class="nav-item nav-link">고객센터</a>
                        <a href="contact.html" class="nav-item nav-link"></a>
                        <a href="contact.html" class="nav-item nav-link"></a>
                        <a href="contact.html" class="nav-item nav-link"></a>
                        <a href="contact.html" class="nav-item nav-link"></a>
                        <!-- <a href="contact.html" class="nav-item nav-link">로그아웃</a>
                        <a href="contact.html" class="nav-item nav-link">마이페이지</a> -->
                        <a href="contact.html" class="nav-item nav-link">로그인</a>
                        <a href="contact.html" class="nav-item nav-link">회원가입</a>
                    </div>
                    <!-- <div class="border-start ps-4 d-none d-lg-block">
                        <button type="button" class="btn btn-sm p-0"><i class="fa fa-search"></i></button>
                    </div> -->
                </div>
            </nav>
        </div>
    </div>
    </header>
    <!-- Navbar End -->


    <!-- Carousel Start -->
	<div class="dd" style="float: left; height:100px; width:100%; display:inline-block;"></div>

    <!-- Carousel End -->
    <div class="container-fluid px-0 mb-5">
        <div id="header-carousel" class="carousel slide carousel-fade" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="w-100" src="./main/img/getImage.png" alt="Image" style="width:500px; height:800px;">
                  
                </div>
                <div class="carousel-item">
                    <img class="w-100" src="./main/img/getImage(1).png" alt="Image" style="width:500px; height:800px;">
                    
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#header-carousel"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#header-carousel"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
    <!-- Carousel End -->
    
    <!-- Copyright Start -->
    <footer>
    <div class="container-fluid copyright py-4">
        <div class="container">
            <div class="row">
                <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                    &copy; <a class="fw-medium" href="javascript:void(0)" style="color:#bbbbbb;">
                    2023 IT1기 FOR문 Seoul</a>, All Right Reserved.
                </div>
                <div class="col-md-6 text-center text-md-end">
                    <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                    Designed By <a class="fw-medium" href="javascript:void(0)" style="color:#dfdfdf;">Hon Gyul</a>
                </div>
            </div>
        </div>
    </div>
    </footer>
    <!-- Copyright End -->
	
<!-- Back to Top -->
<a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>

    <!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="./main/lib/wow/wow.min.js"></script>
    <script src="./main/lib/easing/easing.min.js"></script>
    <script src="./main/lib/waypoints/waypoints.min.js"></script>
    <script src="./main/lib/owlcarousel/owl.carousel.min.js"></script>
    <!-- Template JavaScript -->
    <script src="./main/js/main.js"></script>
	<!-- Bootstrap Script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>