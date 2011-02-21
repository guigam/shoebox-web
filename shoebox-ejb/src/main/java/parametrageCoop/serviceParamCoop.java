/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrageCoop;

import ModelesShoebox.CharteCompte;
import ModelesShoebox.Client;
import ModelesShoebox.Commande;
import ModelesShoebox.Compte;
import ModelesShoebox.Cooperative;
import ModelesShoebox.FournisseurIntrant;
import ModelesShoebox.FournisseurProduit;
import ModelesShoebox.Magasin;
import ModelesShoebox.Produit;
import ModelesShoebox.TransactionMagasin;
import java.lang.Object;
import java.util.ArrayList;
import java.util.LinkedList;
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
public class serviceParamCoop implements serviceParamCoopLocal {

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
    public void newClient(Client client) {
        persist(client);
    }

    @Override
    public void newFP(FournisseurProduit fp) {
        persist(fp);
    }

    @Override
    public void newFI(FournisseurIntrant fi) {
        persist(fi);
    }

    @Override
    public void newCoop(Cooperative coop) {
        persist(coop);
    }

    @Override
    public void newCommande(Commande commande) {
        persist(commande);
    }

    @Override
    public void newProduit(Produit produit) {
        persist(produit);
    }

    @Override
    public void newCharteCompte(CharteCompte charteCompte) {
        persist(charteCompte);
    }

    @Override
    public void newMagasin(Magasin magasin) {
        persist(magasin);
    }

    @Override
    public void updateClient(Client client) {
        merge(client);
    }

    @Override
    public void updateFP(FournisseurProduit fp) {
        merge(fp);
    }

    @Override
    public void updateFI(FournisseurIntrant fi) {
        merge(fi);
    }

    @Override
    public void updateCoop(Cooperative coop) {
        merge(coop);
    }

    @Override
    public void updateCommande(Commande commande) {
        merge(commande);
    }

    @Override
    public void updateProduit(Produit produit) {
        merge(produit);
    }

    @Override
    public void updateCharteCompte(CharteCompte charteCompte) {
        merge(charteCompte);
    }

    @Override
    public void updateMagasin(Magasin magasin) {
        merge(magasin);
    }

    @Override
    public void deleteClient(Client client) {
        delete(client);
    }

    @Override
    public void deleteFP(FournisseurProduit fp) {
        delete(fp);
    }

    @Override
    public void deleteFI(FournisseurIntrant fi) {
        delete(fi);
    }

    @Override
    public void deleteCoop(Cooperative coop) {
        delete(coop);
    }

    @Override
    public void deleteCommande(Commande commande) {
        delete(commande);
    }

    @Override
    public void deleteProduit(Produit produit) {
        delete(produit);
    }

    @Override
    public void deleteCharteCompte(CharteCompte charteCompte) {
        delete(charteCompte);
    }

    @Override
    public void deleteMagasin(Magasin magasin) {
        delete(magasin);
    }

    @Override
    public List<Client> lstClient(Cooperative coop) {
        Query query = em.createQuery("from Client c where c.currentuser.cooperative = ?1");
         query.setParameter(1, coop);
        return query.getResultList();

    }

    @Override
    public List<FournisseurProduit> lstFP(Cooperative coop) {
        Query query = em.createQuery("from FournisseurProduit f where f.currentuser.cooperative = ?1");
        query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<FournisseurIntrant> lstFI(Cooperative coop) {
        Query query = em.createQuery("from FournisseurIntrant f where f.currentuser.cooperative = ?1");
         query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<Produit> lstproduit(Cooperative coop) {
        Query query = em.createQuery("from Produit p where p.categorie = ?1 and p.currentuser.cooperative = ?2");
        query.setParameter(1, "produitCoop");
         query.setParameter(2, coop);
        return query.getResultList();
    }

    @Override
    public List<Magasin> lstMagasin(Cooperative coop) {
        Query query = em.createQuery("from Magasin m where m.currentuser.cooperative = ?1 ");
         query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<Produit> lstproduitIntrant(Cooperative coop) {
        Query query = em.createQuery("from Produit p where p.categorie = ?1 and p.currentuser.cooperative = ?2");
        query.setParameter(1, "intrant");
         query.setParameter(2, coop);
        return query.getResultList();
    }

    @Override
    public List<CharteCompte> lstcharteCompte(Cooperative coop) {
        Query query = em.createQuery("from CharteCompte c where c.currentuser.cooperative = ?1");
         query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<SelectItem> lstItemProduit(Cooperative coop) {
        List<SelectItem> lstproduitItem = new ArrayList<SelectItem>();
        for (Produit p : lstproduit(coop)) {
            lstproduitItem.add(new SelectItem(p, p.getName()));
        }
        return lstproduitItem;
    }

    @Override
    public List<SelectItem> lstItemFP(Cooperative coop) {
        List<SelectItem> lstFPItem = new ArrayList<SelectItem>();
        for (FournisseurProduit p : lstFP(coop)) {
            lstFPItem.add(new SelectItem(p, p.getName()));
        }
        return lstFPItem;
    }

    @Override
    public List<SelectItem> lstItemFI(Cooperative coop) {
        List<SelectItem> lstFIItem = new ArrayList<SelectItem>();
        for (FournisseurIntrant p : lstFI(coop)) {
            lstFIItem.add(new SelectItem(p, p.getName()));
        }
        return lstFIItem;
    }

    @Override
    public List<SelectItem> lstItemProduitIntrant(Cooperative coop) {
        List<SelectItem> lstproduitItemIntrant = new ArrayList<SelectItem>();
        for (Produit p : lstproduitIntrant(coop)) {
            lstproduitItemIntrant.add(new SelectItem(p, p.getName()));
        }
        return lstproduitItemIntrant;
    }

    @Override
    public List<SelectItem> lstItemMagasin(Cooperative coop) {
        List<SelectItem> listMagasin = new ArrayList<SelectItem>();
        for (Magasin p : lstMagasin(coop)) {
            listMagasin.add(new SelectItem(p, p.getName()));
        }
        return listMagasin;
    }

    @Override
    public List<SelectItem> lstitemClient(Cooperative coop) {
        List<SelectItem> listClient = new ArrayList<SelectItem>();
        for (Client c : lstClient(coop)) {
            listClient.add(new SelectItem(c, c.getName()));
        }
        return listClient;
    }

    @Override
    public List<Object[]> rechercheStockProduit(Produit produit, int grade, Cooperative coop) {
        List<Object[]> lstObject = new LinkedList<Object[]>();
        if (!rechercehEntreeProduit(produit, grade, coop).isEmpty() && rechercehSortisProduit(produit, grade,coop).isEmpty()) {
            for (Object[] t : rechercehEntreeProduit(produit, grade, coop)) {
                Object[] obj = new Object[3];
                obj[0] = (Magasin) (t[0]);
                obj[1] = (Produit) (t[1]);
                obj[2] = new Long((Long) t[3]);
                lstObject.add(obj);
            }
        } else {
            for (Object[] t : rechercehEntreeProduit(produit, grade,coop)) {
                for (Object[] o : rechercehSortisProduit(produit, grade, coop)) {
                    if (t[0].equals(o[0]) && t[1].equals(o[1]) && t[2].equals(o[2])) {
                        Object[] obj = new Object[3];
                        obj[0] = (Magasin) (t[0]);
                        obj[1] = (Produit) (t[1]);
                        obj[2] = new Long((Long) t[3]).longValue() - new Long((Long) o[3]).longValue();
                        lstObject.add(obj);
                    }
                }
            }
        }
        return lstObject;
    }

    private List<Object[]> rechercehEntreeProduit(Produit produit, int grade, Cooperative coop) {
        if (produit != null && grade != 0) {
            Query q = em.createQuery("SELECT  x.magasin, x.produit, x.grade  , SUM(x.quantite) FROM TransactionMagasin x where x.m_commande.type = ?3 and x.produit = ?1 AND x.grade = ?2 and x.currentuser.cooperative = ?4 group by x.magasin");
            q.setParameter(1, produit);
            q.setParameter(2, grade);
            q.setParameter(3, "EP");
            q.setParameter(4, coop);
            return (List<Object[]>) q.getResultList();
        }
        return null;
    }

    private List<Object[]> rechercehSortisProduit(Produit produit, int grade, Cooperative coop) {
        if (produit != null && grade != 0) {
            Query q = em.createQuery("SELECT  x.magasin, x.produit,x.grade  , SUM(x.quantite) FROM TransactionMagasin x where x.m_commande.type = ?3 and x.produit = ?1 AND x.grade = ?2 x.currentuser.cooperative = ?4  group by x.magasin");
            q.setParameter(1, produit);
            q.setParameter(2, grade);
            q.setParameter(3, "SP");
            q.setParameter(4, coop);
            return (List<Object[]>) q.getResultList();
        }
        return null;
    }

    @Override
    public List<Object[]> rechercheSommeEntreeProduit(Produit produit, int grade) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TransactionMagasin> test() {
        Query q = em.createQuery("from TransactionMagasin t where t.m_commande = 1 ");
        return q.getResultList();
    }

    @Override
    public List<SelectItem> lstitemCompte(Cooperative coop) {
        List<SelectItem> listConpte = new ArrayList<SelectItem>();
        for (Compte c : lstCompte(coop)) {
            listConpte.add(new SelectItem(c, c.getNomCompte()));
        }
        return listConpte;
    }

    @Override
    public List<Compte> lstCompte(Cooperative coop) {
        Query query = em.createQuery("from Compte c where c.currentuser.cooperative = ?1");
        query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<SelectItem> lstItemCharteCompte(Cooperative coop) {
        List<SelectItem> listCharteCompte = new ArrayList<SelectItem>();
        for (CharteCompte c : lstcharteCompte(coop)) {
            listCharteCompte.add(new SelectItem(c, c.getNom()));
        }
        return listCharteCompte;
    }
}
