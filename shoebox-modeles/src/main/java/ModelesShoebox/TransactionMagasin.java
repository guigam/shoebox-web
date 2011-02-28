/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesShoebox;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.Utilisateur;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author guigam
 */
@Entity
public class TransactionMagasin implements Serializable {
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
    private Magasin magasin;
    private Produit produit;
    private int grade;
    private int humidite;
    private int quantite;
    private float prixUnitaire;
    private int type; //1 = produit ,  2 = intrant
    private Commande m_commande;
    private Utilisateur currentuser;
    private DefinitionPeriode defPeriode;
private Cooperative coop;
    @Transient
    public float getCalculMontant(){

        return quantite * prixUnitaire;
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
        if (!(object instanceof TransactionMagasin)) {
            return false;
        }
        TransactionMagasin other = (TransactionMagasin) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesShoebox.TransactionMagasin[id=" + getId() + "]";
    }

 

    /**
     * @return the magasin
     */
    @ManyToOne
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
     * @return the produit
     */
    @ManyToOne
    public Produit getProduit() {
        return produit;
    }

    /**
     * @param produit the produit to set
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    /**
     * @return the quantite
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * @return the humidite
     */
    public int getHumidite() {
        return humidite;
    }

    /**
     * @param humidite the humidite to set
     */
    public void setHumidite(int humidite) {
        this.humidite = humidite;
    }

    /**
     * @return the prixUnitaire
     */
    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    /**
     * @param prixUnitaire the prixUnitaire to set
     */
    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the m_commande
     */
    @ManyToOne
    public Commande getM_commande() {
        return m_commande;
    }

    /**
     * @param m_commande the m_commande to set
     */
    public void setM_commande(Commande m_commande) {
        this.m_commande = m_commande;
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
