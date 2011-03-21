/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelesParametrage;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author guigamehdi
 */
@Entity
@Table(name = "TemplateParamTransaction")
@NamedQueries({
    @NamedQuery(name = "TemplateParamTransaction.findAll", query = "SELECT t FROM TemplateParamTransaction t")})
public class TemplateParamTransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "abrev")
    private String abrev;
    @Column(name = "type")
    private String type;
    @Id
    private Long id;

    public TemplateParamTransaction() {
    }

    
    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
