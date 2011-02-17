/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soldeDepart;

import ModelesShoebox.SoldeDepart;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import serviceSoldeDepart.serviceSoldeDepartLocal;

/**
 *
 * @author guigamehdi
 */
@Named(value = "gsSoldeDepart")
@RequestScoped
public class gestionSoldeDepart {
    
    @EJB
    private serviceSoldeDepartLocal serviceSoldeDepart;

    /** Creates a new instance of NewJSFManagedBean */
    public gestionSoldeDepart() {
    }

    public List<solde> getlstRemboursementFP() {
     List<solde> lstSolde = new ArrayList<solde>();
        for(SoldeDepart mysolde : serviceSoldeDepart.remboursementFP()){
            solde monsolde = new solde();
            monsolde.setSoldeDepart(mysolde);
            lstSolde.add(monsolde);
        }
        return lstSolde;
    }

    public List<solde> getlstRemboursementFI() {
        List<solde> lstSolde = new ArrayList<solde>();
        for(SoldeDepart mysolde : serviceSoldeDepart.remboursementFI()){
            solde monsolde = new solde();
            monsolde.setSoldeDepart(mysolde);
            lstSolde.add(monsolde);
        }
        return lstSolde;
    }

    public List<solde> getlstRemboursementClient() {
        List<solde> lstSolde = new ArrayList<solde>();
        for(SoldeDepart mysolde : serviceSoldeDepart.remboursementClient()){
            solde monsolde = new solde();
            monsolde.setSoldeDepart(mysolde);
            lstSolde.add(monsolde);
        }
        return lstSolde;
    }

    public List<solde> getlstDetteFP() {
       List<solde> lstSolde = new ArrayList<solde>();
        for(SoldeDepart mysolde : serviceSoldeDepart.dettesFP()){
            solde monsolde = new solde();
            monsolde.setSoldeDepart(mysolde);
            lstSolde.add(monsolde);
        }
        return lstSolde;
    }

    public List<solde> getlstDetteFI() {
         List<solde> lstSolde = new ArrayList<solde>();
        for(SoldeDepart mysolde : serviceSoldeDepart.dettesFI()){
            solde monsolde = new solde();
            monsolde.setSoldeDepart(mysolde);
            lstSolde.add(monsolde);
        }
        return lstSolde;
    }

    public List<solde> getlstDetteClient() {
         List<solde> lstSolde = new ArrayList<solde>();
        for(SoldeDepart mysolde : serviceSoldeDepart.dettesClient()){
            solde monsolde = new solde();
            monsolde.setSoldeDepart(mysolde);
            lstSolde.add(monsolde);
        }
        return lstSolde;
    }

}
