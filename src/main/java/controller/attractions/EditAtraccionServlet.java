package controller.attractions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoAtraccion;
import services.AtraccionService;

@WebServlet("/atracciones/edit.do")
public class EditAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion atraccion = atraccionService.find(id);
		req.setAttribute("atraccion", atraccion);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		double costo = Double.parseDouble(req.getParameter("costo"));
		int tiempo= Integer.parseInt(req.getParameter("tiempo"));
		int cupo = Integer.parseInt(req.getParameter("cupo"));
		int tipoAtraccion =Integer.parseInt(req.getParameter("tipo_promocion"));
		String descripcion= req.getParameter("descripcion");
		String imagen = req.getParameter("imagen");
		
		  TipoAtraccion tipoAtraccionString= null;
	    	if (tipoAtraccion == 1) {
	    		tipoAtraccionString = TipoAtraccion.AVENTURA;
	     }
	    	if (tipoAtraccion == 2) {
	    		tipoAtraccionString = TipoAtraccion.PAISAJE;
	     }
	    	if (tipoAtraccion == 3) {
	    		tipoAtraccionString= TipoAtraccion.DEGUSTACION;
	     }
		Atraccion atraccion = atraccionService.update(id, nombre, costo, tiempo, cupo,tipoAtraccionString , descripcion , imagen);

		if (atraccion.isValid()) {
			resp.sendRedirect("/turimosTierraMedia/atracciones/index.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/atracciones/edit.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
