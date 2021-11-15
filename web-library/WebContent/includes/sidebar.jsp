<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside>
	<div id="sidebar" class="nav-collapse">
		<!-- sidebar menu start-->
		<div class="leftside-navigation">
			<ul class="sidebar-menu" id="nav-accordion">
				<li><a class="active" href="index"> <i class="fa fa-home"></i>
						<span>Trang chủ</span>
				</a></li>
				<li><a class="active" href="book"> <i class="fa fa-book"></i>
						<span>Sách</span>
				</a></li>
				<li><a class="active" href="category"> <i
						class="fa fa-file"></i> <span>Loại sách</span>
				</a></li>
				<c:if test="${sessionScope.librarianDTO != null}">
				<li><a class="active" href="borrow"> <i
						class="fa fa-tags"></i> <span>Mượn trả sách</span>
				</a></li>
				</c:if>
			</ul>
		</div>
		<!-- sidebar menu end-->
	</div>
</aside>