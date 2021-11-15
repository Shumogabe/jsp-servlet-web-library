<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="header fixed-top clearfix">
	<!--logo start-->
	<div class="brand">
		<a href="index" class="logo"> Thư viện </a>

	</div>
	<!--logo end-->
	<div class="top-nav clearfix">
		<!--user info start-->
		<ul class="nav pull-right top-menu">
			<c:if test="${sessionScope.librarianDTO != null}">
				<!-- user login dropdown start-->
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#">  <span style="font-size:22px" class="username">${sessionScope.librarianDTO.name}</span> <b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu extended logout">
						
						<li><a href="logout"><i class="fa fa-key"></i> Log
								Out</a></li>
					</ul></li>
				<!-- user login dropdown end -->
			</c:if>
			<c:if test="${sessionScope.librarianDTO == null}">
				<li class="nav-item"><a style="font-size:20px" class="nav-link" href="login">Login</a>
				</li>
			</c:if>
		</ul>
		<!--user info end-->
	</div>
</header>