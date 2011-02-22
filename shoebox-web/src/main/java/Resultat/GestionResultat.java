/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Resultat;

import Login.login;
import ModelesShoebox.Client;
import ModelesShoebox.TransactionCaisse;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.event.ValueChangeEvent;
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
  
    public void changeValueCombo(ValueChangeEvent event){
         getetatcompteClient();
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
}
