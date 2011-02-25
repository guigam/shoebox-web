/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Resultat;

import Login.login;
import ModelesShoebox.Client;
import ModelesShoebox.FournisseurIntrant;
import ModelesShoebox.FournisseurProduit;
import ModelesShoebox.TransactionCaisse;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;
import resultat.serviceResultatLocal;

/**
 *
 * @author guigam
 */
@Named(value="gsResultat")
@RequestScoped
public class GestionResultat implements Serializable{
@EJB
private serviceResultatLocal resultat;
@Inject
private login session;
private Client client = new Client();
private FournisseurProduit fp = new FournisseurProduit();
private FournisseurIntrant fi = new FournisseurIntrant();
    /** Creates a new instance of GestionResultat */
    public GestionResultat() {
    }

    public List<TransactionCaisse> getetatcompteCoop(){
        return resultat.lstTsxCaisseCoop(session.getUser().getCooperative(), session.getCurrentPeriode());
    }

    public List<TransactionCaisse> getetatcompteClient(){
          List<TransactionCaisse> lstEtatTransactionFP = new LinkedList<TransactionCaisse>();
        if(client.getId() != null){
             lstEtatTransactionFP.addAll(resultat.lstTsxCaisseClientPourSD(session.getUser().getCooperative(), client, session.getCurrentPeriode()));
         lstEtatTransactionFP.addAll(resultat.lstTsxCaisseClient(session.getUser().getCooperative(),client, session.getCurrentPeriode()));
         return lstEtatTransactionFP;
        }
        return null;
    }
      public List<TransactionCaisse> getetatcompteFP(){
          List<TransactionCaisse> lstEtatTransactionFP = new LinkedList<TransactionCaisse>();
        if(fp.getId() != null){
            lstEtatTransactionFP.addAll(resultat.lstTsxCaisseFPPourSD(session.getUser().getCooperative(), fp, session.getCurrentPeriode()));
         lstEtatTransactionFP.addAll(resultat.lstTsxCaisseFP(session.getUser().getCooperative(),fp, session.getCurrentPeriode()));
         return lstEtatTransactionFP;
        }
        return null;
    }
         public List<TransactionCaisse> getetatcompteFI(){
        if(fp.getId() != null){
        return resultat.lstTsxCaisseFI(session.getUser().getCooperative(),fi, session.getCurrentPeriode());
        }
        return null;
    }
  
    /**
     * @return the client
     */
    public Client getClient() {
        getetatcompteClient();
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the fp
     */
    public FournisseurProduit getFp() {
        getetatcompteFP();
        return fp;
    }

    /**
     * @param fp the fp to set
     */
    public void setFp(FournisseurProduit fp) {
        this.fp = fp;
    }

    /**
     * @return the fi
     */
    public FournisseurIntrant getFi() {
        return fi;
    }

    /**
     * @param fi the fi to set
     */
    public void setFi(FournisseurIntrant fi) {
        this.fi = fi;
    }
}
