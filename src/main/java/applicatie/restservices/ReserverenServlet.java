package applicatie.restservices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import applicatie.dao.*;
import applicatie.model.*;

@WebServlet(urlPatterns = "/ReservernServlet.do")
public class ReserverenServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reservering r;
		reserveringDao rDao = new reserveringDaoImpl();
		int reservering_Id = 2;
		String datum = request.getParameter("Datum");
		String tijd = request.getParameter("Tijd");
		String tafel_str = request.getParameter("tafel");
		int klant_Id = 1;
		
		int tafel = Integer.parseInt(tafel_str);
		
		r = new reservering(reservering_Id, datum, tijd, tafel, klant_Id);
		
		rDao.insertReservering(r);
	}
}
