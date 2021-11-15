<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="/includes/head.jsp" />
<body>
	<section id="container">
		<!--header start-->
		<jsp:include page="/includes/header.jsp" />
		<!--header end-->
		<!--sidebar start-->
		<jsp:include page="/includes/sidebar.jsp" />
		<!--sidebar end-->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<!-- //market-->


				<section id="slider">
					<!--slider-->
					<div class="container">
						<div class="row">
							<div class="col-sm-10">
								<div id="slider-carousel" class="carousel slide"
									data-ride="carousel">
									<ol class="carousel-indicators">
										<li data-target="#slider-carousel" data-slide-to="0"
											class="active"></li>
										<li data-target="#slider-carousel" data-slide-to="1"></li>
									</ol>

									<div class="carousel-inner">
										<div class="item active">

											<img style="width: 100%;" alt=""
												src="assets/images/banner/g6.jpg">
										</div>
										<div class="item">
											<img style="width: 100%;" alt=""
												src="assets/images/banner/g9.jpg">
										</div>
									</div>

									<a href="#slider-carousel"
										class="left control-carousel hidden-xs" data-slide="prev">
										<i class="fa fa-angle-left"></i>
									</a> <a href="#slider-carousel"
										class="right control-carousel hidden-xs" data-slide="next">
										<i class="fa fa-angle-right"></i>
									</a>
								</div>

							</div>
							<c:if test="${sessionScope.librarianDTO != null}">
							<div class="col-sm-2">
								<div class="market-update-block clr-block-2">
									<div class="col-md-4 market-update-right">
										<i class="glyphicon glyphicon-book"> </i>
									</div>
									<div class="col-md-8 market-update-left">
										<h4>Sách</h4>
										
										<h3>${dashboardDTO.book}</h3>
										
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="market-update-block clr-block-1">
									<div class="col-md-4 market-update-right">
										<i class="glyphicon glyphicon-tags"></i>
									</div>
									<div class="col-md-8 market-update-left">
										<h4>Loại sách</h4>
										<h3>${dashboardDTO.category}</h3>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="market-update-block clr-block-3">
									<div class="col-md-4 market-update-right">
										<i class="glyphicon glyphicon-list-alt"></i>
									</div>
									<div class="col-md-8 market-update-left">
										<h4>Mượn trả</h4>
										<h3>${dashboardDTO.borrow}</h3>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							</c:if>
						</div>
					</div>
				</section>
				<!--/slider-->




			</section>
		</section>
		<!--main content end-->
	</section>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/scripts.js"></script>
</body>
</html>
