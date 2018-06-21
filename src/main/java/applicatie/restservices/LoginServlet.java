package applicatie.restservices;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import applicatie.dao.*;
import applicatie.model.*;

@WebServlet(urlPatterns = "/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		klantDao k = new klantDaoImpl();
		try {
			
			k.findKlantByEmailAndWachtwoord(request.getParameter("email"), request.getParameter("wachtwoord"));
				
		}
		catch (Exception e)  {
			e.printStackTrace();
		}
			
	}
}