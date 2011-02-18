/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionCommandes;

import ModelesShoebox.Commande;
import ModelesShoebox.Compte;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionMagasin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author guigam
 */
@Local
public interface ServiceGestionCommandeLocal {

    public void newCommnde(Commande commande);

    public List<Commande> lstCommande();

    public void mergeCommande(Commande commande);

    public void deleteCommande(Commande commande);

    public List<Commande> lstCommandeByType(String type);

    public void newtransaction(TransactionCaisse tsxCaisse, Commande commande);

    public void mergeTransactionMagasin(TransactionMagasin tsx);
    

    
}
