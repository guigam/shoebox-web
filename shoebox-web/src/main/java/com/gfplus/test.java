/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gfplus;


import ModelesShoebox.Client;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import test.testLocal;

/**
 *
 * @author guigamehdi
 */
@ManagedBean
@RequestScoped
public class test {
    @EJB
    private testLocal serviceCompta;
   

    /** Creates a new instance of test */
    public List<Client> gettest() {
        return serviceCompta.lstClient();
    }

}
