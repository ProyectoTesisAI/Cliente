package epn.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;

public class EstadoCumplimientoMedida implements Serializable {

    private AdolescenteInfractorUDI idEstadoCumplimientoMedida;
    private String situacionActual;
    private Date fechaReporteCulminacion;
    private Date fechaReporteDerivacion;
    private String uzdiReceptoraDerivacion;
    private Date fechaReporteIncumplimiento;
    private String estadoIncumplimiento;
    private Boolean reanudacionMedida;
    private Date fechaReanudacion;
    
    public EstadoCumplimientoMedida() {
    }

    public AdolescenteInfractorUDI getIdEstadoCumplimientoMedida() {
        return idEstadoCumplimientoMedida;
    }

    public void setIdEstadoCumplimientoMedida(AdolescenteInfractorUDI idEstadoCumplimientoMedida) {
        this.idEstadoCumplimientoMedida = idEstadoCumplimientoMedida;
    }

    public String getSituacionActual() {
        return situacionActual;
    }

    public void setSituacionActual(String situacionActual) {
        this.situacionActual = situacionActual;
    }

    public Date getFechaReporteCulminacion() {
        return fechaReporteCulminacion;
    }

    public void setFechaReporteCulminacion(Date fechaReporteCulminacion) {
        this.fechaReporteCulminacion = fechaReporteCulminacion;
    }

    public Date getFechaReporteDerivacion() {
        return fechaReporteDerivacion;
    }

    public void setFechaReporteDerivacion(Date fechaReporteDerivacion) {
        this.fechaReporteDerivacion = fechaReporteDerivacion;
    }

    public String getUzdiReceptoraDerivacion() {
        return uzdiReceptoraDerivacion;
    }

    public void setUzdiReceptoraDerivacion(String uzdiReceptoraDerivacion) {
        this.uzdiReceptoraDerivacion = uzdiReceptoraDerivacion;
    }

    public Date getFechaReporteIncumplimiento() {
        return fechaReporteIncumplimiento;
    }

    public void setFechaReporteIncumplimiento(Date fechaReporteIncumplimiento) {
        this.fechaReporteIncumplimiento = fechaReporteIncumplimiento;
    }

    public String getEstadoIncumplimiento() {
        return estadoIncumplimiento;
    }

    public void setEstadoIncumplimiento(String estadoIncumplimiento) {
        this.estadoIncumplimiento = estadoIncumplimiento;
    }

    public Boolean getReanudacionMedida() {
        return reanudacionMedida;
    }

    public void setReanudacionMedida(Boolean reanudacionMedida) {
        this.reanudacionMedida = reanudacionMedida;
    }

    public Date getFechaReanudacion() {
        return fechaReanudacion;
    }

    public void setFechaReanudacion(Date fechaReanudacion) {
        this.fechaReanudacion = fechaReanudacion;
    }

    @Override
    public String toString() {
        return "EstadoCumplimientoMedida{" + "idEstadoCumplimientoMedida=" + idEstadoCumplimientoMedida + ", situacionActual=" + situacionActual + ", fechaReporteCulminacion=" + fechaReporteCulminacion + ", fechaReporteDerivacion=" + fechaReporteDerivacion + ", uzdiReceptoraDerivacion=" + uzdiReceptoraDerivacion + ", fechaReporteIncumplimiento=" + fechaReporteIncumplimiento + ", estadoIncumplimiento=" + estadoIncumplimiento + ", reanudacionMedida=" + reanudacionMedida + ", fechaReanudacion=" + fechaReanudacion + '}';
    }
}
