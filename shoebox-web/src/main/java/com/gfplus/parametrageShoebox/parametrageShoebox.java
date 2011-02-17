/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gfplus.parametrageShoebox;

import ModelesShoebox.CharteCompte;
import ModelesShoebox.Client;
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

    /** Creates a new instance of parametrageShoebox */
    public parametrageShoebox() {
    }

    public List<TransactionMagasin> gettest(){
        return parametrageCoop.test();
    }

    public List<FournisseurProduit> getlstFournisseurProduit() {
        return parametrageCoop.lstFP();
    }

    public List<FournisseurIntrant> getlstFournisseurIntrant() {
        return parametrageCoop.lstFI();
    }

    public List<Client> getlstClient() {
        return parametrageCoop.lstClient();
    }

    public List<SelectItem> getlstItemCompte(){
        return parametrageCoop.lstitemCompte();
    }

    public List<Magasin> getlstMagasin() {
        return parametrageCoop.lstMagasin();
    }

    public List<Produit> getlstProduit() {
        return parametrageCoop.lstproduit();
    }

    public List<SelectItem> getListitemProduit() {
        return parametrageCoop.lstItemProduit();
    }

    public List<SelectItem> getlstitemCharteCompte(){
        return parametrageCoop.lstItemCharteCompte();
    }

    public List<SelectItem> getListitemMagasin() {
        return parametrageCoop.lstItemMagasin();
    }

    public List<SelectItem> getListitemProduitIntrant() {
        return parametrageCoop.lstItemProduitIntrant();
    }

    public List<SelectItem> getListitemFP() {
        return parametrageCoop.lstItemFP();
    }

    public List<SelectItem> getListitemFI() {
        return parametrageCoop.lstItemFI();
    }

    public List<SelectItem> getListitemClient() {
        return parametrageCoop.lstitemClient();
    }

    public List<Produit> getlstProduitIntrant() {
        return parametrageCoop.lstproduitIntrant();
    }

    public List<CharteCompte> getlstCharteCompte() {
        return parametrageCoop.lstcharteCompte();
    }

    public String newFournisseurProduit() {
        soldeDepart.setEntite(fournisseurproduit);
        fournisseurproduit.setSoldeDepart(soldeDepart);
        parametrageCoop.newFP(fournisseurproduit);
        return "lstFP";
    }

    public String newFournisseurIntrant() {
        soldeDepart.setEntite(fournisseurIntrant);
        fournisseurIntrant.setSoldeDepart(soldeDepart);
        parametrageCoop.newFI(fournisseurIntrant);
        return "lstFI";
    }

    public String newClient() {
        soldeDepart.setEntite(client);
        client.setSoldeDepart(soldeDepart);
        parametrageCoop.newClient(client);
        return "lstClient";
    }

    public String newMagasin() {
        parametrageCoop.newMagasin(magasin);
        return "lstMagasin";
    }

    public String newProduit() {
        produit.setCategorie("produitCoop");
        parametrageCoop.newProduit(getProduit());
        return "lstProduit";
    }

    public String newProduitIntrant() {
        produit.setCategorie("intrant");
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
