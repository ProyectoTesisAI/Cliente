package epn.edu.ec.modelo;

import java.io.Serializable;

public class EjeSaludCAI implements Serializable {

    private AdolescenteInfractorCAI idEjeSalud;
    private String situacionSalud;
    private String discapacidad;
    private String tipoDiscapacidad;
    private Integer porcentajeDiscapacidad;
    private Boolean enfermedadesCatastroficasRaras;
    private Boolean recibeTratamiento;
    private Boolean tomaMedicacion;
    private Boolean consumeSustancias;
    private String tipoSustancia;
    private Boolean recibeTratamientoDrogas;

    public EjeSaludCAI() {
    }

    public AdolescenteInfractorCAI getIdEjeSalud() {
        return idEjeSalud;
    }

    public void setIdEjeSalud(AdolescenteInfractorCAI idEjeSalud) {
        this.idEjeSalud = idEjeSalud;
    }

    public String getSituacionSalud() {
        return situacionSalud;
    }

    public void setSituacionSalud(String situacionSalud) {
        this.situacionSalud = situacionSalud;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getTipoDiscapacidad() {
        return tipoDiscapacidad;
    }

    public void setTipoDiscapacidad(String tipoDiscapacidad) {
        this.tipoDiscapacidad = tipoDiscapacidad;
    }

    public Integer getPorcentajeDiscapacidad() {
        return porcentajeDiscapacidad;
    }

    public void setPorcentajeDiscapacidad(Integer porcentajeDiscapacidad) {
        this.porcentajeDiscapacidad = porcentajeDiscapacidad;
    }

    public Boolean getEnfermedadesCatastroficasRaras() {
        return enfermedadesCatastroficasRaras;
    }

    public void setEnfermedadesCatastroficasRaras(Boolean enfermedadesCatastroficasRaras) {
        this.enfermedadesCatastroficasRaras = enfermedadesCatastroficasRaras;
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
        return "EjeSaludCAI{" + "idEjeSalud=" + idEjeSalud + ", situacionSalud=" + situacionSalud + ", discapacidad=" + discapacidad + ", tipoDiscapacidad=" + tipoDiscapacidad + ", porcentajeDiscapacidad=" + porcentajeDiscapacidad + ", enfermedadesCatastroficasRaras=" + enfermedadesCatastroficasRaras + ", recibeTratamiento=" + recibeTratamiento + ", tomaMedicacion=" + tomaMedicacion + ", consumeSustancias=" + consumeSustancias + ", tipoSustancia=" + tipoSustancia + ", recibeTratamientoDrogas=" + recibeTratamientoDrogas + '}';
    }
    
}
