/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrageCoop;

import ModelesParametrage.DefinitionPeriode;
import ModelesShoebox.CategorieCharge;
import ModelesShoebox.CharteCompte;
import ModelesShoebox.Client;
import ModelesShoebox.Commande;
import ModelesShoebox.Compte;
import ModelesShoebox.Cooperative;
import ModelesShoebox.FournisseurIntrant;
import ModelesShoebox.FournisseurProduit;
import ModelesShoebox.Magasin;
import ModelesShoebox.Produit;
import ModelesShoebox.TransactionCaisse;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Date;
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
        Query query = em.createQuery("from Client c where c.coop = ?1");
        query.setParameter(1, coop);
        return query.getResultList();

    }

    @Override
    public List<FournisseurProduit> lstFP(Cooperative coop) {
        Query query = em.createQuery("from FournisseurProduit f where f.coop= ?1");
        query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<FournisseurIntrant> lstFI(Cooperative coop) {
        Query query = em.createQuery("from FournisseurIntrant f where f.coop = ?1");
        query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<Produit> lstproduit(Cooperative coop) {
        Query query = em.createQuery("from Produit p where p.categorie = ?1 and p.coop = ?2");
        query.setParameter(1, "produitCoop");
        query.setParameter(2, coop);
        return query.getResultList();
    }

    @Override
    public List<Magasin> lstMagasin(Cooperative coop) {
        Query query = em.createQuery("from Magasin m where m.coop = ?1 ");
        query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<Produit> lstproduitIntrant(Cooperative coop) {
        Query query = em.createQuery("from Produit p where p.categorie = ?1 and p.coop = ?2");
        query.setParameter(1, "intrant");
        query.setParameter(2, coop);
        return query.getResultList();
    }

    @Override
    public List<CharteCompte> lstcharteCompte() {
        Query query = em.createQuery("from CharteCompte c ");
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
    public List<Object[]> rechercheStockProduitIntrant(Produit produit, Cooperative coop) {
        List<Object[]> lstObject = new LinkedList<Object[]>();
        if (!rechercehEntreeProduitIntrant(produit, coop).isEmpty() && rechercehSortisProduitIntrant(produit, coop).isEmpty()) {
            for (Object[] t : rechercehEntreeProduitIntrant(produit, coop)) {
                Object[] obj = new Object[3];
                obj[0] = (Magasin) (t[0]);
                obj[1] = (Produit) (t[1]);
                obj[2] = new Long((Long) t[2]);
                lstObject.add(obj);
            }
        } else {
            for (Object[] t : rechercehEntreeProduitIntrant(produit, coop)) {
                for (Object[] o : rechercehSortisProduitIntrant(produit, coop)) {
                    if (t[0].equals(o[0]) && t[1].equals(o[1])) {
                        Object[] obj = new Object[3];
                        obj[0] = (Magasin) (t[0]);
                        obj[1] = (Produit) (t[1]);
                        obj[2] = new Long((Long) t[2]).longValue() - new Long((Long) o[2]).longValue();
                        lstObject.add(obj);
                    }
                }
            }
        }
        return lstObject;
    }

    public List<Object[]> rechercheStockProduit(Produit produit, int grade, Cooperative coop) {
        List<Object[]> lstObject = new LinkedList<Object[]>();
        if (!rechercehEntreeProduit(produit, grade, coop).isEmpty() && rechercehSortisProduit(produit, grade, coop).isEmpty()) {
            for (Object[] t : rechercehEntreeProduit(produit, grade, coop)) {
                Object[] obj = new Object[3];
                obj[0] = (Magasin) (t[0]);
                obj[1] = (Produit) (t[1]);
                obj[2] = new Long((Long) t[3]);
                lstObject.add(obj);
            }
        } else {
            for (Object[] t : rechercehEntreeProduit(produit, grade, coop)) {
                for (Object[] o : rechercehSortisProduit(produit, grade, coop)) {
                    if (t[1].equals(o[1]) && t[2].equals(o[2])) {
                        if(t[0].equals(o[0])){//le produit chercher est dans le meme magasin
                        Object[] obj = new Object[3];
                        obj[0] = (Magasin) (t[0]);
                        obj[1] = (Produit) (t[1]);
                        obj[2] = new Long((Long) t[3]).longValue() - new Long((Long) o[3]).longValue();
                        lstObject.add(obj);
                        }else{ //le produit existe uniquement dans ce magasin
                        Object[] obj = new Object[3];
                        obj[0] = (Magasin) (t[0]);
                        obj[1] = (Produit) (t[1]);
                        obj[2] = new Long((Long) t[3]).longValue();
                        lstObject.add(obj);

                        }
                    }
                }
            }
        }
        return lstObject;
    }

    private List<Object[]> rechercehEntreeProduit(Produit produit, int grade, Cooperative coop) {
        if (produit != null && grade != 0) {
            if (produit.getType().equals("Principal")) {
                Query q = em.createQuery("SELECT  x.magasin, x.produit, x.grade  , SUM(x.quantite) FROM TransactionMagasin x where x.m_commande.type = ?3  and x.produit = ?1 AND x.grade = ?2 and x.coop = ?4 group by x.magasin");
                q.setParameter(1, produit);
                q.setParameter(2, grade);
                q.setParameter(3, "EPP");
                q.setParameter(4, coop);
                return (List<Object[]>) q.getResultList();
            } else {
                Query q = em.createQuery("SELECT  x.magasin, x.produit, x.grade  , SUM(x.quantite) FROM TransactionMagasin x where x.m_commande.type = ?3  and x.produit = ?1 AND x.grade = ?2 and x.coop = ?4 group by x.magasin");
                q.setParameter(1, produit);
                q.setParameter(2, grade);
                q.setParameter(3, "EPS");
                q.setParameter(4, coop);
                return (List<Object[]>) q.getResultList();
            }

        }
        return null;
    }

    private List<Object[]> rechercehSortisProduit(Produit produit, int grade, Cooperative coop) {
        if (produit != null && grade != 0) {
            Query q = em.createQuery("SELECT  x.magasin, x.produit,x.grade  , SUM(x.quantite) FROM TransactionMagasin x where x.m_commande.type in (?3,?5) and x.produit = ?1 AND x.grade = ?2 and x.coop = ?4  group by x.magasin");
            q.setParameter(1, produit);
            q.setParameter(2, grade);
            q.setParameter(3, "SPP");
            q.setParameter(5, "SPS");
            q.setParameter(4, coop);
            return (List<Object[]>) q.getResultList();
        }
        return null;
    }

    private List<Object[]> rechercehEntreeProduitIntrant(Produit produit, Cooperative coop) {
        if (produit != null) {
            Query q = em.createQuery("SELECT  x.magasin, x.produit , SUM(x.quantite) FROM TransactionMagasin x where x.m_commande.type = ?3 and x.produit = ?1 and x.coop = ?4 group by x.magasin");
            q.setParameter(1, produit);
            q.setParameter(3, "EPI");
            q.setParameter(4, coop);
            return (List<Object[]>) q.getResultList();
        }
        return null;
    }

    private List<Object[]> rechercehSortisProduitIntrant(Produit produit, Cooperative coop) {
        if (produit != null) {
            Query q = em.createQuery("SELECT  x.magasin, x.produit  , SUM(x.quantite) FROM TransactionMagasin x where x.m_commande.type = ?3 and x.produit = ?1  and x.coop = ?4  group by x.magasin");
            q.setParameter(1, produit);
            q.setParameter(3, "SI");
            q.setParameter(4, coop);
            return (List<Object[]>) q.getResultList();
        }
        return null;
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
        Query query = em.createQuery("from Compte c where c.coop = ?1");
        query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<SelectItem> lstItemCharteCompte() {
        List<SelectItem> listCharteCompte = new ArrayList<SelectItem>();
        for (CharteCompte c : lstcharteCompte()) {
            listCharteCompte.add(new SelectItem(c, c.getNom()));
        }
        return listCharteCompte;
    }

    @Override
    public List<CategorieCharge> lstCategorieChargeByType(Cooperative coop, String type) {
        Query query = em.createQuery("from CategorieCharge f where f.cooperative = ?1 and f.type = ?2");
        query.setParameter(1, coop);
        query.setParameter(2, type);
        return query.getResultList();
    }
    @Override
    public List<CategorieCharge> lstCategorieCharge(Cooperative coop) {
        Query query = em.createQuery("from CategorieCharge f where f.cooperative = ?1 and f.type = ?2");
        query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<SelectItem> lstItemCategorieCharge(Cooperative coop) {
        List<SelectItem> lstCategItem = new ArrayList<SelectItem>();
        for (CategorieCharge c : lstCategorieCharge(coop)) {
            lstCategItem.add(new SelectItem(c, c.getNomCategorie()));
        }
        return lstCategItem;
    }

    @Override
    public void newCompte(Compte compte) {
        persist(compte);
    }

    @Override
    public boolean verifdate(Date date, DefinitionPeriode defPer) {
        if (defPer.getDateDebut().before(date) && defPer.getDateFin().after(date)) {
            return true;
        }
        return false;
    }

    @Override
    public Double calculCategorie(CategorieCharge categ) {
        double somme = 0;
       for(TransactionCaisse c : categ.getLsttransactionCharge()){
            somme  = somme + c.getMontant();
       }
       return somme;
    }

    @Override
    public Double sommeCharges(Cooperative coop) {
        double somme = 0;
        for(CategorieCharge c : lstCategorieCharge(coop)){
            somme =  somme + calculCategorie(c);
        }
        return somme;
    }

    @Override
    public List<SelectItem> lstItemCoop() {
        List<SelectItem> lstCategItem = new ArrayList<SelectItem>();
        for (Cooperative c : lstCoop()) {
            lstCategItem.add(new SelectItem(c, c.getName()));
        }
        return lstCategItem;
    }

      @Override
    public List<Cooperative> lstCoop() {
        Query query = em.createQuery("from Cooperative");
        return query.getResultList();
    }


}
