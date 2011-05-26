/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import ModelesParametrage.Utilisateur;
import ModelesShoebox.Cooperative;
import gestionCommandes.gestionCommandes;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import parametrageSocodevi.GestionParametrageSoco;

/**
 *
 * @author guigam
 */
@Named(value="redirectController")
@ConversationScoped
public class RedirectController implements Serializable{
@Inject
private gestionCommandes gsCommande;
@Inject
private GestionParametrageSoco paramSoco;
@Inject
Conversation conversation;
    /** Creates a new instance of redirectController */
    public RedirectController() {
    }



   
    public String redirect(){
        if(!conversation.isTransient()){
            conversation.end();
        }
        String outcome = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("outcome");
        return outcome;
    }

}
