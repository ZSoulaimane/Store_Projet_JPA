package Controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AddPanier
 */
@WebServlet("/AddPanier")
public class AddPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Ajouter article au panier
		
		
		// get article from request => getParameter
		int id = Integer.parseInt(request.getParameter("id"));	
		
		// Get panier from session
		List<Integer> list = (List<Integer>)session.getAttribute("panier");
		
		// ajouter objet article au panier
		list.add(id);
		
		// modifier attrubute panier de la session
		session.setAttribute("panier", list);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("./Catalogue.jsp");
        dispatcher.forward(request, response);
	}

}
