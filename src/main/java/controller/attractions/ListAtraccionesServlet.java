package controller.attractions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;

@WebServlet("/atracciones/index.do")
public class ListAtraccionesServlet extends HttpServlet implements Servlet {

	
	private static final long serialVersionUID = -7206816986157416012L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Atraccion> atracciones = new ArrayList<>();
			atracciones= atraccionService.list();
		req.setAttribute("atracciones", atracciones);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/atracciones/index.jsp");
		dispatcher.forward(req, resp);

	}

}
