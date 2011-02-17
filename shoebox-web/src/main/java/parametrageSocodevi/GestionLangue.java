/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parametrageSocodevi;

import Login.login;
import ModelesParametrage.Dictionnaire;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author guigam
 */
@Named(value="gsLangue")
@RequestScoped
public class GestionLangue implements Serializable{
    @Inject
    private login session;
@EJB
private ServiceParamSoco serviceLangue;
    /** Creates a new instance of GestionLangue */
    public GestionLangue() {
    }

 



}
