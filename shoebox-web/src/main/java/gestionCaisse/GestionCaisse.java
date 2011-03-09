/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionCaisse;

import Login.login;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionCharge;
import com.gfplus.parametrageShoebox.parametrageShoebox;
import gestionCommandes.gestionCommandes;
import gestionCommandesTransaction.ServiceGestionCommandeTransactionLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private TransactionCaisse tsxCaisse = new TransactionCaisse();
    private TransactionCharge tsxCaisseCharge = new TransactionCharge();
    private List<TransactionCaisse> lstTsxCaisse = new LinkedList<TransactionCaisse>();
    @EJB
    private ServiceGestionCommandeTransactionLocal serviceGsCommande;
    @EJB
    private ServiceParamSocoLocal serviceSoco;
    @EJB
    private serviceSoldeDepartLocal serviceSolde;
    @Inject
    private login session;
    @Inject
    private parametrageShoebox paramShoebox;

    /** Creates a new instance of gestionCaisse */
    public GestionCaisse() {
    }

    public void newtransactionCommande() {
      if(validerTransaction(tsxCaisse.getDate(), gsCommande.getCommade().getDateCommande(),tsxCaisse.getMontant(), gsCommande.getCommade().getmontantrestant())){
        tsxCaisse.setCharteCompte((serviceSoco.rechercheParamCharteCompte(gsCommande.getCommade().getType())).getCharteCompte());
        tsxCaisse.setDescription((serviceSoco.rechercheParamCharteCompte(gsCommande.getCommade().getType())).getType());
        tsxCaisse.setCurrentuser(session.getUser());
        tsxCaisse.setCoop(session.getCurrentCoop());
        tsxCaisse.setDefPeriode(session.getCurrentPeriode());
        affectationTypetransactionCaisse();
        gsCommande.getCommade().getLsttransactionCaisse().add(tsxCaisse);
        serviceGsCommande.mergeCommande(gsCommande.getCommade());
        tsxCaisse = new TransactionCaisse();
        }
    }

    private boolean validerTransaction(Date datetsx,Date dateOrigine, float montant, float montantRestant) {
        if(!paramShoebox.validerDate(datetsx)){
            return false;
        }else if(montant > montantRestant){
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "montant saisie incorrect", "montant saisie incorrect");
                FacesContext.getCurrentInstance().addMessage("montant saisie", msg);
                return false;
        }else if (dateOrigine.after(datetsx)){
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Date transaction ne doit pas etre inferieur a la date de la commande", "Date transaction ne doit pas etre inferieur a la date de la commande");
                FacesContext.getCurrentInstance().addMessage("date", msg);
                return false;
        }
        return true;
    }

    public void newtransactionSD() {
        if(paramShoebox.validerDate(tsxCaisse.getDate())){
        tsxCaisse.setCharteCompte((serviceSoco.rechercheParamCharteCompte(gsSoldeDepart.getSd().getTypeSolde())).getCharteCompte());
        tsxCaisse.setDescription(serviceSoco.rechercheParamCharteCompte(gsSoldeDepart.getSd().getTypeSolde()).getType());
        tsxCaisse.setCurrentuser(session.getUser());
        tsxCaisse.setCoop(session.getCurrentCoop());
        tsxCaisse.setDefPeriode(session.getCurrentPeriode());
        affectationTypetransactionSD();
        gsSoldeDepart.getSd().getLstTransactionSoldeDepart().add(tsxCaisse);
        serviceSolde.mergeSolde(gsSoldeDepart.getSd());
        tsxCaisse = new TransactionCaisse();
        }
    }

    private void affectationTypetransactionSD() {

        if (gsSoldeDepart.getSd().getTypeSolde().equals("rmbFP") || gsSoldeDepart.getSd().getTypeSolde().equals("rmbFI") || gsSoldeDepart.getSd().getTypeSolde().equals("rmbClient")) {
            tsxCaisse.setTypeTransaction("D");
        } else {
            tsxCaisse.setTypeTransaction("E");
        }
    }

    private void affectationTypetransactionCaisse() {

        if (gsCommande.getCommade().getType().equals("EPP") || gsCommande.getCommade().getType().equals("EPI")) {
            tsxCaisse.setTypeTransaction("D");
        } else {
            tsxCaisse.setTypeTransaction("E");
        }
    }

    public String newTransactionCharge(){
        if(paramShoebox.validerDate(tsxCaisseCharge.getDate())){
        tsxCaisseCharge.setTypeTransaction("D");
        tsxCaisseCharge.setCurrentuser(session.getUser());
         tsxCaisseCharge.setCoop(session.getCurrentCoop());
        tsxCaisseCharge.setDefPeriode(session.getCurrentPeriode());
        serviceGsCommande.newTransactionCharge(tsxCaisseCharge);
        tsxCaisse = new TransactionCaisse();
        return "lstTransactionCharge";
        }
        return null;
    }

    public List<TransactionCharge> getlstTransactionCharge(){
        return serviceGsCommande.lstCharges(session.getCurrentCoop(), session.getCurrentPeriode());
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

    /**
     * @return the tsxCaisseCharge
     */
    public TransactionCharge getTsxCaisseCharge() {
        return tsxCaisseCharge;
    }

    /**
     * @param tsxCaisseCharge the tsxCaisseCharge to set
     */
    public void setTsxCaisseCharge(TransactionCharge tsxCaisseCharge) {
        this.tsxCaisseCharge = tsxCaisseCharge;
    }
}
