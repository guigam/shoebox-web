/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package resultat;

import ModelesShoebox.Client;
import ModelesShoebox.Cooperative;
import ModelesShoebox.FournisseurIntrant;
import ModelesShoebox.FournisseurProduit;
import ModelesShoebox.TransactionCaisse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author guigam
 */
@Local
public interface serviceResultatLocal {
    
    public List<TransactionCaisse> lstTsxCaisseCoop(Cooperative coop);

    public List<TransactionCaisse> lstTsxCaisseClient(Cooperative coop,Client cli);

    public List<TransactionCaisse> lstTsxCaisseFP(Cooperative coop,FournisseurProduit FP);
    
    public List<TransactionCaisse> lstTsxCaisseFI(Cooperative coop,FournisseurIntrant FI);
}
