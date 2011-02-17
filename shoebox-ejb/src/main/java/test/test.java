/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import ModelesShoebox.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author guigamehdi
 */
@Stateless
public class test implements testLocal {
  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	private EntityManager em = emf.createEntityManager();


    @Override
    public List<Client> lstClient() {
Query query = em.createQuery("from Client");
return query.getResultList();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
