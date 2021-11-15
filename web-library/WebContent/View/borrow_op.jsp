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
											Sửa <b>Thông tin mượn sách</b>
										</h2>
									</div>
									<div class="col-sm-6"></div>
								</div>
							</div>
					</div>
					<form action="editborrow" method="post">
						<div class="card-body">
							<table id="listTable" class="table table-hover">
								<thead>
									<tr>
										<th>ID${dashboardDTO.borrow}</th>
										<th>Tên sinh viên mượn</th>
										<th>Ngày mượn</th>
										<th>Ngày trả</th>
										<th>Tên sách</th>
										<th>Số lượng</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td rowspan="${borrowDetailDTO2.quantity}">${listS1.id}</td>
										<td rowspan="${borrowDetailDTO2.quantity}"><input
											value="${listS1.student_id}" name="student_id" type="text"
											class="form-control" required></td>
										<td rowspan="${borrowDetailDTO2.quantity}"><input
											value="${listS1.day_borrow}" name="day_borrow" type="text"
											class="form-control" required></td>
										<td rowspan="${borrowDetailDTO2.quantity}"><input
											value="${listS1.day_return}" name="day_return" type="text"
											class="form-control" required></td>
										<c:forEach items="${listS2}" var="x">
											<td><input value="${x.book_id}" name="book_id"
												type="text" class="form-control" required></td>
											<td><input value="${x.quantity}" name="quantity"
												type="text" class="form-control" required></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-success" value="Edit">
						</div>
					</form>

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
