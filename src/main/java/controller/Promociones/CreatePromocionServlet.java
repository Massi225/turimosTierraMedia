package controller.Promociones;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Attraction;
import services.AttractionService;
import services.PromocionService;

public class CreatePromocionServlet {
	@WebServlet("/promociones/create.do")
	public class CreateAttractionServlet extends HttpServlet {
		
		private static final long serialVersionUID = 4096046133636185470L;
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
			String name = req.getParameter("nombre");
			Double cost = Double.parseDouble(req.getParameter("cost"));
			Double duration = Double.parseDouble(req.getParameter("duration"));
			Integer capacity = Integer.parseInt(req.getParameter("capacity"));

			Promocion promocion = PromocionService.create(name, cost, duration, capacity);
			
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
