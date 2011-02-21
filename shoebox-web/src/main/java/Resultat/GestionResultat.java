/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Resultat;

import Login.login;
import ModelesShoebox.TransactionCaisse;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import resultat.serviceResultatLocal;

/**
 *
 * @author guigam
 */
@Named(value="gsResultat")
@RequestScoped
public class GestionResultat {
@EJB
private serviceResultatLocal resultat;
@Inject
private login session;
    /** Creates a new instance of GestionResultat */
    public GestionResultat() {
    }

    public List<TransactionCaisse> etatcompteCoop(){
        return resultat.lstTsxCaisseCoop(session.getUser().getCooperative());
    }

}
