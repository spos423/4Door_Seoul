<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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



	<main class="container-fluid px-0 mb-5" style="float:left; width:60%; display: block; flex: 1;">
    <div class="container"> 
      <div class="row"> 
       <h1 align="center">자유 게시판</h1>
       <table class="table table-striped">
         <tr class="danger">
           <th class="text-center" width=10%>번호</th>
           <th class="text-center" width=45%>제목</th>
           <th class="text-center" width=15%>이름</th>
           <th class="text-center" width=20%>작성일</th>
           <th class="text-center" width=10%>조회수</th>
         </tr>   
          <c:forEach var="frboard" items="${frboardList}">
           <tr>
               <td class="text-center" width=10%>${frboard.num}</td>
               <td class="text-center" width=45%>
                 <a href="getBoard.do?num=${frboard.num}">${frboard.title}</a>
               </td>
               <td class="text-center" width=15%>${frboard.writer}</td>
               <td class="text-center" width=20%> <fmt:formatDate value="${frboard.writeday}" pattern="yyyy-MM-dd"/></td>
               <td class="text-center" width=10%>${frboard.readcount}</td>
           </tr>
         </c:forEach>
       </table>
      
         
    <%--페이징 처리 --%>
   
       <%-- <table class="table">
          <td class="text-center">
          <a href="#" class="btn btn-sm btn-primary">이전</a>
          ${curpage } page / ${totalpage } pages
          <a href="#" class="btn btn-sm btn-primary">다음</a>
         </td>
       </table> --%>
     
       <table>
       <tr>
           <td align="right">
             <a href="insertBoard.jsp" class="btn btn-sm btn-primary" >글쓰기</a>
           </td>
         </tr>
         </table>
         
      <form  action="getBoardList.do" method="post" align="center">

       <select name="searchCondition">
         <option value="title" >제목</option>
         <option value="content">내용</option>
         <option value="writer">작성자</option>
       </select>
       <input name="searchKeyword" typer="text"/>
       <input type="submit" value="검색"/>  
     </form>
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