/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelesShoebox;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

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
    private Long id;
    private float montant;
    private Entite entite;
    private String typeSolde;
    private Utilisateur currentuser;
    private List<TransactionCaisse> lstTransactionSoldeDepart = new LinkedList<TransactionCaisse>();
    private DefinitionPeriode defPeriode;
    private Date date;
private Cooperative coop;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    @Transient
    public float getMontantAbsolue(){
        if(montant < 0 ){
        return -montant;
        }
        return montant;
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
    @Transient
    public float getmontantPaye() {
        float somme = 0;
        for (TransactionCaisse tsx : getLstTransactionSoldeDepart()) {
            somme = somme + tsx.getMontant();
        }
        return somme;
    }
    @Transient
    public float getmontantrestant(){
        return getMontantAbsolue() - getmontantPaye();
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
    public float getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(float montant) {
        this.montant = montant;
    }

    /**
     * @return the entite
     */
    @OneToOne(cascade = CascadeType.ALL)
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
     * @return the typeSolde
     */
    public String getTypeSolde() {
        return typeSolde;
    }

    /**
     * @param typeSolde the typeSolde to set
     */
    public void setTypeSolde(String typeSolde) {
        this.typeSolde = typeSolde;
    }

    /**
     * @return the lstTransactionSoldeDepart
     */
    @OneToMany(cascade=CascadeType.ALL)
    public List<TransactionCaisse> getLstTransactionSoldeDepart() {
        return lstTransactionSoldeDepart;
    }

    /**
     * @param lstTransactionSoldeDepart the lstTransactionSoldeDepart to set
     */
    public void setLstTransactionSoldeDepart(List<TransactionCaisse> lstTransactionSoldeDepart) {
        this.lstTransactionSoldeDepart = lstTransactionSoldeDepart;
    }

    /**
     * @return the currentuser
     */
    @ManyToOne
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
    @OneToOne
    public DefinitionPeriode getDefPeriode() {
        return defPeriode;
    }

    /**
     * @param defPeriode the defPeriode to set
     */
    public void setDefPeriode(DefinitionPeriode defPeriode) {
        this.defPeriode = defPeriode;
    }



    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the date
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    /**
     * @return the coop
     */
    @ManyToOne
    public Cooperative getCoop() {
        return coop;
    }

    /**
     * @param coop the coop to set
     */
    public void setCoop(Cooperative coop) {
        this.coop = coop;
    }


}
