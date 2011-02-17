/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesShoebox;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author guigam
 */
@Entity
public class SoldeDepart implements Serializable {
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
    private float montant;
    @OneToOne(cascade=CascadeType.ALL)
    private Entite entite;
    @OneToMany
    private List<TransactionCaisse> lstTransactionSoldeDepart = new LinkedList<TransactionCaisse>();

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
        if (!(object instanceof SoldeDepart)) {
            return false;
        }
        SoldeDepart other = (SoldeDepart) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesShoebox.SoldeDepart[id=" + getId() + "]";
    }

    /**
     * @return the montant
     */
    public float   getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(float   montant) {
        this.montant = montant;
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
     * @return the lstTransactionSoldeDepart
     */
    public List<TransactionCaisse> getLstTransactionSoldeDepart() {
        return lstTransactionSoldeDepart;
    }

    /**
     * @param lstTransactionSoldeDepart the lstTransactionSoldeDepart to set
     */
    public void setLstTransactionSoldeDepart(List<TransactionCaisse> lstTransactionSoldeDepart) {
        this.lstTransactionSoldeDepart = lstTransactionSoldeDepart;
    }

 
}
