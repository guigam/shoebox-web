/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gfplus.parametrageShoebox;

import Login.login;
import ModelesShoebox.CategorieCharge;
import ModelesShoebox.CharteCompte;
import ModelesShoebox.Client;
import ModelesShoebox.Commande;
import ModelesShoebox.Compte;
import ModelesShoebox.FournisseurIntrant;
import ModelesShoebox.FournisseurProduit;
import ModelesShoebox.Magasin;
import ModelesShoebox.Produit;
import ModelesShoebox.SoldeDepart;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionMagasin;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import parametrageCoop.serviceParamCoopLocal;
import parametrageSocodevi.ServiceParamSocoLocal;

/**
 *
 * @author guigam
 */
@Named(value = "parametrageShoebox")
@SessionScoped
public class parametrageShoebox implements Serializable {

    private Compte compte = new Compte();
    private FournisseurProduit fournisseurproduit = new FournisseurProduit();
    private FournisseurIntrant fournisseurIntrant = new FournisseurIntrant();
    private Client client = new Client();
    private Produit produit = new Produit();
    private CharteCompte charteCompte = new CharteCompte();
    private Magasin magasin = new Magasin();
    private SoldeDepart soldeDepart = new SoldeDepart();
    private List<ConfigMag> lstconfigMag = new LinkedList<ConfigMag>();
    private ConfigMag configmag = new ConfigMag();
    @EJB
    private serviceParamCoopLocal parametrageCoop;
    @Inject
    private login session;
    @EJB
    private ServiceParamSocoLocal serviceSoco;

    /** Creates a new instance of parametrageShoebox */
    public parametrageShoebox() {
    }

    public List<FournisseurProduit> getlstFournisseurProduit() {
        return parametrageCoop.lstFP(session.getCurrentCoop());
    }

    public List<FournisseurIntrant> getlstFournisseurIntrant() {
        return parametrageCoop.lstFI(session.getCurrentCoop());
    }

    public List<Client> getlstClient() {
        return parametrageCoop.lstClient(session.getCurrentCoop());
    }

    public List<SelectItem> getlstItemCompte() {
        return parametrageCoop.lstitemCompte(session.getCurrentCoop());
    }

    public List<Magasin> getlstMagasin() {
        return parametrageCoop.lstMagasin(session.getCurrentCoop());
    }

    public List<Compte> getlstCompteEncaisse() {
        return parametrageCoop.lstCompte(session.getCurrentCoop());
    }

    public List<Produit> getlstProduit() {
        return parametrageCoop.lstproduit(session.getCurrentCoop());
    }

    public List<SelectItem> getListitemProduit() {
        return parametrageCoop.lstItemProduit(session.getCurrentCoop());
    }

    public List<SelectItem> getListitemCategorieCharge() {
        return parametrageCoop.lstItemCategorieCharge(session.getCurrentCoop());
    }

    public List<SelectItem> getlstitemCharteCompte() {
        return parametrageCoop.lstItemCharteCompte();
    }

    public List<SelectItem> getListitemMagasin() {
        return parametrageCoop.lstItemMagasin(session.getCurrentCoop());
    }

    public List<SelectItem> getListitemProduitIntrant() {
        return parametrageCoop.lstItemProduitIntrant(session.getCurrentCoop());
    }

    public List<SelectItem> getListitemFP() {
        return parametrageCoop.lstItemFP(session.getCurrentCoop());
    }

    public List<SelectItem> getListitemFI() {
        return parametrageCoop.lstItemFI(session.getCurrentCoop());
    }

    public List<SelectItem> getListitemClient() {
        return parametrageCoop.lstitemClient(session.getCurrentCoop());
    }

    public List<Produit> getlstProduitIntrant() {
        return parametrageCoop.lstproduitIntrant(session.getCurrentCoop());
    }

    public List<CharteCompte> getlstCharteCompte() {
        return parametrageCoop.lstcharteCompte();
    }

    public void addConfigMag() {
        this.lstconfigMag.add(new ConfigMag());
    }

     public List<CategorieCharge> getlstCategorieCharge(){
       return parametrageCoop.lstCategorieCharge(session.getCurrentCoop());
    }
    public boolean validerDate(Date date) {
        if (parametrageCoop.verifdate(date, session.getCurrentPeriode())) {
            return true;
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attention la date n'est pas correct", "Attention la date n'est pas correct");
        FacesContext.getCurrentInstance().addMessage("type produit", msg);
        return false;

    }

    public String newFournisseurProduit() {

        if (getSoldeDepart().getMontant() > 0) {
            getSoldeDepart().setTypeSolde("rmbFP");
        } else {
            getSoldeDepart().setTypeSolde("detteFP");
        }
        getSoldeDepart().setDefPeriode(session.getCurrentPeriode());
        getSoldeDepart().setEntite(fournisseurproduit);
        getSoldeDepart().setCurrentuser(session.getUser());
        getSoldeDepart().setCoop(session.getCurrentCoop());
        fournisseurproduit.setSoldeDepart(getSoldeDepart());
        fournisseurproduit.setCoop(session.getCurrentCoop());
        fournisseurproduit.setCurrentuser(session.getUser());
        parametrageCoop.newFP(fournisseurproduit);
        fournisseurproduit = new FournisseurProduit();
        return "lstFP";
    }

    public String newInitMagasinConfig() {
        if (magasin.getCommande() == null) {
            Commande commande = new Commande();
            TransactionCaisse tsxc = new TransactionCaisse();
            TransactionMagasin tsxm = new TransactionMagasin();
               retourneCharteCompteSelonProduit(configmag);
             affectationMagasinCaisse(tsxc, tsxm);
             commande.getLsttransactionCaisse().add(tsxc);
             commande.getLsttransactionMagasin().add(tsxm);
                magasin.setCommande(commande);
                parametrageCoop.updateMagasin(magasin);
                magasin = new Magasin();
                configmag = new ConfigMag();
                return "/parametrageCoop/listMagasin.xhtml";
            
        } else {
             Commande commande = new Commande();
             commande.getLsttransactionCaisse().add(configmag.getTsxCaisse());
               commande.getLsttransactionMagasin().add(configmag.getTsxMag());
               commande.setConfirmation(true);
               commande.setCoop(session.getCurrentCoop());
               commande.setCurrentuser(session.getUser());
               commande.setDefPeriode(session.getCurrentPeriode());
                 retourneCharteCompteSelonProduit(configmag);
                afectationFieldsCommande(magasin.getCommande());
                parametrageCoop.updateMagasin(magasin);
                magasin = new Magasin();
                configmag = new ConfigMag();
                return "/parametrageCoop/listMagasin.xhtml";
            
    }

 }
    private void afectationFieldsCommande(Commande commande) {
        TransactionMagasin tsxm = new TransactionMagasin();
        TransactionCaisse tsxc = new TransactionCaisse();
        commande.setConfirmation(true);
        commande.setCoop(session.getCurrentCoop());
        commande.setCurrentuser(session.getUser());
        commande.setDefPeriode(session.getCurrentPeriode());
        commande.setReference("magasin" + magasin.getId());
        commande.setType("EMI");
        affectationMagasinCaisse(tsxc, tsxm);

        commande.getLsttransactionCaisse().add(tsxc);
        commande.getLsttransactionMagasin().add(tsxm);
    }

    private void affectationMagasinCaisse(TransactionCaisse tsxc, TransactionMagasin tsxm) {
        tsxc.setCoop(session.getCurrentCoop());
        tsxc.setDescription("Entree Magasin");
        tsxc.setReference("magasin" + magasin.getId());
        tsxc.setTypeTransaction("E");
        tsxc.setCharteCompte(configmag.getTsxCaisse().getCharteCompte());
        tsxc.setCompteEncaisse(configmag.getTsxCaisse().getCompteEncaisse());
        tsxc.setMontant(configmag.getTsxCaisse().getMontant());
        tsxc.setCoop(session.getCurrentCoop());
        tsxc.setDate(new Date());
        tsxc.setCurrentuser(session.getUser());
        tsxc.setDefPeriode(session.getCurrentPeriode());
        tsxm.setCoop(session.getCurrentCoop());
        tsxm.setGrade(configmag.getTsxMag().getGrade());
        tsxm.setM_commande(magasin.getCommande());
        tsxm.setMagasin(configmag.getTsxMag().getMagasin());
        tsxm.setProduit(configmag.getTsxMag().getProduit());
        tsxm.setQuantite(configmag.getTsxMag().getQuantite());
        tsxm.setCurrentuser(session.getUser());
        tsxm.setDefPeriode(session.getCurrentPeriode());

    }

    private void retourneCharteCompteSelonProduit(ConfigMag c) {
        if (c.getTsxMag().getProduit().getType().equals("Principal")) {
            if(serviceSoco.charteCompteByReference("RA-1-SD") != null){
                c.getTsxCaisse().setCharteCompte(serviceSoco.charteCompteByReference("RA-1-SD"));
            }
        } else if (c.getTsxMag().getProduit().getType().equals("Secondaire")) {
              c.getTsxCaisse().setCharteCompte(serviceSoco.charteCompteByReference("RA-2-SD"));
        }else{
              c.getTsxCaisse().setCharteCompte(serviceSoco.charteCompteByReference("RC-SD"));
        }
      
    }

    public String newFournisseurIntrant() {
        if (getSoldeDepart().getMontant() < 0) {
            getSoldeDepart().setTypeSolde("rmbFI");
        } else {
            getSoldeDepart().setTypeSolde("detteFI");
        }
        getSoldeDepart().setDefPeriode(session.getCurrentPeriode());
        getSoldeDepart().setEntite(fournisseurIntrant);
        getSoldeDepart().setCurrentuser(session.getUser());
        getSoldeDepart().setCoop(session.getCurrentCoop());
        fournisseurIntrant.setSoldeDepart(getSoldeDepart());
        fournisseurIntrant.setCurrentuser(session.getUser());
        fournisseurIntrant.setCoop(session.getCurrentCoop());
        parametrageCoop.newFI(fournisseurIntrant);
        fournisseurIntrant = new FournisseurIntrant();
        return "lstFI";
    }

    public String newClient() {
        if (getSoldeDepart().getMontant() < 0) {
            getSoldeDepart().setTypeSolde("rmbClient");
        } else {
            getSoldeDepart().setTypeSolde("detteClient");
        }
        getSoldeDepart().setDefPeriode(session.getCurrentPeriode());
        getSoldeDepart().setEntite(client);
        getSoldeDepart().setCoop(session.getCurrentCoop());
        getSoldeDepart().setCurrentuser(session.getUser());
        client.setSoldeDepart(getSoldeDepart());
        client.setCoop(session.getCurrentCoop());
        client.setCurrentuser(session.getUser());
        parametrageCoop.newClient(client);
        client = new Client();
        return "lstClient";
    }

    public String newMagasin() {
        magasin.setCurrentuser(session.getUser());
        magasin.setCoop(session.getCurrentCoop());
        parametrageCoop.newMagasin(magasin);
        magasin = new Magasin();

        return "lstMagasin";
    }

    public String newCompteEncaisse() {
        compte.setCurrentuser(session.getUser());
        compte.setCoop(session.getCurrentCoop());
        parametrageCoop.newCompte(compte);
        compte = new Compte();

        return "/parametrageCoop/listCompteEncaisse.xhtml";
    }

    public String newProduit() {
        produit.setCategorie("produitCoop");
        produit.setCurrentuser(session.getUser());
        produit.setCoop(session.getCurrentCoop());
        parametrageCoop.newProduit(getProduit());
        produit = new Produit();
        return "lstProduit";
    }

    public String newProduitIntrant() {
        produit.setCategorie("intrant");
        produit.setCurrentuser(session.getUser());
        produit.setCoop(session.getCurrentCoop());
        parametrageCoop.newProduit(getProduit());
        produit = new Produit();
        return "lstProduitIntrant";
    }

    public String newCharteCompte() {
        parametrageCoop.newCharteCompte(charteCompte);
        charteCompte = new CharteCompte();
        return "lstCharteCompte";
    }

    /**
     * @return the fournisseurproduit
     */
    public FournisseurProduit getFournisseurproduit() {
        return fournisseurproduit;
    }

    /**
     * @param fournisseurproduit the fournisseurproduit to set
     */
    public void setFournisseurproduit(FournisseurProduit fournisseurproduit) {
        this.fournisseurproduit = fournisseurproduit;
    }

    /**
     * @return the soldeDepart
     */
    public SoldeDepart getSoldeDepart() {
        return soldeDepart;
    }

    /**
     * @param soldeDepart the soldeDepart to set
     */
    public void setSoldeDepart(SoldeDepart soldeDepart) {
        this.soldeDepart = soldeDepart;
    }

    /**
     * @return the fournisseurIntrant
     */
    public FournisseurIntrant getFournisseurIntrant() {
        return fournisseurIntrant;
    }

    /**
     * @param fournisseurIntrant the fournisseurIntrant to set
     */
    public void setFournisseurIntrant(FournisseurIntrant fournisseurIntrant) {
        this.fournisseurIntrant = fournisseurIntrant;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the charteCompte
     */
    public CharteCompte getCharteCompte() {
        return charteCompte;
    }

    /**
     * @param charteCompte the charteCompte to set
     */
    public void setCharteCompte(CharteCompte charteCompte) {
        this.charteCompte = charteCompte;
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
     * @return the magasin
     */
    public Magasin getMagasin() {
        return magasin;
    }

    /**
     * @param magasin the magasin to set
     */
    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    /**
     * @return the lstconfigMag
     */
    public List<ConfigMag> getLstconfigMag() {
        ConfigMag cm = new ConfigMag();
        for (TransactionMagasin m : magasin.getCommande().getLsttransactionMagasin()) {
            cm.setTsxMag(m);
        }

        return lstconfigMag;
    }

    /**
     * @param lstconfigMag the lstconfigMag to set
     */
    public void setLstconfigMag(List<ConfigMag> lstconfigMag) {
        this.lstconfigMag = lstconfigMag;
    }

    /**
     * @return the configmag
     */
    public ConfigMag getConfigmag() {
        return configmag;
    }

    /**
     * @param configmag the configmag to set
     */
    public void setConfigmag(ConfigMag configmag) {
        this.configmag = configmag;
    }

    /**
     * @return the compte
     */
    public Compte getCompte() {
        return compte;
    }

    /**
     * @param compte the compte to set
     */
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
