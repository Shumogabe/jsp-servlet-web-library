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
										Sửa <b>Thông tin sách</b>
									</h2>
								</div>
								<div class="col-sm-6"></div>
							</div>
						</div>
					</div>
					<div id="editEmployeeModal">
						<div class="modal-dialog">
							<div class="modal-content">
								<form action="edit" method="post">
									<div class="modal-header">
										<h4 class="modal-title"></h4>
										<a href="book" type="button" class="close fa fa-times-circle"
											data-dismiss="modal" aria-hidden="true"></a>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label>ID</label> <input value="${detail.id}" name="id"
												type="text" class="form-control" readonly required>
										</div>
										<div class="form-group">
											<label>Tên sách</label> <input value="${detail.name}"
												name="name" type="text" class="form-control" required>
										</div>
										<div class="form-group">
											<label>Loại sách</label> <select name="category_id"
												class="form-select" aria-label="Default select example">
												<c:forEach items="${listS1}" var="o">
													<option value="${o.id}" ${o.name == detail.category_id ? 'selected="selected"' : ''}>${o.name}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<label>Sách khoa</label> <select name="faculty_id"
												class="form-select" aria-label="Default select example">
												<c:forEach items="${listS2}" var="o">
													<option value="${o.id}" ${o.name == detail.faculty_id ? 'selected="selected"' : ''}>${o.name}</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<label>Hình ảnh</label> <input value="${detail.image}"
												name="image" type="file" class="form-control" required accept="image/*">
										</div>
										<div class="form-group">
											<label>Tác giả</label> <input value="${detail.name_writer}"
												name="name_writer" type="text" class="form-control" required>
										</div>
										<div class="form-group">
											<label>Ngôn ngữ</label> <input value="${detail.language}"
												name="language" type="text" class="form-control" required>
										</div>
										<div class="form-group">
											<label>NXB</label> <input value="${detail.publisher}"
												name="publisher" type="text" class="form-control" required>
										</div>
										<div class="form-group">
											<label>Số trang</label> <input value="${detail.num_pages}"
												name="num_pages" type="number" class="form-control" required>
										</div>
										<div class="form-group">
											<label>Ngày phát hành</label> <input
												value="${detail.day_print}" name="day_print" type="date"
												class="form-control" required>
										</div>
										<div class="form-group">
											<label>Hiện trạng</label> <select name="status"
												class="form-select" aria-label="Default select example">
												<c:if test="${detail.status == 1}">
													<option value="1">Còn sách</option>
													<option value="0">Hết sách</option>
												</c:if>
												<c:if test="${detail.status == 0}">
													<option value="0">Hết sách</option>
													<option value="1">Còn sách</option>
												</c:if>
											</select>
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
