package Controller;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demolocal
 */
@WebServlet("/Demolocal")
public class Demolocal extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] planguage = request.getParameter("language").split("_");
		String language = planguage[0];
		String country = planguage[1];
		Locale locale = new Locale(language,country);
		request.setAttribute("country", locale.getDisplayCountry());
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("Resources.content", locale);
		request.setAttribute("f1", resourceBundle.getString("m1"));
		request.setAttribute("f2", resourceBundle.getString("m2"));
		
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

}
