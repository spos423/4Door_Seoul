<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><meta content="width=device-width, initial-scale=1.0" name="viewport">

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
<link href="/resources/lib/animate/animate.min.css" rel="stylesheet">
<link href="/resources/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

<!-- Bootstrap Stylesheet -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<!-- Template Stylesheet -->
<link href="/resources/css/style.css" rel="stylesheet">

<!-- css 적용 -->
<link href="/resources/css/t_detail.css" rel="stylesheet">

<!-- 카카오 Map API 적용 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=44694e80891ede312de6d526b4b7f5a0&libraries=services"></script>

<!-- script 적용 -->
<script type="text/javascript" src="/resources/js/t_board.js"></script>

<title></title>
</head>
<body>

	<!-- Navbar Start -->
	<header>
		<c:import url="../main/header.jsp"></c:import>
	</header>
	<!-- Navbar End -->


	<!-- Carousel Start -->
	<div class="dd"></div>


	<main class="container-fluid px-0 mb-5" id="main">
		
		<%-- 카카오 지도 api에서 사용할 변수 --%>
		<input type="hidden" id="ad" value="${address}">
		<input type="hidden" id="tt" value="${title}">
	
		<c:choose>
			<c:when test="${ct_u==0}">
				<c:if test="${ct_d==0}">
		<h5 class="present_location"><img alt="" src="/resources/img/home.png" class="where"> > 여행정보 > 축제&행사 > 진행중</h5>
				</c:if>
				<c:if test="${ct_d==1}">
		<h5 class="present_location"><img alt="" src="/resources/img/home.png" class="where"> > 여행정보 > 축제&행사 > 진행예정</h5>
				</c:if>
				<c:if test="${ct_d==2}">
		<h5 class="present_location"><img alt="" src="/resources/img/home.png" class="where"> > 여행정보 > 축제&행사 > 진행완료</h5>
				</c:if>
			</c:when>
			
			<c:when test="${ct_u==1}">
				<c:if test="${ct_d==3}">
		<h5 class="present_location"><img alt="" src="/resources/img/home.png" class="where"> > 여행정보 > 볼거리 > 명소</h5>
				</c:if>
				<c:if test="${ct_d==4}">
		<h5 class="present_location"><img alt="" src="/resources/img/home.png" class="where"> > 여행정보 > 볼거리 > 자연&경관</h5>
				</c:if>
				<c:if test="${ct_d==5}">
		<h5 class="present_location"><img alt="" src="/resources/img/home.png" class="where"> > 여행정보 > 볼거리 > 엔터테인먼트</h5>
				</c:if>
			</c:when>
			
			<c:otherwise>
				<c:if test="${ct_d==6}">
		<h5 class="present_location"><img alt="" src="/resources/img/home.png" class="where"> > 여행정보 > 먹거리 > 카페&디저트</h5>
				</c:if>
				<c:if test="${ct_d==7}">
		<h5 class="present_location"><img alt="" src="/resources/img/home.png" class="where"> > 여행정보 > 먹거리 > 식사</h5>
				</c:if>
				<c:if test="${ct_d==8}">
		<h5 class="present_location"><img alt="" src="/resources/img/home.png" class="where"> > 여행정보 > 먹거리 > 주점</h5>
				</c:if>
			</c:otherwise>
		</c:choose>
		
		<br>
		<div class="float-right">
			<div class="board_btn">
				<a href="t_update.traveldo?num=${num}&ct_u=${ct_u}&ct_d=${ct_d}&ct2=${ct2}" class="btn">게시글 수정</a>
			</div>
			<div class="board_btn">
				<a href="t_delete_proc.traveldo?num=${num}&ct_u=${ct_u}&ct_d=${ct2}" class="btn" onclick="deleteCheck()">
					게시글 삭제		    
				</a>
			</div>
			<div class="board_btn">
				<c:choose>
					<c:when test="${ct_u==0}">
				<a href="t_list.traveldo?ct_u=${ct_u}&ct_d=${ct2}&pageNum=${pageNum}&searchKeyword=${searchKeyword}&date_start=${date_start}&date_end=${date_end}" class="btn">
					</c:when>
					<c:otherwise>
				<a href="t_list.traveldo?ct_u=${ct_u}&ct_d=${ct2}&pageNum=${pageNum}&searchKeyword=${searchKeyword}" class="btn">
					</c:otherwise>
				</c:choose>
					게시글 목록		    
				</a>
			</div>
		</div>
		<div class="board_main">
			<h1 class="page_title" align="center">${title}</h1>
			<br>
			<div class="board_dd">	
				<div class="board_date_line"></div>
				<c:choose>
					<c:when test="${update_day!=null}">
				<div class="board_date">제작일 : ${write_day} / 수정일 : ${update_day}</div>
					</c:when>
					<c:otherwise>
				<div class="board_date">제작일 : ${write_day}</div>
					</c:otherwise>
				</c:choose>
				
			</div>
			<br>
			<div class="board_screen">
				<nav class="left_null">&nbsp;</nav>    
				<nav class="right_null">&nbsp;</nav>
				<div class="board_img">
					<img alt="" src="${filepath}" class="img">
				</div>
			</div>
			
			
			<div class="content">${content}</div>
			
			<div class="detail">
				<dl class="detail_dl">
					<dt class="detail_dt">
						 전화번호
	                </dt>
					<dd class="detail_dd">
    					${tel}
    				</dd>
				</dl>
				
				<c:if test="${ct_u!=2}">
				
				<dl class="detail_dl">
					<dt class="detail_dt">
						 웹사이트
	                </dt>
					<dd class="detail_dd">
    					<a href="${uri}" class="website" target="_blank">
    						웹사이트 보기→
    					</a>
    				</dd>
				</dl>
				<dl class="detail_dl">
					<dt class="detail_dt">
						 이용 요금
	                </dt>
					<dd class="detail_dd">
    					${price}
    				</dd>
				</dl>
				
				</c:if>
				
				<c:if test="${ct_u==2}">
				
				<dl class="detail_dl">
					<dt class="detail_dt">
						 대표 메뉴
	                </dt>
					<dd class="detail_dd">
    					${bestmenu}
    				</dd>
				</dl>
				
				</c:if>
				
				<c:if test="${ct_u==0}">
				
				<dl class="detail_dl">
					<dt class="detail_dt">
						 행사기간
	                </dt>
					<dd class="detail_dd">
    					${time_s}
    					&nbsp; ~ &nbsp;
    					${time_e}
    				</dd>
				</dl>
				
				</c:if>
				
				<dl class="detail_dl">
					<dt class="detail_dt">
						 운영일
	                </dt>
					<dd class="detail_dd">
    					${open_day}
    				</dd>
				</dl>
				<dl class="detail_dl">
					<dt class="detail_dt">
						주소
	                </dt>
					<dd class="detail_dd">
    					${zipcode}&nbsp;${address}
    				</dd>
				</dl>
				<dl class="detail_dl">
					<dt class="detail_dt">
						 교통 정보
	                </dt>
					<dd class="detail_dd">
    					${traffic}
    				</dd>
				</dl>
			</div>
			
			<div class="bottom_line">	
				<div class="board_date_line"></div>
			</div>
			
			
			<div class="map" id="map">
				<script type="text/javascript" src="/resources/js/t_map.js"></script>
			</div>
			
		</div>
		
	</main>


	<!-- Carousel End -->

	<!-- Copyright Start -->
	<footer>
		<c:import url="../main/footer.jsp"></c:import>
	</footer>
	<!-- Copyright End -->
	
    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>

	<!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="/resources/lib/wow/wow.min.js"></script>
    <script src="/resources/lib/easing/easing.min.js"></script>
    <script src="/resources/lib/waypoints/waypoints.min.js"></script>
    <script src="/resources/lib/owlcarousel/owl.carousel.min.js"></script>
    <!-- Template JavaScript -->
    <script src="/resources/js/main.js"></script>
	<!-- Bootstrap Script -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>