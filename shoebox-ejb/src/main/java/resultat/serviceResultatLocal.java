/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package resultat;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.StructureCharge;
import ModelesParametrage.StructureProduit;
import ModelesShoebox.CharteCompte;
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
    
    public List<TransactionCaisse> lstTsxCaisseCoop(Cooperative coop, DefinitionPeriode periode);

    public List<TransactionCaisse> lstTsxCaisseClient(Cooperative coop,Client cli, DefinitionPeriode periode);

    public List<TransactionCaisse> lstTsxCaisseFP(Cooperative coop,FournisseurProduit FP, DefinitionPeriode periode);

    public List<TransactionCaisse> lstTsxCaisseFPPourSD(Cooperative coop,FournisseurProduit FP, DefinitionPeriode periode);

    public List<TransactionCaisse> lstTsxCaisseFIPourSD(Cooperative coop,FournisseurIntrant FI, DefinitionPeriode periode);

    public List<TransactionCaisse> lstTsxCaisseClientPourSD(Cooperative coop,Client client, DefinitionPeriode periode);
    
    public List<TransactionCaisse> lstTsxCaisseFI(Cooperative coop,FournisseurIntrant FI, DefinitionPeriode periode);


    public double  rechercheResultat(int periode, String charteCompte, Cooperative coop);

    public List<CharteCompte> lstCharteCompte(String type);

    public List<StructureCharge> lsttructureCharge();
    
    public List<StructureProduit> lsttructureProduit();

  

}
