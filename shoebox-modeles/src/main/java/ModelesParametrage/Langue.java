/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesParametrage;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author guigamehdi
 */
@Entity
public class Langue implements Serializable {
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
    @OneToMany(mappedBy="langue")
    private List<Dictionnaire> lstDetailLangue= new LinkedList<Dictionnaire>();
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
        if (!(object instanceof Langue)) {
            return false;
        }
        Langue other = (Langue) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesParametrage.langue[id=" + getId() + "]";
    }

    /**
     * @return the lstDetailLangue
     */
    public List<Dictionnaire> getLstDetailLangue() {
        return lstDetailLangue;
    }

    /**
     * @param lstDetailLangue the lstDetailLangue to set
     */
    public void setLstDetailLangue(List<Dictionnaire> lstDetailLangue) {
        this.setLstDetailLangue(lstDetailLangue);
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

  

}
