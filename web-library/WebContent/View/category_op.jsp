<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="/includes/head.jsp"/>
<body>
	<section id="container">
		<!--header start-->
		<jsp:include page="/includes/header.jsp"/>
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
										Chỉnh sửa <b>Loại sách</b>
									</h2>
								</div>
								<div class="col-sm-6"></div>
							</div>
						</div>
					</div>
					<div id="editEmployeeModal">
						<div class="modal-dialog">
							<div class="modal-content">
								<form action="editcategory" method="post">
									<div class="modal-header">
										<h4 class="modal-title"></h4>
										<a href="category" type="button" class="close fa fa-times-circle"
											data-dismiss="modal" aria-hidden="true"></a>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label>ID</label> <input value="${detail.id}" name="id"
												type="text" class="form-control" readonly required>
										</div>
										<div class="form-group">
											<label>Tên loại sách</label> <input value="${detail.name}"
												name="name" type="text" class="form-control" required>
										</div>
										


									</div>
									<div class="modal-footer">
										<input type="submit" class="btn btn-success" value="Edit">
									</div>
								</form>
							</div>
						</div>
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
