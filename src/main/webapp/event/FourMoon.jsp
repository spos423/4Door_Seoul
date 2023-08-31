<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>주소로 장소 표시하기</title>
    <c:import url="../main/nav2.jsp" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body style="display:flex; flex-flow:column; min-height:100vh; padding:0; margin:0;">
<section style="height: 70%">
    <nav style="float: left; width:20%;">&nbsp;</nav>    
	<nav style="float: right; width:20%;">&nbsp;</nav>    



<div style="float:left; width:60%; display: block;" >
	
	<h5 align="center"> 사대문 소개</h5> 
	<br>
	<img alt="흥인지문" src="../img/getImage.png" style="width:100%; height:100%;border-radius:20px;">
	<br><br>
	<pre>
	동대문은 1869년 고종이 재건축한 모습으로 이어오고 있다. 사대문 중 유일하게 반원에 둘러싸인 옹성 형태로 지어졌는데,
	이는 지리적인 단점을 보완하여 적을 방어하기 위함이었다. 
	오늘날 동대문은 DDP, 동대문 시장, 각종 패션몰과 인접하며 세계 디자인 산업의 중심지 역할을 톡톡히 해내고 있다.
	동대문에서 이어지는 한양도성 성곽길에 오르면 늦은 밤까지 활기찬 동대문의 모습을 바라볼 수 있다.
	
	
	
	
	</pre>
	
	
	
	<div id="map" style="width:100%; height:300px;display:flex; justify-content:center;" ></div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3533e1b86e9d6cdbe13026ff2f91936c&libraries=services" ></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
   
	mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder.addressSearch('서울 종로구 종로 288 흥인지문', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
    if (status === kakao.maps.services.Status.OK) {
        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">흥인지문</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
	});    
	</script>
</div>
</section>

<br>

<footer style="height: 30%">
	<c:import url="../main/bottom.jsp" />
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>