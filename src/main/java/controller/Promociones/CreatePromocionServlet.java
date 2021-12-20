package controller.Promociones;

import java.io.IOException;

import java.util.ArrayList;

import com.sun.tools.javac.util.List;

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
import services.AtraccionService;
import services.PromocionService;

@WebServlet("/promociones/create.do")

	
	public class CreatePromocionServlet extends HttpServlet {
		
	
	private static final long serialVersionUID = -2710510087675437661L;
		private PromocionService promocionService;

		@Override
		public void init() throws ServletException {
			super.init();
			this.promocionService = new PromocionService();
		}

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/promociones/create.jsp");
			dispatcher.forward(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String nombre = req.getParameter("nombre");
			//double costo = Double.parseDouble(req.getParameter("atraccion1"));
    		String tipo_promocion= req.getParameter("tipo_promocion");
		   double bonificacion = Double.parseDouble(req.getParameter("bonificacion"));
		   String atraccion1 = req.getParameter("Atraccion1");
		   String atraccion2 = req.getParameter("Atraccion2");
		   
		   String atraccionGratis = req.getParameter("PromocioncionGratis");
		   
			java.util.List<Atraccion> attracciones = new ArrayList<>();
		   AtraccionDAO atr = DAOFactory.getAtraccionesDAO();
		  
		   
		   if(atraccion1!=null) {
		   attracciones.add(atr.find1(atraccion1));
		   }
		   if(atraccion2!=null) {
			   attracciones.add(atr.find1(atraccion2));
		   if(atraccionGratis!=null) {
		   attracciones.add(atr.find1(atraccionGratis));
		   }
		   

			Promocion promocion = promocionService.create(nombre,  tipo_promocion,bonificacion,attracciones );
			
			if (promocion.isValid()) {
				resp.sendRedirect("/turimosTierraMedia/promocion/index.do");
			} else {
				req.setAttribute("promocion", promocion);

				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/promociones/create.jsp");
				dispatcher.forward(req, resp);
			}

		}

	

}
	}

