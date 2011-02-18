/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionCommandes;

import ModelesShoebox.Magasin;

/**
 *
 * @author guigam
 */
public class StockSortieProduit {
    private Magasin magasin = new Magasin();
    private Long quantite;
   
    private int quantiteSaisie;
    private float pu;

    public StockSortieProduit() {
    }



    /**
     * @return the magasin
     */
    public Magasin getMagasin() {
        return magasin;
    }

    /**
     * @param magasin the magasin to set
     */
    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
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

    /**
     * @return the pu
     */
    public float getPu() {
        return pu;
    }

    /**
     * @param pu the pu to set
     */
    public void setPu(float pu) {
        this.pu = pu;
    }

    /**
     * @return the quantite
     */
    public Long getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }


    

}
