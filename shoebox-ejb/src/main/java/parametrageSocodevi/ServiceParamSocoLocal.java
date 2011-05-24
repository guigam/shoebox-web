/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parametrageSocodevi;

import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.ParamTransaction;
import ModelesParametrage.Permission;
import ModelesParametrage.TemplateParamTransaction;
import ModelesParametrage.Utilisateur;
import ModelesParametrage.formatageEntier;
import ModelesShoebox.CharteCompte;
import ModelesShoebox.Cooperative;
import ModelesShoebox.Magasin;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionMagasin;
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

   public ParamTransaction rechercheParamCharteCompte(String typetransction, Cooperative coop);

   public CharteCompte charteCompteByReference(String reference);

   public void mergeParamCharteCompteOfortransaction(ParamTransaction paramTsx);

   public void mergeDefPeriode(DefinitionPeriode def);

   public List<ParamTransaction> lstParamTransaction(Cooperative coop);

   public List<TemplateParamTransaction> lstTemplateParamTransaction();

   public List<DefinitionPeriode> lstDefinitionPeriode(Cooperative coop);

   public DefinitionPeriode currentPeriode(Cooperative coop);

   public Utilisateur verifUtilisateur(String utilisateur, String password);

   public void mergeCoop(Cooperative coop);

   public void newCoop(Cooperative coop);

   public List<formatageEntier> formatage(Cooperative coop);

   public void newformatage(formatageEntier f);

   public List<Utilisateur> lstUtilisteur(Cooperative coop);

   public List<Utilisateur> lstAllUtilisteur();

   public void newUtilisateur(Utilisateur utilisateur);

   public void updateUtilisateur(Utilisateur utilisateur);

   public List<SelectItem> lstItemPermission();

   public List<formatageEntier> lstFormatEntier();

   public void addTransactionCaisse(TransactionCaisse tsxCaisse);
   
   public void addTransactionMagasin(TransactionMagasin tsxMagasin);

    public void addDefPeriode(DefinitionPeriode defperiode);

    public void updateDefinitionPeriode(DefinitionPeriode d);

    public List<TransactionMagasin> lstTsxMagByMagasin(Magasin magasin);

    

  


}
