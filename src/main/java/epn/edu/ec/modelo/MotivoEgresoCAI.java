package epn.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;

public class MotivoEgresoCAI implements Serializable {

    private AdolescenteInfractorCAI idMotivoEgreso;
    private String motivoSalida;
    private Date fechaSalidaCentro;
    private CAI caiTrasladoFk;

    public MotivoEgresoCAI() {
    }

    public AdolescenteInfractorCAI getIdMotivoEgreso() {
        return idMotivoEgreso;
    }

    public void setIdMotivoEgreso(AdolescenteInfractorCAI idMotivoEgreso) {
        this.idMotivoEgreso = idMotivoEgreso;
    }

    public String getMotivoSalida() {
        System.out.println("motivo: "+motivoSalida);
        return motivoSalida;
    }

    public void setMotivoSalida(String motivoSalida) {
        this.motivoSalida = motivoSalida;
    }

    public Date getFechaSalidaCentro() {
        return fechaSalidaCentro;
    }

    public void setFechaSalidaCentro(Date fechaSalidaCentro) {
        this.fechaSalidaCentro = fechaSalidaCentro;
    }

    public CAI getCaiTrasladoFk() {
        return caiTrasladoFk;
    }

    public void setCaiTrasladoFk(CAI caiTrasladoFk) {
        this.caiTrasladoFk = caiTrasladoFk;
    }

    @Override
    public String toString() {
        return "MotivoEgresoCAI{" + "idMotivoEgreso=" + idMotivoEgreso + ", motivoSalida=" + motivoSalida + ", fechaSalidaCentro=" + fechaSalidaCentro + ", caiTrasladoFk=" + caiTrasladoFk + '}';
    }

}
