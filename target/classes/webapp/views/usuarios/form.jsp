<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="nombre" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre"
		required value="${tmp_user.nombre}">
</div>
<div class="mb-3">
	<label for="monedas"
		class='col-form-label ${tmp_user.errors.get("monedas") != null ? "is-invalid" : "" }'>Monedas:</label>
	<input class="form-control" type="number" id="monedas" name="monedas"
		required value="${tmp_user.monedas}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("monedas")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="tiempo"
		class='col-form-label ${tmp_user.errors.get("tiempo") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="tiempo" name="tiempo"
		required value="${tmp_user.tiempo}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("tiempo")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="contrasenia" class="col-form-label">Contrasenia:</label> <input
		type="text" class="form-control" id="contrasenia" name="contrasenia"
		required value="${tmp_user.contrasenia}">
</div>
<div class="mb-3">
	<label for="preferencia" class="col-form-label">Preferencia ( 1 = Aventura , 2= Paisaje 3= Desgustacion):</label> <input
		type="number" class="form-control" id="preferencia"name="preferencia"
		required value="${tmp_user.preferencia}">
</div>
<div class="mb-3">
	<label for="imagen" class="col-form-label">imagen:</label> <input
		type="text" class="form-control" id="imagen" name="imagen"
		required value="${tmp_user.imagen}">
</div>
<div class="mb-3">
	<label for="admin" class="col-form-label">Administrador ( 1 = si // 2 = no):</label> <input
		type="number" class="form-control" id="admin" name="admin"
		required value="${tmp_user.admin}">
		</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
