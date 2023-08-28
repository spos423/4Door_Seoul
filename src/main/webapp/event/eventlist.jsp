<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="./css/eventlist.css" rel="stylesheet">

<!--  커스텀 JS -->
<script type="text/javascript" src="./js/eventlist.js"></script>

<title>FOR문 SEOUL : 이벤트 리스트</title>
</head>
<body>

<header>
<c:import url="/main/header.jsp" />
</header>


<main>

<div class="container-fluid px-0 mb-5">
	<div id="header-carousel" class="carousel slide carousel-fade" data-bs-ride="carousel">
    	<div class="carousel-inner">
        	<div class="carousel-item active">
            	<img class="listslide_custom" src="./img/asd123.jpg">
            </div>
            <div class="carousel-item">
                <img class="listslide_custom" src="./img/dondaemun_1.jpg">
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

<div class="container sort">

	<nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%236c757d'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
  		<ol class="breadcrumb">
    		<li class="breadcrumb-item h5"><a href="/">HOME</a></li>
    		<li class="breadcrumb-item active h5"><a href="javascript:void(0)">사대문</a></li>
    		<li class="breadcrumb-item active h5" aria-current="page">행사안내</li>
  		</ol>
	</nav>


<!-- sort -->
	<div class="sort-element row align-items-center">
		<div class="col-4" style="--bs-breadcrumb-divider:'|';); float: left;" aria-label="breadcrumb">
			<ul class="breadcrumb">
				<li class="breadcrumb-item">
					<a href="/event/eventlist.do" title="목록 항목 선택됨">전체</a>
				</li>
				<li class="breadcrumb-item">
					<a href="/event/eventlist.do?status=ongoing" title="목록 항목 선택됨">진행중</a>
				</li>
				<li class="breadcrumb-item">
					<a href="/event/eventlist.do?status=isscheduled">진행예정</a>
				</li>
				<li class="breadcrumb-item">
					<a href="/event/eventlist.do?status=done">진행완료</a>
				</li>
			</ul>
		</div>
	
		<div class="offset-md-5 col-3" id="sh">
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  				<p class="d-inline-flex gap-1">
	 				<input class="btn btn-primary me-md-2" type="button" value="기간 검색" data-bs-toggle="collapse" data-bs-target="#searchPeriod" aria-expanded="false" aria-controls="searchPeriod">
  					<input class="btn btn-primary" type="button" value="키워드 검색" data-bs-toggle="collapse" data-bs-target="#searchKeyword" aria-expanded="false" aria-controls="searchKeyword">
				</p>
			</div>
		</div>
	</div>
	
	<div class="collapse" id="searchPeriod">
		<div class="text-center" >
			<form action="/event/eventlist.do" class="form-control" name="searchPeriod_Form" method="post" onsubmit="return searchPeriod()">
				<div class="input-group mb-3">
    			<span class="input-group-text" id="event_span">행사 시작일</span>
				<input type="datetime-local" name="startdate" class="form-control" oninput="printConsole(this)">
				<span class="input-group-text" id="event_span">행사 종료일</span>
				<input type="datetime-local" name="enddate" class="form-control" oninput="return startFirst()">
    			</div>
   			</form>
   		</div>
   	</div>	
	
	<div class="collapse" id="searchKeyword">
    	<div class="container text-center">
    		<form action="/event/eventlist.do" class="form-control" name="searchKeyword_Form"  method="post" onsubmit="return searchKeyword()">
    			<select name="searchCondition">
    				<option value="title">제목</option>
    				<option value="content">내용</option>
    				<option value="writer">작성자</option>
    			</select>
    			<input type="text" name="keyword">
    			<input type="submit" value="키워드 검색">
    		</form>
    	</div>
	</div>	
<!-- sort end -->



<br>

	<c:if test="${count eq 0}">
	<table width="700" border="1" cellpadding="0" cellspacing="0">
   		<tr>
      		<td align="center">게시판에 저장된 글이 없습니다.</td>
   		</tr>
	</table>
	</c:if>



	<c:if test="${count ne 0}">

	<div class="row mb-2">
	<c:forEach var="item" items="${e_boardList}">
        <fmt:parseDate value="${item.startdate}" var="start" pattern="yyyy-MM-dd'T'HH:mm" />
        <fmt:parseDate value="${item.enddate}" var="end" pattern="yyyy-MM-dd'T'HH:mm" />
        <fmt:parseDate value="${item.writedate}" var="writeDay" pattern="yyyy-MM-dd HH:mm:ss.SSS" />
	
	    <jsp:useBean id="now" class="java.util.Date" scope="request" />
        <fmt:parseNumber value="${now.time/(1000*60*60*24)}" integerOnly="true" var="nowDays" scope="request" />
        <fmt:parseNumber value="${writeDay.time/(1000*60*60*24)}" integerOnly="true" var="writeDays" scope="request" />
        <fmt:parseNumber value="${start.time/(1000*60*60*24)}" integerOnly="true" var="startDays" scope="request" />
		<fmt:parseNumber value="${end.time/(1000*60*60*24)}" integerOnly="true" var="endDays" scope="request" />
		
    	<div class="col-md-6">
      		<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        		<div class="col p-4 d-flex flex-column position-static" style="overflow: hidden; text-overflow: ellipsis;">
	          		<div class="row">
	          			<c:if test="${writeDays ge nowDays-3}">
	          				<span class="badge bg-info col-1" style="width:50px;">New</span>
						</c:if>
						<c:if test="${startDays <= nowDays and endDays >= nowDays}">
	          				<span class="badge bg-danger col-1" style="width:70px;">Now On!</span>
						</c:if>
						<c:if test="${startDays > nowDays and endDays > nowDays}">
	          				<span class="badge bg-success col-1" style="width:90px;">OnComming</span>
						</c:if>
						<c:if test="${startDays < nowDays and endDays < nowDays}">
		          			<span class="badge bg-dark col-1" style="width:50px;">End</span>
						</c:if>
					</div>
					    			
          			<div style="height: 32px!important; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
          				<h3 class="mb-0" style="font-family: Open Sans,sans-serif;">${item.title}</h3>
					</div>
          			<div class="mb-1 text-muted">
          				<fmt:formatDate value="${start}" pattern="yyyy-MM-dd" />
          				~
          				<fmt:formatDate value="${end}" pattern="yyyy-MM-dd" />
          			</div>
          			<div class="mb-auto" style="height: 50px!important; overflow: hidden; text-overflow: ellipsis;">${item.content}</div>
          				<a class="stretched-link" href="javascript:void(0)" onclick="javascript:goBoard('${item.num}')">작성일 : <fmt:formatDate value="${writeDay}" pattern="yyyy-MM-dd" /></a>
        			</div>
        		<div class="col-auto d-none d-lg-block" style="width: 180px; height: 220px;">
        			<c:if test="${item.img1_url eq null}">
        				<img src="/event/upload/no_image.jpg" class="img-thumbnail thumbnail_custom">
        			</c:if>
        			<c:if test="${item.img1_url ne null}">
          				<img src="${item.img1_url}" class="img-thumbnail thumbnail_custom">
          			</c:if>
        		</div>
      		</div>
    	</div>
  	</c:forEach>
  	</div>
  	
  	</c:if>
  	
  	
  	
  	<div class="offset-md-9 col-3" id="sh">
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  			<p class="d-inline-flex gap-1">
	 			<input class="btn btn-primary me-md-2" type="button" value="새글 작성" onclick="location.href='/event/eventForm.jsp'">
			</p>
		</div>
	</div>
  	
  	
  	<%-- 페이징 처리  --%>
  	<c:if test="${count > 0}">
  	<c:set var="pageBlock" value="${4}"/>
  	<c:set var="imsi" value="${count % pageSize == 0 ? 0 : 1}"/>
  	<c:set var="pageCount" value="${count/pageSize + imsi}"/>
  	<fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock}" integerOnly="true" />
  	<c:set var="startPage" value="${result*pageBlock+1}"/>
	<c:set var="endPage" value="${startPage + pageBlock-1}"/>
  	
  	<c:if test="${endPage > pageCount }">
   	<c:set var="endPage" value="${pageCount}"/>
   	</c:if>
  	
  	
  	<div aria-label="..." class="container text-center">
  		<div class="row justify-content-md-center">
  			<div class="col-md-auto">
  			<ul class="pagination align-items-start">
  				<c:if test="${startPage > pageBlock}">
    				<li class="page-item"><a class="page-link" href="javascript:void(0)" onclick="frm_sub(${startPage - pageBlock})">Previous</a></li>
    			</c:if>
    			<c:forEach var="i" begin="${startPage}" end="${endPage}">
    				<li class="page-item"><a class="page-link" href="javascript:void(0)" onclick="frm_sub(${i})">${i}</a></li>
    			</c:forEach>
    			<c:if test="${endPage < pageCount }">
    				<li class="page-item"><a class="page-link" href="javascript:void(0)" onclick="frm_sub(${startPage + pageBlock})">Next</a></li>
  				</c:if>
  			</ul>
  			</div>
  		</div>
	</div>
	</c:if>
</div>

<form action="" method="post" name="i_frm">
<input type ="hidden" name="find" value="${searchCondition}">
<input type ="hidden" name="find_box" value="${keyword}">
</form>


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