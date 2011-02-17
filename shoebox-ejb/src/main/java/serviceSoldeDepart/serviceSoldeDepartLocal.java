/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceSoldeDepart;

import ModelesShoebox.SoldeDepart;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author guigam
 */
@Local
public interface serviceSoldeDepartLocal {

    public List<SoldeDepart> remboursementFP();

    public List<SoldeDepart> remboursementFI();

    public List<SoldeDepart> remboursementClient();

    public List<SoldeDepart> dettesFP();

    public List<SoldeDepart> dettesFI();

    public List<SoldeDepart> dettesClient();
}
