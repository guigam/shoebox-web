/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gfplus.parametrageShoebox;

import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionMagasin;
import javax.transaction.Transaction;

/**
 *
 * @author guigam
 */
public class ConfigMag {
    private TransactionMagasin tsxMag = new TransactionMagasin();
    private TransactionCaisse tsxCaisse = new TransactionCaisse();

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
     * @return the tsxCaisse
     */
    public TransactionCaisse getTsxCaisse() {
        return tsxCaisse;
    }

    /**
     * @param tsxCaisse the tsxCaisse to set
     */
    public void setTsxCaisse(TransactionCaisse tsxCaisse) {
        this.tsxCaisse = tsxCaisse;
    }

}
