/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesShoebox;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author guigamehdi
 */
@Entity
public class TransactionCharge extends TransactionCaisse {
   @ManyToOne
   private CategorieCharge categorieCharge;

    /**
     * @return the categorieCharge
     */
    public CategorieCharge getCategorieCharge() {
        return categorieCharge;
    }

    /**
     * @param categorieCharge the categorieCharge to set
     */
    public void setCategorieCharge(CategorieCharge categorieCharge) {
        this.categorieCharge = categorieCharge;
    }
}
