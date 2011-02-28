/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gfplus.parametrageShoebox;

import Login.login;
import ModelesShoebox.CharteCompte;
import ModelesShoebox.Client;
import ModelesShoebox.Compte;
import ModelesShoebox.FournisseurIntrant;
import ModelesShoebox.FournisseurProduit;
import ModelesShoebox.Magasin;
import ModelesShoebox.Produit;
import ModelesShoebox.SoldeDepart;
import ModelesShoebox.TransactionMagasin;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import parametrageCoop.serviceParamCoopLocal;

/**
 *
 * @author guigam
 */
@Named(value = "parametrageShoebox")
@RequestScoped
public class parametrageShoebox {

    private FournisseurProduit fournisseurproduit = new FournisseurProduit();
    private FournisseurIntrant fournisseurIntrant = new FournisseurIntrant();
    private Client client = new Client();
    private Produit produit = new Produit();
    private CharteCompte charteCompte = new CharteCompte();
    private Magasin magasin = new Magasin();
    private SoldeDepart soldeDepart = new SoldeDepart();

    @EJB
    private serviceParamCoopLocal parametrageCoop;
 @Inject
    private login session;
    /** Creates a new instance of parametrageShoebox */
    public parametrageShoebox() {
    }

    public List<TransactionMagasin> gettest(){
        return parametrageCoop.test();
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

    public List<SelectItem> getlstItemCompte(){
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

    public List<SelectItem> getlstitemCharteCompte(){
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

    public String newFournisseurProduit() {

        if(soldeDepart.getMontant() > 0){
            soldeDepart.setTypeSolde("rmbFP");
        }else{
            soldeDepart.setTypeSolde("detteFP");
        }
        soldeDepart.setDefPeriode(session.getCurrentPeriode());
        soldeDepart.setEntite(fournisseurproduit);
        soldeDepart.setCurrentuser(session.getUser());
        soldeDepart.setCoop(session.getCurrentCoop());
        fournisseurproduit.setSoldeDepart(soldeDepart);
        parametrageCoop.newFP(fournisseurproduit);
        return "lstFP";
    }

    public String newFournisseurIntrant() {
        if(soldeDepart.getMontant() < 0){
            soldeDepart.setTypeSolde("rmbFI");
        }else{soldeDepart.setTypeSolde("detteFI");
        }
        soldeDepart.setDefPeriode(session.getCurrentPeriode());
        soldeDepart.setEntite(fournisseurIntrant);
        soldeDepart.setCurrentuser(session.getUser());
        fournisseurIntrant.setSoldeDepart(soldeDepart);
        fournisseurIntrant.setCoop(session.getCurrentCoop());
        parametrageCoop.newFI(fournisseurIntrant);
        return "lstFI";
    }

    public String newClient() {
        if(soldeDepart.getMontant() < 0){
            soldeDepart.setTypeSolde("rmbClient");
        }else{soldeDepart.setTypeSolde("detteClient");
        }
        soldeDepart.setDefPeriode(session.getCurrentPeriode());
        soldeDepart.setEntite(client);
        soldeDepart.setCurrentuser(session.getUser());
        client.setSoldeDepart(soldeDepart);
        client.setCoop(session.getCurrentCoop());
        parametrageCoop.newClient(client);
        return "lstClient";
    }

    public String newMagasin() {
        magasin.setCurrentuser(session.getUser());
        magasin.setCoop(session.getCurrentCoop());
        parametrageCoop.newMagasin(magasin);

        return "lstMagasin";
    }

    public String newProduit() {
        produit.setCategorie("produitCoop");
        produit.setCurrentuser(session.getUser());
        produit.setCoop(session.getCurrentCoop());
        parametrageCoop.newProduit(getProduit());
        return "lstProduit";
    }

    public String newProduitIntrant() {
        produit.setCategorie("intrant");
        produit.setCurrentuser(session.getUser());
        produit.setCoop(session.getCurrentCoop());
        parametrageCoop.newProduit(getProduit());
        return "lstProduitIntrant";
    }

    public String newCharteCompte() {
        parametrageCoop.newCharteCompte(charteCompte);
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

 
}
