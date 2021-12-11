<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
}
* {
  box-sizing: border-box;
}
.bg-img {
  /* La imagen usada */
  background-image: url("https://www.rionegro.com.ar/wp-content/uploads/2019/06/Hielo-Azul.jpg?w=920&h=517&resize=920,517");
  min-height: 380px;
  /* Imagen centrada */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}
/* Estilos del container */
.container {
  position: absolute;
  right: 0;
  margin: 20px;
  max-width: 300px;
  padding: 16px;
  background-color: white;
}
/* tamaño de los campos de ingreso */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}
input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}
/* Estilo del boton de ingresar */
.btn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
.btn:hover {
  opacity: 1;
}
</style>
</head>
<body>

<h2>Turismo Tierra Media</h2>
<div class="bg-img">

  <form action="login" class="container" method="post" >
    <h1>Bienvenido!</h1>

    <label for="usuario"><b>Usuario</b></label>
    <input type="text" class="form-control" placeholder="Usuario" name="username" required>

    <label for="psw"><b>Contraseña</b></label>
    <input type="password" class="form-control" placeholder="Contraseña" name="password" required>

    <button type="submit" class="btn">Ingresar</button>
  </form>
 
</div>

</body>
</html>