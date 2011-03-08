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
import javax.persistence.Table;

/**
 *
 * @author guigam
 */
@Entity
@Table(name = "structureProduit")

public class StructureProduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @Column(name = "referenceAffichage")
    private String referenceAffichage;
    @Basic(optional = false)
    @Column(name = "activite")
    private String activite;

    public StructureProduit() {
    }

    public StructureProduit(String id) {
        this.id = id;
    }

    public StructureProduit(String id, String reference, String referenceAffichage, String activite) {
        this.id = id;
        this.reference = reference;
        this.referenceAffichage = referenceAffichage;
        this.activite = activite;
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

    public String getReferenceAffichage() {
        return referenceAffichage;
    }

    public void setReferenceAffichage(String referenceAffichage) {
        this.referenceAffichage = referenceAffichage;
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
        if (!(object instanceof StructureProduit)) {
            return false;
        }
        StructureProduit other = (StructureProduit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesParametrage.StructureProduit[id=" + id + "]";
    }

}
