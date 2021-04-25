package DAO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.Collections;
import java.util.HashSet;

import Modele.Articles;
import Modele.Clients;
import Modele.Commandes;
import Modele.Lignescommandes;
import jakarta.servlet.http.HttpSession;

public class PanierDAO {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("GI4");
	
	static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
	static Date date = new Date(System.currentTimeMillis());
	
	public static void AjouteCommande(HttpSession session) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		
		try {
			
			et = em.getTransaction();
			et.begin();
			Clients user = new Clients();
			user = (Clients) session.getAttribute("Clients");
			Commandes cmd = new Commandes(user, formatter.format(date));
			
			em.persist(cmd);
			et.commit();
        }
        catch(Exception e)
        {
        	if(et != null) {
        		et.rollback();
        	}
           e.printStackTrace();
        }finally {
        	em.close();
        }
    }
	
	public static Commandes GetLastCmd() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Commandes cmd = null;
		try {
			
			String query = "FROM Commandes c ORDER BY c.NumCommande DESC";
			TypedQuery<Commandes> tq = em.createQuery(query , Commandes.class);
			cmd = tq.setMaxResults(1).getSingleResult();
			return cmd;
        }
        catch(NoResultException e)
        {
           e.printStackTrace();
        }
		return cmd;       
    }
	
	public static void AjouteCommandeP(Commandes cmd,HttpSession session) {
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		
		try {
			et = em.getTransaction();
			et.begin();
			
			List<Lignescommandes> commandes = new ArrayList<Lignescommandes>();

			List<Integer> list = new ArrayList<Integer>();
			list = (List<Integer>)session.getAttribute("panier");

            HashSet<Integer> hSetNumbers = new HashSet(list);
            for(int i : hSetNumbers) {
            	Articles art = ArticlesDAO.getArticle(i);
            	Lignescommandes lcmd = new Lignescommandes(cmd, art,Collections.frequency(list,i));
            	em.persist(lcmd);
            	em.flush();
            }
            et.commit();
            
        }
        catch(Exception e)
        {
        	if(et!=null) {
        		et.rollback();
        	}
           e.printStackTrace();
        }finally {
        	em.clear();
        }
    }
}