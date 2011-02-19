/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soldeDepart;

import ModelesShoebox.SoldeDepart;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import serviceSoldeDepart.serviceSoldeDepartLocal;

/**
 *
 * @author guigamehdi
 */
@Named(value = "gsSoldeDepart")
@SessionScoped
public class gestionSoldeDepart implements Serializable{
    private SoldeDepart sd = new SoldeDepart();
    @EJB
    private serviceSoldeDepartLocal serviceSoldeDepart;

    /** Creates a new instance of NewJSFManagedBean */
    public gestionSoldeDepart() {
    }

    public List<SoldeDepart> getlstRemboursementFP() {
       return  serviceSoldeDepart.remboursementFP();
    }

    public List<SoldeDepart> getlstRemboursementFI() {
        return serviceSoldeDepart.remboursementFI();
    }

    public List<SoldeDepart> getlstRemboursementClient() {
        return serviceSoldeDepart.remboursementClient();
    }

    public List<SoldeDepart> getlstDetteFP() {
        return serviceSoldeDepart.dettesFP();
    }

    public List<SoldeDepart> getlstDetteFI() {
        return serviceSoldeDepart.dettesFI();
           
    }

    public List<SoldeDepart> getlstDetteClient() {
        return serviceSoldeDepart.dettesClient();
    }

    /**
     * @return the sd
     */
    public SoldeDepart getSd() {
        return sd;
    }

    /**
     * @param sd the sd to set
     */
    public void setSd(SoldeDepart sd) {
        this.sd = sd;
    }

}
