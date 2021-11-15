<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="/includes/head.jsp" />
<body>
	<div class="log-w3">
		<div class="w3layouts-main">
			<h2>Đăng nhập</h2>
			<form action="login" method="post">
				<input type="username" class="ggg" name="username"
					placeholder="USERNAME" required=""> <input type="password"
					class="ggg" name="password" placeholder="PASSWORD" required="">
				<div class="clearfix"></div>
				<c:if test="${message != null}">
					<div class="alert alert-danger" role="alert">${message}</div>
				</c:if>
				<input type="submit" value="Sign In" name="login">
			</form>
		</div>
	</div>
	<jsp:include page="/includes/script.jsp" />
</body>
</html>