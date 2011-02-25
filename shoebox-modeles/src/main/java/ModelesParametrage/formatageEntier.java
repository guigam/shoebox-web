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
public class formatageEntier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int apresVirgule;
    private String curremcy;
    private String type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof formatageEntier)) {
            return false;
        }
        formatageEntier other = (formatageEntier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesParametrage.formatageEntier[id=" + id + "]";
    }

    /**
     * @return the curremcy
     */
    public String getCurremcy() {
        return curremcy;
    }

    /**
     * @param curremcy the curremcy to set
     */
    public void setCurremcy(String curremcy) {
        this.curremcy = curremcy;
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
     * @return the apresVirgule
     */
    public int getApresVirgule() {
        return apresVirgule;
    }

    /**
     * @param apresVirgule the apresVirgule to set
     */
    public void setApresVirgule(int apresVirgule) {
        this.apresVirgule = apresVirgule;
    }

}
