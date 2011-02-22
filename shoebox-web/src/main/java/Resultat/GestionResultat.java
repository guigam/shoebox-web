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
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import resultat.serviceResultatLocal;

/**
 *
 * @author guigam
 */
@Named(value="gsResultat")
@SessionScoped
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
        return resultat.lstTsxCaisseCoop(session.getUser().getCooperative());
    }

    public List<TransactionCaisse> getetatcompteClient(){
        if(client.getId() != null){
        return resultat.lstTsxCaisseClient(session.getUser().getCooperative(),client);
        }
        return null;
    }
      public List<TransactionCaisse> getetatcompteFP(){
        if(fp.getId() != null){
        return resultat.lstTsxCaisseFP(session.getUser().getCooperative(),fp);
        }
        return null;
    }
         public List<TransactionCaisse> getetatcompteFI(){
        if(fp.getId() != null){
        return resultat.lstTsxCaisseFI(session.getUser().getCooperative(),fi);
        }
        return null;
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
     * @return the fp
     */
    public FournisseurProduit getFp() {
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
