<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${atraccion != null && !atraccion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al actualizar la Promocion.</p>
			</div>
		</c:if>

		<form action="/turimosTierraMedia/promociones/edit.do" method="post">
			<input type="hidden" name="id" value="${atraccion.id}">
			<jsp:include page="/views/promociones/form.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>
