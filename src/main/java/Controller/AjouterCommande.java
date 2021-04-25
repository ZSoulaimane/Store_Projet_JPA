package Controller;

import java.io.IOException;
import java.util.List;

import DAO.PanierDAO;
import Modele.Clients;
import Modele.Commandes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AjouterCommande
 */
@WebServlet("/AjouterCommande")
public class AjouterCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		// get user from session
		Clients user = (Clients) session.getAttribute("Clients");
		
		// Insert commande in commande table
		PanierDAO.AjouteCommande(session);
		
		// get last comande id
		Commandes lastCMDId = PanierDAO.GetLastCmd();
		
		System.out.println(lastCMDId.getNumCommande());
		
		// get articles from session "panier"
		List<Integer> list = (List<Integer>)session.getAttribute("panier");
		
		// Insert articles into lignesCommandes
		PanierDAO.AjouteCommandeP(lastCMDId,session);
		
		list.clear();
		session.setAttribute("panier", list);
		
		String destPage = "./Catalogue.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
