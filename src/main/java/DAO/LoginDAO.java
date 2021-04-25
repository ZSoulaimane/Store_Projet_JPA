package DAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Modele.Clients;

public class LoginDAO {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("GI4");
	

	public static Clients checkLogin(String email, String password) throws SQLException ,ClassNotFoundException {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Clients user = null;
		
		String query = "FROM Clients c WHERE c.Email = :cliEmail";
		
		TypedQuery tq = em.createQuery(query, Clients.class);
		tq.setParameter("cliEmail", email);
		
		try { 
				user = (Clients) tq.getSingleResult();

			}
		catch(NoResultException e) {
			e.printStackTrace();
    	   }finally {
    		   em.close();
    	   }
		
		
		return user;
		}
	}
	