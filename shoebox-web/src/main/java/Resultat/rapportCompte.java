/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Resultat;

import ModelesShoebox.Entite;
import java.util.Date;

/**
 *
 * @author guigamehdi
 */
public class rapportCompte {
private Date date;
private String reference;
private Entite entite;
private String description;
private float montantTotal;
private float montantPaye;

public float getresteAPayer(){
    return getMontantTotal() - getMontantPaye();
}

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the entite
     */
    public Entite getEntite() {
        return entite;
    }

    /**
     * @param entite the entite to set
     */
    public void setEntite(Entite entite) {
        this.entite = entite;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the montantTotal
     */
    public float getMontantTotal() {
        return montantTotal;
    }

    /**
     * @param montantTotal the montantTotal to set
     */
    public void setMontantTotal(float montantTotal) {
        this.montantTotal = montantTotal;
    }

    /**
     * @return the montantPaye
     */
    public float getMontantPaye() {
        return montantPaye;
    }

    /**
     * @param montantPaye the montantPaye to set
     */
    public void setMontantPaye(float montantPaye) {
        this.montantPaye = montantPaye;
    }
}
