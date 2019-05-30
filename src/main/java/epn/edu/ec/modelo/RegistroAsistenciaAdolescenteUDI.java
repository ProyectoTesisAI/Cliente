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
public class RegistroAsistenciaAdolescenteUDI implements Serializable {

    private Integer idRegistroAsistenciaAdolescentesUdi;
    private Boolean asistio;
    private AdolescenteInfractorUDI idAdolescenteUdi;
    private RegistroAsistencia idRegistroAsistencia;

    public RegistroAsistenciaAdolescenteUDI() {
    }

    public Integer getIdRegistroAsistenciaAdolescentesUdi() {
        return idRegistroAsistenciaAdolescentesUdi;
    }

    public void setIdRegistroAsistenciaAdolescentesUdi(Integer idRegistroAsistenciaAdolescentesUdi) {
        this.idRegistroAsistenciaAdolescentesUdi = idRegistroAsistenciaAdolescentesUdi;
    }


    public Boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(Boolean asistio) {
        this.asistio = asistio;
    }

    public AdolescenteInfractorUDI getIdAdolescenteUdi() {
        return idAdolescenteUdi;
    }

    public void setIdAdolescenteUdi(AdolescenteInfractorUDI idAdolescenteUdi) {
        this.idAdolescenteUdi = idAdolescenteUdi;
    }

    public RegistroAsistencia getIdRegistroAsistencia() {
        return idRegistroAsistencia;
    }

    public void setIdRegistroAsistencia(RegistroAsistencia idRegistroAsistencia) {
        this.idRegistroAsistencia = idRegistroAsistencia;
    }

    @Override
    public String toString() {
        return "RegistroAsistenciaAdolescenteUDI{" + "idRegistroAsistenciaAdolescentesUdi=" + idRegistroAsistenciaAdolescentesUdi + ", asistio=" + asistio + ", idAdolescenteUdi=" + idAdolescenteUdi + ", idRegistroAsistencia=" + idRegistroAsistencia + '}';
    }

    
}
