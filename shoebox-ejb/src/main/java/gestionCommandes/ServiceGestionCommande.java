/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionCommandes;

import ModelesShoebox.Commande;
import ModelesShoebox.Compte;
import ModelesShoebox.TransactionCaisse;
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
public class ServiceGestionCommande implements ServiceGestionCommandeLocal {
    @EJB
    private ServiceParamSocoLocal serviceParamSoco;
 private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();

    
     private void persist(Object objet) {
        em.getTransaction().begin();
        em.persist(objet);
        em.getTransaction().commit();
    }

    private void merge(Object objet) {
        em.getTransaction().begin();
        em.merge(objet);
        em.getTransaction().commit();
    }

    private void delete(Object objet) {
        em.getTransaction().begin();
        em.remove(objet);
        em.getTransaction().commit();
    }



    @Override
    public void newCommnde(Commande commande) {
        persist(commande);
    }

    @Override
    public List<Commande> lstCommande() {
        Query query = em.createQuery("from Commande");
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
    public List<Commande> lstCommandeByType(String type) {
        Query query = em.createQuery("from Commande c where c.type = ?1");
        query.setParameter(1, type);
       return query.getResultList();
    }

    @Override
    public void newtransaction(TransactionCaisse tsxCaisse, Commande commande) {
            tsxCaisse.setCharteCompte(serviceParamSoco.rechercheParamCharteCompte(commande.getType()));
            tsxCaisse.setTypeTransaction(commande.getType());
            tsxCaisse.setCommande(commande);
            persist(tsxCaisse);
    }

  
   
    
   
 
}
