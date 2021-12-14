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

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>					
				<div class="bg-light p-4 mb-3 rounded">
			<h1>Estas son las Promociones de la Tierra Media</h1>
		</div>		
						
				<c:if test="${user.isAdmin()}">
			<div class="mb-3">
				<a href="/turimosTierraMedia/promociones/create.do" class="btn btn-primary"
					role="button"> <i class="bi bi-plus-lg"></i> Nueva Promocion
				</a>
			</div>			
					</c:if>
				
			<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Promocion</th>
					<th>Costo</th>
					<th>Duracion</th>
					<th>tipoAtraccion</th>
					<th>Acciones</th>
		</tr>
</thead>
<tbody>
   <c:forEach items="${promociones}" var= "promocion">
   
   <tr>
	<td><strong><c:out value="${promocion.nombre}"></c:out></strong><p>descripcion de la promocion</p></td>
	<td><c:out value="${promocion.costo}"></c:out></td>
 <td><c:out value="${promocion.tiempo}"></c:out></td>
<td><c:out value="${promocion.tipoAtraccion}"></c:out></td>


								<td><c:if test="${user.admin}">
								<a href="/turimosTierraMedia/promociones/edit.do?id=${promocion.idPromocion}"
									class="btn btn-light rounded-0" role="button"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="/turimosTierraMedia/promociones/delete.do?id=${promocion.idPromocion}"
									class="btn btn-danger rounded" role="button"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if> 
							<c:choose>
								<c:when
									test="${user.canAffordPromo( promocion) && user.canAttendPromo( promocion) }">
									<a href="/turimosTierraMedia/promociones/buy.do?id=${promocion.idPromocion}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
							</tr>
  </c:forEach>
		</tbody>
		</table>
</main>

</body>
</html>