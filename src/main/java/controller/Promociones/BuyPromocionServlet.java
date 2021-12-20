package controller.Promociones;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.commons.DAOFactory;
import services.BuyAtraccionService;
import services.BuyPromocionService;


	
@WebServlet("/promociones/buy.do")

public class BuyPromocionServlet extends HttpServlet {

private static final long serialVersionUID = -1234471958913646512L;

private BuyPromocionService buyPromocionService;
   
   @Override
	public void init() throws ServletException {
		super.init();
		this.buyPromocionService = new BuyPromocionService();
	}
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer promocionId = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Map<String, String> errors = buyPromocionService.buy(usuario.getId(), promocionId);
		
		Usuario usuario2 = DAOFactory.getUsuarioDAO().find(usuario.getId());
		req.getSession().setAttribute("usuario", usuario2);
		
		if (errors.isEmpty()) {
			req.setAttribute("success", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/promociones/index.do");
		dispatcher.forward(req, resp);
	}
}

