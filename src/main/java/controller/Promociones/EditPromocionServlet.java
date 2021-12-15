package controller.Promociones;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Attraction;
import model.Promocion;
import services.AttractionService;
import services.PromocionService;

@WebServlet("/Promociones/edit.do")

public class EditPromocionServlet extends HttpServlet{
	

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

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/promociones/edit.jsp");
			dispatcher.forward(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Integer id = Integer.parseInt(req.getParameter("id"));
			String nombre = req.getParameter("nambre");
			Double cost = Double.parseDouble(req.getParameter("c"));
			
			Double duration = Double.parseDouble(req.getParameter("duration"));
			Integer capacity = Integer.parseInt(req.getParameter("capacity"));
			
			
			Promocion promocion = promocionService.update(id, name, cost, duration, capacity, description , image);

			if (attraction.isValid()) {
				resp.sendRedirect("/turimosTierraMedia/attractions/index.do");
			} else {
				req.setAttribute("promocion", promocion);

				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/views/attractions/edit.jsp");
				dispatcher.forward(req, resp);
			}
		}
	}

}
