<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
<title></title>
</head>
<body style="display: flex; flex-flow: column; min-height: 100vh; padding: 0; margin: 0;">

	<!-- Navbar Start -->
	<header>
		<c:import url="./header.jsp"></c:import>
	</header>
	<!-- Navbar End -->


	<!-- Carousel Start -->
	<div class="dd"
		style="float: left; height: 100px; width: 100%; display: inline-block;"></div>



	<main class="container-fluid px-0 mb-5"
		style="float: left; width: 60%; display: block; flex: 1; text-align: center;">
	
	</main>


	<!-- Carousel End -->

	<!-- Copyright Start -->
	<footer>
		<c:import url="./footer.jsp"></c:import>
	</footer>
	<!-- Copyright End -->

	<!-- Back to Top -->
	<a href="#"
		class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i
		class="bi bi-arrow-up"></i></a>

</body>
</html>