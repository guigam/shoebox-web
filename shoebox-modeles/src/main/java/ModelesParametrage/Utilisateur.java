/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesParametrage;

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
import org.hibernate.event.PersistEvent;

/**
 *
 * @author guigamehdi
 */
@Entity
public class Utilisateur implements Serializable {
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
    private String username;
    private String password;
    private boolean etat;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Permission> lstpermission = new LinkedList<Permission>();
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesParametrage.Utilisateur[id=" + getId() + "]";
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the etat
     */
    public boolean isEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    /**
     * @return the lstpermission
     */
    public List<Permission> getLstpermission() {
        return lstpermission;
    }

    /**
     * @param lstpermission the lstpermission to set
     */
    public void setLstpermission(List<Permission> lstpermission) {
        this.lstpermission = lstpermission;
    }


   

}
