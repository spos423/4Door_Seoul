<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1.0" name="viewport">

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
<link href="./css/eventForm.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<!-- Summernote JavaScript -->
<script type="text/javascript">
function postForm() {
    $('textarea[name="content"]').val($('#summernote').summernote('code'));
}
</script>

<!-- 폼 정보 알림 메세지 -->
<script src="./js/eventForm.js"></script>

<title>FOR문 SEOUL : 이벤트 리스트</title>
</head>
<body>

<header>
<c:import url="/main/header.jsp" />
</header>


<main class="eventform">
<div class="container">
	<nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%236c757d'/%3E%3C/svg%3E&#34;);">
  		<ol class="breadcrumb">
    		<li class="breadcrumb-item h5"><a href="#">HOME</a></li>
    		<li class="breadcrumb-item h5 active"><a href="#">사대문</a></li>
    		<li class="breadcrumb-item h5"><a href="./eventlist.jsp">행사안내</a></li>
    		<li class="breadcrumb-item active h5" aria-current="page">게시글 작성</li>
  		</ol>
	</nav>

  <p class="display-1">행사안내 양식</p>
  <hr>
  <form action="/event/updateE_Board_Proc.do" name="eventForm" method="post" enctype="multipart/form-data" onsubmit="return formCheck()">
	
	<!-- submit할 때 같이 넘길 num값  -->	
	<input type="hidden" name="num" value="${e_board.num}">
	
    <div class="input-group mb-3">
  		<span class="input-group-text" id="event_span">제목</span>
 		<input type="text" name="title" class="form-control" placeholder="글 제목을 입력해주세요.(50자 이내)" maxlength="50" oninput="lengthLimit(this,this.maxlength)" value="${e_board.title}">
 		<span class="input-group-text" id="event_span">작성자</span>
 		<input type="text" name="writer" class="form-control" placeholder="Writer" maxlength="10" oninput="lengthLimit(this,this.maxlength)" readonly="readonly" value="${e_board.writer}">
	</div>
	
	<div class="input-group mb-3 insert">
  		<label class="input-group-text" id="event_label">Upload</label>
  		<input type="file" class="form-control" name="thumb_img1" onchange="return fileUploadCheck(this.value)" value="${e_board.img1_url}">
	</div>
    
	<div class="input-group mb-3" id="zipcode_div">
  		<span class="input-group-text" id="zipcode_span">우편번호</span>
  		<input type="text" name="zipcode" id="zipcode" class="form-control" placeholder="우편번호 입력(5자)" maxlength="5" oninput="lengthLimit(this,this.maxlength)" readonly="readonly" value="${e_board.zipcode}">
  		<button class="btn btn-outline-secondary" id="address_kakao" type="button">주소검색</button>
	</div>
	
	<div class="input-group mb-3">
		<span class="input-group-text" id="event_span">주소</span>
  		 <input type="text" name="address" id="address" class="form-control" placeholder="도로명 주소 입력" maxlength="50" oninput="lengthLimit(this,this.maxlength)" value="${e_board.address}">
	</div>

<textarea id="summernote" name="content">${e_board.content}</textarea>
    <script>
      $('#summernote').summernote({
        height: 500,
        placeholder: '게시글 입력란(한글 800자 이내)',
        tabsize: 2,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ]
      });
    </script>
	<br>
	
    <div class="input-group mb-3">
  		<span class="input-group-text" id="event_span">이용요금</span>
 		<input type="text" name="price" class="form-control" placeholder="이용요금 있을시 작성(30자 내외)" maxlength="30" oninput="lengthLimit(this,this.maxlength)" value="${e_board.price}">
 		<span class="input-group-text" id="event_span">전화번호</span>
 		<input type="text" name="tel" class="form-control" placeholder="행사 담당부서 연락처(20자 내외)" maxlength="20" oninput="lengthLimit(this,this.maxlength)" value="${e_board.tel}">
	</div>
    
    <div class="input-group mb-3">
    	<span class="input-group-text" id="event_span">교통정보</span>
      	<input type="text" name="traf" class="form-control" id="traffic_info" placeholder="교통 정보를 간단하게 입력" maxlength="100" oninput="lengthLimit(this,this.maxlength)" value="${e_board.traf}">
    </div>
    
    <div class="input-group mb-3">
    	<span class="input-group-text" id="event_span">웹사이트</span>
      	<input type="text" name="uri" class="form-control" id="url_info" placeholder="요금 입력" maxlength="100" oninput="lengthLimit(this,this.maxlength)" value="${e_board.uri}">
    </div>
    
    <div class="input-group mb-3">
    	
    	<fmt:parseDate value="${e_board.startdate}" var="start" pattern="yyyy-MM-dd'T'HH:mm" />
    	<fmt:parseDate value="${e_board.enddate}" var="end" pattern="yyyy-MM-dd'T'HH:mm" />
    
    	<span class="input-group-text" id="event_span">행사 시작일</span>
		<input type="datetime-local" name="startdate" class="form-control" oninput="printConsole(this)" value="<fmt:formatDate value="${start}" pattern="yyyy-MM-dd'T'HH:mm"/>">
		<span class="input-group-text" id="event_span">행사 종료일</span>
		<input type="datetime-local" name="enddate" class="form-control" oninput="return startFirst()" value="<fmt:formatDate value="${end}" pattern="yyyy-MM-dd'T'HH:mm"/>">
    </div>
 
	
	<div class="row">
		<div class="offset-md-8 col-2">
			<button name="submit_btn" type="submit" class="btn btn-primary">등록</button>
    	</div>
    	<div class="col-2">
 			<button name="cancel_btn" type="button" class="btn btn-primary" onclick="javascript:history.go(-1)">취소</button>
    	</div>
    </div>
    
    <br><br>
    
  </form>
</div>
</main>

<footer>
	<c:import url="/main/footer.jsp" />
</footer>

<!-- Back to Top -->
<a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>
	
	<!-- 카카오 주소검색 라이브러리 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("zipcode").value = data.zonecode; // 우편번호 넣기
                document.getElementById("address").value = data.address; // 주소 넣기
                document.querySelector("input[name=address]").focus(); //상세입력 포커싱
            }
        }).open();
    });
}
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