<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="nombre" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre"
		required value="${promocion.nombre}">
</div>
<div class="mb-3">
	<label for="costo"
		class='col-form-label ${promocion.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
	<input class="form-control" type="number" id="costo" name="costo"
		required value="${promocion.costo}"></input>
	<div class="invalid-feedback">
		<c:out value='${promocion.errors.get("costo")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="duracion"
		class='col-form-label ${promocion.errors.get("duracion") != null ? "is-invalid" : "" }'>Duracion:</label>
	<input class="form-control" type="number" id="duracion" name="duracion"
		required value="${promocion.duracion}"></input>
	<div class="invalid-feedback">
		<c:out value='${promocion.errors.get("duracion")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="cupos"
		class='col-form-label ${promocion.errors.get("cupos") != null ? "is-invalid" : "" }'>Cupo:</label>
	<input class="form-control" type="number" id="cupos" name="cupos"
		required value="${promocion.cupos}"></input>
	<div class="invalid-feedback">
		<c:out value='${promocion.errors.get("cupo")}'></c:out>
	</div>
</div>


<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
iv></div>