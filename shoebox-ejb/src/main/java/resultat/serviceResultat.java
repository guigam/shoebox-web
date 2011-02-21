/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package resultat;

import ModelesShoebox.Client;
import ModelesShoebox.Commande;
import ModelesShoebox.Cooperative;
import ModelesShoebox.FournisseurIntrant;
import ModelesShoebox.FournisseurProduit;
import ModelesShoebox.TransactionCaisse;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author guigam
 */
@Stateless
public class serviceResultat implements serviceResultatLocal {
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion");
    private EntityManager em = emf.createEntityManager();

    @Override
    public List<TransactionCaisse> lstTsxCaisseCoop(Cooperative coop) {
        Query query = em.createQuery( "from TransactionCaisse t where t.currentuser.cooperative = ?1");
        query.setParameter(1, coop);
        return query.getResultList();
    }

    @Override
    public List<TransactionCaisse> lstTsxCaisseClient(Cooperative coop,Client cli) {
        List<TransactionCaisse> lstTsxCaisse = new LinkedList<TransactionCaisse>();
        Query query = em.createQuery( "from Commande t where t.m_entite = ?1 and t.currentuser.cooperative = ?2");
        query.setParameter(1, cli);
        query.setParameter(2, coop);
        for(Commande comm : (List<Commande>)query.getResultList() ){
            lstTsxCaisse.addAll(comm.getLsttransactionCaisse());
        }
        return lstTsxCaisse;
    }

    @Override
    public List<TransactionCaisse> lstTsxCaisseFP(Cooperative coop, FournisseurProduit FP) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TransactionCaisse> lstTsxCaisseFI(Cooperative coop, FournisseurIntrant FI) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
