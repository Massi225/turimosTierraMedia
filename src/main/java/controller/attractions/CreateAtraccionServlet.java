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

@WebServlet("/atracciones/create.do")
public class CreateAtraccionServlet extends HttpServlet {


	
	private static final long serialVersionUID = 6308211162133898374L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/create.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		int tiempo = Integer.parseInt(req.getParameter("tiempo"));
		Integer cupo= Integer.parseInt(req.getParameter("cupo"));
		String descripcion = req.getParameter("descripcion");
		int tipoAtraccion = Integer.parseInt(req.getParameter("tipo_atraccion"));
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


		Atraccion atraccion = atraccionService.create(nombre, costo, tiempo, cupo ,tipoAtraccionString, descripcion, imagen);
		
		if (atraccion.isValid()) {
			resp.sendRedirect("/turimosTierraMedia/atracciones/index.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/atracciones/create.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
