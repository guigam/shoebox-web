/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionCommandes;

import ModelesShoebox.Commande;
import gestionCommandesTransaction.ServiceGestionCommandeTransactionLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author guiga
 */
@Named
@SessionScoped
public class confirmCommandController implements Serializable {
@Inject private Conversation conversation;

    @EJB
    private ServiceGestionCommandeTransactionLocal serviceGsCommande;
  private Commande commadeConfirm = new Commande();

  
      public String confirmerCommande() {
        commadeConfirm.setConfirmation(true);
        serviceGsCommande.mergeCommande(commadeConfirm);
        commadeConfirm = new Commande();
        return "/commandes/listCommandeSortieProduit.xhtml";
    }
  
      public void conversBegin(){
      }
      
/**
     * @return the commadeConfirm
     */
    public Commande getCommadeConfirm() {
        return commadeConfirm;
    }

    /**
     * @param commadeConfirm the commadeConfirm to set
     */
    public void setCommadeConfirm(Commande commadeConfirm) {
        this.commadeConfirm = commadeConfirm;
    }


    
}
