package controller.session;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Usuario;
import services.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 8308079314140233763L;
	private LoginService loginService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
	}
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String nombre	 = req.getParameter("nombre");
    	String contrasenia= req.getParameter("contrasenia");
    	
    	Usuario usuario = loginService.login(nombre, contrasenia);
    	
    	if (!usuario.isNull()) {
    		req.getSession().setAttribute("usuario", usuario);
    		resp.sendRedirect("index.jsp");    		
       	} else {
    		req.setAttribute("flash", "Nombre de usuario o contraseña incorrectos");
    		
    		RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/login.jsp");
      		    dispatcher.forward(req, resp);
    	}
    }
}

// a traves de los datos que paso  nombre y contraseña , usamos el metodo login para q me devuelva un usuari  , si este no es nulo ,requierola sesion y
//establezo una variable temporal con el nombre usuario y direcciono al index.
