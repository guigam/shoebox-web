/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesShoebox;

import javax.persistence.Entity;

/**
 *
 * @author guigamehdi
 */
@Entity
public class FournisseurProduit extends Entite {
    private String pointCollecte;
    private String statut;

    /**
     * @return the pointCollecte
     */
    public String getPointCollecte() {
        return pointCollecte;
    }

    /**
     * @param pointCollecte the pointCollecte to set
     */
    public void setPointCollecte(String pointCollecte) {
        this.pointCollecte = pointCollecte;
    }

    /**
     * @return the statut
     */
    public String getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }

}
