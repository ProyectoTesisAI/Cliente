package epn.edu.ec.modelo;

import java.io.Serializable;

public class DetalleInfraccionCAI implements Serializable {
    
    private AdolescenteInfractorCAI idDetalleInfraccion;
    private String tipoPenal;
    private String provinciaInfraccion;
    private String cantonInfraccion;
    private String unidadJudicial;
    private String nombreUnidadJudicial;
    private String numeroCausa;
    private String nombreJuez;

    public DetalleInfraccionCAI() {
    }

    public AdolescenteInfractorCAI getIdDetalleInfraccion() {
        return idDetalleInfraccion;
    }

    public void setIdDetalleInfraccion(AdolescenteInfractorCAI idDetalleInfraccion) {
        this.idDetalleInfraccion = idDetalleInfraccion;
    }

    public String getTipoPenal() {
        return tipoPenal;
    }

    public void setTipoPenal(String tipoPenal) {
        this.tipoPenal = tipoPenal;
    }

    public String getProvinciaInfraccion() {
        return provinciaInfraccion;
    }

    public void setProvinciaInfraccion(String provinciaInfraccion) {
        this.provinciaInfraccion = provinciaInfraccion;
    }

    public String getCantonInfraccion() {
        return cantonInfraccion;
    }

    public void setCantonInfraccion(String cantonInfraccion) {
        this.cantonInfraccion = cantonInfraccion;
    }

    public String getUnidadJudicial() {
        return unidadJudicial;
    }

    public void setUnidadJudicial(String unidadJudicial) {
        this.unidadJudicial = unidadJudicial;
    }

    public String getNombreUnidadJudicial() {
        return nombreUnidadJudicial;
    }

    public void setNombreUnidadJudicial(String nombreUnidadJudicial) {
        this.nombreUnidadJudicial = nombreUnidadJudicial;
    }

    public String getNumeroCausa() {
        return numeroCausa;
    }

    public void setNumeroCausa(String numeroCausa) {
        this.numeroCausa = numeroCausa;
    }

    public String getNombreJuez() {
        return nombreJuez;
    }

    public void setNombreJuez(String nombreJuez) {
        this.nombreJuez = nombreJuez;
    }

    @Override
    public String toString() {
        return "DetalleInfraccionCAI{" + "idDetalleInfraccion=" + idDetalleInfraccion + ", tipoPenal=" + tipoPenal + ", provinciaInfraccion=" + provinciaInfraccion + ", cantonInfraccion=" + cantonInfraccion + ", unidadJudicial=" + unidadJudicial + ", nombreUnidadJudicial=" + nombreUnidadJudicial + ", numeroCausa=" + numeroCausa + ", nombreJuez=" + nombreJuez + '}';
    }
    
}
