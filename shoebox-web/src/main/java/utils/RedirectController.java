/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import ModelesParametrage.Utilisateur;
import ModelesShoebox.Commande;
import ModelesShoebox.Cooperative;
import gestionCommandes.gestionCommandes;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import parametrageSocodevi.GestionParametrageSoco;

/**
 *
 * @author guigam
 */
@Named(value="redirectController")
@RequestScoped
public class RedirectController {
@Inject
private gestionCommandes gsCommande;
@Inject
private GestionParametrageSoco paramSoco;
    /** Creates a new instance of redirectController */
    public RedirectController() {
    }



   
    public String redirect(){
        String outcome = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("outcome");
        gsCommande.setCommade(new Commande());
        gsCommande.getLstTsxMagasin().clear();
        gsCommande.getLstStockSortieProduit().clear();
        if(outcome.equals("lstCooperative")){
        paramSoco.setUtilisateur(new Utilisateur());
//        paramSoco.getlstDefinitionPeriodeAdmin().clear();
//        paramSoco.getlstParamtransaction().clear();
////        paramSoco.getlstDefinitionPeriode().clear();
       paramSoco.setCooperative(new Cooperative());
        }
        return outcome;
    }

}
