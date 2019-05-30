/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.modelo;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author User
 */
public class CAI implements Serializable {

    private Integer idCai;
    private String cai;
    
    public CAI() {
    }

    public Integer getIdCai() {
        return idCai;
    }

    public void setIdCai(Integer idCai) {
        this.idCai = idCai;
    }

    public String getCai() {
        return cai;
    }

    public void setCai(String cai) {
        this.cai = cai;
    }

    @Override
    public String toString() {
        return "CAI{" + "idCai=" + idCai + ", cai=" + cai + '}';
    }

    
    
}
