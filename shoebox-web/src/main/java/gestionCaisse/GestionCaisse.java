/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionCaisse;

import Login.login;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionCharge;
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

    /** Creates a new instance of gestionCaisse */
    public GestionCaisse() {
    }

    public void newtransactionCommande() {
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

    public void newtransactionSD() {
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

    private void affectationTypetransactionSD() {

        if (gsSoldeDepart.getSd().getTypeSolde().equals("rmbFP") || gsSoldeDepart.getSd().getTypeSolde().equals("rmbFI") || gsSoldeDepart.getSd().getTypeSolde().equals("rmbClient")) {
            tsxCaisse.setTypeTransaction("D");
        } else {
            tsxCaisse.setTypeTransaction("E");
        }
    }

    private void affectationTypetransactionCaisse() {

        if (gsCommande.getCommade().getType().equals("EP") || gsCommande.getCommade().getType().equals("EI")) {
            tsxCaisse.setTypeTransaction("D");
        } else {
            tsxCaisse.setTypeTransaction("E");
        }
    }

    public String newTransactionCharge(){
        tsxCaisseCharge.setTypeTransaction("D");
        tsxCaisseCharge.setCurrentuser(session.getUser());
         tsxCaisseCharge.setCoop(session.getCurrentCoop());
        tsxCaisseCharge.setDefPeriode(session.getCurrentPeriode());
        serviceGsCommande.newTransactionCharge(tsxCaisseCharge);
        tsxCaisse = new TransactionCaisse();
        return "lstTransactionCharge";
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
