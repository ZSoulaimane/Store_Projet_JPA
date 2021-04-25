package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Modele.Clients;

public class Registering {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("GI4");
	
	public String registerUser(Clients client){         
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		String res = "";
        try
        {
        	
        	et = em.getTransaction();
        	et.begin();

        	em.persist(client);
        	et.commit();
        }
        catch(Exception e)
        {
        	if(et !=null) {
        		et.rollback();
        	}
           res =  e.toString();
        }finally {
        	em.close();
        }
        return res;  // On failure, send a message from here.
    }

}
