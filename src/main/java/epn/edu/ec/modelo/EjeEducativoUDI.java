package epn.edu.ec.modelo;

import java.io.Serializable;

public class EjeEducativoUDI implements Serializable {

    private AdolescenteInfractorUDI idEjeEducativo;
    private String codigoUnicoElectrico;
    private String coordinacionZonalEducacionDomicilioEstudiante;
    private String distritoEducativoDomicilioEstudiante;
    private Boolean estudia;
    private String razonNoEstudia;
    private String ultimoNivelEducativoAprobado;
    private String nombreUnidadEducativaUltimaAprobado;
    private String sostenimientoUltimoNivelAprobado;
    private String aniosRezagoEscolar;
    private String nivelEducativoActual;
    private String tipoOferta;
    private String nombreUnidadEducativa;
    private String sostenimiento;
    private String regimenEducativo;

    public EjeEducativoUDI() {
    }

    public AdolescenteInfractorUDI getIdEjeEducativo() {
        return idEjeEducativo;
    }

    public void setIdEjeEducativo(AdolescenteInfractorUDI idEjeEducativo) {
        this.idEjeEducativo = idEjeEducativo;
    }

    public String getCodigoUnicoElectrico() {
        return codigoUnicoElectrico;
    }

    public void setCodigoUnicoElectrico(String codigoUnicoElectrico) {
        this.codigoUnicoElectrico = codigoUnicoElectrico;
    }

    public String getCoordinacionZonalEducacionDomicilioEstudiante() {
        return coordinacionZonalEducacionDomicilioEstudiante;
    }

    public void setCoordinacionZonalEducacionDomicilioEstudiante(String coordinacionZonalEducacionDomicilioEstudiante) {
        this.coordinacionZonalEducacionDomicilioEstudiante = coordinacionZonalEducacionDomicilioEstudiante;
    }

    public String getDistritoEducativoDomicilioEstudiante() {
        return distritoEducativoDomicilioEstudiante;
    }

    public void setDistritoEducativoDomicilioEstudiante(String distritoEducativoDomicilioEstudiante) {
        this.distritoEducativoDomicilioEstudiante = distritoEducativoDomicilioEstudiante;
    }

    public Boolean getEstudia() {
        return estudia;
    }

    public void setEstudia(Boolean estudia) {
        this.estudia = estudia;
    }

    public String getRazonNoEstudia() {
        return razonNoEstudia;
    }

    public void setRazonNoEstudia(String razonNoEstudia) {
        this.razonNoEstudia = razonNoEstudia;
    }

    public String getUltimoNivelEducativoAprobado() {
        return ultimoNivelEducativoAprobado;
    }

    public void setUltimoNivelEducativoAprobado(String ultimoNivelEducativoAprobado) {
        this.ultimoNivelEducativoAprobado = ultimoNivelEducativoAprobado;
    }

    public String getNombreUnidadEducativaUltimaAprobado() {
        return nombreUnidadEducativaUltimaAprobado;
    }

    public void setNombreUnidadEducativaUltimaAprobado(String nombreUnidadEducativaUltimaAprobado) {
        this.nombreUnidadEducativaUltimaAprobado = nombreUnidadEducativaUltimaAprobado;
    }

    public String getSostenimientoUltimoNivelAprobado() {
        return sostenimientoUltimoNivelAprobado;
    }

    public void setSostenimientoUltimoNivelAprobado(String sostenimientoUltimoNivelAprobado) {
        this.sostenimientoUltimoNivelAprobado = sostenimientoUltimoNivelAprobado;
    }

    public String getAniosRezagoEscolar() {
        return aniosRezagoEscolar;
    }

    public void setAniosRezagoEscolar(String aniosRezagoEscolar) {
        this.aniosRezagoEscolar = aniosRezagoEscolar;
    }

    public String getNivelEducativoActual() {
        return nivelEducativoActual;
    }

    public void setNivelEducativoActual(String nivelEducativoActual) {
        this.nivelEducativoActual = nivelEducativoActual;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public String getNombreUnidadEducativa() {
        return nombreUnidadEducativa;
    }

    public void setNombreUnidadEducativa(String nombreUnidadEducativa) {
        this.nombreUnidadEducativa = nombreUnidadEducativa;
    }

    public String getSostenimiento() {
        return sostenimiento;
    }

    public void setSostenimiento(String sostenimiento) {
        this.sostenimiento = sostenimiento;
    }

    public String getRegimenEducativo() {
        return regimenEducativo;
    }

    public void setRegimenEducativo(String regimenEducativo) {
        this.regimenEducativo = regimenEducativo;
    }

    @Override
    public String toString() {
        return "EjeEducativoUDI{" + "idEjeEducativo=" + idEjeEducativo + ", codigoUnicoElectrico=" + codigoUnicoElectrico + ", coordinacionZonalEducacionDomicilioEstudiante=" + coordinacionZonalEducacionDomicilioEstudiante + ", distritoEducativoDomicilioEstudiante=" + distritoEducativoDomicilioEstudiante + ", estudia=" + estudia + ", razonNoEstudia=" + razonNoEstudia + ", ultimoNivelEducativoAprobado=" + ultimoNivelEducativoAprobado + ", nombreUnidadEducativaUltimaAprobado=" + nombreUnidadEducativaUltimaAprobado + ", sostenimientoUltimoNivelAprobado=" + sostenimientoUltimoNivelAprobado + ", aniosRezagoEscolar=" + aniosRezagoEscolar + ", nivelEducativoActual=" + nivelEducativoActual + ", tipoOferta=" + tipoOferta + ", nombreUnidadEducativa=" + nombreUnidadEducativa + ", sostenimiento=" + sostenimiento + ", regimenEducativo=" + regimenEducativo + '}';
    }
    
}
