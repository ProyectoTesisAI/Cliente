package epn.edu.ec.modelo;

import java.io.Serializable;

public class EjeSaludUDI implements Serializable {

    private AdolescenteInfractorUDI idEjeSalud;
    private String situacionSalud;
    private String diagnosticoEnfermedad;
    private Boolean recibeTratamiento;
    private Boolean tomaMedicacion;
    private String numeroHistoriaClinica;
    private String embarazo;
    private String tiempoGestacionMes;
    private Boolean consumeSustancias;
    private String tipoSustancia;
    private Boolean recibeTratamientoDrogas;

    public EjeSaludUDI() {
    }

    public AdolescenteInfractorUDI getIdEjeSalud() {
        return idEjeSalud;
    }

    public void setIdEjeSalud(AdolescenteInfractorUDI idEjeSalud) {
        this.idEjeSalud = idEjeSalud;
    }

    public String getSituacionSalud() {
        return situacionSalud;
    }

    public void setSituacionSalud(String situacionSalud) {
        this.situacionSalud = situacionSalud;
    }

    public String getDiagnosticoEnfermedad() {
        return diagnosticoEnfermedad;
    }

    public void setDiagnosticoEnfermedad(String diagnosticoEnfermedad) {
        this.diagnosticoEnfermedad = diagnosticoEnfermedad;
    }

    public Boolean getRecibeTratamiento() {
        return recibeTratamiento;
    }

    public void setRecibeTratamiento(Boolean recibeTratamiento) {
        this.recibeTratamiento = recibeTratamiento;
    }

    public Boolean getTomaMedicacion() {
        return tomaMedicacion;
    }

    public void setTomaMedicacion(Boolean tomaMedicacion) {
        this.tomaMedicacion = tomaMedicacion;
    }

    public String getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(String numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    public String getEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(String embarazo) {
        this.embarazo = embarazo;
    }

    public String getTiempoGestacionMes() {
        return tiempoGestacionMes;
    }

    public void setTiempoGestacionMes(String tiempoGestacionMes) {
        this.tiempoGestacionMes = tiempoGestacionMes;
    }

    public Boolean getConsumeSustancias() {
        return consumeSustancias;
    }

    public void setConsumeSustancias(Boolean consumeSustancias) {
        this.consumeSustancias = consumeSustancias;
    }

    public String getTipoSustancia() {
        return tipoSustancia;
    }

    public void setTipoSustancia(String tipoSustancia) {
        this.tipoSustancia = tipoSustancia;
    }

    public Boolean getRecibeTratamientoDrogas() {
        return recibeTratamientoDrogas;
    }

    public void setRecibeTratamientoDrogas(Boolean recibeTratamientoDrogas) {
        this.recibeTratamientoDrogas = recibeTratamientoDrogas;
    }

    @Override
    public String toString() {
        return "EjeSaludUDI{" + "idEjeSalud=" + idEjeSalud + ", situacionSalud=" + situacionSalud + ", diagnosticoEnfermedad=" + diagnosticoEnfermedad + ", recibeTratamiento=" + recibeTratamiento + ", tomaMedicacion=" + tomaMedicacion + ", numeroHistoriaClinica=" + numeroHistoriaClinica + ", embarazo=" + embarazo + ", tiempoGestacionMes=" + tiempoGestacionMes + ", consumeSustancias=" + consumeSustancias + ", tipoSustancia=" + tipoSustancia + ", recibeTratamientoDrogas=" + recibeTratamientoDrogas + '}';
    }
    
}
