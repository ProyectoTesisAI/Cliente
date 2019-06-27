package epn.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;

public class InformePsicologia implements Serializable {

    private Integer idInformePsicologia;
    private Date fecha;
    private Date hora;
    private Integer numAdolescentes;
    private String adolescentesJustificacion;
    private String objetivoGeneral;
    private String socializacionDesarrollo;
    private String socializacionObjetivos;
    private String cierreEvaluacion;
    private String conclusiones;
    private String recomendaciones;
    private String observaciones;
    private String elaborado;
    
    //variable local para analizar si estamos viendo o editando
    private String estado;
    /*puede tener:
    -editar
    -ver*/

    private TallerPsicologia idTallerPsicologia;
    
    public InformePsicologia() {
    }

    public Integer getIdInformePsicologia() {
        return idInformePsicologia;
    }

    public void setIdInformePsicologia(Integer idInformePsicologia) {
        this.idInformePsicologia = idInformePsicologia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Integer getNumAdolescentes() {
        return numAdolescentes;
    }

    public void setNumAdolescentes(Integer numAdolescentes) {
        this.numAdolescentes = numAdolescentes;
    }

    public String getAdolescentesJustificacion() {
        return adolescentesJustificacion;
    }

    public void setAdolescentesJustificacion(String adolescentesJustificacion) {
        this.adolescentesJustificacion = adolescentesJustificacion;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getSocializacionDesarrollo() {
        return socializacionDesarrollo;
    }

    public void setSocializacionDesarrollo(String socializacionDesarrollo) {
        this.socializacionDesarrollo = socializacionDesarrollo;
    }

    public String getSocializacionObjetivos() {
        return socializacionObjetivos;
    }

    public void setSocializacionObjetivos(String socializacionObjetivos) {
        this.socializacionObjetivos = socializacionObjetivos;
    }

    public String getCierreEvaluacion() {
        return cierreEvaluacion;
    }

    public void setCierreEvaluacion(String cierreEvaluacion) {
        this.cierreEvaluacion = cierreEvaluacion;
    }

    public String getConclusiones() {
        return conclusiones;
    }

    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getElaborado() {
        return elaborado;
    }

    public void setElaborado(String elaborado) {
        this.elaborado = elaborado;
    }

    public TallerPsicologia getIdTallerPsicologia() {
        return idTallerPsicologia;
    }

    public void setIdTallerPsicologia(TallerPsicologia idTallerPsicologia) {
        this.idTallerPsicologia = idTallerPsicologia;
    }

    //Get y set de variable local
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "InformePsicologia{" + "idInformePsicologia=" + idInformePsicologia + ", fecha=" + fecha + ", hora=" + hora + ", numAdolescentes=" + numAdolescentes + ", adolescentesJustificacion=" + adolescentesJustificacion + ", objetivoGeneral=" + objetivoGeneral + ", socializacionDesarrollo=" + socializacionDesarrollo + ", socializacionObjetivos=" + socializacionObjetivos + ", cierreEvaluacion=" + cierreEvaluacion + ", conclusiones=" + conclusiones + ", recomendaciones=" + recomendaciones + ", observaciones=" + observaciones + ", elaborado=" + elaborado + ", idTallerPsicologia=" + idTallerPsicologia + '}';
    }

}
