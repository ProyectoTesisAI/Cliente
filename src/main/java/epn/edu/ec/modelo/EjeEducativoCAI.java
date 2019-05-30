package epn.edu.ec.modelo;

import java.io.Serializable;

public class EjeEducativoCAI implements Serializable {

    private AdolescenteInfractorCAI idEjeEducativo;
    private String codigoUnicoElectrico;
    private String coordinacionZonalEducacionDomicilioEstudiante;
    private String distritoEducativoDomicilioEstudiante;
    private Boolean estudia;
    private String razonNoEstudia;
    private String ultimoNivelEducativoAprobado;
    private String nombreUnidadEducativoUltimo;
    private String sostenimientoUltimoNivel;
    private String aniosRezagoEscolar;
    private String nivelEducativoActual;
    private String tipoOferta;
    private String nombreUnidadEducativa;
    private String sostenimiento;
    private String regimenEducativo;

    public EjeEducativoCAI() {
    }

    public AdolescenteInfractorCAI getIdEjeEducativo() {
        return idEjeEducativo;
    }

    public void setIdEjeEducativo(AdolescenteInfractorCAI idEjeEducativo) {
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

    public String getNombreUnidadEducativoUltimo() {
        return nombreUnidadEducativoUltimo;
    }

    public void setNombreUnidadEducativoUltimo(String nombreUnidadEducativoUltimo) {
        this.nombreUnidadEducativoUltimo = nombreUnidadEducativoUltimo;
    }

    public String getSostenimientoUltimoNivel() {
        return sostenimientoUltimoNivel;
    }

    public void setSostenimientoUltimoNivel(String sostenimientoUltimoNivel) {
        this.sostenimientoUltimoNivel = sostenimientoUltimoNivel;
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
        return "EjeEducativoCAI{" + "idEjeEducativo=" + idEjeEducativo + ", codigoUnicoElectrico=" + codigoUnicoElectrico + ", coordinacionZonalEducacionDomicilioEstudiante=" + coordinacionZonalEducacionDomicilioEstudiante + ", distritoEducativoDomicilioEstudiante=" + distritoEducativoDomicilioEstudiante + ", estudia=" + estudia + ", razonNoEstudia=" + razonNoEstudia + ", ultimoNivelEducativoAprobado=" + ultimoNivelEducativoAprobado + ", nombreUnidadEducativoUltimo=" + nombreUnidadEducativoUltimo + ", sostenimientoUltimoNivel=" + sostenimientoUltimoNivel + ", aniosRezagoEscolar=" + aniosRezagoEscolar + ", nivelEducativoActual=" + nivelEducativoActual + ", tipoOferta=" + tipoOferta + ", nombreUnidadEducativa=" + nombreUnidadEducativa + ", sostenimiento=" + sostenimiento + ", regimenEducativo=" + regimenEducativo + '}';
    }
    
}
