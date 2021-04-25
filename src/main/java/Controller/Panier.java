package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class Panier
 */
@WebServlet("/Panier")
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Panier() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Get panier from session
		HttpSession session = request.getSession();
		
		List<Integer> list = (List<Integer>)session.getAttribute("panier");
		HashSet<Integer> hSetNumbers = new HashSet(list);
		
		List<Articles> tabArt = new ArrayList<Articles>();
		List<Integer> tabQuant = new ArrayList<Integer>();
		
		for(int indx : hSetNumbers) {
			try {
				tabArt.add(ArticlesDAO.getArticle(indx));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			tabQuant.add(Collections.frequency(list,indx));
		}
		
		session.setAttribute("panierArticles", tabArt);
		session.setAttribute("panierQuant", tabQuant);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./Panier.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
