/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Login;

import ModelesParametrage.Langue;
import ModelesParametrage.Permission;
import java.io.Serializable;
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
    @EJB
    private ServiceParamSocoLocal serviceparamSoco;
    /** Creates a new instance of login */
    public login() {

    }
    public List<Permission> getlstpermission(){
        return serviceparamSoco.lstPermission();
    }

    




}
