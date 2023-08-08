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
		style="float: left; width: 60%; display: block; flex: 1;">
	
		<h4 style="font-family: 견고딕; color:gray">홈 > 여행정보 > 볼거리</h4>
		<br>
		<div style="float:left; width:100%; display: block;">
			<div class="ct_d" style="width: 100%;
									 max-width: 1200px;
									 position: relative;
									 margin: 10px auto 0;
									 text-align: left;">
				<a class="active" href="#" style="color: #0066eb;
												  padding: 5px 0px;
												  border-bottom: 2px solid #0066eb;
												  margin-right: 10px;">
				전체
				</a>
				<a href="#" style="color: grey; margin-right: 10px;">명소</a>
				<a href="#" style="color: grey; margin-right: 10px;">자연&경관</a>
				<a href="#" style="color: grey; margin-right: 10px;">엔터테인먼트</a>
			</div>
			<div class="search_board" style="height: 50px">
				<div class="float-right" style="float: right;">
					<div class="search_board_t" style="height: 40px; float: left; margin-right: 10px;">
						<a href="#" style=" display: block;
										    font-size: 14px;
										    color: #767676;
										    font-weight: 300;
										    border: solid 1px #d9d9d9;
										    background-color: #ffffff;
										    line-height: 37px;
										    padding: 0px 12px;
										    border-radius: 4px;
										    text-align: center;">
							기간 검색				    
						</a>
					</div>
					<div class="search_board_k" style="height: 40px; float: left; margin-right: 10px;">					
						<a href="#" style=" display: block;
										    font-size: 14px;
										    color: #767676;
										    font-weight: 300;
										    border: solid 1px #d9d9d9;
										    background-color: #ffffff;
										    line-height: 37px;
										    padding: 0px 12px;
										    border-radius: 4px;
										    text-align: center;">
							키워드 검색				    
						</a>
					</div>
				</div>
			</div>
			
			<div class="mb" style="--bs-gutter-x: 1.5rem;
								   --bs-gutter-y: 0;
								   display: block;
								   flex-wrap: wrap;
								   margin-right: calc(-.5 * var(--bs-gutter-x));
								   margin-left: calc(-.5 * var(--bs-gutter-x));
								   margin-top: 1.5rem!important;
								   margin-bottom: 20rem!important;
								   box-sizing: border-box;">
				<a href="#">
									   
					<div class="mb_l" style="flex: 0 0 auto; width: 50%;
											 display: inline-block;
											 float: left;
										     min-width: 550px;
											 --bs-gutter-x: 1.5rem;
										     --bs-gutter-y: 0;
										     max-width: 100px;
										     box-sizing: border-box;">
										     
						<div class="mb_l_one" style="--bs-gutter-x: 0;
												   --bs-gutter-y: 0;
												   height: 250px;
												   display: flex;
											       flex-wrap: wrap;
											       margin-top: calc(-1 * var(--bs-gutter-y));
											       margin-right: calc(-.5 * var(--bs-gutter-x));
											       margin-left: calc(-.5 * var(--bs-gutter-x));
											       overflow: hidden!important;
											       box-shadow: 0 .125rem .25rem rgba(0,0,0,.075)!important;
											       border: var(--bs-border-width) var(--bs-border-style) var(--bs-border-color)!important;
											       border-radius: var(--bs-border-radius)!important;">
							
							<div class="mb_l_one_left" style="--bs-gutter-x: 0;
												   		   --bs-gutter-y: 0;
												   		   max-width: 60%;
												   		   display: flex!important;
												   		   flex-direction: column!important;
													       flex-wrap: wrap;
													       flex: 1 0 0%;
													       padding: 1.5rem!important;
													   	   margin-top: calc(-1 * var(--bs-gutter-y));
													       margin-right: calc(-.5 * var(--bs-gutter-x));
													       margin-left: calc(-.5 * var(--bs-gutter-x));
													       box-sizing: border-box;
													       text-align: center;">
								<h3 style="font-familly: 견고딕; padding-left: 20px; margin-bottom: 40px;">도봉산</h3>
								<div class="mb_l_one_left_c" style="max-width: 100%;
								                                    height: 100px;
																	color: #959595;
																	padding-left: 20px;
																	overflow: hidden;
									    							text-overflow: ellipsis;">
								도봉산은 이름 그대로 봉우리가 길인 산이다. 선인봉을 오르는 암벽 등반 코스만 해도 37개나 된다. 
								매표소 입구를 지나 공원에 들어서면 우암 송시열이 바위에 직접 새긴 글씨가 눈에 띈다.
								도봉산의 입구를 알리는 암각문이다. 높은 봉우리에 붉은 빛의 구름이 걸린다는 의미의 자운봉은 739.5미터의 도봉산 최고봉이다. 
								</div>
							</div>
							<div class="mb_l_one_right" style="background-image: url(./img/dbmt.jpg);
															   overflow: hidden;
															   position: relative;
															   width: 100%;
															   height: 100%;
															   background-repeat: no-repeat;
															   background-size: cover;
															   background-position: center;
															   --bs-gutter-x: 0;
													   		   --bs-gutter-y: 0;
													   		   max-width: 40%;
													   		   display: flex!important;
													   		   flex-direction: column!important;
														       flex-wrap: wrap;
														       flex: 1 0 0%;
														       padding: 1.5rem!important;
														   	   margin-top: calc(-1 * var(--bs-gutter-y));
														       margin-right: calc(-.5 * var(--bs-gutter-x));
														       margin-left: calc(-.5 * var(--bs-gutter-x));
														       box-sizing: border-box;
														       text-align: center;">
							
							</div>
							
				        </div>
				        
					</div>
					
				</a>
					
				<a href="#">
					<div class="mb_r" style="flex: 0 0 auto; width: 50%;
											 display: inline-block;
											 float: right;
										     min-width: 550px;
											 --bs-gutter-x: 1.5rem;
										     --bs-gutter-y: 0;
										     max-width: 100px;
										     box-sizing: border-box;">
										     
						<div class="mb_l_one" style="--bs-gutter-x: 0;
												   --bs-gutter-y: 0;
												   height: 250px;
												   display: flex;
											       flex-wrap: wrap;
											       margin-top: calc(-1 * var(--bs-gutter-y));
											       margin-right: calc(-.5 * var(--bs-gutter-x));
											       margin-left: calc(-.5 * var(--bs-gutter-x));
											       overflow: hidden!important;
											       box-shadow: 0 .125rem .25rem rgba(0,0,0,.075)!important;
											       border: var(--bs-border-width) var(--bs-border-style) var(--bs-border-color)!important;
											       border-radius: var(--bs-border-radius)!important;">
							
							<div class="mb_l_one_left" style="--bs-gutter-x: 0;
												   		   --bs-gutter-y: 0;
												   		   max-width: 60%;
												   		   display: flex!important;
												   		   flex-direction: column!important;
													       flex-wrap: wrap;
													       flex: 1 0 0%;
													       padding: 1.5rem!important;
													   	   margin-top: calc(-1 * var(--bs-gutter-y));
													       margin-right: calc(-.5 * var(--bs-gutter-x));
													       margin-left: calc(-.5 * var(--bs-gutter-x));
													       box-sizing: border-box;
													       text-align: center;">
								<h3 style="font-familly: 견고딕; padding-left: 20px; margin-bottom: 40px;">예술의전당</h3>
								<div class="mb_l_one_left_c" style="max-width: 100%;
								                                    height: 100px;
																	color: #959595;
																	padding-left: 20px;
																	overflow: hidden;
									    							text-overflow: ellipsis;">
								예술의 전당은 1988년 음악당과 서예박물관을 시작으로 단계별 개관이 이루어졌고, 1993년에 이르러 전체 개관을 마무리했다. 
								오페라하우스와 음악당, 한가람미술관, 한가람디자인미술관, 서울서예박물관 등 예술의 전반적인 영역을 두루 수용할 수 있는 
								공간들을 만들어왔을 뿐만 아니라 원형 광장을 비롯해 전통 한국 정원 등 옥외 공간에도 힘을 쏟았다.
								</div>
							</div>
							<div class="mb_l_one_right" style="background-image: url(./img/예술의전당.jpg);
															   overflow: hidden;
															   position: relative;
															   width: 100%;
															   height: 100%;
															   background-repeat: no-repeat;
															   background-size: cover;
															   background-position: center;
															   --bs-gutter-x: 0;
													   		   --bs-gutter-y: 0;
													   		   max-width: 40%;
													   		   display: flex!important;
													   		   flex-direction: column!important;
														       flex-wrap: wrap;
														       flex: 1 0 0%;
														       padding: 1.5rem!important;
														   	   margin-top: calc(-1 * var(--bs-gutter-y));
														       margin-right: calc(-.5 * var(--bs-gutter-x));
														       margin-left: calc(-.5 * var(--bs-gutter-x));
														       box-sizing: border-box;
														       text-align: center;">
							
							</div>
							
				        </div>
				        
					</div>
				</a>
					
			</div>
			
			<div class="mb" style="--bs-gutter-x: 1.5rem;
								   --bs-gutter-y: 0;
								   display: block;
								   flex-wrap: wrap;
								   margin-right: calc(-.5 * var(--bs-gutter-x));
								   margin-left: calc(-.5 * var(--bs-gutter-x));
								   margin-top: 1.5rem!important;
								   margin-bottom: 20rem!important;
								   box-sizing: border-box;">
				<a href="#">
									   
					<div class="mb_l" style="flex: 0 0 auto; width: 50%;
											 display: inline-block;
											 float: left;
										     min-width: 550px;
											 --bs-gutter-x: 1.5rem;
										     --bs-gutter-y: 0;
										     max-width: 100px;
										     box-sizing: border-box;">
										     
						<div class="mb_l_one" style="--bs-gutter-x: 0;
												   --bs-gutter-y: 0;
												   height: 250px;
												   display: flex;
											       flex-wrap: wrap;
											       margin-top: calc(-1 * var(--bs-gutter-y));
											       margin-right: calc(-.5 * var(--bs-gutter-x));
											       margin-left: calc(-.5 * var(--bs-gutter-x));
											       overflow: hidden!important;
											       box-shadow: 0 .125rem .25rem rgba(0,0,0,.075)!important;
											       border: var(--bs-border-width) var(--bs-border-style) var(--bs-border-color)!important;
											       border-radius: var(--bs-border-radius)!important;">
							
							<div class="mb_l_one_left" style="--bs-gutter-x: 0;
												   		   --bs-gutter-y: 0;
												   		   max-width: 60%;
												   		   display: flex!important;
												   		   flex-direction: column!important;
													       flex-wrap: wrap;
													       flex: 1 0 0%;
													       padding: 1.5rem!important;
													   	   margin-top: calc(-1 * var(--bs-gutter-y));
													       margin-right: calc(-.5 * var(--bs-gutter-x));
													       margin-left: calc(-.5 * var(--bs-gutter-x));
													       box-sizing: border-box;
													       text-align: center;">
								<h3 style="font-familly: 견고딕; padding-left: 20px; margin-bottom: 40px;">경복궁</h3>
								<div class="mb_l_one_left_c" style="max-width: 100%;
								                                    height: 100px;
																	color: #959595;
																	padding-left: 20px;
																	overflow: hidden;
									    							text-overflow: ellipsis;">
								경복궁은 조선 시대에 지어진 왕궁 중 가장 큰 궁궐이었다. 조선 왕조 개국 3년인 1395년에 완공된 궁궐은 390여 칸으로 한양의 중심축에 자리했다. 
								개국공신 정도전은 태조로부터 첫 번째 궁궐의 이름을 지으라는 명을 받았고, 
								고심 끝에 '새 왕조가 큰 복을 누려 번영할 것'이라는 의미로 경복궁(景福宮)이라는 이름을 붙였다. 
								경복궁은 5대궁인 경희궁, 덕수궁, 창경궁, 창덕궁 중 가장 큰 궁궐로 조선 왕조의 주요 궁궐 역할을 했다.
								</div>
							</div>
							<div class="mb_l_one_right" style="background-image: url(./img/경복궁.jpg);
															   overflow: hidden;
															   position: relative;
															   width: 100%;
															   height: 100%;
															   background-repeat: no-repeat;
															   background-size: cover;
															   background-position: center;
															   --bs-gutter-x: 0;
													   		   --bs-gutter-y: 0;
													   		   max-width: 40%;
													   		   display: flex!important;
													   		   flex-direction: column!important;
														       flex-wrap: wrap;
														       flex: 1 0 0%;
														       padding: 1.5rem!important;
														   	   margin-top: calc(-1 * var(--bs-gutter-y));
														       margin-right: calc(-.5 * var(--bs-gutter-x));
														       margin-left: calc(-.5 * var(--bs-gutter-x));
														       box-sizing: border-box;
														       text-align: center;">
							
							</div>
							
				        </div>
				        
					</div>
					
				</a>
					
				<a href="#">
					<div class="mb_r" style="flex: 0 0 auto; width: 50%;
											 display: inline-block;
											 float: right;
										     min-width: 550px;
											 --bs-gutter-x: 1.5rem;
										     --bs-gutter-y: 0;
										     max-width: 100px;
										     box-sizing: border-box;">
										     
						<div class="mb_l_one" style="--bs-gutter-x: 0;
												   --bs-gutter-y: 0;
												   height: 250px;
												   display: flex;
											       flex-wrap: wrap;
											       margin-top: calc(-1 * var(--bs-gutter-y));
											       margin-right: calc(-.5 * var(--bs-gutter-x));
											       margin-left: calc(-.5 * var(--bs-gutter-x));
											       overflow: hidden!important;
											       box-shadow: 0 .125rem .25rem rgba(0,0,0,.075)!important;
											       border: var(--bs-border-width) var(--bs-border-style) var(--bs-border-color)!important;
											       border-radius: var(--bs-border-radius)!important;">
							
							<div class="mb_l_one_left" style="--bs-gutter-x: 0;
												   		   --bs-gutter-y: 0;
												   		   max-width: 60%;
												   		   display: flex!important;
												   		   flex-direction: column!important;
													       flex-wrap: wrap;
													       flex: 1 0 0%;
													       padding: 1.5rem!important;
													   	   margin-top: calc(-1 * var(--bs-gutter-y));
													       margin-right: calc(-.5 * var(--bs-gutter-x));
													       margin-left: calc(-.5 * var(--bs-gutter-x));
													       box-sizing: border-box;
													       text-align: center;">
								<h3 style="font-familly: 견고딕; padding-left: 20px; margin-bottom: 40px;">전쟁기념관</h3>
								<div class="mb_l_one_left_c" style="max-width: 100%;
								                                    height: 100px;
																	color: #959595;
																	padding-left: 20px;
																	overflow: hidden;
									    							text-overflow: ellipsis;">
								전쟁기념관에 들어서면 '형제의 상'이 가장 먼저 눈에 들어온다. 현대사의 슬픔을 고스란히 보여준다. 
								너른 광장을 지나 기념관을 향한다. 1층 전시실에는 선사 시대부터 6.25전쟁까지 그 역사가 모형으로 꾸며져 있다. 
								모형과 더불어 2층과 3층에는 전시 자료들도 준비되어 있다. 
								전쟁체험실은 전쟁의 극한 상황을 다양한 감각으로 체험하는 공간이다. 전쟁기념관은 옥외 전시장도 들러볼 만하다.
								</div>
							</div>
							<div class="mb_l_one_right" style="background-image: url(./img/전쟁기념관.jpg);
															   overflow: hidden;
															   position: relative;
															   width: 100%;
															   height: 100%;
															   background-repeat: no-repeat;
															   background-size: cover;
															   background-position: center;
															   --bs-gutter-x: 0;
													   		   --bs-gutter-y: 0;
													   		   max-width: 40%;
													   		   display: flex!important;
													   		   flex-direction: column!important;
														       flex-wrap: wrap;
														       flex: 1 0 0%;
														       padding: 1.5rem!important;
														   	   margin-top: calc(-1 * var(--bs-gutter-y));
														       margin-right: calc(-.5 * var(--bs-gutter-x));
														       margin-left: calc(-.5 * var(--bs-gutter-x));
														       box-sizing: border-box;
														       text-align: center;">
							
							</div>
							
				        </div>
				        
					</div>
				</a>
					
			</div>
			
		</div>
		
		<div class="page_list" style="display: block;
								      clear: both;
								      text-align: center;
								      font-size: 13px;
								      color: #999;
								      padding-top: 50px;">
			<a href="#" class="pprev" style="background: #fff;
										    border: 1px solid #dedede;
										    font-size: 15px;
										    color: #555;
										    margin-right: 15px;
										    border-radius: 36px;
										    height: 36px;
										    width: 36px;
										    line-height: 34px;
										    display: inline-block;
    										vertical-align: top;"><<</a>
			<a href="#" class="prev" style="background: #fff;
										    border: 1px solid #dedede;
										    font-size: 15px;
										    color: #555;
										    margin-right: 15px;
										    border-radius: 36px;
										    height: 36px;
										    width: 36px;
										    line-height: 34px;
										    display: inline-block;
    										vertical-align: top;"><</a>
			<a href="#" class="num_on" style="background: #333;
										    border: 1px solid #dedede;
										    font-size: 15px;
										    color: #fff;
										    margin-right: 15px;
										    border-radius: 36px;
										    height: 36px;
										    width: 36px;
										    line-height: 34px;
										    display: inline-block;
    										vertical-align: top;">1</a>
			<a href="#" class="num" style="background: #fff;
										    border: 1px solid #dedede;
										    font-size: 15px;
										    color: #555;
										    margin-right: 15px;
										    border-radius: 36px;
										    height: 36px;
										    width: 36px;
										    line-height: 34px;
										    display: inline-block;
    										vertical-align: top;">2</a>
			<a href="#" class="num" style="background: #fff;
										    border: 1px solid #dedede;
										    font-size: 15px;
										    color: #555;
										    margin-right: 15px;
										    border-radius: 36px;
										    height: 36px;
										    width: 36px;
										    line-height: 34px;
										    display: inline-block;
    										vertical-align: top;">3</a>
			<a href="#" class="num" style="background: #fff;
										    border: 1px solid #dedede;
										    font-size: 15px;
										    color: #555;
										    margin-right: 15px;
										    border-radius: 36px;
										    height: 36px;
										    width: 36px;
										    line-height: 34px;
										    display: inline-block;
    										vertical-align: top;">4</a>
			<a href="#" class="num" style="background: #fff;
										    border: 1px solid #dedede;
										    font-size: 15px;
										    color: #555;
										    margin-right: 15px;
										    border-radius: 36px;
										    height: 36px;
										    width: 36px;
										    line-height: 34px;
										    display: inline-block;
    										vertical-align: top;">5</a>
			<a href="#" class="next" style="background: #fff;
										    border: 1px solid #dedede;
										    font-size: 15px;
										    color: #555;
										    margin-right: 15px;
										    border-radius: 36px;
										    height: 36px;
										    width: 36px;
										    line-height: 34px;
										    display: inline-block;
    										vertical-align: top;">></a>
			<a href="#" class="nnext" style="background: #fff;
										    border: 1px solid #dedede;
										    font-size: 15px;
										    color: #555;
										    margin-right: 15px;
										    border-radius: 36px;
										    height: 36px;
										    width: 36px;
										    line-height: 34px;
										    display: inline-block;
    										vertical-align: top;">>></a>

		</div>
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