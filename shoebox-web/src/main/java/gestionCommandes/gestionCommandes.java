/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionCommandes;

import Login.login;
import gestionCommandesTransaction.ServiceGestionCommandeTransactionLocal;
import ModelesShoebox.Commande;
import ModelesShoebox.Magasin;
import ModelesShoebox.Produit;
import ModelesShoebox.TransactionMagasin;
import gestionCaisse.GestionCaisse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import parametrageCoop.serviceParamCoopLocal;

/**
 *
 * @author guigam
 */
@Named(value = "gsCommandes")
@SessionScoped
public class gestionCommandes implements Serializable {
    @EJB
    private ServiceGestionCommandeTransactionLocal serviceGsCommande;
    @EJB
    private serviceParamCoopLocal parametrageCoop;
    @Inject
    private GestionCaisse gsCaisse;
     @Inject
    private login session;
     @Inject
     Conversation conversation;
    private Commande commade = new Commande();
    private List<TransactionMagasin> lstTsxMagasin = new ArrayList<TransactionMagasin>();
    private List<StockSortieProduit> lstStockSortieProduit = new ArrayList<StockSortieProduit>();
    private StockSortieProduit m_ssp = new StockSortieProduit();
    private Produit produit = new Produit();
    private int grade = 0;
    private List<Commande> lstCommandeSortisProduit = new LinkedList<Commande>();

    /** Creates a new instance of gestionCommandes */
    public gestionCommandes() {
    }

    public String newCommandeEntreeProduit() {
        commade.setType("EP");
        commade.setDefPeriode(session.getCurrentPeriode());
        setterCurrentUserPeriode();
        commade.setCurrentuser(session.getUser());
        commade.setLsttransactionMagasin(lstTsxMagasin);
        serviceGsCommande.newCommnde(commade);
        commade = new Commande();
        lstTsxMagasin.clear();
        
        return "lstCommandeEntreeproduit";
    }

    private void setterCurrentUserPeriode() {
        for (TransactionMagasin tsx : lstTsxMagasin) {
            tsx.setCurrentuser(session.getUser());
            tsx.setDefPeriode(session.getCurrentPeriode());
        }
    }

    public String newCommandeEntreeIntrant() {
        commade.setType("EI");
        commade.setDefPeriode(session.getCurrentPeriode());
        serviceGsCommande.newCommnde(commade);
        commade = new Commande();
        return "lstCommandeEntreeIntrant";
    }

    public void ajouterLigneVide() {
        TransactionMagasin tsx = new TransactionMagasin();
        tsx.setM_commande(commade);
        lstTsxMagasin.add(tsx);


    }

    public List<Commande> getlstCommandeEntreeProduit() {
        return serviceGsCommande.lstCommandeByType("EP",session.getUser().getCooperative(),session.getCurrentPeriode());
    }

    public List<Commande> getlstCommandeEntreeIntrant() {
        return serviceGsCommande.lstCommandeByType("EI",session.getUser().getCooperative(),session.getCurrentPeriode());
    }

    public String newCommandeSortisProduit() {
        commade.setType("SP");
        setterCurrentUserPeriode();
        commade.setLsttransactionMagasin(lstTsxMagasin);
        commade.setDefPeriode(session.getCurrentPeriode());
        commade.setCurrentuser(session.getUser());
        serviceGsCommande.newCommnde(commade);
        lstCommandeSortisProduit.add(commade);
        commade = new Commande();
        lstTsxMagasin.clear();
        return "lstCommandeSortieproduit";
    }

    public String newCommandeSortisIntrant() {
        commade.setType("SI");
        commade.setDefPeriode(session.getCurrentPeriode());
        serviceGsCommande.newCommnde(commade);
        commade = new Commande();
        return "lstCommandeSortisIntrant";
    }


    public List<Commande> getlstCommandeSortisIntrant() {
        return serviceGsCommande.lstCommandeByType("SI",session.getUser().getCooperative(), session.getCurrentPeriode());
    }

    public void rechercheStockProduit() {
        List<Object[]> lstObject = new LinkedList<Object[]>();
        lstStockSortieProduit.clear();
        lstObject = parametrageCoop.rechercheStockProduit(produit, grade,session.getUser().getCooperative());
        for (Object[] t : lstObject) {
            StockSortieProduit ssp = new StockSortieProduit();
            ssp.setMagasin((Magasin) t[0]);
            ssp.setQuantite((Long) t[2]);
            lstStockSortieProduit.add(ssp);
        }
    }

 

    public void ajouterSortieProduit() {
        if (m_ssp.getPu() != 0 && m_ssp.getQuantiteSaisie() != 0) {
            TransactionMagasin tsx = new TransactionMagasin();
            tsx.setM_commande(commade);
            tsx.setGrade(grade);
            tsx.setMagasin(m_ssp.getMagasin());
            tsx.setPrixUnitaire(m_ssp.getPu());
            tsx.setProduit(produit);
            tsx.setQuantite(m_ssp.getQuantiteSaisie());
            lstTsxMagasin.add(tsx);
            m_ssp = new StockSortieProduit();
        }
    }

    public float getcalculSommeCommande() {
        float somme = 0;
        for (TransactionMagasin tsx : lstTsxMagasin) {
            somme = somme + tsx.getCalculMontant();
        }
        return somme;
    }

    /**
     * @return the commade
     */
    public Commande getCommade() {

        return commade;
    }

    /**
     * @param commade the commade to set
     */
    public void setCommade(Commande commade) {
        this.commade = commade;
    }

    /**
     * @return the lstTsxMagasin
     */
    public List<TransactionMagasin> getLstTsxMagasin() {
        return lstTsxMagasin;
    }

    /**
     * @param lstTsxMagasin the lstTsxMagasin to set
     */
    public void setLstTsxMagasin(List<TransactionMagasin> lstTsxMagasin) {
        this.lstTsxMagasin = lstTsxMagasin;
    }
    public void confirmerCommande() {
                    commade.setConfirmation(true);
                    serviceGsCommande.mergeCommande(commade);
    }



    /**
     * @return the produit
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * @param produit the produit to set
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    /**
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * @return the lstStockSortieProduit
     */
    public List<StockSortieProduit> getLstStockSortieProduit() {
        return lstStockSortieProduit;
    }

    /**
     * @param lstStockSortieProduit the lstStockSortieProduit to set
     */
    public void setLstStockSortieProduit(List<StockSortieProduit> lstStockSortieProduit) {
        this.lstStockSortieProduit = lstStockSortieProduit;
    }

    /**
     * @return the m_ssp
     */
    public StockSortieProduit getM_ssp() {
        return m_ssp;
    }

    /**
     * @param m_ssp the m_ssp to set
     */
    public void setM_ssp(StockSortieProduit m_ssp) {
        this.m_ssp = m_ssp;
    }



    /**
     * @return the lstCommandeSortisProduit
     */
    public List<Commande> getLstCommandeSortisProduit() {
      return serviceGsCommande.lstCommandeByType("SP",session.getUser().getCooperative(), session.getCurrentPeriode());
    }

    /**
     * @param lstCommandeSortisProduit the lstCommandeSortisProduit to set
     */
    public void setLstCommandeSortisProduit(List<Commande> lstCommandeSortisProduit) {
        this.lstCommandeSortisProduit = lstCommandeSortisProduit;
    }

}
