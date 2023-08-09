<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<script src="./js/jquery-1.11.0.min.js"></script>
<script>
$(function(){               
// slide toggle(hide & show)
$('main > .container > .sort-element > #sh > div > input:eq(0)').click(function(){
    $('main > .container > .sort-element > div > #sh-date').slideToggle(150, 'linear');
});
 
$('main > .container > .sort-element > #sh > div > input:eq(1)').click(function(){
    $('main > .container > .sort-element > div > #sh-keyword').slideToggle(150, 'linear');
}); 
 

});
</script>

<title>FOR문 SEOUL : 이벤트 리스트</title>
</head>
<body style="display:flex; flex-flow:column; min-height:100vh; padding:0; margin:0;">

<header>
<c:import url="/main/header.jsp" />

<div class="container-fluid px-0 mb-5">
	<div id="header-carousel" class="carousel slide carousel-fade" data-bs-ride="carousel">
    	<div class="carousel-inner">
        	<div class="carousel-item active">
            	<img class="w-100" src="img/getImage.png" alt="Image" style="width:500px; height:800px;">
            </div>
            <div class="carousel-item">
                <img class="w-100" src="img/getImage(1).png" alt="Image" style="width:500px; height:800px;">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#header-carousel" data-bs-slide="prev">
        	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#header-carousel" data-bs-slide="next">
        	<span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
</header>


<main style="flex:1;">

<div class="container">

	<nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%236c757d'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
  		<ol class="breadcrumb">
    		<li class="breadcrumb-item h5"><a href="#">HOME</a></li>
    		<li class="breadcrumb-item h5"><a href="#">사대문</a></li>
    		<li class="breadcrumb-item active h5" aria-current="page">행사안내</li>
  		</ol>
	</nav>


<!-- sort -->
	<div class="sort-element row align-items-center">
		<div class="col-4" style="--bs-breadcrumb-divider:'|';); float: left;" aria-label="breadcrumb">
			<ul class="breadcrumb">
				<li class="breadcrumb-item">
					<a href="#" onclick="schdulSumit(&#39;&#39;); return false;" title="목록 항목 선택됨">전체</a>
				</li>
				<li class="breadcrumb-item">
					<a href="#" onclick="schdulSumit(&#39;&#39;); return false;" title="목록 항목 선택됨">진행중</a>
				</li>
				<li class="breadcrumb-item">
					<a href="#" onclick="schdulSumit(&#39;U&#39;); return false;">진행예정</a>
				</li>
				<li class="breadcrumb-item">
					<a href="https://korean.visitseoul.net/events#" onclick="schdulSumit(&#39;C&#39;); return false;">진행완료</a>
				</li>
			</ul>
		</div>


	
		<div class="offset-md-5 col-3" id="sh">
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  				<input class="btn btn-primary me-md-2" type="button" value="기간 검색">
  				<input class="btn btn-primary" type="button" value="키워드 검색">
			</div>	
		</div>
	
	
		<div class="container text-center">
			<form class="form-control"  id="sh-date" action="#" method="post" style="display:none;">
				<label>시작일 </label> 
    			<input type="date" style="width: 200px;">
    			<label>~ 종료일 </label>
    			<input type="date" style="width: 200px;">
    			<input type="submit" value="검색">
    		</form>
    	</div>
    	<div class="container text-center">
    		<form class="form-control" id="sh-keyword" action="#" method="post" style="display:none;">
    			<input type="text" name="keyword">
    			<input type="submit" value="키워드 검색">
    		</form>
    	</div>
    </div>
	
	
	

<!--// sort end -->



<br>

	<div class="row mb-2">
    <div class="col-md-6">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-success">행사 안내 제목</strong>
          <h3 class="mb-0">행사안내 예시</h3>
          <div class="mb-1 text-muted">행사 기간 표시</div>
          <p class="mb-auto">이 곳은 행사 안내를 위해 간략한 내용을 표시하기 위한 공간입니다.</p>
          <a href="#" class="stretched-link">페이지 이동을 위한 &lt;a &gt;태그</a>
        </div>
        <div class="col-auto d-none d-lg-block">
          <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-success">행사 안내 제목</strong>
          <h3 class="mb-0">행사안내 예시</h3>
          <div class="mb-1 text-muted">행사 기간 표시</div>
          <p class="mb-auto">이 곳은 행사 안내를 위해 간략한 내용을 표시하기 위한 공간입니다.</p>
          <a href="#" class="stretched-link">페이지 이동을 위한 &lt;a &gt;태그</a>
        </div>
        <div class="col-auto d-none d-lg-block">
          <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

        </div>
      </div>
    </div>
  	</div>
  	
  	<div class="row mb-2">
    <div class="col-md-6">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">행사 안내 제목</strong>
          <h3 class="mb-0">행사안내 예시</h3>
          <div class="mb-1 text-muted">행사 기간 표시</div>
          <p class="card-text mb-auto">이 곳은 행사 안내를 위해 간략한 내용을 표시하기 위한 공간입니다.</p>
          <a href="#" class="stretched-link">페이지 이동을 위한 &lt;a &gt;태그</a>
        </div>
        <div class="col-auto d-none d-lg-block">
          <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-success">행사 안내 제목</strong>
          <h3 class="mb-0">행사안내 예시</h3>
          <div class="mb-1 text-muted">행사 기간 표시</div>
          <p class="mb-auto">이 곳은 행사 안내를 위해 간략한 내용을 표시하기 위한 공간입니다.</p>
          <a href="#" class="stretched-link">페이지 이동을 위한 &lt;a &gt;태그</a>
        </div>
        <div class="col-auto d-none d-lg-block">
          <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

        </div>
      </div>
    </div>
  	</div>
  	
  	
  	<div aria-label="..." class="container text-center">
  		<div class="row justify-content-md-center">
  			<div class="col-md-auto">
  			<ul class="pagination align-items-start">
    			<li class="page-item"><a class="page-link" href="eventlist.jsp?pageNum=${startPage - pageBlock}">Previous</a></li>
    			<li class="page-item"><a class="page-link" href="#">1</a></li>
    			<li class="page-item" aria-current="page"><a class="page-link" href="#">2</a></li>
    			<li class="page-item"><a class="page-link" href="#">3</a></li>
    			<li class="page-item"><a class="page-link" href="eventlist.jsp?pageNum=${startPage + pageBlock}">Next</a></li>
  			</ul>
  			</div>
  		</div>
	</div>
	
</div>

</main>

<footer style="height: 30%">
	<c:import url="/main/footer.jsp" />
</footer>

<!-- Back to Top -->
<a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>

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