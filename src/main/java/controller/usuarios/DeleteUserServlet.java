package controller.usuarios;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AtraccionService;

import services.UsuarioService;
@WebServlet("/usuarios/delete.do")
public class DeleteUserServlet extends HttpServlet {
	
	

	private static final long serialVersionUID = -5672024431368913082L;
		private UsuarioService usuarioService;

		@Override
		public void init() throws ServletException {
			super.init();
			this.usuarioService = new UsuarioService();
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Integer id = Integer.parseInt(req.getParameter("id"));

			usuarioService.delete(id);

			resp.sendRedirect("/turimosTierraMedia/usuarios/index.do");
		}


	}

