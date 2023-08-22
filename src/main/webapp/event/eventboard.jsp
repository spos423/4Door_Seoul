<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Playfair+Display:wght@700;900&display=swap" rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="./lib/animate/animate.min.css" rel="stylesheet">
<link href="./lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

<!-- Bootstrap Stylesheet -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous"> -->

<!-- Template Stylesheet -->
<link href="./css/style.css" rel="stylesheet">
<link href="./css/eventboard.css" rel="stylesheet">


<title>FOR문 SEOUL : 이벤트 보드</title>
</head>
<body style="display:flex; flex-flow:column; min-height:100vh; padding:0; margin:0;">

<header>
<c:import url="/main/header.jsp" />

</header>


<main style="flex:1;width:50%;align-self:center;">

<div class="container">
	<nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%236c757d'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
  		<ol class="breadcrumb">
    		<li class="breadcrumb-item h5"><a href="#">HOME</a></li>
    		<li class="breadcrumb-item h5"><a href="#">사대문</a></li>
    		<li class="breadcrumb-item active h5" aria-current="page">행사안내</li>
  		</ol>
	</nav>

	<div>
		<span class="text-primary fw-bold" style="justify-content: center; align-items: center; display: flex;">이벤트</span>
		<br>
		<h3 class="text-dark"style="justify-content: center; align-items: center; display: flex; font-family:'Noto Sans Korean', 'AppleSDGothicNeo-Regular', 'Malgun Gothic', '맑은 고딕', 'dotum', '돋움', sans-serif; color:black">제목이 들어갈 자리입니다.</h3>
	</div>
	
	<div class="dateline">
		최초작성일 : 2023.08.18 / 수정일 : 2023.08.18
	</div>
	
	<div class="container">
		<img src="./img/carousel-1.jpg" class="thumb_img1">
	</div>
	<br>
	
	<div class="content-area">
	어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
	어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
	어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
	어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
	어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
	어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
	어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
	어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
	어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
	어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구
	
	</div>
	
	<div align="center">
		<table  width="100%" height="auto" cellpadding="10" cellspacing="100">
			<tr>
				<th >주소</th>
				<td>우편번호 주소 출력</td>
			</tr>
			<tr>
				<th>교통정보</th>
				<td>교통정보 출력</td>
			</tr>
			<tr>
				<th>이용요금</th>
				<td>이용요금 출력</td>
			</tr>
			<tr>
				<th>행사 기간</th>
				<td>행사 시작일, 행사 종료일 출력</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>전화번호 출력</td>
			</tr>
			<tr>
				<th>홈페이지</th>
				<td><a href="#">홈페이지 바로가기</a></td>
			</tr>
		</table>
	</div>
	
	<div class="dateline"><b>위치 정보<b></div>
	
	<div class="container">
		<div id="map" style="width:90%; height:400px; margin:auto!important;"></div>
	</div>
	
	<br><hr>
	
	
	
	
	
	
	
	
	
	
	
	
	<div class="container">
		<form action="#" method="post">
			<div class="input-group">
  				<span class="input-group-text">Comment</span>
  				<textarea class="form-control" aria-label="With textarea"></textarea>
  				<button class="btn btn-outline-secondary" type="submit" id="button-addon2">등록하기</button>
			</div>
		</form>
	</div>
	
	<br>
	

</div>

</main>



<footer style="height: 30%">
	<c:import url="/main/footer.jsp" />
</footer>

<!-- Back to Top -->
<a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>

	<!-- 카카오맵 API -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3533e1b86e9d6cdbe13026ff2f91936c&libraries=services" ></script>
	<script type="text/javascript" src="./js/kakaoMapAPI.js"></script>
    <!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="./lib/wow/wow.min.js"></script>
    <script src="./lib/easing/easing.min.js"></script>
    <script src="./lib/waypoints/waypoints.min.js"></script>
    <script src="./lib/owlcarousel/owl.carousel.min.js"></script>
    <!-- Template JavaScript -->
    <script src="./js/main.js"></script>
	<!-- Bootstrap Script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>