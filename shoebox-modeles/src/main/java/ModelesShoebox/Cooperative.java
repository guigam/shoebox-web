/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesShoebox;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.ParamTransaction;
import ModelesParametrage.Utilisateur;
import ModelesParametrage.formatageEntier;
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
 * @author guigamehdi
 */
@Entity
public class Cooperative implements Serializable {
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
    private String name;
    private String reference;
    private String pays;
    private String linkLogo;
    @OneToMany(mappedBy="cooperative",cascade=CascadeType.ALL)
   private  List<Utilisateur> lstutilisateur = new LinkedList<Utilisateur>();
    @OneToMany(mappedBy="coop",cascade=CascadeType.ALL)
    private List<DefinitionPeriode> lstDef = new LinkedList<DefinitionPeriode>();
    @OneToMany(mappedBy="coop",cascade=CascadeType.ALL)
private List<formatageEntier> lstFormatEntier = new LinkedList<formatageEntier>();
    @OneToMany(mappedBy="coop", cascade=CascadeType.ALL)
    private List<ParamTransaction> lstParametrage = new LinkedList<ParamTransaction>();
    @OneToMany(mappedBy="cooperative", cascade=CascadeType.ALL)
    private List<CategorieCharge> lstCategCharge = new LinkedList<CategorieCharge>();
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
        if (!(object instanceof Cooperative)) {
            return false;
        }
        Cooperative other = (Cooperative) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesShoebox.Cooperative[id=" + getId() + "]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the lstutilisateur
     */
    public List<Utilisateur> getLstutilisateur() {
        return lstutilisateur;
    }

    /**
     * @param lstutilisateur the lstutilisateur to set
     */
    public void setLstutilisateur(List<Utilisateur> lstutilisateur) {
        this.lstutilisateur = lstutilisateur;
    }

    /**
     * @return the pays
     */
    public String getPays() {
        return pays;
    }

    /**
     * @param pays the pays to set
     */
    public void setPays(String pays) {
        this.pays = pays;
    }

    /**
     * @return the linkLogo
     */
    public String getLinkLogo() {
        return linkLogo;
    }

    /**
     * @param linkLogo the linkLogo to set
     */
    public void setLinkLogo(String linkLogo) {
        this.linkLogo = linkLogo;
    }

    /**
     * @return the lstDef
     */
    public List<DefinitionPeriode> getLstDef() {
        return lstDef;
    }

    /**
     * @param lstDef the lstDef to set
     */
    public void setLstDef(List<DefinitionPeriode> lstDef) {
        this.lstDef = lstDef;
    }

    /**
     * @return the lstFormatEntier
     */
    public List<formatageEntier> getLstFormatEntier() {
        return lstFormatEntier;
    }

    /**
     * @param lstFormatEntier the lstFormatEntier to set
     */
    public void setLstFormatEntier(List<formatageEntier> lstFormatEntier) {
        this.lstFormatEntier = lstFormatEntier;
    }

    /**
     * @return the lstParametrage
     */
    public List<ParamTransaction> getLstParametrage() {
        return lstParametrage;
    }

    /**
     * @param lstParametrage the lstParametrage to set
     */
    public void setLstParametrage(List<ParamTransaction> lstParametrage) {
        this.lstParametrage = lstParametrage;
    }

    /**
     * @return the lstCategCharge
     */
    public List<CategorieCharge> getLstCategCharge() {
        return lstCategCharge;
    }

    /**
     * @param lstCategCharge the lstCategCharge to set
     */
    public void setLstCategCharge(List<CategorieCharge> lstCategCharge) {
        this.lstCategCharge = lstCategCharge;
    }


  
}
