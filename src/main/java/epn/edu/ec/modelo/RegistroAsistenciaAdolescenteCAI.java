package epn.edu.ec.modelo;

import java.io.Serializable;

public class RegistroAsistenciaAdolescenteCAI implements Serializable {

    private Integer idRegistroAsistenciaAdolescenteCai;
    private Boolean asistio;
    private AdolescenteInfractorCAI idAdolescenteCai;
    private RegistroAsistencia idRegistroAsistencia;

    public RegistroAsistenciaAdolescenteCAI() {
    }

    public Integer getIdRegistroAsistenciaAdolescenteCai() {
        return idRegistroAsistenciaAdolescenteCai;
    }

    public void setIdRegistroAsistenciaAdolescenteCai(Integer idRegistroAsistenciaAdolescenteCai) {
        this.idRegistroAsistenciaAdolescenteCai = idRegistroAsistenciaAdolescenteCai;
    }

    public Boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(Boolean asistio) {
        this.asistio = asistio;
    }

    public AdolescenteInfractorCAI getIdAdolescenteCai() {
        return idAdolescenteCai;
    }

    public void setIdAdolescenteCai(AdolescenteInfractorCAI idAdolescenteCai) {
        this.idAdolescenteCai = idAdolescenteCai;
    }

    public RegistroAsistencia getIdRegistroAsistencia() {
        return idRegistroAsistencia;
    }

    public void setIdRegistroAsistencia(RegistroAsistencia idIdRegistroAsistencia) {
        this.idRegistroAsistencia = idIdRegistroAsistencia;
    }

    @Override
    public String toString() {
        return "RegistroAsistenciaAdolescenteCAI{" + "idRegistroAsistenciaAdolescenteCai=" + idRegistroAsistenciaAdolescenteCai + ", asistio=" + asistio + ", idAdolescenteCai=" + idAdolescenteCai + ", idRegistroAsistencia=" + idRegistroAsistencia + '}';
    }
    
}