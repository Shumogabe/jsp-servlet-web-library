<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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

				<div class="container">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-6">
									<h2>
										Xem <b>Thông tin mượn sách</b>
									</h2>
								</div>
								<div class="col-sm-6"></div>
							</div>
						</div>
					</div>
					<div class="card-body">
						<table id="listTable" class="table table-hover">
							<thead>
								<tr>
									<th>ID${dashboardDTO.borrow}</th>
									<th>Tên sinh viên mượn</th>
									<th>Lớp</th>
									<th>Ngày mượn</th>
									<th>Ngày trả</th>
									<th>Tên sách</th>
									<th>Số lượng</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td rowspan="${borrowDetailDTO2.quantity}">${listS1.id}</td>
									<td rowspan="${borrowDetailDTO2.quantity}">${listS1.student_id}</td>
									<td rowspan="${borrowDetailDTO2.quantity}">${classDTO.name}</td>
									<td rowspan="${borrowDetailDTO2.quantity}">${listS1.day_borrow}</td>
									<td rowspan="${borrowDetailDTO2.quantity}">${listS1.day_return}</td>
									<c:forEach items="${listS2}" var="x">
										<td>${x.book_id}</td>
										<td>${x.quantity}</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					

				</div>

			</section>
		</section>
		<!--main content end-->
	</section>


	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
	<script src="assets/js/dataTable.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/scripts.js"></script>
</body>
</html>
