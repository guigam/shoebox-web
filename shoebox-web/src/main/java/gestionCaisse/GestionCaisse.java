/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionCaisse;

import Login.login;
import ModelesShoebox.TransactionCaisse;
import gestionCommandes.gestionCommandes;
import gestionCommandesTransaction.ServiceGestionCommandeTransactionLocal;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import parametrageSocodevi.ServiceParamSocoLocal;
import serviceSoldeDepart.serviceSoldeDepartLocal;
import soldeDepart.gestionSoldeDepart;

/**
 *
 * @author guigamehdi
 */
@Named(value = "gestionCaisse")
@SessionScoped
public class GestionCaisse implements Serializable {
@Inject
private gestionCommandes gsCommande;
@Inject
private gestionSoldeDepart gsSoldeDepart;
   private TransactionCaisse tsxCaisse =  new TransactionCaisse();
   private List<TransactionCaisse> lstTsxCaisse = new LinkedList<TransactionCaisse>();
 @EJB
    private ServiceGestionCommandeTransactionLocal serviceGsCommande;
 @EJB
 private ServiceParamSocoLocal serviceSoco;
 @EJB
 private serviceSoldeDepartLocal serviceSolde;
   @Inject
    private login session;

    /** Creates a new instance of gestionCaisse */
    public GestionCaisse() {
    }

    public void newtransactionCommande(){
        tsxCaisse.setCharteCompte((serviceSoco.rechercheParamCharteCompte(gsCommande.getCommade().getType(),session.getUser().getCooperative())).getCharteCompte());
        tsxCaisse.setDescription((serviceSoco.rechercheParamCharteCompte(gsCommande.getCommade().getType(),session.getUser().getCooperative())).getType());
        tsxCaisse.setCurrentuser(session.getUser());
        affectationTypetransactionCaisse();
    gsCommande.getCommade().getLsttransactionCaisse().add(tsxCaisse);
    serviceGsCommande.mergeCommande(gsCommande.getCommade());
        tsxCaisse = new TransactionCaisse();
    }
    public void newtransactionSD(){
        tsxCaisse.setCharteCompte((serviceSoco.rechercheParamCharteCompte(gsSoldeDepart.getSd().getTypeSolde(),session.getUser().getCooperative())).getCharteCompte());
        tsxCaisse.setDescription(serviceSoco.rechercheParamCharteCompte(gsSoldeDepart.getSd().getTypeSolde(),session.getUser().getCooperative()).getType());
        tsxCaisse.setCurrentuser(session.getUser());
        affectationTypetransactionSD();
    gsSoldeDepart.getSd().getLstTransactionSoldeDepart().add(tsxCaisse);
    serviceSolde.mergeSolde(gsSoldeDepart.getSd());
      tsxCaisse = new TransactionCaisse();
    }

    private void affectationTypetransactionSD() {
        
        if (gsSoldeDepart.getSd().getTypeSolde() == "rmbFP" || gsSoldeDepart.getSd().getTypeSolde() == "rmbFI" || gsSoldeDepart.getSd().getTypeSolde() == "rmbClient") {
            tsxCaisse.setTypeTransaction("D");
        }else{
            tsxCaisse.setTypeTransaction("E");
        }
    }
    private void affectationTypetransactionCaisse() {

        if (gsCommande.getCommade().getType() == "EP" || gsCommande.getCommade().getType()  == "EI" ) {
            tsxCaisse.setTypeTransaction("D");
        }else{
            tsxCaisse.setTypeTransaction("E");
        }
    }

    /**
     * @return the tsxCiasse
     */
    public TransactionCaisse getTsxCaisse() {
        return tsxCaisse;
    }

    /**
     * @param tsxCiasse the tsxCiasse to set
     */
    public void setTsxCaisse(TransactionCaisse tsxCiasse) {
        this.tsxCaisse = tsxCiasse;
    }

    /**
     * @return the lstTsxCaisse
     */
    public List<TransactionCaisse> getLstTsxCaisse() {
        return lstTsxCaisse;
    }

    /**
     * @param lstTsxCaisse the lstTsxCaisse to set
     */
    public void setLstTsxCaisse(List<TransactionCaisse> lstTsxCaisse) {
        this.lstTsxCaisse = lstTsxCaisse;
    }





   


}
