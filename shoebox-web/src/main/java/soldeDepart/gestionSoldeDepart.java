/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soldeDepart;

import Login.login;
import ModelesShoebox.SoldeDepart;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import serviceSoldeDepart.serviceSoldeDepartLocal;

/**
 *
 * @author guigamehdi
 */
@Named(value = "gsSoldeDepart")
@SessionScoped
public class gestionSoldeDepart implements Serializable {

    private SoldeDepart sd = new SoldeDepart();
    @EJB
    private serviceSoldeDepartLocal serviceSoldeDepart;
    @Inject
    private login session;

    /** Creates a new instance of NewJSFManagedBean */
    public gestionSoldeDepart() {
    }

    public List<SoldeDepart> getlstRemboursementFP() {
        return serviceSoldeDepart.remboursementFP(session.getCurrentCoop());
    }

    public List<SoldeDepart> getlstRemboursementFI() {
        return serviceSoldeDepart.remboursementFI(session.getCurrentCoop());
    }

    public List<SoldeDepart> getlstRemboursementClient() {
        return serviceSoldeDepart.remboursementClient(session.getCurrentCoop());
    }

    public List<SoldeDepart> getlstDetteFP() {
        return serviceSoldeDepart.dettesFP(session.getCurrentCoop());
    }

    public List<SoldeDepart> getlstDetteFI() {
        return serviceSoldeDepart.dettesFI(session.getCurrentCoop());

    }

    public List<SoldeDepart> getlstDetteClient() {
        return serviceSoldeDepart.dettesClient(session.getCurrentCoop());
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
