package controller.Promociones;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;

import model.Promocion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

import services.PromocionService;

@WebServlet("/promociones/edit.do")

public class EditPromocionServlet extends HttpServlet {

	private static final long serialVersionUID = 664732392314813290L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Promocion promocion = promocionService.find(id);
		req.setAttribute("promocion", promocion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promociones/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Integer id = Integer.parseInt(req.getParameter("id"));
			String nombre = req.getParameter("nombre");
	
    	String tipo_promocion= req.getParameter("tipo_promocion");
		   double bonificacion = Double.parseDouble(req.getParameter("bonificacion"));
		   String atraccion1 = req.getParameter("Atraccion1");
		   String atraccion2 = req.getParameter("Atraccion2");
		   
		   String atraccionGratis = req.getParameter("PromocioncionGratis");
		   
			java.util.List<Atraccion> atracciones = new ArrayList<>();
		   AtraccionDAO atr = DAOFactory.getAtraccionesDAO();
		  
		   
		   if(atraccion1!=null) {
		   atracciones.add(atr.find1(atraccion1));
		   }
		   if(atraccion2!=null) {
			   atracciones.add(atr.find1(atraccion2));
		   if(atraccionGratis!=null) {
		   atracciones.add(atr.find1(atraccionGratis));
		   }
			
			Promocion promocion = promocionService.update(id, nombre,  tipo_promocion,bonificacion,atracciones);

			if (promocion.isValid()) {
				resp.sendRedirect("/turimosTierraMedia/promociones/index.do");
			} else {
				req.setAttribute("promocion", promocion);

				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/promociones/edit.jsp");
				dispatcher.forward(req, resp);
			}
		}
	}
}