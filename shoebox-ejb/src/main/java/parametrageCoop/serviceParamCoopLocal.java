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
import ModelesShoebox.TransactionMagasin;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import javax.faces.model.SelectItem;

/**
 *
 * @author guigam
 */
@Local
public interface serviceParamCoopLocal {
//**********************************insertion*************************************

    public void newClient(Client client);

    public void newFP(FournisseurProduit fp);

    public void newFI(FournisseurIntrant fi);

    public void newCoop(Cooperative coop);

    public void newCommande(Commande commande);

    public void newProduit(Produit produit);

    public void newCharteCompte(CharteCompte charteCompte);

    public void newMagasin(Magasin magasin);

    public void newCompte(Compte compte);

    //***********************************modification***************************************************//
    public void updateClient(Client client);

    public void updateFP(FournisseurProduit fp);

    public void updateFI(FournisseurIntrant fi);

    public void updateCoop(Cooperative coop);

    public void updateCommande(Commande commande);

    public void updateProduit(Produit produit);

    public void updateCharteCompte(CharteCompte charteCompte);

    public void updateMagasin(Magasin magasin);

    //*************************************Suppression***************************************//
    public void deleteClient(Client client);

    public void deleteFP(FournisseurProduit fp);

    public void deleteFI(FournisseurIntrant fi);

    public void deleteCoop(Cooperative coop);

    public void deleteCommande(Commande commande);

    public void deleteProduit(Produit produit);

    public void deleteCharteCompte(CharteCompte charteCompte);

    public void deleteMagasin(Magasin magasin);

    //***************************************les liste ******************************************************//
    public List<Client> lstClient(Cooperative coop);

    public List<FournisseurProduit> lstFP(Cooperative coop);

    public List<FournisseurIntrant> lstFI(Cooperative coop);

    public List<Produit> lstproduit(Cooperative coop);

    public List<CategorieCharge> lstCategorieChargeByType(Cooperative coop, String type);

    public List<CategorieCharge> lstCategorieCharge(Cooperative coop);

    public List<Magasin> lstMagasin(Cooperative coop);

    public List<Produit> lstproduitIntrant(Cooperative coop);

    public List<Compte> lstCompte(Cooperative coop);

    public List<CharteCompte> lstcharteCompte();

    public List<SelectItem> lstItemProduit(Cooperative coop);

    public List<SelectItem> lstItemCategorieCharge(Cooperative coop);

    public Double calculCategorie(CategorieCharge categ);

    public List<SelectItem> lstItemProduitIntrant(Cooperative coop);

    public List<SelectItem> lstItemFP(Cooperative coop);

    public List<SelectItem> lstItemFI(Cooperative coop);

    public List<SelectItem> lstItemMagasin(Cooperative coop);

    public List<SelectItem> lstitemClient(Cooperative coop);

    public List<SelectItem> lstitemCompte(Cooperative coop);

    public List<SelectItem> lstItemCharteCompte();

    public List<SelectItem> lstItemCoop();

    public List<Cooperative> lstCoop();


    //***************************autres*********************************//
    public List<TransactionMagasin> rechercheStockProduit(Produit produit, Long grade, Cooperative coop,DefinitionPeriode periode);

    public List<TransactionMagasin> rechercheStockProduitIntrant(Produit produit, Cooperative coop, DefinitionPeriode periode);

    public boolean verifdate(Date date, DefinitionPeriode defPer);

    public Double sommeCharges(Cooperative coop);

       public List<Commande> rechercheCommande(String ref, Date datecom);



     
}
