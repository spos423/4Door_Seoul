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
<link href="/resources/css/t_write.css" rel="stylesheet">

<!-- 카카오 주소 검색 api script 적용 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

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
		<h5 class="present_location"><img alt="" src="/resources/img/home.png" class="where"> > 여행정보 > 먹거리 > 게시글 수정</h5>
	  	<br>
	  	<h1 class="page_title">게시글 수정</h1>
	  	<div class="board_dd">	
				<div class="board_line"></div>
		</div>
		
		<div class="location">
			<nav class="left_null">&nbsp;</nav>
			<nav class="right_null">&nbsp;</nav>
			<div class="board_center">
			  	<form action="t_update_proc.traveldo" method="post" name="boardForm" enctype="multipart/form-data">
					
					<input type="hidden" id="delete" value="0">
					
					<input type="hidden" name="num" value="${num}">
					<input type="hidden" name="ct_u" value="2">
					<input type="hidden" name="ct2" value="${ct2}">
					
					<input type="hidden" name="p_filepath" value="${p_filepath}">
					
					<div class="form-group">
				    	<label for="ct_d" class="label">* 카테고리</label>
				        <select name="ct_d" class="form-control" id="ct_d">
				        	<c:if test="${ct_d==6}">
					        	<option value="6" selected>카페&디저트</option>
					        	<option value="7">식사</option>
					        	<option value="8">주점</option>
				        	</c:if>
				        	<c:if test="${ct_d==7}">
					        	<option value="6">카페&디저트</option>
					        	<option value="7" selected>식사</option>
					        	<option value="8">주점</option>
				        	</c:if>
				        	<c:if test="${ct_d==8}">
					        	<option value="6">카페&디저트</option>
					        	<option value="7">식사</option>
					        	<option value="8" selected>주점</option>
				        	</c:if>
				        </select>
				    </div>
				    
				    <div class="form-group">
				    	<label for="title" class="label">* 제목</label>
				      	<input type="text" class="form-control"
				       	       placeholder="제목 입력(4-100)" name="title"
				               maxlength="100" required="required"
				               pattern=".{4,100}" id="title"
				               value="${title}">
				    </div>
				    
				    
				    
				    <%-- 로그인 세션에 저장된 아이디로 변경 --%>
				    <div class="form-group">
				      	<label for="writer" class="label">* 작성자</label>
				      	<%-- 로그인 세션에 저장된 아이디로 변경 --%>
				      	<input type="hidden" name="updater" value="${writer}">
				      	<div class="writer">${writer}</div>
				    </div>
				 
				 
				 
				    <div class="form-group-file">
				    	<label for="file" class="label">* 사진 업로드</label>
				    	<input type="file" class="form-control form-control-sm" 
				    	       id="fileName_u" name="fileName">
				    	<a id="a" href="${p_filepath}">${p_filename}</a>
				    	<input type="button" class="file_del" id="btnDel" value="삭제" onclick="fileDel()">
				    </div>
					
					<br>
				    
				    <div class="form-group-content">
					   	<label for="content" class="label">* 내용</label>
					   	<textarea class="form-control content" rows="30" cols="10" id="content"
					              name="content" placeholder="내용 작성">${content}</textarea>
					</div>
					
					<div class="form-group">
				      	<label for="tel_info" class="label">* 전화번호</label>
				      	<input type="text" class="form-control" id="tel_info" placeholder="연락처 입력" name="tel" value="${tel}">
				    </div>
				 
					<div class="form-group">
				      	<label for="open_day" class="label">* 운영일</label>
				       	<textarea class="form-control open" rows="30" cols="10" id="open_day"
				      		      placeholder="운영일 입력" name="open_day">${open_day}</textarea>
				    </div>
				  
				    <div class="form-group">
				    	<label for="dish_info" class="label">* 대표 메뉴</label>
				       	<textarea class="form-control dish" rows="30" cols="10" id="dish_info"
				      		      placeholder="대표 메뉴 입력" name="bestmenu">${bestmenu}</textarea>
				    </div>
				   
					<div class="form-group">
				      	<label for="zipcode" class="label zip">* 우편번호 / 도로명 주소</label><br>
				      	<input type="text" class="form-control" id="zipcode1" placeholder="우편번호 5자리" name="zipcode" value="${zipcode}" readonly>
				      	<input type="button" class="btn sch" id="zipsch" value="검색" onclick="zipSearch()">
				      	<input type="text" class="form-control" id="zipcode2" placeholder="상세 주소 입력" name="address" value="${address}">
					</div>
				    
				   	<div class="form-group">
				      	<label for="traffic_info" class="label">* 교통정보</label>
				      	<textarea class="form-control traffic" rows="30" cols="10" id="traffic_info"
				      		      placeholder="대중 교통 정보 입력" name="traffic">${traffic}</textarea>
				    </div>
					
					<input type="button" class="btn" value="돌아가기" onclick="javascript:window.history.go(-1)">
					<input type="reset" class="btn" value="다시 작성">
					<input type="button" class="btn" value="게시글 수정" onclick="u_formCheck2()"/>
			    </form>
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