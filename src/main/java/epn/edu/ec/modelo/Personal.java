package epn.edu.ec.modelo;

import java.io.Serializable;

public class Personal implements Serializable {

    private Integer idPersonalPk;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String usuario;
    private String password;
    private String rol;

    public Personal() {
    }

    public Personal(Integer idPersonalPk) {
        this.idPersonalPk = idPersonalPk;
    }

    public Integer getIdPersonalPk() {
        return idPersonalPk;
    }

    public void setIdPersonalPk(Integer idPersonalPk) {
        this.idPersonalPk = idPersonalPk;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }    

    @Override
    public String toString() {
        return "Personal{" + "idPersonalPk=" + idPersonalPk + ", nombres=" + nombres + ", apellidos=" + apellidos + ", cedula=" + cedula + ", usuario=" + usuario + ", password=" + password + ", rol=" + rol + '}';
    }
    
}
