/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesShoebox;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author guigamehdi
 */
@Entity
public class TransactionCooperative extends Transaction {
   @OneToOne
   private Cooperative coop;
}
