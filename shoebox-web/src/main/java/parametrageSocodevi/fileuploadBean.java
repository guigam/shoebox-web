/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parametrageSocodevi;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

/**
 *
 * @author guigam
 */
@Named(value="fileuploadBean")
@SessionScoped
public class fileuploadBean implements Serializable {
    private UploadItem file ;

    /** Creates a new instance of fileuploadBean */
    public fileuploadBean() {
    }

    public void uploadListener(UploadEvent event) {
        if (event.getUploadItem().getData() != null) {
            setFile(event.getUploadItem());
        }
    }

    /**
     * @return the file
     */
    public UploadItem getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadItem file) {
        this.file = file;
    }

}
