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
    private Long SommequantiteEntree;
    private Long SommequantiteSortis;
    private int quantiteSaisie;
    private float pu;

    public StockSortieProduit() {
    }


    public Long getCalculstock(){
        return SommequantiteEntree - SommequantiteSortis;
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
     * @return the SommequantiteEntree
     */
    public Long getSommequantiteEntree() {
        return SommequantiteEntree;
    }

    /**
     * @param SommequantiteEntree the SommequantiteEntree to set
     */
    public void setSommequantiteEntree(Long SommequantiteEntree) {
        this.SommequantiteEntree = SommequantiteEntree;
    }

    /**
     * @return the SommequantiteSortis
     */
    public Long getSommequantiteSortis() {
        return SommequantiteSortis;
    }

    /**
     * @param SommequantiteSortis the SommequantiteSortis to set
     */
    public void setSommequantiteSortis(Long SommequantiteSortis) {
        this.SommequantiteSortis = SommequantiteSortis;
    }
    

}
