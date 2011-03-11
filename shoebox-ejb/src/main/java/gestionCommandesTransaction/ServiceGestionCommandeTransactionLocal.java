/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionCommandesTransaction;

import ModelesParametrage.DefinitionPeriode;
import ModelesShoebox.Commande;
import ModelesShoebox.Cooperative;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionCharge;
import ModelesShoebox.TransactionMagasin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author guigam
 */
@Local
public interface ServiceGestionCommandeTransactionLocal {

    public void newCommnde(Commande commande);

    public List<Commande> lstCommande(Cooperative coop, DefinitionPeriode periode);

     public List<Commande> allSortisCommandeProduitPrincipal();
     
     public List<Commande> allEntreeCommandeProduitPrincipal();

     public void mergeCommande(Commande commande);

    public void deleteCommande(Commande commande);

    public List<Commande> lstCommandeByType(String type,Cooperative coop, DefinitionPeriode periode);

    public void mergeTransactionMagasin(TransactionMagasin tsx);

    public List<TransactionCharge> lstCharges(Cooperative coop, DefinitionPeriode periode);

    public void newTransactionCharge(TransactionCharge transactionCharge);

     public Long calculTotalQuantiteProduit();


    

    
}
