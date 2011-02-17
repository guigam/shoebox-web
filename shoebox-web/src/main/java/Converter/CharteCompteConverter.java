/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Converter;

import ModelesShoebox.CharteCompte;
import ModelesShoebox.Client;
import ModelesShoebox.FournisseurIntrant;
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
public class CharteCompteConverter implements Converter {
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	 private EntityManager em = emf.createEntityManager();
    /** Creates a new instance of ProduitConverter */
    public CharteCompteConverter() {
    }
   

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
       String name = value;
        Query query = em.createQuery("from CharteCompte");
       List<CharteCompte> lstCharteCompte = query.getResultList();
       for(CharteCompte p : lstCharteCompte){
            if(p.getNom().equals(value)){
                return p;
            }
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null){
            CharteCompte p = (CharteCompte) o;
            return p.getNom();
        }
        return null;
    }

}
