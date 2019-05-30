/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.modelo;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class UDI implements Serializable {

    private Integer idUdi;
    private String udi;
    
    public UDI() {
    }

    public Integer getIdUdi() {
        return idUdi;
    }

    public void setIdUdi(Integer idUdi) {
        this.idUdi = idUdi;
    }

    public String getUdi() {
        return udi;
    }

    public void setUdi(String udi) {
        this.udi = udi;
    }

    @Override
    public String toString() {
        return "UDI{" + "idUdi=" + idUdi + ", udi=" + udi + '}';
    }
    
}
