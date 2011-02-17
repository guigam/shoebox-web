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

    public List<Client> lstClient();

    public List<FournisseurProduit> lstFP();

    public List<FournisseurIntrant> lstFI();

    public List<Produit> lstproduit();

    public List<Magasin> lstMagasin();

    public List<Produit> lstproduitIntrant();

    public List<Compte> lstCompte();

    public List<CharteCompte> lstcharteCompte();

    public List<SelectItem> lstItemProduit();

    public List<SelectItem> lstItemProduitIntrant();

    public List<SelectItem> lstItemFP();

    public List<SelectItem> lstItemFI();

    public List<SelectItem> lstItemMagasin();

    public List<SelectItem> lstitemClient();

    public List<SelectItem> lstitemCompte();

    public List<SelectItem> lstItemCharteCompte();

    //***************************recherche*********************************//
    public  List<Object[]>  rechercheStockProduit(Produit produit, int grade);
    
    public List<Object[]> rechercheSommeEntreeProduit(Produit produit, int grade);

    public List<TransactionMagasin> test();

 }
