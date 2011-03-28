/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesParametrage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author guigam
 */
@Entity
@Table(name = "StructureCharge")
@NamedQueries({
    @NamedQuery(name = "StructureCharge.findAll", query = "SELECT s FROM StructureCharge s")})
public class StructureCharge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "Reference")
    private String reference;
    @Column(name = "refereaffichage")
    private String refereaffichage;
    @Column(name = "activite")
    private String activite;

    public StructureCharge() {
    }

    public StructureCharge(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRefereaffichage() {
        return refereaffichage;
    }

    public void setRefereaffichage(String refereaffichage) {
        this.refereaffichage = refereaffichage;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StructureCharge)) {
            return false;
        }
        StructureCharge other = (StructureCharge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesParametrage.StructureCharge[id=" + id + "]";
    }

}
