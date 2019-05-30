package epn.edu.ec.modelo;

import java.io.Serializable;


public class InformacionInfraccion implements Serializable {

    private AdolescenteInfractorUDI idInformacionInfraccion;
    private String provinciaDetencion;
    private String cantonDetencion;
    private String tipoInfraccion;
    
    public InformacionInfraccion() {
    }

    public AdolescenteInfractorUDI getIdInformacionInfraccion() {
        return idInformacionInfraccion;
    }

    public void setIdInformacionInfraccion(AdolescenteInfractorUDI idInformacionInfraccion) {
        this.idInformacionInfraccion = idInformacionInfraccion;
    }

    public String getProvinciaDetencion() {
        return provinciaDetencion;
    }

    public void setProvinciaDetencion(String provinciaDetencion) {
        this.provinciaDetencion = provinciaDetencion;
    }

    public String getCantonDetencion() {
        return cantonDetencion;
    }

    public void setCantonDetencion(String cantonDetencion) {
        this.cantonDetencion = cantonDetencion;
    }

    public String getTipoInfraccion() {
        return tipoInfraccion;
    }

    public void setTipoInfraccion(String tipoInfraccion) {
        this.tipoInfraccion = tipoInfraccion;
    }

    @Override
    public String toString() {
        return "InformacionInfraccion{" + "idInformacionInfraccion=" + idInformacionInfraccion + ", provinciaDetencion=" + provinciaDetencion + ", cantonDetencion=" + cantonDetencion + ", tipoInfraccion=" + tipoInfraccion + '}';
    }
    
}
