/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrageSocodevi;

import Login.login;
import ModelesParametrage.DefinitionPeriode;
import ModelesParametrage.ParamTransaction;
import ModelesParametrage.formatageEntier;
import ModelesShoebox.CharteCompte;
import ModelesShoebox.Cooperative;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.component.UIData;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

/**
 *
 * @author guigam
 */
@Named(value = "gsParamSoco")
@RequestScoped
public class GestionParametrageSoco implements Serializable {
    private Cooperative cooperative = new Cooperative();
    private List<ParamTransaction> lstParamtransaction = new LinkedList<ParamTransaction>();
    private ParamTransaction paramtsx = new ParamTransaction();
    private UIData dataTable;
    private List<DefinitionPeriode> lstDefPeriode = new LinkedList<DefinitionPeriode>();
    private formatageEntier formatageDevise = new formatageEntier();
    private formatageEntier formatageunite = new formatageEntier();
    @Inject
    private login session;
    @EJB
    private ServiceParamSocoLocal serviceSoco;

    /** Creates a new instance of GestionLangue */
    public GestionParametrageSoco() {
    }

    public void newCoop(){
        cooperative.getLstutilisateur().add(session.getUser());
        serviceSoco.newCoop(cooperative);
    }

    public void newParamCharteTransaction() {
        for (ParamTransaction p : lstParamtransaction) {
            p.setCooperative(session.getCurrentCoop());
            serviceSoco.mergeParamCharteCompteOfortransaction(p);
        }
    }
    private void newDefinitionPeriode(DefinitionPeriode def){
        def.setCurrentuser(session.getUser());
        serviceSoco.mergeDefPeriode(def);
    }

    public void valueChangeListener(ValueChangeEvent event) {
        paramtsx = new ParamTransaction();
        paramtsx = (ParamTransaction) dataTable.getRowData();
        paramtsx.setCharteCompte((CharteCompte) event.getNewValue());
        paramtsx.setCooperative(session.getCurrentCoop());
        serviceSoco.mergeParamCharteCompteOfortransaction(paramtsx);
    }

    public void valueChangeListenerDefinitionPeriode(ValueChangeEvent event) {
        DefinitionPeriode def = new DefinitionPeriode();
        def = (DefinitionPeriode) dataTable.getRowData();
        def.setPeriode((String) event.getNewValue());
        def.setCurrentuser(session.getUser());
        newDefinitionPeriode(def);
    }
    
      public void valueChangeListenerformatage(ValueChangeEvent event) {
        formatageEntier fe = new formatageEntier();
        fe = (formatageEntier) dataTable.getRowData();
        fe.setCurremcy((String) event.getNewValue());
    }



    /**
     * @return the lstParamtransaction
     */
    public List<ParamTransaction> getLstParamtransaction() {
        return serviceSoco.lstParamTransaction(session.getUser().getCooperative());
    }

    public List<DefinitionPeriode> getlstDefinitionPeriode() {
        return serviceSoco.lstDefinitionPeriode(session.getUser().getCooperative());
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
     * @return the lstDefPeriode
     */
    public List<DefinitionPeriode> getLstDefPeriode() {
        return lstDefPeriode;
    }

    /**
     * @param lstDefPeriode the lstDefPeriode to set
     */
    public void setLstDefPeriode(List<DefinitionPeriode> lstDefPeriode) {
        this.lstDefPeriode = lstDefPeriode;
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

   
}
