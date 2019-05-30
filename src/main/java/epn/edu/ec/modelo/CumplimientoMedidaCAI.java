package epn.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;

public class CumplimientoMedidaCAI implements Serializable {

    private AdolescenteInfractorCAI idCumplimientoMedida;
    private Date fechaCumplimiento100;
    private Date alertaCambioMedida;

    public CumplimientoMedidaCAI() {
    }

    public AdolescenteInfractorCAI getIdCumplimientoMedida() {
        return idCumplimientoMedida;
    }

    public void setIdCumplimientoMedida(AdolescenteInfractorCAI idCumplimientoMedida) {
        this.idCumplimientoMedida = idCumplimientoMedida;
    }

    public Date getFechaCumplimiento100() {
        return fechaCumplimiento100;
    }

    public void setFechaCumplimiento100(Date fechaCumplimiento100) {
        this.fechaCumplimiento100 = fechaCumplimiento100;
    }

    public Date getAlertaCambioMedida() {
        return alertaCambioMedida;
    }

    public void setAlertaCambioMedida(Date alertaCambioMedida) {
        this.alertaCambioMedida = alertaCambioMedida;
    }

    @Override
    public String toString() {
        return "CumplimientoMedidaCAI{" + "idCumplimientoMedida=" + idCumplimientoMedida + ", fechaCumplimiento100=" + fechaCumplimiento100 + ", alertaCambioMedida=" + alertaCambioMedida + '}';
    }
    
}
