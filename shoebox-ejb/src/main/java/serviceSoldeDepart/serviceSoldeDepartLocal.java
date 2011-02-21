/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceSoldeDepart;

import ModelesShoebox.Cooperative;
import ModelesShoebox.SoldeDepart;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author guigam
 */
@Local
public interface serviceSoldeDepartLocal {

    public List<SoldeDepart> remboursementFP(Cooperative coop);

    public List<SoldeDepart> remboursementFI(Cooperative coop);

    public List<SoldeDepart> remboursementClient(Cooperative coop);

    public List<SoldeDepart> dettesFP(Cooperative coop);

    public List<SoldeDepart> dettesFI(Cooperative coop);

    public List<SoldeDepart> dettesClient(Cooperative coop);

    public void mergeSolde(SoldeDepart sd);
}
