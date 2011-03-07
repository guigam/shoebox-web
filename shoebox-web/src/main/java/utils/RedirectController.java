/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import ModelesShoebox.Commande;
import gestionCommandes.gestionCommandes;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author guigam
 */
@Named(value="redirectController")
@RequestScoped
public class RedirectController {
@Inject
private gestionCommandes gsCommande;
    /** Creates a new instance of redirectController */
    public RedirectController() {
    }



   
    public String redirect(){
        String outcome = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("outcome");
        gsCommande.setCommade(new Commande());
        gsCommande.getLstTsxMagasin().clear();
        gsCommande.getLstStockSortieProduit().clear();
        return outcome;
    }

}
