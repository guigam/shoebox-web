/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package soldeDepart;

import ModelesShoebox.SoldeDepart;
import ModelesShoebox.TransactionCaisse;

/**
 *
 * @author guigamehdi
 */
public class solde {
    private SoldeDepart soldeDepart = new SoldeDepart();
    
    private float montantPaye;
    private String etat;

    /**
     * @return the soldeDepart
     */
    public SoldeDepart getSoldeDepart() {
        return soldeDepart;
    }

    /**
     * @param soldeDepart the soldeDepart to set
     */
    public void setSoldeDepart(SoldeDepart soldeDepart) {
        this.soldeDepart = soldeDepart;
    }



    /**
     * @return the montantPaye
     */
    public float getMontantPaye() {
        for(TransactionCaisse tsx : soldeDepart.getLstTransactionSoldeDepart()){
                montantPaye = montantPaye + tsx.getMontant();
        }

        return montantPaye;
    }

    /**
     * @param montantPaye the montantPaye to set
     */
    public void setMontantPaye(float montantPaye) {
        this.montantPaye = montantPaye;
    }

    /**
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

}
