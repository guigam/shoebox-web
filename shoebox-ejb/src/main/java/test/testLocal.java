/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import ModelesShoebox.Client;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author guigamehdi
 */
@Local
public interface testLocal {

    public List<Client> lstClient();
}
