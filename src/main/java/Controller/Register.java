package Controller;

import java.io.IOException;

import DAO.Registering;
import Modele.Clients;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet  {
	  private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest  request, HttpServletResponse  response)throws ServletException, IOException {

	        String Prenom = request.getParameter("first_name");
	        String Nom = request.getParameter("last_name");
	        String Email = request.getParameter("Email");
	        String Adresse = request.getParameter("Adresse");
	        String MotPasse = request.getParameter("password");
	        String Ville = request.getParameter("Ville");
	        int CodePostal = Integer.parseInt(request.getParameter("CodePostal"));
	        int Tel = Integer.parseInt(request.getParameter("Tel"));
	        
	        Clients client = new Clients();

	        client.setPrenom(Prenom);
	        client.setNom(Nom);
	        client.setEmail(Email);
	        client.setMotPasse(MotPasse);
	        client.setAdresse(Adresse);
	        client.setCodePostal(CodePostal);
	        client.setTel(Tel);
	        client.setVille(Ville);
	        
	        Registering registerDao = new Registering();
	        
	        String userRegistered = registerDao.registerUser(client);
	        
	        if(userRegistered.equals("SUCCESS"))
	        {
	           request.getRequestDispatcher("/identifiez-vous.jsp").forward(request, response);
	        }
	        else
	        {
	           request.setAttribute("errMessage", userRegistered);
	           request.getRequestDispatcher("/index.jsp").forward(request, response);
	        }
	    }
	   
}
