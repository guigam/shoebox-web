/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Login;

import ModelesParametrage.Langue;
import ModelesParametrage.Permission;
import ModelesParametrage.Utilisateur;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
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
    @EJB
    private ServiceParamSocoLocal serviceparamSoco;
    /** Creates a new instance of login */
    public login() {

    }
    public List<Permission> getlstpermission(){
        return serviceparamSoco.lstPermission();
    }

    public String identification(){
        user = serviceparamSoco.verifUtilisateur(user.getUsername(), user.getPassword());
        if(user != null){
           return "begin";
        }
        return null;
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




}
