/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceSoldeDepart;

import ModelesParametrage.DefinitionPeriode;
import ModelesShoebox.Client;
import ModelesShoebox.Cooperative;
import ModelesShoebox.FournisseurIntrant;
import ModelesShoebox.FournisseurProduit;
import ModelesShoebox.SoldeDepart;
import java.util.ArrayList;
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
public class serviceSoldeDepart implements serviceSoldeDepartLocal {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();

    @Override
    public List<SoldeDepart> remboursementFP(Cooperative coop) {
        List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<FournisseurProduit> lstFP = new ArrayList<FournisseurProduit>();
         Query query = em.createQuery("from FournisseurProduit f where f.currentuser.cooperative = ?1 ");
         query.setParameter(1, coop);
       lstFP = query.getResultList();
         for(FournisseurProduit f : lstFP){
            if(f.getSoldeDepart().getMontant() < 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public List<SoldeDepart> remboursementFI(Cooperative coop) {
        List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<FournisseurIntrant> lstFI = new ArrayList<FournisseurIntrant>();
        Query query = em.createQuery("from FournisseurIntrant f where f.currentuser.cooperative = ?1 ");
        query.setParameter(1, coop);
        lstFI = query.getResultList();
         for(FournisseurIntrant f : lstFI){
            if(f.getSoldeDepart().getMontant() > 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public List<SoldeDepart> remboursementClient(Cooperative coop) {
         List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<Client> lstClient = new ArrayList<Client>();
        Query query = em.createQuery("from Client c where c.currentuser.cooperative = ?1 ");
        query.setParameter(1, coop);
        lstClient = query.getResultList();
         for(Client f : lstClient){
            if(f.getSoldeDepart().getMontant() > 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public List<SoldeDepart> dettesFP(Cooperative coop) {
         List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<FournisseurProduit> lstFP = new ArrayList<FournisseurProduit>();
        Query query = em.createQuery("from FournisseurProduit f where f.currentuser.cooperative = ?1 ");
        query.setParameter(1, coop);
        lstFP = query.getResultList();
         for(FournisseurProduit f : lstFP){
            if(f.getSoldeDepart().getMontant() > 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public List<SoldeDepart> dettesFI(Cooperative coop) {
             List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<FournisseurIntrant> lstFI = new ArrayList<FournisseurIntrant>();
        Query query = em.createQuery("from FournisseurIntrant f where f.currentuser.cooperative = ?1");
        query.setParameter(1, coop);
        lstFI = query.getResultList();
         for(FournisseurIntrant f : lstFI){
            if(f.getSoldeDepart().getMontant() < 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public List<SoldeDepart> dettesClient(Cooperative coop) {
        List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<Client> lstClient = new ArrayList<Client>();
        Query query = em.createQuery("from Client c where c.currentuser.cooperative = ?1");
        query.setParameter(1, coop);
        lstClient = query.getResultList();
         for(Client f : lstClient){
            if(f.getSoldeDepart().getMontant() < 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public void mergeSolde(SoldeDepart sd) {
            em.getTransaction().begin();
            em.merge(sd);
            em.getTransaction().commit();
    }
}
