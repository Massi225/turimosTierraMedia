<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="/partials/head.jsp"></jsp:include>
    <style>
      .cards-container {
        display: flex;
        flex-wrap: wrap;
      }

      .card {
        display: flex;
        position: relative;
        flex-direction: column;
        width: 400px;
        height: 300px;
        border: 1px solid grey;
      }
      .data {
        display: flex;
        flex-direction: column;
        margin: 10px;
      }
      .data-list {
        display: flex;
        flex-direction: column;
        margin: 10px;
        justify-content: space-evenly;
      }
      .botones {
        position: absolute;
        bottom: 20px;
        display: flex;
        justify-content: space-evenly;
        flex-wrap: wrap;
        width: 400px;
      }
      .botones a {
        margin: 10px;
      }
    </style>
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
          <a
            href="/turimosTierraMedia/promociones/create.do"
            class="btn btn-primary"
            role="button"
          >
            <i class="bi bi-plus-lg"></i> Nueva Promocion
          </a>
        </div>
      </c:if>
      <div class="cards-container">
        <c:forEach items="${promociones}" var="promocion">
          <div class="card">
            <div class="data">
              <h3 class="name"><c:out value="${promocion.nombre}"></c:out></h3>
              <p class="desc">Descripcion:</p>

              <ul class="data-list">
                <li>
                  Precio:
                  
                  <c:out value="${promocion.costo}"></c:out>
                 
                </li>
                <li>Duracion: <c:out value="${promocion.tiempo}"></c:out></li>
                <li>
                  Tipo de Atracciones:
                  <c:out value="${promocion.tipoAtraccion}"></c:out>
                </li>
              
              </ul>
            </div>
            <div class="botones">
              <c:if test="${user.admin}">
                <a
                  href="/turimosTierraMedia/promociones/edit.do?id=${promocion.idPromocion}"
                  class="btn btn-secondary rounded"
                  role="button"
                  ><i class="bi bi-pencil-fill"></i>Editar</a
                >
                <a
                  href="/turimosTierraMedia/promociones/delete.do?id=${promocion.idPromocion}"
                  class="btn btn-danger rounded"
                  role="button"
                  ><i class="bi bi-x-circle-fill"></i>Eliminar</a
                >
              </c:if>
             
							<c:choose>
								<c:when
									test="${user.canAffordPromo(promocion) && user.canAttendPromo(promocion) }">
									<a href="/turimosTierraMedia/promociones/buy.do?id=${promocion.id}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose>
            </div>
          </div>
        </c:forEach>
      </div>
    </main>
  </body>
</html>

