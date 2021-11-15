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
					sách các loại sách trong thư viện</h4>
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
										<th scope="col">Tên</th>
										<c:if test="${sessionScope.librarianDTO != null}">
											<th scope="col">Thao tác</th>
										</c:if>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listS}" var="x">
										<tr>
											<td>${x.id}</td>
											<td>${x.name}</td>
											<c:if test="${sessionScope.librarianDTO != null}">
												<td><a href="editcategory?id=${x.id}"
													class="btn btn-primary fa fa-wrench"></a> <a
													href="deletecategory?id=${x.id}"
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
				<form action="addcategory" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Thêm tên loại sách</h4>
						<button type="button" class="close fa fa-times-circle"
							data-dismiss="modal" aria-hidden="true"></button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Tên loại sách</label> <input name="name" type="text"
								class="form-control" required>
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
