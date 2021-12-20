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
        .name {
            text-align: center;
        }
        .data {
          display: flex;
          flex-direction: column;
          margin: 10px;
        }
        .data-list {
          display: flex;
          margin: 10px;
          flex-direction: column;
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
        <h1>Usuarios</h1>
      </div>

      <c:if test="${usuario.isAdmin()}">
        <div class="mb-3">
          <a
            href="/turimosTierraMedia/usuarios/create.do"
            class="btn btn-primary"
            role="button"
          >
            <i class="bi bi-plus-lg"></i> Nuevo Usuario
          </a>
        </div>
      </c:if>

      <div class="cards-container">
        <c:forEach items="${usuarios}" var="tmp_user">
        <div class="card">
             <div class="data">
                 <h3 class="name"><c:out value="${tmp_user.nombre}"></c:out></h3>
                  <img src="<c:out value="${tmp_user.imagen}"></c:out>" alt="foto de atraccion" class="img-atraccion"> 
                 <ul class="data-list">
                     <li>Monedas: <c:out value="${tmp_user.monedas}"></c:out></li>
                     <li>Tiempo: <c:out value="${tmp_user.tiempo}"></c:out></li>
                     <li>Rol: 
                         <c:choose>
                            <c:when test="${tmp_user.admin}"> Administrador </c:when>
                            <c:otherwise> jugador </c:otherwise>
                          </c:choose>
                     </li>
                 </ul>
                </div>   
                <div class="botones">
                    <c:if
                    test="${usuario.admin && (!tmp_user.admin || tmp_user.id == usurio.id)}"
                  >
                    
                    <a
                      href="/turimosTierraMedia/usuarios/delete.do?id=${tmp_user.id}"
                      class="btn btn-danger rounded"
                      role="button"
                      ><i class="bi bi-x-circle-fill"></i
                    >Eliminar</a>
                  </c:if>
            </div>
        </div>
    </c:forEach>
</div>


    </main>
  </body>
</html>
