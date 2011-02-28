 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrageSocodevi;

import Login.login;
import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.ParamTransaction;
import ModelesParametrage.Permission;
import ModelesParametrage.Utilisateur;
import ModelesParametrage.formatageEntier;
import ModelesShoebox.CharteCompte;
import ModelesShoebox.Cooperative;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.faces.component.UIData;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author guigam
 */
@Named(value = "gsParamSoco")
@ConversationScoped
public class GestionParametrageSoco implements Serializable {
    private Cooperative cooperative = new Cooperative();
    private List<ParamTransaction> lstParamtransaction = new LinkedList<ParamTransaction>();
    private ParamTransaction paramtsx = new ParamTransaction();
    private UIData dataTable;
    private DefinitionPeriode dePeriode = new DefinitionPeriode();
    private formatageEntier formatageDevise = new formatageEntier();
    private formatageEntier formatageunite = new formatageEntier();
    private List<Permission> lstPermissions = new LinkedList<Permission>();
    @Inject
    private login session;
    @EJB
    private ServiceParamSocoLocal serviceSoco;
    @Inject
    private Conversation conversation;
    private Utilisateur utilisateur = new Utilisateur();;
    /** Creates a new instance of GestionLangue */
    public GestionParametrageSoco() {
    }

    public void changePeriodeActif(){
        for(DefinitionPeriode defPeriode : getlstDefinitionPeriode()){
            if(defPeriode.equals(dePeriode)){
                defPeriode.setPeriodeActif(true);
                serviceSoco.mergeDefPeriode(defPeriode);
            }else{
                defPeriode.setPeriodeActif(false);
                serviceSoco.mergeDefPeriode(defPeriode);
            }
        }
        if(!conversation.isTransient())
        conversation.end();
    }

    public void newCoop(){
        cooperative.getLstutilisateur().add(session.getUser());
        serviceSoco.newCoop(cooperative);
    }

    public void newParamCharteTransaction() {
        for (ParamTransaction p : lstParamtransaction) {
            serviceSoco.mergeParamCharteCompteOfortransaction(p);
        }
    }
    private void newDefinitionPeriode(DefinitionPeriode def){
        def.setCooperative(session.getCurrentCoop());
        serviceSoco.mergeDefPeriode(def);
    }

    public void valueChangeListener(ValueChangeEvent event) {
        paramtsx = new ParamTransaction();
        paramtsx = (ParamTransaction) dataTable.getRowData();
        paramtsx.setCharteCompte((CharteCompte) event.getNewValue());
        serviceSoco.mergeParamCharteCompteOfortransaction(paramtsx);
    }

    public void valueChangeListenerDefinitionPeriode(ValueChangeEvent event) {
        DefinitionPeriode def = new DefinitionPeriode();
        def = (DefinitionPeriode) dataTable.getRowData();
        def.setPeriode((String) event.getNewValue());
        def.setCooperative(session.getCurrentCoop());
        newDefinitionPeriode(def);
    }
    
      public void valueChangeListenerformatage(ValueChangeEvent event) {
        formatageEntier fe = new formatageEntier();
        fe = (formatageEntier) dataTable.getRowData();
        fe.setCurremcy((String) event.getNewValue());
    }
    public List<Utilisateur> getListUtilisateur(){
        return serviceSoco.lstUtilisteur(session.getCurrentCoop());
    }

    public String newUtilisateur(){
        utilisateur.setCooperative(session.getCurrentCoop());
        utilisateur.setPassword("soco");
        serviceSoco.newUtilisateur(utilisateur);
        return "lstUtilisateurs";
    }

  public List<SelectItem> getListitemPermission() {
        return serviceSoco.lstItemPermission();
    }
    /**
     * @return the lstParamtransaction
     */
    public List<ParamTransaction> getLstParamtransaction() {
        return serviceSoco.lstParamTransaction(session.getCurrentCoop());
    }

    public List<DefinitionPeriode> getlstDefinitionPeriode() {
        
        return serviceSoco.lstDefinitionPeriode(session.getCurrentCoop());
    }

    /**
     * @param lstParamtransaction the lstParamtransaction to set
     */
    public void setLstParamtransaction(List<ParamTransaction> lstParamtransaction) {
        this.lstParamtransaction = lstParamtransaction;
    }

    /**
     * @return the paramtsx
     */
    public ParamTransaction getParamtsx() {
        return paramtsx;
    }

    /**
     * @param paramtsx the paramtsx to set
     */
    public void setParamtsx(ParamTransaction paramtsx) {
        this.paramtsx = paramtsx;
    }

    /**
     * @return the dataTable
     */
    public UIData getDataTable() {
        return dataTable;
    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(UIData dataTable) {
        this.dataTable = dataTable;
    }



    /**
     * @return the cooperative
     */
    public Cooperative getCooperative() {

        return cooperative;
    }

    /**
     * @param cooperative the cooperative to set
     */
    public void setCooperative(Cooperative cooperative) {
        this.cooperative = cooperative;
    }

    /**
     * @return the formatageDevise
     */
    public formatageEntier getFormatageDevise() {
        return serviceSoco.formatage("devise");
    }

    /**
     * @param formatageDevise the formatageDevise to set
     */
    public void setFormatageDevise(formatageEntier formatageDevise) {
        this.formatageDevise = formatageDevise;
    }

    /**
     * @return the formatageunite
     */
    public formatageEntier getFormatageunite() {
        return serviceSoco.formatage("unite");
    }

    /**
     * @param formatageunite the formatageunite to set
     */
    public void setFormatageunite(formatageEntier formatageunite) {
        this.formatageunite = formatageunite;
    }

    /**
     * @return the dePeriode
     */
    public DefinitionPeriode getDePeriode() {
        conversation.begin();
        return dePeriode;
    }

    /**
     * @param dePeriode the dePeriode to set
     */
    public void setDePeriode(DefinitionPeriode dePeriode) {
        this.dePeriode = dePeriode;
    }

    /**
     * @return the utilisateur
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * @param utilisateur the utilisateur to set
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * @return the lstPermissions
     */
    public List<Permission> getLstPermissions() {
        return lstPermissions;
    }

    /**
     * @param lstPermissions the lstPermissions to set
     */
    public void setLstPermissions(List<Permission> lstPermissions) {
        this.lstPermissions = lstPermissions;
    }

   
}
