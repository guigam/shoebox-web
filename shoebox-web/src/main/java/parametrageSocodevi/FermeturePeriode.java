/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parametrageSocodevi;

import ModelesParametrage.DefinitionPeriode;
import ModelesShoebox.Cooperative;
import ModelesShoebox.TransactionCaisse;
import ModelesShoebox.TransactionMagasin;
import gestionCaisse.GestionCaisse;
import gestionCommandesTransaction.ServiceGestionCommandeTransactionLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author guiga
 */
@Named
@ConversationScoped
public class FermeturePeriode implements Serializable {
    private Cooperative coop;
    @EJB
    private ServiceGestionCommandeTransactionLocal serviceGsCommande;
    @EJB
    private ServiceParamSocoLocal serviceSOCO;
    @Inject
    Conversation conversation;
    @Inject
    GestionCaisse gsCaisse;
    private Date datefin;
    private List<mappingFermeturetransactionMagasin> lstTransMag = new LinkedList<mappingFermeturetransactionMagasin>();
    private DefinitionPeriode defperiode = new DefinitionPeriode();
   

    public String fermerPeriode(){
       
        serviceSOCO.addDefPeriode(getDefperiode());
        for(mappingFermeturetransactionMagasin m : lstTransMag){
            TransactionMagasin t = new TransactionMagasin();
            TransactionCaisse c = new TransactionCaisse();
            t.setMagasin(m.getMagasin());
            t.setDefPeriode(getDefperiode());
            t.setGrade(m.getGrade());
            t.setProduit(m.getProduit());
            t.setQuantite(m.getQteReel());
            if(t.getProduit().getType().equals("Principal")){
                c.setCharteCompte(serviceSOCO.charteCompteByReference("RA-1-SD"));
                c.setCoop(coop);
                c.setDefPeriode(getDefperiode());
                c.setMontant(m.getValueReel());
                serviceSOCO.addTransactionCaisse(c);
                 c.setCharteCompte(serviceSOCO.charteCompteByReference("RA-1-SF"));
                serviceSOCO.addTransactionCaisse(c);
                 
                
            }else if(t.getProduit().getType().equals("Secondaire")){
                 c.setCharteCompte(serviceSOCO.charteCompteByReference("RA-2-SD"));
                c.setCoop(coop);
                c.setDefPeriode(getDefperiode());
                c.setMontant(m.getValueReel());
                serviceSOCO.addTransactionCaisse(c);
                 c.setCharteCompte(serviceSOCO.charteCompteByReference("RA-2-SF"));
                serviceSOCO.addTransactionCaisse(c);
            }else{
             c.setCharteCompte(serviceSOCO.charteCompteByReference("RC-SD"));
                c.setCoop(coop);
                c.setDefPeriode(getDefperiode());
                c.setMontant(m.getValueReel());
                serviceSOCO.addTransactionCaisse(c);
                 c.setCharteCompte(serviceSOCO.charteCompteByReference("RC-SF"));
                serviceSOCO.addTransactionCaisse(c);
            }
            serviceSOCO.addTransactionMagasin(t);
        }
        updateListDefPeriodeToInactif();
        conversation.end();
        return "/firstTime/lstCooperative";
    }
    public String annulBeginPeriode(){
             if(!conversation.isTransient()){
            conversation.end();
        }
             return "/firstTime/menuAdmin";
    }

    public String gsPeriode(){
        conversation.begin();
        return "/fermeturePeriode/listDefinitioPeriodeAdminView.xhtml";
    }
    
    
    public void updateListDefPeriodeToInactif() {
        for(DefinitionPeriode d : serviceSOCO.lstDefinitionPeriode(coop)){
            if(d != defperiode){
                d.setPeriodeActif(false);
                serviceSOCO.updateDefinitionPeriode(d);
            }
        }
    }
    
    
    public String beginFermeturePeriode() {
        return "/fermeturePeriode/nouvellePeriode.xhtml";
    }

    public String setterDateFin() {
        lstTransMag.clear();
        getDefperiode().setDateDebut(serviceSOCO.currentPeriode(coop).getDateDebut());
        getDefperiode().setDateFin(datefin);
        getDefperiode().setPeriodeActif(true);
        getDefperiode().setCoop(coop);
        if(serviceSOCO.lstDefinitionPeriode(coop).size()+1<12){
            getDefperiode().setPeriode(serviceSOCO.lstDefinitionPeriode(coop).size()+1);
        }else{
            getDefperiode().setPeriode(1);
        }
        return "/fermeturePeriode/fermetureMagasin.xhtml";
    }

    private void etatMagasingroupBy() {
        for(TransactionMagasin t :serviceGsCommande.etatMagByProduit(coop, serviceSOCO.currentPeriode(coop))){
         mappingFermeturetransactionMagasin mapFermemag = new mappingFermeturetransactionMagasin();
            mapFermemag.setGrade(t.getGrade());
            mapFermemag.setMagasin(t.getMagasin());
            mapFermemag.setProduit(t.getProduit());
            mapFermemag.setQuantite(t.getQuantite());
            mapFermemag.setQteReel(0);
        }
    }


    /**
     * @return the datefin
     */
    public Date getDatefin() {
        return datefin;
    }

    /**
     * @param datefin the datefin to set
     */
    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

   
    

    /**
     * @return the lstTransMag
     */
    public List<mappingFermeturetransactionMagasin> getLstTransMag() {
        if(lstTransMag.isEmpty()){
          for(TransactionMagasin t : serviceGsCommande.etatMagByProduit(coop, serviceSOCO.currentPeriode(coop))){
         mappingFermeturetransactionMagasin mapFermemag = new mappingFermeturetransactionMagasin();
            mapFermemag.setGrade(t.getGrade());
            mapFermemag.setMagasin(t.getMagasin());
            mapFermemag.setProduit(t.getProduit());
            mapFermemag.setQuantite(t.getQuantite());
            mapFermemag.setQteReel(0);
            lstTransMag.add(mapFermemag);
        }
        }
        return lstTransMag;
    }

    /**
     * @param lstTransMag the lstTransMag to set
     */
    public void setLstTransMag(List<mappingFermeturetransactionMagasin> lstTransMag) {
        this.lstTransMag = lstTransMag;
    }

    /**
     * @return the coop
     */
    public Cooperative getCoop() {
        return coop;
    }

    /**
     * @param coop the coop to set
     */
    public void setCoop(Cooperative coop) {
        this.coop = coop;
    }

    /**
     * @return the defperiode
     */
    public DefinitionPeriode getDefperiode() {
        defperiode.setDateDebut(serviceSOCO.currentPeriode(coop).getDateFin());
        return defperiode;
    }

    /**
     * @param defperiode the defperiode to set
     */
    public void setDefperiode(DefinitionPeriode defperiode) {
        this.defperiode = defperiode;
    }
}
