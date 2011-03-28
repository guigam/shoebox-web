/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Converter;

import Login.login;
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
public class CategorieChargeConverter implements Converter {
    @Inject
    private login session;
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	 private EntityManager em = emf.createEntityManager();
    /** Creates a new instance of ProduitConverter */
    public CategorieChargeConverter() {
    }
   

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
       String name = value;
        Query query = em.createQuery("from CategorieCharge c");
       List<CategorieCharge> lstCategCharge = query.getResultList();
       for(CategorieCharge p : lstCategCharge){
            if(p.getNomCategorie().equals(value)){
                return p;
            }
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null){
            CategorieCharge p = (CategorieCharge) o;
            return p.getNomCategorie();
        }
        return null;
    }

}
