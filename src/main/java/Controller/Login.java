package Controller;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.ArticlesDAO;
import DAO.CategoriesDAO;
import DAO.LoginDAO;
import Modele.Articles;
import Modele.Categories;
import Modele.Clients;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet  {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        String password = request.getParameter("password");
         
        //LoginDAO userDao = new LoginDAO();
        
         
        try {
            Clients user = LoginDAO.checkLogin(email, password);
            
            String destPage = null;
             
            if (user != null) {
            	//CategoriesDAO catDAO = new CategoriesDAO();
            	List<Categories> categories = CategoriesDAO.listCategories();
            	List<Articles> articles = ArticlesDAO.listProducts();
            	List<Integer> list = new ArrayList<Integer>();
            	for (Categories testcat : categories) {
					System.out.println(testcat.getRefCat());
				}

            	for (Articles testart : articles) {
					System.out.println(testart.getCodeArticle());
				}
                HttpSession session = request.getSession();
                session.setAttribute("Clients", user);
                session.setAttribute("categories", categories);
                session.setAttribute("articles", articles);
                
                // Add panier attribute to session list<int>
                session.setAttribute("panier", list);
                
                destPage = "./Accueil2.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
                destPage = "./identifiez-vous.jsp";
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
    
}
