/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionCommandes;

import ModelesShoebox.TransactionMagasin;

/**
 *
 * @author guigam
 */
public class ConfirmationCommande {
private TransactionMagasin tsxMag = new TransactionMagasin();
private int gradeSaisie = 0;
private float puSaisie = 0;
private int quantiteSaisie = 0;

    /**
     * @return the tsxMag
     */
    public TransactionMagasin getTsxMag() {
        return tsxMag;
    }

    /**
     * @param tsxMag the tsxMag to set
     */
    public void setTsxMag(TransactionMagasin tsxMag) {
        this.tsxMag = tsxMag;
    }

    /**
     * @return the gradeSaisie
     */
    public int getGradeSaisie() {
        return gradeSaisie;
    }

    /**
     * @param gradeSaisie the gradeSaisie to set
     */
    public void setGradeSaisie(int gradeSaisie) {
        this.gradeSaisie = gradeSaisie;
    }

    /**
     * @return the puSaisie
     */
    public float getPuSaisie() {
        return puSaisie;
    }

    /**
     * @param puSaisie the puSaisie to set
     */
    public void setPuSaisie(float puSaisie) {
        this.puSaisie = puSaisie;
    }

    /**
     * @return the quantiteSaisie
     */
    public int getQuantiteSaisie() {
        return quantiteSaisie;
    }

    /**
     * @param quantiteSaisie the quantiteSaisie to set
     */
    public void setQuantiteSaisie(int quantiteSaisie) {
        this.quantiteSaisie = quantiteSaisie;
    }
}
