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
        height: 500px;
        border: 1px solid grey;
      }
      .img-atraccion {
        width: 90%;
        height: auto;
        max-height: 200px;
        margin: 10px auto;
      }
      .data {
        display: flex;
        flex-direction: column;
        margin: 10px;
      }
      .data-list {
        display: flex;
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
        <h1>Estas son las atracciones de la Tierra Media</h1>
      </div>

      <c:if test="${usuario.isAdmin()}">
        <div class="mb-3">
          <a
            href="/turimosTierraMedia/atracciones/create.do"
            class="btn btn-primary"
            role="button"
          >
            <i class="bi bi-plus-lg"></i> Nueva Atraccion
          </a>
        </div>
      </c:if>
      <div class="cards-container">
        <c:forEach items="${atracciones}" var="atraccion">
          <div class="card">
            <img src="<c:out value='${atraccion.imagen}'></c:out>" alt="foto de atraccion" class="img-atraccion">
            <div class="data">
              <h3 class="name"><c:out value="${atraccion.nombre}"></c:out></h3>
              <p class="desc">
                Descripcion: <c:out value="${atraccion.descripcion}"></c:out>
              </p>
              <ul class="data-list">
                <li>Precio: <c:out value="${atraccion.costo}"></c:out></li>
                <li>Duracion:<c:out value="${atraccion.tiempo}"></c:out></li>
                <li>Capacidad:<c:out value="${atraccion.cupo}"></c:out></li>
                 </ul>
            </div>
            <div class="botones">
              <c:if test="${usuario.admin}">
                <a
                  href="/turimosTierraMedia/atracciones/edit.do?id=${atraccion.id}"
                  class="btn btn-secondary rounded"
                  role="button"
                  ><i class="bi bi-pencil-fill">Editar</i></a
                >
                <a
                  href="/turimosTierraMedia/atracciones/delete.do?id=${atraccion.id}"
                  class="btn btn-danger rounded"
                  role="button"
                  ><i class="bi bi-x-circle-fill">Eliminar</i></a
                >
              </c:if>
               <c:choose>
                <c:when
                  test="${usuario.canAfford(atraccion) && usuario.canAttend(atraccion) && atraccion.canHost(1)}"
                >
                  <a
                    href="/turimosTierraMedia/atracciones/buy.do?id=${atraccion.id}"
                    class="btn btn-success rounded"
                    role="button"
                    >Comprar</a
                  >
                </c:when>
                <c:otherwise>
                  <a
                    href="#"
                    class="btn btn-secondary rounded disabled"
                    role="button"
                    >No se puede comprar</a
                  >
                </c:otherwise>
              </c:choose>
            </div>
          </div>
        </c:forEach>
      </div>
    </main>
  </body>
</html>
