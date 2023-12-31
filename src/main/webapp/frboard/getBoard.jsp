<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><meta content="width=device-width, initial-scale=1.0" name="viewport">

<!-- Favicon -->
<link href="/main/img/logo.png" rel="icon">

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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<!-- Template Stylesheet -->
<link href="./css/style.css" rel="stylesheet">

<title></title>
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
    	<c:import url="/main/header.jsp"></c:import>
    </header>
    <!-- Navbar End -->


    <!-- Carousel Start -->
	<!-- <div class="dd" style="float: left; height:100px; width:100%; display:inline-block;"></div> -->



	<main class="container-fluid px-0 mb-5" style="float:left; width:60%; display: block; flex: 1;" >
		<div class="container">
	
     <div class="row" style="margin-top: 100px;">
      <h1>내용보기</h1>
     <form action="updateBoard.do" method="post">
      <table class="table table-striped">
       
        <tr>
          <th width=20% class="text-center  bg-primary bg-opacity-50">번호</th>
          <td width=30% class="text-center ">${frboard.num}</td>
          
          
          <th width=20% class="text-center  bg-primary bg-opacity-50">작성일</th>
          <td width=30% class="text-center"><fmt:formatDate value="${frboard.writeday}" pattern="yyyy-MM-dd"/></td>
        </tr>
        <tr>
          <th width=20% class="text-center  bg-primary bg-opacity-50" >이름</th>
          <td width=30% class="text-center">${frboard.writer }</td>
          <th width=20% class="text-center  bg-primary bg-opacity-50">조회수</th>
          <td width=30% class="text-center">${frboard.readcount }</td>
        </tr>
        <tr>
          <th width=20% class="text-center  bg-primary bg-opacity-50">제목</th>
          <td colspan="3" class="text-left">${frboard.title } </td>
        </tr>
        
        <tr>
          <td colspan="4" class="text-left" valign="top" height=200>
             ${frboard.content }
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right" align="right">
            <a href="updateBoard.jsp" class="btn btn-sm btn-success">수정</a>
            <a href="deleteBoard.do?num=${frboard.num }" class="btn btn-sm btn-info">삭제</a>
            <a href="getBoardList.do" class="btn btn-sm btn-warning">목록</a>
          </td>
        </tr>
      </table>


     </form>
     
    
    
    <form action="/frboard/insertDBoard.do" method="post">
    	<input type="hidden" value="${frboard.num}" name="d_num">
    <table class="table">
        <tr>
           <th class="text-center danger bg-primary bg-opacity-50" width=15% align="left">작성자</th>
        <td width=85%>
          <input type="text" name="writer"  size=15 />
        </td>
       </tr>
        
        <tr>
        <th class="text-center danger bg-primary bg-opacity-50" width=15%><br>내용</th>
        <td width=85%>
          <textarea rows="3" cols="90" name="content"></textarea>
          <input type="submit" class="btn btn-xs btn-success" value="등록" align="right" >
        </td>
       </tr>

    </table>
</form>
       <div class="card">
       <div class="card-header">댓글 목록</div>
          <ul class="reply-box" class="list-group">
          <c:forEach items="${dboard }" var="dboard">
          <li id="reply--1" class="list-group-item d-flex justify-content-between">
          <div> ${dboard.content} </div>
          <div class="d-flex">
              <div class="font-italic">작성자: ${dboard.writer} &nbsp;</div>
              <div class="font-italic">작성일: <fmt:formatDate value="${frboard.writeday}" pattern="yyyy-MM-dd"/> &nbsp;</div>
              <a href="deleteDBoard.do?rno=${dboard.rno }&num=${frboard.num}"  class="btn btn-sm btn-info">삭제</a>

          </div>
          </li>
          </c:forEach>
          </ul>
       </div>
     
     </div>
     
   </div>
   
	</main>
   	
   	
    <!-- Carousel End -->
	
    <!-- Copyright Start -->
    <footer>
    	<c:import url="/main/footer.jsp"></c:import>
    </footer>
    <!-- Copyright End -->
	
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