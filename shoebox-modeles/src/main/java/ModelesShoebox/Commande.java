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
 * @author guigamehdi
 */
@Entity
public class Commande implements Serializable {
    private Long id;
    private String reference;
    private String type;
    private Date dateCommande;
    private List<TransactionMagasin> lsttransactionMagasin = new LinkedList<TransactionMagasin>();
    private List<TransactionCaisse> lsttransactionCaisse = new LinkedList<TransactionCaisse>();
    private Entite m_entite;
    private boolean confirmation = false;
    private Utilisateur currentuser;
    private DefinitionPeriode defPeriode;
    @Transient
    public float getmontantTotal() {
        float total = 0;
        for (TransactionMagasin t : lsttransactionMagasin) {
            total = total + (t.getPrixUnitaire() * t.getQuantite());
        }
        return total;
    }

    @Transient
    public float getmontantPaye(){
    float montatPaye = 0;
    for(TransactionCaisse tsx : getLsttransactionCaisse()){
        montatPaye = montatPaye + tsx.getMontant();
    }
        return montatPaye;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesShoebox.StockMagasinCoop[id=" + getId() + "]";
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
     * @return the lsttransactionMagasin
     */
    

    @OneToMany(cascade=CascadeType.ALL, mappedBy="m_commande")
    public List<TransactionMagasin> getLsttransactionMagasin() {
        return lsttransactionMagasin;
    }

    /**
     * @param lsttransactionMagasin the lsttransactionMagasin to set
     */
    public void setLsttransactionMagasin(List<TransactionMagasin> lsttransactionMagasin) {
        this.lsttransactionMagasin = lsttransactionMagasin;
    }




    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the confirmation
     */
    public boolean isConfirmation() {
        return confirmation;
    }

    /**
     * @param confirmation the confirmation to set
     */
    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    /**
     * @return the m_entite
     */
    @ManyToOne
    public Entite getM_entite() {
        return m_entite;
    }

    /**
     * @param m_entite the m_entite to set
     */
    public void setM_entite(Entite m_entite) {
        this.m_entite = m_entite;
    }

    
    /**
     * @return the dateCommande
     */
    @Temporal(value = javax.persistence.TemporalType.DATE)
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * @param dateCommande the dateCommande to set
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    /**
     * @return the lsttransactionCaisse
     */
    @OneToMany(cascade=CascadeType.ALL)
    public List<TransactionCaisse> getLsttransactionCaisse() {
        return lsttransactionCaisse;
    }

    /**
     * @param lsttransactionCaisse the lsttransactionCaisse to set
     */
    public void setLsttransactionCaisse(List<TransactionCaisse> lsttransactionCaisse) {
        this.lsttransactionCaisse = lsttransactionCaisse;
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
     * @return the lsttransactionCaisse
     */
    
}
