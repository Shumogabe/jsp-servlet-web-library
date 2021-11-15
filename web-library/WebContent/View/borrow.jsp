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
				<h4 class="page-title" style="text-transform: uppercase;">Danh
					sách các cuốn sách trong thư viện</h4>
				<div class="col-md-12">
					<div class="card">
						<div class="card-header ">
							<div class="text-right">
								<c:if test="${sessionScope.librarianDTO != null}">
									<a href="#addEmployeeModal" data-toggle="modal"
										class="btn btn-success"> Thêm </a>
								</c:if>
							</div>
						</div>
						<div class="card-body">
							<table id="listTable" class="table table-hover">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Tên sinh viên mượn</th>
										<th scope="col">Ngày mượn</th>
										<th scope="col">Ngày trả</th>
										<th scope="col">Thao tác</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listS}" var="x">
										<tr>
											<td>${x.id}</td>
											<td>${x.student_id }</td>
											<td>${x.day_borrow}</td>
											<td>${x.day_return}</td>
											<td><a href="viewborrow?id=${x.id}"
												class="btn btn-primary fa fa-eye"></a> <a
												href="editborrow?id=${x.id}"
												class="btn btn-primary fa fa-wrench"></a> <a
												href="delete?id=${x.id}"
												onclick="return confirm('Bạn có thực sự muốn xóa?');"
												class="btn btn-danger fa fa-trash"> </a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</section>
		</section>
		<!--main content end-->
	</section>
	<!-- Modal Add -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="add" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Thêm phiếu mượn sách</h4>
						<button type="button" class="close fa fa-times-circle"
							data-dismiss="modal" aria-hidden="true"></button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Tên sinh viên</label> <input name="name" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Lớp</label> <select name="category_id" class="form-select"
								aria-label="Default select example">
								<c:forEach items="${classDTOs}" var="x">
									<option value="${x.id}">${x.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Ngày mượn</label> <input name="day_print" type="date"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Ngày trả</label> <input name="day_print" type="date"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Tên sách</label> <select name="faculty_id"
								class="form-select" aria-label="Default select example">
								<c:forEach items="${bookDTOs}" var="x">
									<option value="${x.id}">${x.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Số lượng</label> <input name="image" type="file"
								class="form-control" required accept="image/*">
						</div>

						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel"> <input type="submit"
								class="btn btn-success" value="Thêm">
						</div>
				</form>
			</div>
		</div>
	</div>


	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
	<script src="assets/js/dataTable.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/scripts.js"></script>
</body>
</html>
