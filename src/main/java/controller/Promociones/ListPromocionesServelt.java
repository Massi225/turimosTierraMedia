package controller.Promociones;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import services.PromocionService;


@WebServlet("/promociones/index.do")
public class ListPromocionesServelt extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = 6713480411872133414L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();

}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Promocion> promociones = promocionService.list();
		req.setAttribute("promociones", promociones);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/promociones/index.jsp");
		dispatcher.forward(req, resp);

	}
}
