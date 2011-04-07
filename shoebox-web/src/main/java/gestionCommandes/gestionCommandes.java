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
import com.gfplus.parametrageShoebox.parametrageShoebox;
import gestionCaisse.GestionCaisse;
import java.io.IOException;
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
    private parametrageShoebox paramShoebox;
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
    private List<Commande> allCommande = new LinkedList<Commande>();
    private TransactionMagasin tsxMag = new TransactionMagasin();
    private Commande commandeAffiche = new Commande();

    /** Creates a new instance of gestionCommandes */
    public gestionCommandes() {
    }

    public String newCommandeEntreeProduit() {
        if (paramShoebox.validerDate(commade.getDateCommande())) {
            if (verifHomogeniteEntreeProduit()) {
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
        }
        return null;
    }

    private void affectationTypeCommandesSelonProduit() {
        String typeCommande = lstTsxMagasin.get(0).getProduit().getType();
        if (typeCommande.equals("Principal")) {
            commade.setType("SPP");
        } else {
            commade.setType("SPS");
        }
    }

    private String detectTypeEntreeProduit() {
        TransactionMagasin tsxx = lstTsxMagasin.get(0);
        if (tsxx.getProduit().getType().equals("Principal")) {
            return "EPP";
        } else {
            return "EPS";
        }
    }

      public void fermerModelPanel(){
          lstTsxMagasin.clear();
        commandeAffiche = new Commande();
    }

    private void setterCurrentUserPeriode() {
        for (TransactionMagasin tsx : lstTsxMagasin) {
            tsx.setCurrentuser(session.getUser());
            tsx.setCoop(session.getCurrentCoop());
            tsx.setDefPeriode(session.getCurrentPeriode());
        }
    }


    public void lstTransactionMagasinsByTypeProduitPrincipal(String type){
        lstTsxMagasin =  serviceGsCommande.transactionByProduit(type,session.getCurrentCoop(), session.getCurrentPeriode());
    }
  

    public void removeTsxMAG() {
        if(lstTsxMagasin.remove(tsxMag));
        getLstTsxMagasin();
    }

    public String newCommandeEntreeIntrant() {
        if(veriflistTsxmagasin()){
        if (paramShoebox.validerDate(commade.getDateCommande())) {
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
        }
        return null;
    }

    public void ajouterLigneVide() {
        if (verifHomogeniteEntreeProduit()) {
            TransactionMagasin tsx = new TransactionMagasin();
            tsx.setM_commande(commade);
            lstTsxMagasin.add(tsx);
        }

    }
    public void ajouterLigneVideIntrant() {
        if(veriflistTsxmagasin()){
            TransactionMagasin tsx = new TransactionMagasin();
            tsx.setM_commande(commade);
            lstTsxMagasin.add(tsx);
        }
    }

    private boolean  veriflistTsxmagasin() {
        for (TransactionMagasin t : lstTsxMagasin) {
            if (t.getGrade() == 0 || t.getHumidite() == 0 || t.getMagasin() == null || t.getQuantite() == 0 || t.getProduit() == null || t.getPrixUnitaire() == 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez remplir tous les champs necessaires", "Veuillez remplir tous les champs necessaires");
                FacesContext.getCurrentInstance().addMessage("verif", msg);
                return false;
            }
        }
        return true;
    }

    private boolean verifDuplicSortisProduit() throws IOException {
        for (TransactionMagasin t : lstTsxMagasin) {
///home/guigam/NetBeansProjects/shoebox2/shoebox-web/src/main/resources/bundles/MessageResources_fr_CA.properties
//            /home/guigam/NetBeansProjects/shoebox2/shoebox-web/src/main/webapp/bundles/MessageResources_fr_CA.properties
//            String propertiePath = "src/properties/MessageResources_fr_CA.properties";
//             Properties p = new Properties();
// p.load(new FileInputStream(propertiePath));
//            Properties p = new Properties();
//            try {
//                p.load(this.getClass().getResourceAsStream("resources/bundles/MessageResources_fr_CA"));
//            } catch (IOException ex) {
//                Logger.getLogger(gestionCommandes.class.getName()).log(Level.SEVERE, null, ex);
//            }

//            if (t.getProduit().equals(produit) && t.getGrade() == grade && t.getMagasin().equals(m_ssp.getMagasin())) {
//                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, p.getProperty("messageDuplicationDonnee"), p.getProperty("messageDuplicationDonnee"));
//                FacesContext.getCurrentInstance().addMessage("type produit", msg);
//                return false;
//            }
        }
        return true;
    }

    private boolean verifHomogeniteEntreeProduit() {
        if (!lstTsxMagasin.isEmpty()) {
            TransactionMagasin tsxz = lstTsxMagasin.get(0);
            for (TransactionMagasin t : lstTsxMagasin) {
                if(t.getGrade() == 0 || t.getHumidite()  == 0 || t.getMagasin()  == null || t.getQuantite()  == 0 || t.getProduit()  == null || t.getPrixUnitaire()  == 0){
                 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez remplir tous les champs necessaires", "Veuillez remplir tous les champs necessaires");
                    FacesContext.getCurrentInstance().addMessage("verif", msg);
                    return false;
                }else if (!t.getProduit().getType().equals(tsxz.getProduit().getType())) {
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "le produit ajouter n'est pas du meme type", "le produit ajouter n'est pas du meme type");
                    FacesContext.getCurrentInstance().addMessage("type produit", msg);

                    return false;
                }
            }
        }
        return true;
    }
    private boolean verifHomogeniteSortisProduit() {
        if (!lstTsxMagasin.isEmpty()) {

            for (TransactionMagasin t : lstTsxMagasin) {
                if (!t.getProduit().getType().equals(produit.getType())) {
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
        listCommandes.addAll(serviceGsCommande.lstCommandeByType("EPP", session.getCurrentCoop()));
        listCommandes.addAll(serviceGsCommande.lstCommandeByType("EPS", session.getCurrentCoop()));

        return listCommandes;
    }

    public List<Commande> getlstCommandeEntreeIntrant() {
        return serviceGsCommande.lstCommandeByType("EPI", session.getCurrentCoop());
    }

    public String newCommandeSortisProduit() {
        if (paramShoebox.validerDate(commade.getDateCommande())) {
            affectationTypeCommandesSelonProduit();
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
        return null;
    }

    public String newCommandeSortisIntrant() {
        if (paramShoebox.validerDate(commade.getDateCommande())) {
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
            return "/commandes/listCommandeSortieProduitIntrant.xhtml";
        }
        return null;
    }

    public List<Commande> getlstCommandeSortisIntrant() {
        return serviceGsCommande.lstCommandeByType("SI", session.getCurrentCoop());
    }

    public void rechercheStockProduit() {
        if(produit == null && grade == 0){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez remplir les champs necessaires pour la recherche", "Veuillez remplir les champs necessaires pour la recherche");
            FacesContext.getCurrentInstance().addMessage("recherche", msg);
        }else{
        List<Object[]> lstObject = new LinkedList<Object[]>();
        lstStockSortieProduit.clear();
        lstObject = parametrageCoop.rechercheStockProduit(produit, grade, session.getCurrentCoop(), session.getCurrentPeriode());
        for (Object[] t : lstObject) {
            StockSortieProduit ssp = new StockSortieProduit();
            ssp.setMagasin((Magasin) t[0]);
            ssp.setQuantite((Long) t[2]);
            lstStockSortieProduit.add(ssp);
        }
        }
         
    }

    public void rechercheStockProduitIntrant() {
        if(produit == null){
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez choisir un produit pour la recherche ", "Veuillez choisir un produit pour la recherche ");
            FacesContext.getCurrentInstance().addMessage("recherche", msg);
        }else{
        List<Object[]> lstObject = new LinkedList<Object[]>();
        lstStockSortieProduit.clear();
        lstObject = parametrageCoop.rechercheStockProduitIntrant(produit, session.getCurrentCoop(), session.getCurrentPeriode());
        for (Object[] t : lstObject) {
            StockSortieProduit ssp = new StockSortieProduit();
            ssp.setMagasin((Magasin) t[0]);
            ssp.setQuantite((Long) t[2]);
            lstStockSortieProduit.add(ssp);
        }
    }
    }

    public void ajouterSortieProduit() throws IOException {
        if(m_ssp.getQuantite() < m_ssp.getQuantiteSaisie()){
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention depassement du stock", "Attention depassement du stock");
            FacesContext.getCurrentInstance().addMessage("depassement", msg);
        }else if(m_ssp.getQuantiteSaisie() == 0 || m_ssp.getPu() == 0){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez Remplir tous les champs necessaires", "Veuillez Remplir tous les champs necessaires");
            FacesContext.getCurrentInstance().addMessage("required", msg);
        }else if (paramShoebox.validerDate(commade.getDateCommande())) {
                if(verifHomogeniteSortisProduit()){
                if (verifDuplicSortisProduit()) {
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
        }
    
    public void ajouterSortieProduitIntrant() throws IOException {
        if(m_ssp.getQuantiteSaisie() >  m_ssp.getQuantite()){
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention depassement du stock", "Attention depassement du stock");
            FacesContext.getCurrentInstance().addMessage("depassement", msg);
        }else if (m_ssp.getPu() == 0 && m_ssp.getQuantiteSaisie() == 0) {
                 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez Remplir tous les champs necessaires", "Veuillez Remplir tous les champs necessaires");
            FacesContext.getCurrentInstance().addMessage("required", msg);
            }else if (verifDuplicSortisProduit()) {
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

    public String confirmerCommande() {
        commade.setConfirmation(true);
        serviceGsCommande.mergeCommande(commade);
        return "/commandes/listCommandeSortieProduit.xhtml";
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
        List<Commande> lstCommandes = new LinkedList<Commande>();
        lstCommandes.addAll(serviceGsCommande.lstCommandeByType("SPP", session.getCurrentCoop()));
        lstCommandes.addAll(serviceGsCommande.lstCommandeByType("SPS", session.getCurrentCoop()));
        return lstCommandes;
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

    /**
     * @return the allCommande
     */
    public List<Commande> getAllCommande() {
        return allCommande;
    }

    /**
     * @param allCommande the allCommande to set
     */
    public void setAllCommande(List<Commande> allCommande) {
        this.allCommande = allCommande;
    }

    /**
     * @return the commandeAffiche
     */
    public Commande getCommandeAffiche() {
        return commandeAffiche;
    }

    /**
     * @param commandeAffiche the commandeAffiche to set
     */
    public void setCommandeAffiche(Commande commandeAffiche) {
        this.commandeAffiche = commandeAffiche;
    }
}
