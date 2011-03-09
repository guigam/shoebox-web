/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parametrageSocodevi;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.ParamTransaction;
import ModelesParametrage.Permission;
import ModelesParametrage.Utilisateur;
import ModelesParametrage.formatageEntier;
import ModelesShoebox.CharteCompte;
import ModelesShoebox.Cooperative;
import java.util.List;
import javax.ejb.Local;
import javax.faces.model.SelectItem;

/**
 *
 * @author guigam
 */
@Local
public interface ServiceParamSocoLocal {

    public List<Permission> lstPermission();

   public ParamTransaction rechercheParamCharteCompte(String typetransction);

   public CharteCompte charteCompteByReference(String reference);

   public void mergeParamCharteCompteOfortransaction(ParamTransaction paramTsx);

   public void mergeDefPeriode(DefinitionPeriode def);

   public List<ParamTransaction> lstParamTransaction();

   public List<DefinitionPeriode> lstDefinitionPeriode();

   public DefinitionPeriode currentPeriode();

   public Utilisateur verifUtilisateur(String utilisateur, String password);

   public void newCoop(Cooperative coop);

   public formatageEntier formatage(String type);

   public List<Utilisateur> lstUtilisteur(Cooperative coop);

   public void newUtilisateur(Utilisateur utilisateur);

   public void updateUtilisateur(Utilisateur utilisateur);

   public List<SelectItem> lstItemPermission();

  


}
