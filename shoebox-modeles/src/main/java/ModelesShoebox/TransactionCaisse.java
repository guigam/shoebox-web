/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesShoebox;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author guigamehdi
 */
@Entity
public class TransactionCaisse implements Serializable {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private int montant;
    private String typeTransaction;
    private String description;
    @ManyToOne
    private Utilisateur currentuser;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    @ManyToOne
    private CharteCompte charteCompte;
    @ManyToOne
    private Compte compteEncaisse;
     @OneToOne
    private DefinitionPeriode defPeriode;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionCaisse)) {
            return false;
        }
        TransactionCaisse other = (TransactionCaisse) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesShoebox.Transaction[id=" + getId() + "]";
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
     * @return the montant
     */
    public int getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(int montant) {
        this.montant = montant;
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
     * @return the charteCompte
     */
    public CharteCompte getCharteCompte() {
        return charteCompte;
    }

    /**
     * @param charteCompte the charteCompte to set
     */
    public void setCharteCompte(CharteCompte charteCompte) {
        this.charteCompte = charteCompte;
    }

    /**
     * @return the typeTransaction
     */
    public String getTypeTransaction() {
        return typeTransaction;
    }

    /**
     * @param typeTransaction the typeTransaction to set
     */
    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
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
     * @return the compteEncaisse
     */
    public Compte getCompteEncaisse() {
        return compteEncaisse;
    }

    /**
     * @param compteEncaisse the compteEncaisse to set
     */
    public void setCompteEncaisse(Compte compteEncaisse) {
        this.compteEncaisse = compteEncaisse;
    }

    /**
     * @return the currentuser
     */
    public Utilisateur getCurrentuser() {
        return currentuser;
    }

    /**
     * @param currentuser the currentuser to set
     */
    public void setCurrentuser(Utilisateur currentuser) {
        this.currentuser = currentuser;
    }

    /**
     * @return the defPeriode
     */
    public DefinitionPeriode getDefPeriode() {
        return defPeriode;
    }

    /**
     * @param defPeriode the defPeriode to set
     */
    public void setDefPeriode(DefinitionPeriode defPeriode) {
        this.defPeriode = defPeriode;
    }



}
