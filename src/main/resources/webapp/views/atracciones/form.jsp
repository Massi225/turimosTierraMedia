<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="name" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre"
		required value="${atraccion.nombre}">
</div>
<div class="mb-3">
	<label for="cost"
		class='col-form-label ${atraccion.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
	<input class="form-control" type="number" id="costo" name="costo"
		required value="${atraccion.costo}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("costo")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="duration"
		class='col-form-label ${atraccion.errors.get("tiempo") != null ? "is-invalid" : "" }'>Duracion:</label>
	<input class="form-control" type="number" id="tiempo" name="tiempo"
		required value="${atraccion.tiempo}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("tiempo")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="capacity"
		class='col-form-label ${atraccion.errors.get("cupos") != null ? "is-invalid" : "" }'>Cupo:</label>
	<input class="form-control" type="number" id="cupos" name="cupos"
		required value="${atraccion.cupos}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("cupos")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="description" class="col-form-label">Descripcion:</label> <input
		type="text" class="form-control" id="descripcion" name="descripcion"
		required value="${atraccion.descripcion}">
</div>
<div class="mb-3">
	<label for="image" class="col-form-label">Url Imagen</label> <input
		type="text" class="form-control" id="imagen" name="imagen"
		required value="${atraccion.imagen}">
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
