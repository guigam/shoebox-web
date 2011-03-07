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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private TransactionMagasin tsxMag = new TransactionMagasin();

    /** Creates a new instance of gestionCommandes */
    public gestionCommandes() {
    }

    public String newCommandeEntreeProduit() {
        if(verifHomogeniteEntreeProduit()){
        commade.setType(detectTypeEntreeProduit());
        commade.setDefPeriode(session.getCurrentPeriode());
        setterCurrentUserPeriode();
        commade.setCurrentuser(session.getUser());
        commade.setCoop(session.getCurrentCoop());
        commade.setLsttransactionMagasin(lstTsxMagasin);
        serviceGsCommande.newCommnde(commade);
        commade = new Commande();
        lstTsxMagasin.clear();
        return "lstCommandeEntreeproduit";
        }
        return null;
    }

    private String detectTypeEntreeProduit() {
        TransactionMagasin tsxx = lstTsxMagasin.get(0);
        if (tsxx.getProduit().getType().equals("Principal")) {
            return "EPP";
        } else {
            return "EPS";
        }
    }

    private void setterCurrentUserPeriode() {
        for (TransactionMagasin tsx : lstTsxMagasin) {
            tsx.setCurrentuser(session.getUser());
            tsx.setCoop(session.getCurrentCoop());
            tsx.setDefPeriode(session.getCurrentPeriode());
        }
    }

    public void removeTsxMAG(){
        lstTsxMagasin.remove(tsxMag);
    }


    public String newCommandeEntreeIntrant() {
        commade.setType("EPI");
        commade.setDefPeriode(session.getCurrentPeriode());
        setterCurrentUserPeriode();
        commade.setCurrentuser(session.getUser());
         commade.setCoop(session.getCurrentCoop());
        commade.setLsttransactionMagasin(lstTsxMagasin);
        serviceGsCommande.newCommnde(commade);
        commade = new Commande();
        return "lstCommandeEntreeIntrant";
    }

    public void  ajouterLigneVide() {
         if(verifHomogeniteEntreeProduit()){
        
            TransactionMagasin tsx = new TransactionMagasin();
        tsx.setM_commande(commade);
        lstTsxMagasin.add(tsx);
        }
         
    }

    private boolean  verifDuplicSortisProduit() {
        for (TransactionMagasin t : lstTsxMagasin) {
            if (t.getProduit().equals(produit) && t.getGrade() == grade) {
                 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention dupplication de donnée", "Attention dupplication de donnée");
            FacesContext.getCurrentInstance().addMessage("type produit", msg);
                return false;
            }
        }
        return true;
    }

    private boolean verifHomogeniteEntreeProduit() {
        if(!lstTsxMagasin.isEmpty()){
        TransactionMagasin tsxz = lstTsxMagasin.get(0);
        for (TransactionMagasin t : lstTsxMagasin) {
            if (!t.getProduit().getType().equals(tsxz.getProduit().getType())) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "le produit ajouter n'esy pas du meme type", "le produit ajouter n'esy pas du meme type");
            FacesContext.getCurrentInstance().addMessage("type produit", msg);

                return false;
            }
          }
        }
        
        return true;
    }

    public List<Commande> getlstCommandeEntreeProduit() {
        List<Commande> listCommandes = new LinkedList<Commande>();
        listCommandes.addAll(serviceGsCommande.lstCommandeByType("EPP",session.getCurrentCoop(),session.getCurrentPeriode()));
        listCommandes.addAll(serviceGsCommande.lstCommandeByType("EPS",session.getCurrentCoop(),session.getCurrentPeriode()));

        return listCommandes;
    }

    public List<Commande> getlstCommandeEntreeIntrant() {
        return serviceGsCommande.lstCommandeByType("EPI",session.getCurrentCoop(),session.getCurrentPeriode());
    }

    public String newCommandeSortisProduit() {
        commade.setType("SP");
        setterCurrentUserPeriode();
        commade.setLsttransactionMagasin(lstTsxMagasin);
        commade.setDefPeriode(session.getCurrentPeriode());
        commade.setCurrentuser(session.getUser());
         commade.setCoop(session.getCurrentCoop());
        serviceGsCommande.newCommnde(commade);
        lstCommandeSortisProduit.add(commade);
        commade = new Commande();
        lstTsxMagasin.clear();
        return "lstCommandeSortieproduit";
    }

    public String newCommandeSortisIntrant() {
        commade.setType("SI");
        setterCurrentUserPeriode();
        commade.setLsttransactionMagasin(lstTsxMagasin);
        commade.setConfirmation(true);//il n'y a pas de confirmation avec la sortis de produit intrant 
        commade.setDefPeriode(session.getCurrentPeriode());
        commade.setCurrentuser(session.getUser());
         commade.setCoop(session.getCurrentCoop());
        serviceGsCommande.newCommnde(commade);
        commade = new Commande();
        lstTsxMagasin.clear();
        return "lstCommandeSortisIntrant";
    }


    public List<Commande> getlstCommandeSortisIntrant() {
        return serviceGsCommande.lstCommandeByType("SI",session.getCurrentCoop(), session.getCurrentPeriode());
    }

    public void rechercheStockProduit() {
        List<Object[]> lstObject = new LinkedList<Object[]>();
        lstStockSortieProduit.clear();
        lstObject = parametrageCoop.rechercheStockProduit(produit, grade,session.getCurrentCoop());
        for (Object[] t : lstObject) {
            StockSortieProduit ssp = new StockSortieProduit();
            ssp.setMagasin((Magasin) t[0]);
            ssp.setQuantite((Long) t[2]);
            lstStockSortieProduit.add(ssp);
        }
    }
    public void rechercheStockProduitIntrant() {
        List<Object[]> lstObject = new LinkedList<Object[]>();
        lstStockSortieProduit.clear();
        lstObject = parametrageCoop.rechercheStockProduitIntrant(produit,session.getCurrentCoop());
        for (Object[] t : lstObject) {
            StockSortieProduit ssp = new StockSortieProduit();
            ssp.setMagasin((Magasin) t[0]);
            ssp.setQuantite((Long) t[2]);
            lstStockSortieProduit.add(ssp);
        }
    }

 

    public void ajouterSortieProduit() {
        if (m_ssp.getPu() != 0 && m_ssp.getQuantiteSaisie() != 0) {
           if(verifDuplicSortisProduit()){

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
      return serviceGsCommande.lstCommandeByType("SP",session.getCurrentCoop(), session.getCurrentPeriode());
    }

    /**
     * @param lstCommandeSortisProduit the lstCommandeSortisProduit to set
     */
    public void setLstCommandeSortisProduit(List<Commande> lstCommandeSortisProduit) {
        this.lstCommandeSortisProduit = lstCommandeSortisProduit;
    }

    /**
     * @return the tsxMag
     */
    public TransactionMagasin getTsxMag() {
        return tsxMag;
    }

    /**
     * @param tsxMag the tsxMag to set
     */
    public void setTsxMag(TransactionMagasin tsxMag) {
        this.tsxMag = tsxMag;
    }

}
