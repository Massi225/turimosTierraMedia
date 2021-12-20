package controller.attractions;

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

@WebServlet("/atracciones/buy.do")
public class BuyAtraccionServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private BuyAtraccionService buyAtraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.buyAtraccionService = new BuyAtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer atraccionId = Integer.parseInt(req.getParameter("id"));
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Map<String, String> errors = buyAtraccionService.buy(usuario.getId(), atraccionId);
		
		Usuario usuario2 = DAOFactory.getUsuarioDAO().find(usuario.getId());
		req.getSession().setAttribute("usuario", usuario2);
		
		if (errors.isEmpty()) {
			req.setAttribute("success", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/atracciones/index.do");
		dispatcher.forward(req, resp);
	}
}


