package controller.usuarios;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoAtraccion;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/usuarios/create.do")
public class CreateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/usuarios/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String contrasenia = req.getParameter("contrasenia");
		double monedas = Double.parseDouble(req.getParameter("monedas"));
		int tiempo = Integer.parseInt(req.getParameter("tiempo"));
		TipoAtraccion tipoPreferencia =TipoAtraccion.valueOf(req.getParameter("preferencia"));
		int admin = Integer.parseInt(req.getParameter("admin"));
		String imagen = req.getParameter("imagen");
		
		boolean admin2= false;
		if(admin ==1) {
			admin2= true;
		}
		
		

		Usuario tmp_user = usuarioService.create(nombre, monedas, tiempo, tipoPreferencia, contrasenia, admin2, imagen);
		
		if (tmp_user.isValid()) {
			resp.sendRedirect("/turimosTierraMedia/usuario/index.do");
		} else {
			req.setAttribute("tmp_user", tmp_user);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/usuario/create.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
