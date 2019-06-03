package epn.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;

public class TallerPsicologia implements Serializable {

    private Integer idTallerPsicologia;
    private String tema;
    private Integer numeroTaller;
    private Date fecha;
    private String objetivo;
    private Integer numeroTotalParticipantes;
    private String recomendaciones;
    private String elaborado;
    
    private CAI idCai;
    private UDI idUdi;
    
    public TallerPsicologia() {
    }

    public Integer getIdTallerPsicologia() {
        return idTallerPsicologia;
    }

    public void setIdTallerPsicologia(Integer idTallerPsicologia) {
        this.idTallerPsicologia = idTallerPsicologia;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Integer getNumeroTaller() {
        return numeroTaller;
    }

    public void setNumeroTaller(Integer numeroTaller) {
        this.numeroTaller = numeroTaller;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Integer getNumeroTotalParticipantes() {
        return numeroTotalParticipantes;
    }

    public void setNumeroTotalParticipantes(Integer numeroTotalParticipantes) {
        this.numeroTotalParticipantes = numeroTotalParticipantes;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getElaborado() {
        return elaborado;
    }

    public void setElaborado(String elaborado) {
        this.elaborado = elaborado;
    }

    public CAI getIdCai() {
        return idCai;
    }

    public void setIdCai(CAI idCai) {
        this.idCai = idCai;
    }

    public UDI getIdUdi() {
        return idUdi;
    }

    public void setIdUdi(UDI idUdi) {
        this.idUdi = idUdi;
    }

    @Override
    public String toString() {
        return "TallerPsicologia{" + "idTallerPsicologia=" + idTallerPsicologia + ", tema=" + tema + ", numeroTaller=" + numeroTaller + ", fecha=" + fecha + ", objetivo=" + objetivo + ", numeroTotalParticipantes=" + numeroTotalParticipantes + ", recomendaciones=" + recomendaciones + ", elaborado=" + elaborado + ", idCai=" + idCai + ", idUdi=" + idUdi + '}';
    }  
}
