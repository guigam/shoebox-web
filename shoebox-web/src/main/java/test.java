/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import parametrageCoop.serviceParamCoopLocal;

/**
 *
 * @author guigam
 */
@Named(value="test")
@RequestScoped
public class test {
    @EJB
    private serviceParamCoopLocal serviceParamCoop;

    /** Creates a new instance of test */
    public test() {
    }


}
