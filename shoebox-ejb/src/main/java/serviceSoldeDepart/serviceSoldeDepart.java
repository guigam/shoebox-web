/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceSoldeDepart;

import ModelesShoebox.Client;
import ModelesShoebox.Entite;
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
    public List<SoldeDepart> remboursementFP() {
        List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<FournisseurProduit> lstFP = new ArrayList<FournisseurProduit>();
         Query query = em.createQuery("from FournisseurProduit f");
       lstFP = query.getResultList();
         for(FournisseurProduit f : lstFP){
            if(f.getSoldeDepart().getMontant() < 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public List<SoldeDepart> remboursementFI() {
        List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<FournisseurIntrant> lstFI = new ArrayList<FournisseurIntrant>();
        Query query = em.createQuery("from FournisseurIntrant f  ");
        lstFI = query.getResultList();
         for(FournisseurIntrant f : lstFI){
            if(f.getSoldeDepart().getMontant() > 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public List<SoldeDepart> remboursementClient() {
         List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<Client> lstClient = new ArrayList<Client>();
        Query query = em.createQuery("from Client c  ");
        lstClient = query.getResultList();
         for(Client f : lstClient){
            if(f.getSoldeDepart().getMontant() > 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public List<SoldeDepart> dettesFP() {
         List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<FournisseurProduit> lstFP = new ArrayList<FournisseurProduit>();
        Query query = em.createQuery("from FournisseurProduit f  ");
        lstFP = query.getResultList();
         for(FournisseurProduit f : lstFP){
            if(f.getSoldeDepart().getMontant() > 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public List<SoldeDepart> dettesFI() {
             List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<FournisseurIntrant> lstFI = new ArrayList<FournisseurIntrant>();
        Query query = em.createQuery("from FournisseurIntrant f  ");
        lstFI = query.getResultList();
         for(FournisseurIntrant f : lstFI){
            if(f.getSoldeDepart().getMontant() < 0 ){
                lstSD.add(f.getSoldeDepart());
            }
         }
        return lstSD;
    }

    @Override
    public List<SoldeDepart> dettesClient() {
        List<SoldeDepart> lstSD = new ArrayList<SoldeDepart>();
        List<Client> lstClient = new ArrayList<Client>();
        Query query = em.createQuery("from Client f  ");
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
