package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Modele.Articles;

public class ArticlesDAO {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("GI4");
	

    public static List<Articles> listProducts() throws SQLException  {

    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List < Articles > product = new ArrayList < > ();
        
        String query = "FROM Articles a";
        
        TypedQuery<Articles> tq = em.createQuery(query, Articles.class);
        
        try {
        	
        	product = tq.getResultList();
                          

        } catch (NoResultException e) {
        	e.printStackTrace();
        }finally {
    	em.close();
    }
  
        return product;
    }
    
    public static Articles getArticle(int id) throws SQLException  {
    	
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        
        String query = "FROM Articles a WHERE a.CodeArticle = :cdAricle";
        
        TypedQuery<Articles> tq = em.createQuery(query, Articles.class);
        tq.setParameter("cdAricle", id);
    	
    	Articles article = null;
    	
        try {
        	
        	article = (Articles) tq.getSingleResult();
        	
        } catch (NoResultException e) {
        	e.printStackTrace();
        }finally {
        	em.close();
        }
        
        return article;
    }
	
}
