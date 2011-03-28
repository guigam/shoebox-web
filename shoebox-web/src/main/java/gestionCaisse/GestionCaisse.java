/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionCaisse;

import Login.login;
import ModelesShoebox.TransactionAvanceProduit;
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
import javax.faces.event.ValueChangeEvent;
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
    private TransactionAvanceProduit tsxCaisseAvanceProduit = new TransactionAvanceProduit();
    private List<TransactionCaisse> lstTsxCaisse = new LinkedList<TransactionCaisse>();
    private String typeRemboursement = null;
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

    public String newtransactionCommande() {
        if (validerTransaction(tsxCaisse.getDate(), gsCommande.getCommade().getDateCommande(), tsxCaisse.getMontant(), gsCommande.getCommade().getmontantrestant())) {
            tsxCaisse.setCharteCompte((serviceSoco.rechercheParamCharteCompte(gsCommande.getCommade().getType())).getCharteCompte());
            tsxCaisse.setDescription((serviceSoco.rechercheParamCharteCompte(gsCommande.getCommade().getType())).getType());
            tsxCaisse.setCurrentuser(session.getUser());
            tsxCaisse.setCoop(session.getCurrentCoop());
            tsxCaisse.setDefPeriode(session.getCurrentPeriode());
            affectationTypetransactionCaisse();
            gsCommande.getCommade().getLsttransactionCaisse().add(tsxCaisse);
            serviceGsCommande.mergeCommande(gsCommande.getCommade());
            tsxCaisse = new TransactionCaisse();
            return "/caisse/menuCaisse.xhtml";
        }
        return null;
    }

    public void payerRestant(){
            tsxCaisse.setMontant(gsCommande.getCommade().getmontantrestant());
    }
    public void resetMontant(){
            tsxCaisse.setMontant(0);
    }

    private boolean validerTransaction(Date datetsx, Date dateOrigine, float montant, float montantRestant) {
        if (!paramShoebox.validerDate(datetsx)) {
            return false;
        } else if (montant > montantRestant) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "montant saisie incorrect", null);
            FacesContext.getCurrentInstance().addMessage("montant saisie", msg);
            return false;
        } else if (dateOrigine.after(datetsx)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Date transaction ne doit pas etre inferieur a la date de la commande",null);
            FacesContext.getCurrentInstance().addMessage("date", msg);
            return false;
        }
        return true;
    }
    private boolean validerTransactionSD(Date datetsx, Date dateOrigine, float montant, float montantRestant) {
        if (!paramShoebox.validerDate(datetsx)) {
            return false;
        } else if (montant > montantRestant) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "montant saisie incorrect", null);
            FacesContext.getCurrentInstance().addMessage("montant saisie", msg);
            return false;
        } 
        return true;
    }

    public String newtransactionSD() {
        if (validerTransactionSD(tsxCaisse.getDate(), gsSoldeDepart.getSd().getDate(), tsxCaisse.getMontant(), gsSoldeDepart.getSd().getmontantrestant())) {
            tsxCaisse.setCharteCompte((serviceSoco.rechercheParamCharteCompte(gsSoldeDepart.getSd().getTypeSolde())).getCharteCompte());
            tsxCaisse.setDescription(serviceSoco.rechercheParamCharteCompte(gsSoldeDepart.getSd().getTypeSolde()).getType());
            tsxCaisse.setCurrentuser(session.getUser());
            tsxCaisse.setCoop(session.getCurrentCoop());
            tsxCaisse.setDefPeriode(session.getCurrentPeriode());
            affectationTypetransactionSD();
            gsSoldeDepart.getSd().getLstTransactionSoldeDepart().add(tsxCaisse);
            serviceSolde.mergeSolde(gsSoldeDepart.getSd());
            tsxCaisse = new TransactionCaisse();
            return "/caisse/menuCaisse.xhtml";
        }
        return null;
    }

    private void affectationTypetransactionSD() {

        if (gsSoldeDepart.getSd().getTypeSolde().equals("rmbFP") || gsSoldeDepart.getSd().getTypeSolde().equals("rmbFI") || gsSoldeDepart.getSd().getTypeSolde().equals("rmbClient")) {
            tsxCaisse.setTypeTransaction("D");
        } else {
            tsxCaisse.setTypeTransaction("E");
        }
    }

    private void affectationTypetransactionCaisse() {
        if (gsCommande.getCommade().getType().equals("EPP") || gsCommande.getCommade().getType().equals("EPS") || gsCommande.getCommade().getType().equals("EPI")) {
            tsxCaisse.setTypeTransaction("D");
        } else {
            tsxCaisse.setTypeTransaction("E");
        }
    }

    public String newTransactionCharge() {
        if (paramShoebox.validerDate(tsxCaisseCharge.getDate())) {
            tsxCaisseCharge.setTypeTransaction("D");
            tsxCaisseCharge.setCurrentuser(session.getUser());
            tsxCaisseCharge.setCoop(session.getCurrentCoop());
            tsxCaisseCharge.setDefPeriode(session.getCurrentPeriode());
            serviceGsCommande.newTransactionCharge(tsxCaisseCharge);
            tsxCaisseCharge = new TransactionCharge();
            return "lstTransactionCharge";
        }
        return null;
    }
    public String newTransactionAvanceproduit() {
        if(paramShoebox.validerDate(tsxCaisseAvanceProduit.getDate())) {
            tsxCaisseAvanceProduit.setTypeTransaction("E");
            tsxCaisseAvanceProduit.setCurrentuser(session.getUser());
            tsxCaisseAvanceProduit.setCoop(session.getCurrentCoop());
            tsxCaisseAvanceProduit.setDefPeriode(session.getCurrentPeriode());
            serviceGsCommande.newTransactionAvanceProduit(tsxCaisseAvanceProduit);
            tsxCaisseAvanceProduit = new TransactionAvanceProduit();
            return "/caisse/addAvanceProduit.xhtml";
        }
        return null;
    }

    public List<TransactionCharge> getlstTransactionCharge() {
        return serviceGsCommande.lstCharges(session.getCurrentCoop());
    }
    
    public List<TransactionAvanceProduit> getlstTransactionAvanceProduit() {
        return serviceGsCommande.lstAvanceProduit(session.getCurrentCoop());
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

    /**
     * @return the tsxCaisseAvanceProduit
     */
    public TransactionAvanceProduit getTsxCaisseAvanceProduit() {
        return tsxCaisseAvanceProduit;
    }

    /**
     * @param tsxCaisseAvanceProduit the tsxCaisseAvanceProduit to set
     */
    public void setTsxCaisseAvanceProduit(TransactionAvanceProduit tsxCaisseAvanceProduit) {
        this.tsxCaisseAvanceProduit = tsxCaisseAvanceProduit;
    }

    /**
     * @return the typeRemboursement
     */
    public String getTypeRemboursement() {
        return typeRemboursement;
    }

    /**
     * @param typeRemboursement the typeRemboursement to set
     */
    public void setTypeRemboursement(String typeRemboursement) {
        this.typeRemboursement = typeRemboursement;
         if(typeRemboursement.equals("Payer montant restant")){
            tsxCaisse.setMontant(gsCommande.getCommade().getmontantrestant());
        }else{
        tsxCaisse.setMontant(0);
        }
    }
}
