/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Login;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.Permission;
import ModelesParametrage.Utilisateur;
import ModelesParametrage.formatageEntier;
import ModelesShoebox.Cooperative;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import parametrageSocodevi.GestionParametrageSoco;
import parametrageSocodevi.ServiceParamSocoLocal;

/**
 *
 * @author guigam
 */
@Named(value="gsLogin")
@SessionScoped
public class login implements Serializable{
    private List<Permission> lstPermission = new LinkedList<Permission>();
    private Utilisateur user = new Utilisateur();
    private DefinitionPeriode currentPeriode = new DefinitionPeriode();
    private Cooperative currentCoop = new Cooperative();
    private formatageEntier currentFormatDevise = new formatageEntier();
    private formatageEntier currentFormatUnite = new formatageEntier();
    private String verifMDP = null;
    @EJB
    private ServiceParamSocoLocal serviceparamSoco;
    @EJB
    private ServiceParamSocoLocal test;
    @Inject
    private GestionParametrageSoco paramSoco;
    /** Creates a new instance of login */
    public login() {

    }
    public List<Permission> getlstpermission(){
        return serviceparamSoco.lstPermission();
    }

    public String identification(){
        if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
            return "/firstTime/menuAdmin.xhtml";
        }else{
        user = serviceparamSoco.verifUtilisateur(user.getUsername(), user.getPassword());
        if(user != null){
          currentCoop = user.getCooperative();
                currentPeriode = serviceparamSoco.currentPeriode(currentCoop);
                formatage();
           return "begin";
        }
    }
        return null;
    }
    public String logout(){
((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();

        return "/login.xhtml";
    }
    private void formatage(){
        for(formatageEntier f : serviceparamSoco.formatage(currentCoop)){
            if(f.getType().equals("Devise")){
                currentFormatDevise = f;
            }else{
                currentFormatUnite = f;
            }
        }
    }

    public void verifMotdepasse(){
        if(!user.getPassword().equals(verifMDP)){
             FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Verifier votre mot de passe", "Verifier votre mot de passe");
                FacesContext.getCurrentInstance().addMessage("mdp", msg);
        }
    }


    public String updateUser(){
        
        serviceparamSoco.updateUtilisateur(user);
        return "/index.xhtml";
    }
    /**
     * @return the user
     */
    public Utilisateur getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Utilisateur user) {
        this.user = user;
    }

    /**
     * @return the lstPermission
     */
    public List<Permission> getLstPermission() {
        return lstPermission;
    }

    /**
     * @param lstPermission the lstPermission to set
     */
    public void setLstPermission(List<Permission> lstPermission) {
        this.lstPermission = lstPermission;
    }

   

    /**
     * @param currentPeriode the currentPeriode to set
     */
    public void setCurrentPeriode(DefinitionPeriode currentPeriode) {
        this.currentPeriode = currentPeriode;
    }

    /**
     * @return the currentPeriode
     */
    public DefinitionPeriode getCurrentPeriode() {
        return currentPeriode;
    }

    /**
     * @return the cuurentCoop
     */
    public Cooperative getCurrentCoop() {
        return currentCoop;
    }

    /**
     * @param cuurentCoop the cuurentCoop to set
     */
    public void setCurrentCoop(Cooperative cuurentCoop) {
        this.currentCoop = cuurentCoop;
    }

    /**
     * @return the currentFormatDevise
     */
    public formatageEntier getCurrentFormatDevise() {
        return currentFormatDevise;
    }

    /**
     * @param currentFormatDevise the currentFormatDevise to set
     */
    public void setCurrentFormatDevise(formatageEntier currentFormatDevise) {
        this.currentFormatDevise = currentFormatDevise;
    }

    /**
     * @return the currentFormatUnite
     */
    public formatageEntier getCurrentFormatUnite() {
        return currentFormatUnite;
    }

    /**
     * @param currentFormatUnite the currentFormatUnite to set
     */
    public void setCurrentFormatUnite(formatageEntier currentFormatUnite) {
        this.currentFormatUnite = currentFormatUnite;
    }

    /**
     * @return the verifMDP
     */
    public String getVerifMDP() {
        return verifMDP;
    }

    /**
     * @param verifMDP the verifMDP to set
     */
    public void setVerifMDP(String verifMDP) {
        this.verifMDP = verifMDP;
    }

   




}
