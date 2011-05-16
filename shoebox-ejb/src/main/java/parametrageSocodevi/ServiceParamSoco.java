/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrageSocodevi;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.ParamTransaction;
import ModelesParametrage.Permission;
import ModelesParametrage.TemplateParamTransaction;
import ModelesParametrage.Utilisateur;
import ModelesParametrage.formatageEntier;
import ModelesShoebox.CharteCompte;
import ModelesShoebox.Cooperative;
import enumerationTransaction.EnumTransaction;
import java.util.ArrayList;
import java.util.List;
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
//    @PersistenceContext(unitName="gestion")
//    EntityManager em;

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
    @SuppressWarnings("empty-statement")
    public ParamTransaction rechercheParamCharteCompte(String typetransction, Cooperative coop) {
        Query query = em.createQuery("from ParamTransaction p where p.abrev = ?1 and p.coop = ?2");
        EnumTransaction t = EnumTransaction.valueOf(typetransction);
        query.setParameter(1, t);
        query.setParameter(2, coop);
        return   (ParamTransaction) query.getResultList().get(0);
    }


    @Override
    public List<ParamTransaction> lstParamTransaction(Cooperative coop) {
       Query query = em.createQuery("from ParamTransaction p where p.coop = ?1 ");
       query.setParameter(1, coop);
       return query.getResultList();
    }

    @Override
    public void mergeParamCharteCompteOfortransaction(ParamTransaction paramTsx) {
        merge(paramTsx);
    }

    @Override
    public List<DefinitionPeriode> lstDefinitionPeriode(Cooperative coop) {
       Query query = em.createQuery("from DefinitionPeriode p where p.coop =?1 order by p.id" );
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
        if(!query.getResultList().isEmpty()){
        return (Utilisateur) query.getSingleResult();
        }else{
        return null;
        }
    }

    @Override
    public void newCoop(Cooperative coop) {
     persist(coop);
    }
    @Override
    public void mergeCoop(Cooperative coop) {
     merge(coop);
    }

    @Override
    public DefinitionPeriode currentPeriode(Cooperative coop) {
        DefinitionPeriode Defperiode = new DefinitionPeriode();
       for(DefinitionPeriode periode : lstDefinitionPeriode(coop)){
          if(periode.getPeriode() == lstDefinitionPeriode(coop).size()){
            Defperiode =  periode;
          }
       }
       return Defperiode;
    }

    @Override
    public List<formatageEntier> formatage(Cooperative coop) {
       Query query=em.createQuery("from formatageEntier f where f.coop = ?1");

       query.setParameter(1, coop);
       return query.getResultList();
    }

    @Override
    public List<Utilisateur> lstUtilisteur(Cooperative coop) {
       Query query = em.createQuery("from Utilisateur u where u.cooperative = ?1");
       query.setParameter(1, coop);
       return query.getResultList();
    }

    @Override
    public void newUtilisateur(Utilisateur utilisateur) {
       merge(utilisateur);
    }

    @Override
    public List<SelectItem> lstItemPermission() {
         List<SelectItem> lstPermission = new ArrayList<SelectItem>();
        for (Permission c : lstPermission()) {
            lstPermission.add(new SelectItem(c, c.getName()));
        }
        return lstPermission;
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        merge(utilisateur);
    }

    @Override
    public CharteCompte charteCompteByReference(String reference) {
        Query query = em.createQuery("from CharteCompte c where c.reference = ?1");
        query.setParameter(1, reference);
        return (CharteCompte) query.getSingleResult();
    }



    @Override
    public List<formatageEntier> lstFormatEntier() {
        Query query = em.createQuery("from formatageEntier");
        return query.getResultList();
    }

    @Override
    public List<Utilisateur> lstAllUtilisteur() {
         Query query = em.createQuery("from Utilisateur u ");
       return query.getResultList();
    }

    @Override
    public void newformatage(formatageEntier f) {
        persist(f);
    }

    @Override
    public List<TemplateParamTransaction> lstTemplateParamTransaction() {
       Query query = em.createQuery("from TemplateParamTransaction");
       return query.getResultList();
    }



  

 
   
}
