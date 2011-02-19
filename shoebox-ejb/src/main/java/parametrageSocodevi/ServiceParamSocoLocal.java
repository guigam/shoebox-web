/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parametrageSocodevi;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.ParamTransaction;
import ModelesParametrage.Permission;
import ModelesShoebox.CharteCompte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author guigam
 */
@Local
public interface ServiceParamSocoLocal {

    public List<Permission> lstPermission();

   public ParamTransaction rechercheParamCharteCompte(String typetransction);

   public void mergeParamCharteCompteOfortransaction(ParamTransaction paramTsx);

   public void mergeDefPeriode(DefinitionPeriode def);

   public List<ParamTransaction> lstParamTransaction();

   public List<DefinitionPeriode> lstDefinitionPeriode();

}
