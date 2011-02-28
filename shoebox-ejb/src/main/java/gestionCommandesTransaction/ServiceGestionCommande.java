/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionCommandesTransaction;

import ModelesParametrage.DefinitionPeriode;
import ModelesShoebox.Commande;
import ModelesShoebox.Cooperative;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionCharge;
import ModelesShoebox.TransactionMagasin;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import parametrageSocodevi.ServiceParamSocoLocal;

/**
 *
 * @author guigam
 */
@Stateless
public class ServiceGestionCommande implements ServiceGestionCommandeTransactionLocal {
    @EJB
    private ServiceParamSocoLocal serviceParamSoco;
 private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();

    
     private void persist(Object objet) {
        em.getTransaction().begin();
        em.persist(objet);
        em.getTransaction().commit();
        em.clear();
    }

    private void merge(Object objet) {
        em.getTransaction().begin();
        em.merge(objet);
        em.getTransaction().commit();
        em.clear();
    }

    private void delete(Object objet) {
        em.getTransaction().begin();
        em.remove(objet);
        em.getTransaction().commit();
        em.clear();
    }



    @Override
    public void newCommnde(Commande commande) {
        persist(commande);
    }

    @Override
    public List<Commande> lstCommande(Cooperative coop, DefinitionPeriode periode) {
        Query query = em.createQuery("from Commande c where c.coop = ?1 and c.defPeriode = ?2 ");
         query.setParameter(1, coop);
         query.setParameter(2, periode);
       return query.getResultList();
    }

    @Override
    public void mergeCommande(Commande commande) {
       merge(commande);
    }

    @Override
    public void deleteCommande(Commande commande) {
       delete(commande);
    }

    @Override
    public List<Commande> lstCommandeByType(String type,Cooperative coop, DefinitionPeriode periode) {
        Query query = em.createQuery("from Commande c where c.type = ?1 and c.coop = ?2 and c.defPeriode = ?3");
        query.setParameter(1, type);
         query.setParameter(2, coop);
         query.setParameter(3, periode);
       return query.getResultList();
    }



    @Override
    public void mergeTransactionMagasin(TransactionMagasin tsx) {
        merge(tsx);
    }

    @Override
    public List<TransactionCharge> lstCharges(Cooperative coop, DefinitionPeriode periode) {
       Query query = em.createQuery("from TransactionCharge t where t.coop = ?2 and t.defPeriode = ?3");
       query.setParameter(2,coop);
       query.setParameter(3,periode);
       return query.getResultList();

    }

    @Override
    public void newTransactionCharge(TransactionCharge transactionCharge) {
     persist(transactionCharge);
    }



  
   
    
   
 
}
