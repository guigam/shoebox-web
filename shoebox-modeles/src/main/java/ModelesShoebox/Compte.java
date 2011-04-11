/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesShoebox;

import ModelesParametrage.Utilisateur;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author guigamehdi
 */
@Entity
public class Compte implements Serializable {
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
    private String folio;
    private String typeCompte;
    private String nomCompte;
    private String description;
    private Utilisateur currentuser;
    private Cooperative coop;
   private List<TransactionCaisse> tsxCaisse = new LinkedList<TransactionCaisse>();

   @Transient
   public double getValeurtotalCompte(){
       double c = 0;
    for(TransactionCaisse t : tsxCaisse){
        if(t.getTypeTransaction().equals("E")){
            c = c + t.getMontant();
        }else if(t.getTypeTransaction().equals("D")){
            c = c - t.getMontant();
        }
    }
        return c;
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
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModelesShoebox.Compte[id=" + getId() + "]";
    }

    /**
     * @return the folio
     */
    public String getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * @return the typeCompte
     */
    public String getTypeCompte() {
        return typeCompte;
    }

    /**
     * @param typeCompte the typeCompte to set
     */
    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.description = Description;
    }

    /**
     * @return the tsxCaisse
     */
    @OneToMany(mappedBy = "compteEncaisse")
    public List<TransactionCaisse> getTsxCaisse() {
        return tsxCaisse;
    }

    /**
     * @param tsxCaisse the tsxCaisse to set
     */
    public void setTsxCaisse(List<TransactionCaisse> tsxCaisse) {
        this.tsxCaisse = tsxCaisse;
    }

    /**
     * @return the nomCompte
     */
    public String getNomCompte() {
        return nomCompte;
    }

    /**
     * @param nomCompte the nomCompte to set
     */
    public void setNomCompte(String nomCompte) {
        this.nomCompte = nomCompte;
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
