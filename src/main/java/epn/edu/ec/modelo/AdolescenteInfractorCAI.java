package epn.edu.ec.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
        if(fechaNacimiento!=null){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "E MMM dd HH:mm:ss z uuuu" ).withLocale( Locale.US );
            ZonedDateTime zdt = ZonedDateTime.parse( fechaNacimiento.toString() , dtf );
            LocalDate ld = zdt.toLocalDate();

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fecha= ld.format(fmt);
            LocalDate fechaNac = LocalDate.parse(fecha, fmt);
            LocalDate ahora = LocalDate.now();

            Period periodo = Period.between(fechaNac, ahora);
            edad=periodo.getYears();
            return edad;
        }
        return edad;
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

    
    
}
