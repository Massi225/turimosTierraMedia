package controller.Promociones;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PromocionService;


@WebServlet("/promociones/delete.do")
public class DeletePromocionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5075717420040368672L;
		private PromocionService promocionService;

		@Override
		public void init() throws ServletException {
			super.init();
			this.promocionService = new PromocionService();
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Integer id = Integer.parseInt(req.getParameter("id"));

			promocionService.delete(id);

			resp.sendRedirect("/turimosTierraMedia/attractions/index.do");
		}


	}

}
