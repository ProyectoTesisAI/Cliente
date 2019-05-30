package epn.edu.ec.modelo;

import java.io.Serializable;

public class Representante implements Serializable {

    private AdolescenteInfractorUDI idRepresentante;
    private String cedula;
    private String nombresApellidos;
    private String parentesco;
    
    public Representante() {
    }

    public AdolescenteInfractorUDI getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(AdolescenteInfractorUDI idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public String toString() {
        return "Representante{" + "idRepresentante=" + idRepresentante + ", cedula=" + cedula + ", nombresApellidos=" + nombresApellidos + ", parentesco=" + parentesco + '}';
    }
    
}
