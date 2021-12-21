<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-md mb-4" style="background-color: #023e8a">
  <div class="container">
    <a
      class="navbar-brand"
      href="/turimosTierraMedia/index.jsp"
      style="color: #fff"
      >Turismo en la Tierra Media</a
    >
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarCollapse"
      aria-controls="navbarCollapse"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav me-auto mb-2 mb-md-0" style="margin-left: 30px">
       <li class="nav-item">
          <a
            style="color: #fff"
            class="nav-link active"
            aria-current="page"
            href="/turimosTierraMedia/atracciones/index.do"
            >Atracciones</a
          >
        </li>
         <li class="nav-item">
          <a
            style="color: #fff"
            class="nav-link active"
            aria-current="page"
            href="/turimosTierraMedia/promociones/index.do"
            >Promociones</a
          >
        </li>
        <c:if test="${usuario.isAdmin()}">
          <li class="nav-item">
            <a
              style="color: #fff"
              class="nav-link active"
              aria-current="page"
              href="/turimosTierraMedia/usuarios/index.do"
              >Usuarios</a
            >
          </li>
        </c:if>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a
            style="color: #fff"
            class="nav-link dropdown-toggle"
            href="#"
            id="navbarDropdown"
            role="button"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            <c:out value="${usuario.nombre}"></c:out>
          </a>
          <ul
            class="dropdown-menu dropdown-menu-end"
            aria-labelledby="navbarDropdown"
          >
            <li>
              <a class="dropdown-item disabled" style="color: black">
                <i title="monedas" style="color: gold" class="bi bi-coin"></i>
                <c:out value="${usuario.monedas}"></c:out>
              </a>
            </li>
            <li>
              <a class="dropdown-item disabled" style="color: black">
                <i
                  title="tiempo"
                  style="color: blue"
                  class="bi bi-clock-fill"
                ></i>
                <c:out value="${usuario.tiempo}h"></c:out>
              </a>
            </li>
            <li><hr class="dropdown-divider" /></li>
            <li>
              <a href="/turimosTierraMedia/logout" class="dropdown-item"
                >Salir</a
              >
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<c:if test="${success != null}">
  <div class="alert alert-success">
    <p>
      <c:out value="${success}" />
    </p>
  </div>
</c:if>

