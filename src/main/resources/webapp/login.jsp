<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <style>
      body,
      html {
        height: 100%;
        font-family: Arial, Helvetica, sans-serif;
        margin: 0;
      }
      * {
        box-sizing: border-box;
      }
      .bg-img {
        width: 100%;
        height: 100vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        text-align: center;
        background-image: url('https://images.unsplash.com/photo-1506466010722-395aa2bef877?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1930&q=80');
        background-size: cover;
      }
      .form-title {
        margin: 25px 0 20px 0;
        font-size: 1.5rem;
        font-weight: 400;
      }
      .form-container {
        position: relative;
        background-color: #d3f8e2;
        border-radius: 15px;
        height: 400px;
        width: 400px;
        margin: auto;
      }
      .form-login {
        display: flex;
        flex-direction: column;
        margin: 18px;
      }
      .form-label {
        font-size: 1rem;
        text-align: left;
        margin-top: 25px;
        margin-bottom: 10px;
      }

      .form-control {
        height: 30px;
        border-radius: 15px;
        border: 1px solid #e5e5e5;
        padding: 10px;
      }
      .form-control:focus {
        background-color: #ddd;
        outline: none;
      }
      /* Estilo del boton de ingresar */
      .btn {
        position: absolute;
        bottom: 40px;
        left: 15%;
        width: 70%;
        border: none;
        background-color: #4ea8de;
        color: white;
        padding: 10px;
        border-radius: 15px;
        font-size: 1rem;
        font-weight: 600;
      }

      @media screen and (max-width: 720px) {
        .form-container {
          max-width: 90%;
        }
      }
    </style>
  </head>
  <body>
    <div class="bg-img">
      <h1>Turismo Tierra Media</h1>
      <div class="form-container">
        <form action="login" class="form-login" method="post">
          <h1 class="form-title">Bienvenido!</h1>

          <label for="usuario" class="form-label"><b>Usuario</b></label>
          <input
            type="text"
            class="form-control"
            placeholder="Usuario"
            name="nombre"
            required
          />

          <label for="psw" class="form-label"><b>Contraseña</b></label>
          <input
            type="password"
            class="form-control"
            placeholder="Contraseña"
            name="contrasenia"
            required
          />

          <button type="submit" class="btn">Ingresar</button>
        </form>
      </div>
    </div>
  </body>
</html>
