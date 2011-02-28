/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesParametrage;

import ModelesShoebox.Cooperative;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author guigamehdi
 */
@Entity
public class DefinitionPeriode implements Serializable {
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
    private String periode;
    private String mois;
    private int numMois;
    private boolean periodeActif;
    @ManyToOne
    private Cooperative cooperative;
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
        if (!(object instanceof DefinitionPeriode)) {
            return false;
        }
        DefinitionPeriode other = (DefinitionPeriode) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesParametrage.DefinitionPeriode[id=" + getId() + "]";
    }

    /**
     * @return the periode
     */
    public String getPeriode() {
        return periode;
    }

    /**
     * @param periode the periode to set
     */
    public void setPeriode(String periode) {
        this.periode = periode;
    }

    /**
     * @return the mois
     */
    public String getMois() {
        return mois;
    }

    /**
     * @param mois the mois to set
     */
    public void setMois(String mois) {
        this.mois = mois;
    }

    /**
     * @return the numMois
     */
    public int getNumMois() {
        return numMois;
    }

    /**
     * @param numMois the numMois to set
     */
    public void setNumMois(int numMois) {
        this.numMois = numMois;
    }


    /**
     * @return the periodeActif
     */
    public boolean isPeriodeActif() {
        return periodeActif;
    }

    /**
     * @param periodeActif the periodeActif to set
     */
    public void setPeriodeActif(boolean periodeActif) {
        this.periodeActif = periodeActif;
    }

    /**
     * @return the cooperative
     */
    public Cooperative getCooperative() {
        return cooperative;
    }

    /**
     * @param cooperative the cooperative to set
     */
    public void setCooperative(Cooperative cooperative) {
        this.cooperative = cooperative;
    }

}
