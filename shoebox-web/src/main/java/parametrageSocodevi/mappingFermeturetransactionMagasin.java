/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrageSocodevi;

import ModelesShoebox.TransactionMagasin;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author guiga
 */
public class mappingFermeturetransactionMagasin extends TransactionMagasin{
    private long qteReel;
    private float valueReel;

    /**
     * @return the qteReel
     */
    public long getQteReel() {
        return qteReel;
    }

    /**
     * @param qteReel the qteReel to set
     */
    public void setQteReel(long qteReel) {
        this.qteReel = qteReel;
    }

    /**
     * @return the valueReel
     */
    public float getValueReel() {
        return valueReel;
    }

    /**
     * @param valueReel the valueReel to set
     */
    public void setValueReel(float valueReel) {
        this.valueReel = valueReel;
    }



    
}
