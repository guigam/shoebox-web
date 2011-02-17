/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Converter;

import ModelesShoebox.Magasin;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class MagasinConverter implements Converter {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
	 private EntityManager em = emf.createEntityManager();
    /** Creates a new instance of MagasinConverter */
    public MagasinConverter() {
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
         String name = value;
        Query query = em.createQuery("from Magasin");
       List<Magasin> lstMagasin = query.getResultList();
       for(Magasin p : lstMagasin){
            if(p.getName().equals(value)){
                return p;
            }
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o != null){
            Magasin p = (Magasin) o;
            return p.getName();
        }
        return null;
    }

}
