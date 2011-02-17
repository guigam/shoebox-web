/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Converter;

import ModelesShoebox.Client;
import ModelesShoebox.Compte;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
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
public class CompteConverter implements Converter {
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	 private EntityManager em = emf.createEntityManager();
    /** Creates a new instance of ProduitConverter */
    public CompteConverter() {
    }
   

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
       String name = value;
        Query query = em.createQuery("from Compte");
       List<Compte> lstCompte = query.getResultList();
       for(Compte p : lstCompte){
            if(p.getNomCompte().equals(value)){
                return p;
            }
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null){
            Compte p = (Compte) o;
            return p.getNomCompte();
        }
        return null;
    }

}
