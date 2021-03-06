<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="nombre" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre"
		required value="${atraccion.nombre}">
</div>
<div class="mb-3">
	<label for="costo"
		class='col-form-label ${atraccion.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
	<input class="form-control" type="number" id="costo" name="costo"
		required value="${atraccion.costo}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("costo")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="tiempo"
		class='col-form-label ${atraccion.errors.get("tiempo") != null ? "is-invalid" : "" }'>Duracion:</label>
	<input class="form-control" type="number" id="tiempo" name="tiempo"
		required value="${atraccion.tiempo}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("tiempo")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="cupo"
		class='col-form-label ${atraccion.errors.get("cupo") != null ? "is-invalid" : "" }'>Cupo:</label>
	<input class="form-control" type="number" id="cupo" name="cupo"
		required value="${atraccion.cupo}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("cupo")}'></c:out>
	</div>
	<div class="mb-3">
	<label for="descripcion" class="col-form-label">Descripcion:</label> <input
		type="text" class="form-control" id="descripcion" name="descripcion"
		required value="${atraccion.descripcion}">
</div>

<div class="mb-3">
	<label for="tipo_atraccion" class="col-form-label">Tipo de Atraccion:  ( 1: Aventura , 2: Paisaje , 3: Desgustacion)</label> <input
		type="text" class="form-control" id="tipo_atraccion" name="tipo_atraccion"
		required value="${atraccion.tipo_atraccion}">
		</div>
<div class="mb-3">
	<label for="imagen" class="col-form-label">Url Imagen</label> <input
		type="text" class="form-control" id="imagen" name="imagen"
		required value="${atraccion.imagen}">
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
