/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gfplus.parametrageShoebox;

import Login.login;
import ModelesShoebox.Compte;
import ModelesShoebox.Magasin;
import ModelesShoebox.Produit;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionMagasin;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import parametrageCoop.serviceParamCoopLocal;
import parametrageSocodevi.ServiceParamSocoLocal;

/**
 *
 * @author guigam
 */
@Named
@ConversationScoped
public class ConfigMag implements Serializable{
       @Inject
    private login session;
    @EJB
    private ServiceParamSocoLocal serviceSoco;
    @Inject
    Conversation conversation;
     @EJB
    private serviceParamCoopLocal parametrageCoop;
private Produit produit;
private long grade;
private long quantite;
private float montant;
private Magasin magasin;
private Compte compteEncaisse;

public String beginConfMag(){
conversation.begin();
return "/parametrageCoop/configurationMagasin";
}

public String endConfMag(){
    conversation.end();
return "/parametrageCoop/listMagasin";
}

public String newInitMagasinConfig() {
            TransactionCaisse tsxc = new TransactionCaisse();
            TransactionMagasin tsxm = new TransactionMagasin();
            if(this.getProduit().getType().equals("Principal")){
                tsxc.setCoop(session.getCurrentCoop());
                tsxc.setCharteCompte(serviceSoco.charteCompteByReference("RA-1-SD"));
                tsxc.setCoop(session.getCurrentCoop());
                tsxc.setDefPeriode(session.getCurrentPeriode());
                tsxc.setMontant(this.getMontant());
                tsxc.setCurrentuser(session.getUser());
                tsxc.setCompteEncaisse(compteEncaisse);
                magasin.getLstTransCaisse().add(tsxc);
                parametrageCoop.updateMagasin(magasin);
                
                 
                
            }else if(this.getProduit().getType().equals("Secondaire")){
                tsxc.setCoop(session.getCurrentCoop());
                tsxc.setCharteCompte(serviceSoco.charteCompteByReference("RA-2-SD"));
                tsxc.setCoop(session.getCurrentCoop());
                tsxc.setDefPeriode(session.getCurrentPeriode());
                tsxc.setMontant(this.getMontant());
                tsxc.setCurrentuser(session.getUser());
                tsxc.setCompteEncaisse(compteEncaisse);
                magasin.getLstTransCaisse().add(tsxc);
                parametrageCoop.updateMagasin(magasin);
            }else{
                tsxc.setCoop(session.getCurrentCoop());
              tsxc.setCharteCompte(serviceSoco.charteCompteByReference("RC-SD"));
                tsxc.setCoop(session.getCurrentCoop());
                tsxc.setDefPeriode(session.getCurrentPeriode());
                tsxc.setMontant(this.getMontant());
                tsxc.setCurrentuser(session.getUser());
                tsxc.setCompteEncaisse(compteEncaisse);
               magasin.getLstTransCaisse().add(tsxc);
                parametrageCoop.updateMagasin(magasin);
            }
            tsxm.setDefPeriode(session.getCurrentPeriode());
            tsxm.setCoop(session.getCurrentCoop());
            tsxm.setMagasin(this.magasin);
            tsxm.setGrade(this.getGrade());
            tsxm.setProduit(this.getProduit());
            tsxm.setQuantite(this.getQuantite());
            tsxm.setCurrentuser(session.getUser());
            serviceSoco.addTransactionMagasin(tsxm);
            conversation.end();
        return "/parametrageCoop/listMagasin";
        }


public List<TransactionMagasin> lstTsxMag(){
    System.out.print(session.getCurrentPeriode().getId());
    return serviceSoco.lstTsxMagByMagasin(magasin);
}

    /**
     * @return the produit
     */
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
     * @return the grade
     */
    public long getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(long grade) {
        this.grade = grade;
    }

    /**
     * @return the montant
     */
    public float getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(float montant) {
        this.montant = montant;
    }

    /**
     * @return the quantite
     */
    public long getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(long quantite) {
        this.quantite = quantite;
    }

    /**
     * @return the magasin
     */
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
     * @return the compteEncaisse
     */
    public Compte getCompteEncaisse() {
        return compteEncaisse;
    }

    /**
     * @param compteEncaisse the compteEncaisse to set
     */
    public void setCompteEncaisse(Compte compteEncaisse) {
        this.compteEncaisse = compteEncaisse;
    }
}
