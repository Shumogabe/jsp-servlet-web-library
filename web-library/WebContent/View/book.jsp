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
							<table id="listTable"
								class="table table-hover">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Loại sách</th>
										<th scope="col">Sách khoa</th>
										<th scope="col">Ảnh</th>
										<th scope="col">Tên</th>
										<th scope="col">Tác giả</th>
										<th scope="col">Ngôn ngữ</th>
										<th scope="col">NXB</th>
										<th scope="col">Số trang</th>
										<th scope="col">Ngày phát hành</th>
										<th scope="col">Hiện trạng</th>
										<c:if test="${sessionScope.librarianDTO != null}">
											<th scope="col">Thao tác</th>
										</c:if>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listS}" var="x">
										<tr>
											<td>${x.id}</td>
											<td>${x.category_id }</td>
											<td>${x.faculty_id }</td>
											<td><img style="width: 40%" alt="" src="${x.image }"></td>
											<td>${x.name}</td>
											<td>${x.name_writer}</td>
											<td>${x.language}</td>
											<td>${x.publisher}</td>
											<td>${x.num_pages}</td>
											<td>${x.day_print}</td>
											<td>${x.status}</td>
											<c:if test="${sessionScope.librarianDTO != null}">
												<td><a href="edit?id=${x.id}"
													class="btn btn-primary fa fa-wrench"></a> <a
													href="delete?id=${x.id}"
													onclick="return confirm('Bạn có thực sự muốn xóa?');"
													class="btn btn-danger fa fa-trash"> </a></td>
											</c:if>
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
						<h4 class="modal-title">Thêm sách</h4>
						<button type="button" class="close fa fa-times-circle"
							data-dismiss="modal" aria-hidden="true"></button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Tên sách</label> <input name="name" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Loại sách</label> <select name="category_id"
								class="form-select" aria-label="Default select example">
								<c:forEach items="${listS1}" var="x">
									<option value="${x.id}">${x.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Sách khoa</label> <select name="faculty_id"
								class="form-select" aria-label="Default select example">
								<c:forEach items="${listS2}" var="x">
									<option value="${x.id}">${x.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Hình ảnh</label> <input name="image" type="file"
								class="form-control" required accept="image/*">
						</div>
						<div class="form-group">
							<label>Tác giả</label> <input name="name_writer" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Ngôn ngữ</label> <input name="language" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>NXB</label> <input name="publisher" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Số trang</label> <input name="num_pages" type="number"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Ngày phát hành</label> <input name="day_print" type="date"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Hiện trạng</label> <select name="status"
								class="form-select" aria-label="Default select example">
								<option value="1">Còn sách</option>
								<option value="2">Hết sách</option>
							</select>
						</div>
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
