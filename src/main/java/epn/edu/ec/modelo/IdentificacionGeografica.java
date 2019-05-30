package epn.edu.ec.modelo;

import java.io.Serializable;

public class IdentificacionGeografica implements Serializable {

    private AdolescenteInfractorUDI idIdentificacionGeografica;
    private String paisNacimiento;
    private String provinciaAdolescente;
    private String cantonAdolescente;
    private String parroquia;
    private String direccionDomicilio;
    private String referenciaDomicilio;
    private String telefono;
    
    public IdentificacionGeografica() {
    }

    public AdolescenteInfractorUDI getIdIdentificacionGeografica() {
        return idIdentificacionGeografica;
    }

    public void setIdIdentificacionGeografica(AdolescenteInfractorUDI idIdentificacionGeografica) {
        this.idIdentificacionGeografica = idIdentificacionGeografica;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getProvinciaAdolescente() {
        return provinciaAdolescente;
    }

    public void setProvinciaAdolescente(String provinciaAdolescente) {
        this.provinciaAdolescente = provinciaAdolescente;
    }

    public String getCantonAdolescente() {
        return cantonAdolescente;
    }

    public void setCantonAdolescente(String cantonAdolescente) {
        this.cantonAdolescente = cantonAdolescente;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public String getReferenciaDomicilio() {
        return referenciaDomicilio;
    }

    public void setReferenciaDomicilio(String referenciaDomicilio) {
        this.referenciaDomicilio = referenciaDomicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "IdentificacionGeografica{" + "idIdentificacionGeografica=" + idIdentificacionGeografica + ", paisNacimiento=" + paisNacimiento + ", provinciaAdolescente=" + provinciaAdolescente + ", cantonAdolescente=" + cantonAdolescente + ", parroquia=" + parroquia + ", direccionDomicilio=" + direccionDomicilio + ", referenciaDomicilio=" + referenciaDomicilio + ", telefono=" + telefono + '}';
    }

}
