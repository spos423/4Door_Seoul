<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<!--  커스텀 JS -->
<script type="text/javascript" src="./js/eventboard.js"></script>

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
	
			<div class="offset-md-9 col-3" id="sh">
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  				<p class="d-inline-flex gap-1">
  					<input class="btn btn-primary me-md-2" type="button" value="글목록" onclick="location.href='/event/eventlist.do'">
	 				<input class="btn btn-primary me-md-2" type="button" value="수정">
  					<input class="btn btn-primary" type="button" value="삭제" onclick="deleteCheck()">
				</p>
			</div>
		</div>
	
	
	
	<div>
		<span class="text-primary fw-bold" style="justify-content: center; align-items: center; display: flex;">이벤트</span>
		<br>
		<h3 class="text-dark" style="justify-content: center; align-items: center; display: flex; font-family:'Noto Sans Korean', 'AppleSDGothicNeo-Regular', 'Malgun Gothic', '맑은 고딕', 'dotum', '돋움', sans-serif; color:black">${e_board.title}</h3>
	</div>
	
	
    <fmt:parseDate value="${e_board.startdate}" var="start" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
    <fmt:parseDate value="${e_board.enddate}" var="end" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
    <fmt:parseDate value="${e_board.writedate}" var="writeDay" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
    <fmt:parseDate value="${e_board.updatedate}" var="updateDay" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
	
	<jsp:useBean id="now" class="java.util.Date" scope="request" />
    <fmt:parseNumber value="${now.time/(1000*60*60*24)}" integerOnly="true" var="nowDays" scope="request" />
    <fmt:parseNumber value="${writeDay.time/(1000*60*60*24)}" integerOnly="true" var="writeDays" scope="request" />
    <fmt:parseNumber value="${start.time/(1000*60*60*24)}" integerOnly="true" var="startDays" scope="request" />
	<fmt:parseNumber value="${end.time/(1000*60*60*24)}" integerOnly="true" var="endDays" scope="request" />
	
	<div class="dateline">
		최초작성일 : <fmt:formatDate value="${writeDay}" pattern="yyyy-MM-dd" /> / <fmt:formatDate value="${updateDay}" pattern="yyyy-MM-dd" />
	</div>
	
	<div class="container">
		<img src="${e_board.img1_url}" class="thumb_img1">
	</div>
	<br>
	
	<div class="content-area" style="font-size: 120%;">
		${e_board.content}
	</div>
	
	<div align="center">
		<table  width="100%" height="auto" cellpadding="10" cellspacing="100">
			<tr>
				<th >주소</th>
				<td>${e_board.zipcode}&nbsp;${e_board.address}</td>
			</tr>
			<tr>
				<th>교통정보</th>
				<td>${e_board.traf}</td>
			</tr>
			<tr>
				<th>이용요금</th>
				<td>${e_board.price}</td>
			</tr>
			<tr>
				<th>행사 기간</th>
				<td><fmt:formatDate value="${start}" pattern="YYYY년 MM월 dd일 HH:mm"/>&nbsp;~&nbsp;<fmt:formatDate value="${end }" pattern="YYYY년 MM월 dd일 HH:mm"/></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${e_board.tel}</td>
			</tr>
			<tr>
				<th>홈페이지</th>
					<c:choose>
						<c:when test="${e_board.uri eq  null}">
							<td>홈페이지 정보 없음</td>
						</c:when>	
						<c:otherwise>
							<td><a href="${e_board.uri}">홈페이지 바로가기</a></td>
						</c:otherwise>
					</c:choose>
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
	
	<div class="container" >
		<table width="100%" height="auto" cellpadding="0" cellspacing="0">
			<tr><td class="Comment-form-title">댓&ensp;&ensp;&ensp;&ensp;글</td></tr>
			
			<tr height="25px"><td class="Comment-form-writer">&ensp;작성자</td></tr>
			<tr><td class="Comment-form-content">&ensp;댓글 내용이 입력될 공간입니다.</td></tr>
			<tr><td class="comment-form-date">&ensp;작성일자 : 2023.08.23&ensp;<a href="#" class="reply-comment">답글쓰기</a></td></tr>
			
			<table width="100%" height="auto" cellpadding="0" cellspacing="0">
			<tr><td class="Comment-form-writer">&ensp;작성자</td></tr>
			<tr><td class="Comment-form-content">&ensp;댓글 내용이 입력될 공간입니다.</td></tr>
			<tr><td class="comment-form-date">&ensp;작성일자 : 2023.08.23&ensp;<a href="#" class="reply-comment">답글쓰기</a></td></tr>
			</table>
			
		</table>
		
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
	<script type="text/javascript" >
	var addressForMap = "${e_board.address}"; // DB에서 카카오 주소 API를 통해 입력한 주소를 EL로 입력

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	   
	mapOption = {
	    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	    level: 2 // 지도의 확대 레벨
	};  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(addressForMap, function(result, status) {

	// 정상적으로 검색이 완료됐으면 
	if (status === kakao.maps.services.Status.OK) {
	    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	    
	    var aa = result[0].y;
	    var bb = result[0].x;
	    // 결과값으로 받은 위치를 마커로 표시합니다
	    var marker = new kakao.maps.Marker({
	        map: map,
	        position: coords
	    });

	    // 인포윈도우로 장소에 대한 설명을 표시합니다
	    var infowindow = new kakao.maps.InfoWindow({
	        content: '<div style="width:150px;text-align:center;padding:6px 0;">${e_board.title}</a></div>'
	    });
	    infowindow.open(map, marker);

	    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	    map.setCenter(coords);
	} 
	}); 
	</script>
	
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