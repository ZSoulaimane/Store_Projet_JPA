package Controller;

import java.io.IOException;
import java.sql.SQLException;

import DAO.ArticlesDAO;
import Modele.Articles;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//get article id from catalogue
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			
            HttpSession session = request.getSession();
			
			Articles article = ArticlesDAO.getArticle(id);
			
			// put Article into session
			session.setAttribute("arr",article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Detail.jsp");
        dispatcher.forward(request, response);
	}

}
