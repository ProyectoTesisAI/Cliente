package epn.edu.ec.modelo;

import epn.edu.ec.utilidades.Validaciones;
import java.io.Serializable;
import java.util.Date;

public class AdolescenteInfractorCAI implements Serializable {

    private Integer idAdolescenteCai;
    private Date fechaReporte;
    private String apellidos;
    private String nombres;
    private String cedula;
    private Date fechaNacimiento;
    private Integer edad;
    private String sexo;
    private String paisOrigen;
    private String nacionalidad;
    private String estadoCivil;
    private String ocupacion;
    private String tieneHijos;
    private String etnia;
    private Boolean registroSocial;
    private String direccionDomicilio;
    private String provinciaAdolescente;
    private String cantonAdolescente;
    private String numeroContacto;
    private String nombresRepresentante;
    private String observacionIngreso;

    //Verificadores
    private Validaciones validacion = new Validaciones();
    private Boolean verificadorCedula;
    private Boolean verificadorFechaNacimiento;

    public AdolescenteInfractorCAI() {
    }

    public Integer getIdAdolescenteCai() {
        return idAdolescenteCai;
    }

    public void setIdAdolescenteCai(Integer idAdolescenteCai) {
        this.idAdolescenteCai = idAdolescenteCai;
    }

    public Date getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(Date fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad=validacion.obtenerEdad(fechaNacimiento);
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTieneHijos() {
        return tieneHijos;
    }

    public void setTieneHijos(String tieneHijos) {
        this.tieneHijos = tieneHijos;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public Boolean getRegistroSocial() {
        return registroSocial;
    }

    public void setRegistroSocial(Boolean registroSocial) {
        this.registroSocial = registroSocial;
    }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
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

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getNombresRepresentante() {
        return nombresRepresentante;
    }

    public void setNombresRepresentante(String nombresRepresentante) {
        this.nombresRepresentante = nombresRepresentante;
    }

    public String getObservacionIngreso() {
        return observacionIngreso;
    }

    public void setObservacionIngreso(String observacionIngreso) {
        this.observacionIngreso = observacionIngreso;
    }

    public Boolean getVerificadorCedula() {
        if (cedula != null) {
            verificadorCedula = false;
            verificadorCedula = validacion.cedulaValida(cedula);
            if (verificadorCedula == true) {
                return verificadorCedula;
            } else {
                return verificadorCedula = false;
            }
        } else {
            return verificadorCedula;
        }
    }

    public void setVerificadorCedula(Boolean verificadorCedula) {
        this.verificadorCedula = verificadorCedula;
    }

    public Boolean getVerificadorFechaNacimiento() {
        if (fechaNacimiento != null) {
            verificadorFechaNacimiento = false;
            verificadorFechaNacimiento = validacion.verificarFechaNacimiento(fechaNacimiento);
            if (verificadorFechaNacimiento == true) {
                return verificadorCedula;
            } else {
                return verificadorCedula = false;
            }
        } else {
            return verificadorFechaNacimiento;
        }
    }

    public void setVerificadorFechaNacimiento(Boolean verificadorFechaNacimiento) {
        this.verificadorFechaNacimiento = verificadorFechaNacimiento;
    }

    @Override
    public String toString() {
        return "AdolescenteInfractorCAI{" + "idAdolescenteCai=" + idAdolescenteCai + ", fechaReporte=" + fechaReporte + ", apellidos=" + apellidos + ", nombres=" + nombres + ", cedula=" + cedula + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", sexo=" + sexo + ", paisOrigen=" + paisOrigen + ", nacionalidad=" + nacionalidad + ", estadoCivil=" + estadoCivil + ", ocupacion=" + ocupacion + ", tieneHijos=" + tieneHijos + ", etnia=" + etnia + ", registroSocial=" + registroSocial + ", direccionDomicilio=" + direccionDomicilio + ", provinciaAdolescente=" + provinciaAdolescente + ", cantonAdolescente=" + cantonAdolescente + ", numeroContacto=" + numeroContacto + ", nombresRepresentante=" + nombresRepresentante + ", observacionIngreso=" + observacionIngreso + '}';
    }
}
