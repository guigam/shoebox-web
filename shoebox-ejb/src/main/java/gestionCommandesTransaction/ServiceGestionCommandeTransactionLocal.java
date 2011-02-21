/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionCommandesTransaction;

import ModelesShoebox.Commande;
import ModelesShoebox.Cooperative;
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

    public List<Commande> lstCommande(Cooperative coop);

    public void mergeCommande(Commande commande);

    public void deleteCommande(Commande commande);

    public List<Commande> lstCommandeByType(String type,Cooperative coop);

    public void mergeTransactionMagasin(TransactionMagasin tsx);
    

    
}
