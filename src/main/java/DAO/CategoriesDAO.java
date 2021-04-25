package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Modele.Categories;


public  class CategoriesDAO {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("GI4");
	
	
    public static List<Categories> listCategories() throws SQLException  {
    	// using try-with-resources to avoid closing resources (boiler plate code)
    	//OuvreBase();
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        List <Categories> cat = new ArrayList < > ();
        
        String query = "FROM Categories c";
		
		TypedQuery<Categories> tq = em.createQuery(query, Categories.class);
        // Step 1: Establishing a Connection
        try {
        	
        	cat = tq.getResultList();

        } catch (NoResultException e) {
        	e.printStackTrace();
        }finally {
        	em.close();
        }
       
        return cat;
    }
    

}
