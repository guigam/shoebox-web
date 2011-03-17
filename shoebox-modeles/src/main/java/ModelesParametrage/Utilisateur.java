/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesParametrage;

import ModelesShoebox.Commande;
import ModelesShoebox.Compte;
import ModelesShoebox.Cooperative;
import ModelesShoebox.Magasin;
import ModelesShoebox.Produit;
import ModelesShoebox.SoldeDepart;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionMagasin;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
    private String fonction;
    private String langue;
    private boolean etat;
    @ManyToOne
    private Cooperative cooperative;
    @OneToMany(mappedBy="currentuser",cascade=CascadeType.ALL)
    private List<Commande> lstCommande = new LinkedList<Commande>();
    @OneToMany(mappedBy="currentuser")
    private List<Compte> lstCompte = new LinkedList<Compte>();
    @OneToMany(mappedBy="currentuser")
    private List<Magasin> lstMagasin = new LinkedList<Magasin>();
    @OneToMany(mappedBy="currentuser")
    private List<Produit> lstProduit = new LinkedList<Produit>();
    @OneToMany(mappedBy="currentuser")
    private List<SoldeDepart> lstSoldeDepart = new LinkedList<SoldeDepart>();
    @OneToMany(mappedBy="currentuser")
    private List<TransactionCaisse> lsttransactionCaisse = new LinkedList<TransactionCaisse>();
    @OneToMany(mappedBy="currentuser")
    private List<TransactionMagasin> lstTransactionMagasin = new LinkedList<TransactionMagasin>();
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Permission> lstPermission = new LinkedList<Permission>() ;
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
     * @return the lstCommande
     */
    public List<Commande> getLstCommande() {
        return lstCommande;
    }

    /**
     * @param lstCommande the lstCommande to set
     */
    public void setLstCommande(List<Commande> lstCommande) {
        this.lstCommande = lstCommande;
    }

    /**
     * @return the lstCompte
     */
    public List<Compte> getLstCompte() {
        return lstCompte;
    }

    /**
     * @param lstCompte the lstCompte to set
     */
    public void setLstCompte(List<Compte> lstCompte) {
        this.lstCompte = lstCompte;
    }

   
    /**
     * @return the lstMagasin
     */
    public List<Magasin> getLstMagasin() {
        return lstMagasin;
    }

    /**
     * @param lstMagasin the lstMagasin to set
     */
    public void setLstMagasin(List<Magasin> lstMagasin) {
        this.lstMagasin = lstMagasin;
    }

    /**
     * @return the lstProduit
     */
    public List<Produit> getLstProduit() {
        return lstProduit;
    }

    /**
     * @param lstProduit the lstProduit to set
     */
    public void setLstProduit(List<Produit> lstProduit) {
        this.lstProduit = lstProduit;
    }

    /**
     * @return the lstSoldeDepart
     */
    public List<SoldeDepart> getLstSoldeDepart() {
        return lstSoldeDepart;
    }

    /**
     * @param lstSoldeDepart the lstSoldeDepart to set
     */
    public void setLstSoldeDepart(List<SoldeDepart> lstSoldeDepart) {
        this.lstSoldeDepart = lstSoldeDepart;
    }

    /**
     * @return the lsttransactionCaisse
     */
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
     * @return the lstTransactionMagasin
     */
    public List<TransactionMagasin> getLstTransactionMagasin() {
        return lstTransactionMagasin;
    }

    /**
     * @param lstTransactionMagasin the lstTransactionMagasin to set
     */
    public void setLstTransactionMagasin(List<TransactionMagasin> lstTransactionMagasin) {
        this.lstTransactionMagasin = lstTransactionMagasin;
    }

  
   

    /**
     * @return the lstPermission
     */
    public List<Permission> getLstPermission() {
        return lstPermission;
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

    /**
     * @return the fonction
     */
    public String getFonction() {
        return fonction;
    }

    /**
     * @param fonction the fonction to set
     */
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }


    /**
     * @return the langue
     */
    public String getLangue() {
        return langue;
    }

    /**
     * @param langue the langue to set
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }

    /**
     * @param lstPermission the lstPermission to set
     */
    public void setLstPermission(List<Permission> lstPermission) {
        this.lstPermission = lstPermission;
    }


   

}
