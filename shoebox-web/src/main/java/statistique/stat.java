/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statistique;

import Login.login;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionMagasin;
import gestionCommandesTransaction.ServiceGestionCommandeTransactionLocal;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import resultat.serviceResultatLocal;

/**
 *
 * @author guiga
 */
@Named

public class stat {
  @EJB
  serviceResultatLocal serviceResultat;
     @EJB
    private ServiceGestionCommandeTransactionLocal serviceGsCommande;
    @Inject
    login session;
    
    
        public String getDataMagByProd() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (TransactionMagasin t : serviceResultat.statMagasinByProduit(session.getCurrentCoop(), session.getCurrentPeriode()))
            sb.append("['"+t.getProduit().getName()+"', "+t.getQuantite()+"],");
        sb.append("]");
        return sb.toString();
    }
        public String getDataCaissByProd() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (TransactionCaisse t : serviceResultat.statCaisseByProduit(session.getCurrentCoop(), session.getCurrentPeriode()))
            sb.append("['"+t.getTypeTransaction()+"', "+t.getMontant()+"],");
        sb.append("]");
        return sb.toString();
    }
        public String getDataMagasinInventaire() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (TransactionCaisse t : serviceResultat.statCaisseByProduit(session.getCurrentCoop(), session.getCurrentPeriode()))
            sb.append("['"+t.getTypeTransaction()+"', "+t.getMontant()+"],");
        sb.append("]");
        return sb.toString();
    }
}
