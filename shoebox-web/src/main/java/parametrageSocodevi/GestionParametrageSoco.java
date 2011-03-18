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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import parametrageCoop.serviceParamCoopLocal;

/**
 *
 * @author guigam
 */
@Named(value = "gsParamSoco")
@SessionScoped
public class GestionParametrageSoco implements Serializable {

    private Cooperative cooperative = new Cooperative();
    private List<ParamTransaction> lstParamtransaction = new LinkedList<ParamTransaction>();
    private ParamTransaction paramtsx = new ParamTransaction();
    private UIData dataTable;
    private DefinitionPeriode dePeriode = new DefinitionPeriode();
    private formatageEntier formatageDevise = new formatageEntier();
    private formatageEntier formatageunite = new formatageEntier();
    private List<Permission> maLstPermissionChoisit = new LinkedList<Permission>();
    private List<DefinitionPeriode> lstDefPeriode = new LinkedList<DefinitionPeriode>();
    @Inject
    private login session;
    @EJB
    private ServiceParamSocoLocal serviceSoco;
    @EJB
    private serviceParamCoopLocal serviceParamCoop;
    @Inject
    private Conversation conversation;
    @Inject
    private fileuploadBean fup;
    private Utilisateur utilisateur = new Utilisateur();

    ;

    /** Creates a new instance of GestionLangue */
    public GestionParametrageSoco() {
    }

    public String test() {

        return "/caisse/listAchatProduitIntrant.xhtml";
    }

    public void changePeriodeActif() {
        if (!lstDefPeriode.isEmpty()) {
            for (DefinitionPeriode d : lstDefPeriode) {
                if (d.equals(dePeriode)) {
                    d.setPeriodeActif(true);
                } else {
                    d.setPeriodeActif(false);
                }
            }
        } else if (serviceSoco.lstDefinitionPeriode(session.getCurrentCoop()).contains(dePeriode)) {
            for (DefinitionPeriode d : serviceSoco.lstDefinitionPeriode(session.getCurrentCoop())) {
                if (d.equals(dePeriode)) {

                    d.setPeriodeActif(true);
                } else {
                    d.setPeriodeActif(false);
                }
            }
        }
    }

    public void newCoop() throws FileNotFoundException, IOException {
        String chemin = "/home/guigam/NetBeansProjects/shoebox2/shoebox-web/src/main/webapp/logo/";
        saveFile(chemin);
        cooperative.setLinkLogo(chemin + fup.getFile().getFileName());
        cooperative.getLstutilisateur().add(session.getUser());
        serviceSoco.newCoop(cooperative);
        verifConfiguration();
    }

    public String verifConfiguration() {
        if (serviceParamCoop.lstCoop().isEmpty()) {
            return "/firstTime/addCooperative.xhtml";
        } else if (!serviceSoco.lstParamTransaction().isEmpty()) {
            for (ParamTransaction p : serviceSoco.lstParamTransaction()) {
                if (p.getCharteCompte() == null) {
                    return "/parametrageSoco/parametragetransactionCharteSoco.xhtml";
                }
            }
        } else if (serviceSoco.lstFormatEntier().size() < 2) {
            return "/parametrageSoco/formatage.xhtml";
        } else if (!serviceSoco.lstDefinitionPeriode(session.getCurrentCoop()).isEmpty()) {
            for (DefinitionPeriode d : serviceSoco.lstDefinitionPeriode(session.getCurrentCoop())) {
                if (d.isPeriodeActif() == true) {
                    return "menu.xhtml";
                }
            }
        }
        return null;
    }

    protected void saveFile(String chemin) throws FileNotFoundException, IOException {

        FileOutputStream fos = new FileOutputStream(chemin + fup.getFile().getFileName());
        fos.write(fup.getFile().getData());
    }

    public void newParamCharteTransaction() {
        for (ParamTransaction p : lstParamtransaction) {
            serviceSoco.mergeParamCharteCompteOfortransaction(p);
        }
    }

    private void newDefinitionPeriode(DefinitionPeriode def) {
        serviceSoco.mergeDefPeriode(def);
    }

    public List<Cooperative> getlstCoop() {
        return serviceParamCoop.lstCoop();
    }

    public void valueChangeListener(ValueChangeEvent event) {
        paramtsx = new ParamTransaction();
        paramtsx = (ParamTransaction) dataTable.getRowData();
        paramtsx.setCharteCompte((CharteCompte) event.getNewValue());
        serviceSoco.mergeParamCharteCompteOfortransaction(paramtsx);
    }

    public void valueChangeListenerDefinitionPeriode(ValueChangeEvent event) {
        dePeriode = (DefinitionPeriode) dataTable.getRowData();
        dePeriode.setPeriode((String) event.getNewValue());
        lstDefPeriode.add(dePeriode);
    }

    public String validerConfigDefinitionperiode() {
        if (verifDonneePeriode() && verifPeriodeActif()) {
            for (DefinitionPeriode d : lstDefPeriode) {
                d.setCoop(session.getCurrentCoop());
                newDefinitionPeriode(d);
            }
            if (serviceSoco.currentPeriode(session.getCurrentCoop()) == null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "la Definition de periode est enregistre avec succes, Veuillez svp indiquer la periode de debut", "la Definition de periode est enregistre avec succes, Veuillez svp indiquer la periode de debut");
                FacesContext.getCurrentInstance().addMessage("defPeriode", msg);
            } else {
                ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
                return "/firstTime/menuAdmin.xhtml";
            }
        }
        return null;
    }

    private boolean verifPeriodeActif() {
        for (DefinitionPeriode d : lstDefPeriode) {
            if (d.isPeriodeActif()) {
                return true;
            }
        }
        return false;
    }

    private boolean verifDonneePeriode() {
        for (DefinitionPeriode d : lstDefPeriode) {
            if (d.getMois().equals("")) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "La configuration de la definition de la periode n'est pas complete ");
                FacesContext.getCurrentInstance().addMessage("defPeriode", msg);
                lstDefPeriode.clear();
                return false;
            }
        }
        return true;
    }

    public void valueChangeListenerformatage(ValueChangeEvent event) {
        formatageEntier fe = new formatageEntier();
        fe = (formatageEntier) dataTable.getRowData();
        fe.setCurremcy((String) event.getNewValue());
    }

    public List<Utilisateur> getListUtilisateur() {
        return serviceSoco.lstUtilisteur(session.getCurrentCoop());
    }

    public List<Utilisateur> getListAllUtilisateur() {
        return serviceSoco.lstAllUtilisteur();
    }

    public String newUtilisateur() {
        utilisateur.setCooperative(session.getCurrentCoop());
        utilisateur.setPassword("soco");
        serviceSoco.newUtilisateur(utilisateur);
        return "lstUtilisateurs";
    }

    public String newUtilisateurAdmin() {
        utilisateur.setPassword("soco");
        serviceSoco.newUtilisateur(utilisateur);
        return "lstUtilisateurs";
    }

    public String updateUtilisateur() {
        serviceSoco.updateUtilisateur(utilisateur);
        return "lstUtilisateurs";
    }

    public List<SelectItem> getListitemPermission() {
        return serviceSoco.lstItemPermission();
    }

    /**
     * @return the lstParamtransaction
     */
    public List<ParamTransaction> getLstParamtransaction() {
        return serviceSoco.lstParamTransaction();
    }

    public List<DefinitionPeriode> getlstDefinitionPeriodeAdmin() {
        if (serviceSoco.lstDefinitionPeriode(session.getCurrentCoop()).isEmpty()) {
            if (lstDefPeriode.isEmpty()) {
                for (int i = 1; i <= 12; i++) {
                    DefinitionPeriode def = new DefinitionPeriode();
                    def.setPeriode("P" + i);
                    lstDefPeriode.add(def);
                }
                return lstDefPeriode;
            } else {
                return lstDefPeriode;
            }
        }
        return serviceSoco.lstDefinitionPeriode(session.getCurrentCoop());
    }

    public List<DefinitionPeriode> getlstDefinitionPeriode() {
        if (serviceSoco.lstDefinitionPeriode(session.getCurrentCoop()).isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "SVP, Contacter votre administrateur la definition de periode n'est pas bien configure", null);
            FacesContext.getCurrentInstance().addMessage("defPeriode", msg);
            return null;
        }
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
        dePeriode.setPeriodeActif(true);
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
     * @return the maLstPermissionChoisit
     */
    public List<Permission> getMaLstPermissionChoisit() {
        return maLstPermissionChoisit;
    }

    /**
     * @param maLstPermissionChoisit the maLstPermissionChoisit to set
     */
    public void setMaLstPermissionChoisit(List<Permission> maLstPermissionChoisit) {
        this.maLstPermissionChoisit = maLstPermissionChoisit;
    }
}
