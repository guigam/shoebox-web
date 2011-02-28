/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Converter;

import Login.login;
import ModelesParametrage.Permission;
import ModelesShoebox.CategorieCharge;
import ModelesShoebox.CharteCompte;
import ModelesShoebox.Client;
import ModelesShoebox.FournisseurIntrant;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author guigam
 */
@Named
public class permissionConverter implements Converter {
    @Inject
    private login session;
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	 private EntityManager em = emf.createEntityManager();
    /** Creates a new instance of ProduitConverter */
    public permissionConverter() {
    }
   

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
       String name = value;
        Query query = em.createQuery("from Permission c");
       List<Permission> lstPermission = query.getResultList();
       for(Permission p : lstPermission){
            if(p.getName().equals(value)){
                return p;
            }
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null){
            Permission p = (Permission) o;
            return p.getName();
        }
        return null;
    }

}
