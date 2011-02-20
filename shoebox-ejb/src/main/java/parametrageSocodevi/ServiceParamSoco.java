/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrageSocodevi;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.ParamTransaction;
import ModelesParametrage.Permission;
import ModelesParametrage.Utilisateur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author guigam
 */
@Stateless
public class ServiceParamSoco implements ServiceParamSocoLocal {

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
    public List<Permission> lstPermission() {
           Query query = em.createQuery("from Permission ");

        return query.getResultList();
    }

    @Override
    public ParamTransaction rechercheParamCharteCompte(String typetransction) {
        Query query = em.createQuery("from ParamTransaction p where p.abrev = ?1");
        query.setParameter(1, typetransction);
        return  (ParamTransaction) query.getSingleResult();
    }


    @Override
    public List<ParamTransaction> lstParamTransaction() {
       Query query = em.createQuery("from ParamTransaction");
       return query.getResultList();
    }

    @Override
    public void mergeParamCharteCompteOfortransaction(ParamTransaction paramTsx) {
        merge(paramTsx);
    }

    @Override
    public List<DefinitionPeriode> lstDefinitionPeriode() {
       Query query = em.createQuery("from DefinitionPeriode");
       return query.getResultList();
    }

    @Override
    public void mergeDefPeriode(DefinitionPeriode def) {
        merge(def);
    }

    @Override
    public Utilisateur verifUtilisateur(String username, String password) {
        Query query = em.createQuery("from Utilisateur u where u.username = ?1 and u.password = ?2");
        query.setParameter(1, username);
        query.setParameter(2, password);
        return (Utilisateur) query.getSingleResult();
    }

  

 
   
}
