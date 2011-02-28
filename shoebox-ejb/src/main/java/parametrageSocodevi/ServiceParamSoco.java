/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrageSocodevi;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.ParamTransaction;
import ModelesParametrage.Permission;
import ModelesParametrage.Utilisateur;
import ModelesParametrage.formatageEntier;
import ModelesShoebox.Cooperative;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
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
    public ParamTransaction rechercheParamCharteCompte(String typetransction,Cooperative coop) {
        Query query = em.createQuery("from ParamTransaction p where p.abrev = ?1 and  p.cooperative = ?2 ");
        query.setParameter(1, typetransction);
         query.setParameter(2, coop);
        return  (ParamTransaction) query.getSingleResult();
    }


    @Override
    public List<ParamTransaction> lstParamTransaction(Cooperative coop) {
       Query query = em.createQuery("from ParamTransaction p where p.cooperative = ?1 ");
        query.setParameter(1, coop);
       return query.getResultList();
    }

    @Override
    public void mergeParamCharteCompteOfortransaction(ParamTransaction paramTsx) {
        merge(paramTsx);
    }

    @Override
    public List<DefinitionPeriode> lstDefinitionPeriode(Cooperative coop) {
       Query query = em.createQuery("from DefinitionPeriode p where  p.cooperative = ?1" );
        query.setParameter(1, coop);
       return query.getResultList();
    }

    @Override
    public void mergeDefPeriode(DefinitionPeriode def) {
        merge(def);
    }

    @Override
    public Utilisateur verifUtilisateur(String username, String password) {
        Query query = em.createQuery("from Utilisateur u where u.username = ?1 and u.password = ?2 ");
        query.setParameter(1, username);
        query.setParameter(2, password);
        return (Utilisateur) query.getSingleResult();
    }

    @Override
    public void newCoop(Cooperative coop) {
     persist(coop);
    }

    @Override
    public DefinitionPeriode currentPeriode(Cooperative coop) {
       for(DefinitionPeriode periode : lstDefinitionPeriode(coop)){
            if(periode.isPeriodeActif()){
                return periode;
            }
       }
       return null;
    }

    @Override
    public formatageEntier formatage(String type) {
       Query query=em.createQuery("from formatageEntier f where f.type = ?1");
       query.setParameter(1, type);
       return (formatageEntier) query.getSingleResult();
    }

    @Override
    public List<Utilisateur> lstUtilisteur(Cooperative coop) {
       Query query = em.createQuery("from Utilisateur u where u.cooperative = ?1");
       query.setParameter(1, coop);
       return query.getResultList();
    }

    @Override
    public void newUtilisateur(Utilisateur utilisateur) {
       persist(utilisateur);
    }

    @Override
    public List<SelectItem> lstItemPermission() {
         List<SelectItem> lstPermission = new ArrayList<SelectItem>();
        for (Permission c : lstPermission()) {
            lstPermission.add(new SelectItem(c, c.getName()));
        }
        return lstPermission;
    }


  

 
   
}
