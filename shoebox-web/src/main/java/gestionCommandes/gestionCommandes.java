/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionCommandes;

import ModelesShoebox.Commande;
import ModelesShoebox.Magasin;
import ModelesShoebox.Produit;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionMagasin;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIData;
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
    private ServiceGestionCommandeLocal serviceGsCommande;
    private Commande commade = new Commande();
    private List<TransactionMagasin> lstTsxMagasin = new ArrayList<TransactionMagasin>();
    private List<TransactionMagasin> lstTsxMagasinRowData = new ArrayList<TransactionMagasin>();
    private UIData dataTable;
    private List<StockSortieProduit> lstStockSortieProduit = new ArrayList<StockSortieProduit>();
    private StockSortieProduit m_ssp = new StockSortieProduit();
    private Produit produit = new Produit();
    private int grade = 0;
    private TransactionCaisse tsxCaisse = new TransactionCaisse();
    @EJB
    private serviceParamCoopLocal parametrageCoop;

    /** Creates a new instance of gestionCommandes */
    public gestionCommandes() {
    }

    public String newCommandeEntreeProduit() {
        commade.setType("EP");
        commade.setLsttransactionMagasin(lstTsxMagasin);
        serviceGsCommande.newCommnde(commade);
        commade = new Commande();
        lstTsxMagasin.clear();
        return "lstCommandeEntreeProduit";
    }

    public String newCommandeEntreeIntrant() {
        commade.setType("EI");
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
        return serviceGsCommande.lstCommandeByType("EP");
    }

    public List<Commande> getlstCommandeEntreeIntrant() {
        return serviceGsCommande.lstCommandeByType("EI");
    }

    public String newCommandeSortisProduit() {
        commade.setType("SP");
        commade.setLsttransactionMagasin(lstTsxMagasin);
        serviceGsCommande.newCommnde(commade);
        commade = new Commande();
        lstTsxMagasin.clear();
        return "lstCommandeSortieproduit";
    }

    public String newCommandeSortisIntrant() {
        commade.setType("SI");
        serviceGsCommande.newCommnde(commade);
        commade = new Commande();
        return "lstCommandeSortisIntrant";
    }

    public List<Commande> getlstCommandeSortisProduit() {
        return serviceGsCommande.lstCommandeByType("SP");
    }

    public List<Commande> getlstCommandeSortisIntrant() {
        return serviceGsCommande.lstCommandeByType("SI");
    }

    public void rechercheStockProduit() {
        List<Object[]> lstObject = new LinkedList<Object[]>();
        lstStockSortieProduit.clear();
        lstObject = parametrageCoop.rechercheStockProduit(produit, grade);
        for (Object[] t : lstObject) {
            StockSortieProduit ssp = new StockSortieProduit();
            ssp.setMagasin((Magasin) t[0]);
            ssp.setQuantite((Long) t[2]);
            lstStockSortieProduit.add(ssp);
        }
    }

    public void newTransaction() {
        serviceGsCommande.newtransaction(tsxCaisse, commade);

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
        for (TransactionMagasin tsx : commade.getLsttransactionMagasin()) {
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

    /**
     * @return the dataTable
     */
    public UIData getDataTable() {

        return dataTable;
    }

    public void rowData() {
        lstTsxMagasinRowData.clear();
        if (dataTable.getRowIndex() != -1) {
            Commande com = (Commande) dataTable.getRowData();
            for (TransactionMagasin tx : com.getLsttransactionMagasin()) {
                getLstTsxMagasinRowData().add(tx);
            }
        }

    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(UIData dataTable) {
        this.dataTable = dataTable;
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
     * @return the lstTsxMagasinRowData
     */
    public List<TransactionMagasin> getLstTsxMagasinRowData() {

        return lstTsxMagasinRowData;
    }

    /**
     * @param lstTsxMagasinRowData the lstTsxMagasinRowData to set
     */
    public void setLstTsxMagasinRowData(List<TransactionMagasin> lstTsxMagasinRowData) {
        this.lstTsxMagasinRowData = lstTsxMagasinRowData;
    }

    /**
     * @return the tsxCaisse
     */
    public TransactionCaisse getTsxCaisse() {
        return tsxCaisse;
    }

    /**
     * @param tsxCaisse the tsxCaisse to set
     */
    public void setTsxCaisse(TransactionCaisse tsxCaisse) {
        this.tsxCaisse = tsxCaisse;
    }
}
