/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author User
 */
public class AdolescenteInfractorUDI implements Serializable {

    private Integer id_adolescente_udi_pk;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String genero;
    private String etnia;
    private String discapacidad;
    private String tipoDiscapacidad;
    private Integer porcentajeDiscapacidad;
    private Boolean enfermedadesCatastroficasRaras;
    private Boolean registroSocial;
    private String estadoCivil;
    private Date fechaNacimiento;
    private Integer edad;
    private Integer numeroHijos;
    private String conQuienVive;

    
    public AdolescenteInfractorUDI() {
    }

    public Integer getId_adolescente_udi_pk() {
        return id_adolescente_udi_pk;
    }

    public void setId_adolescente_udi_pk(Integer id_adolescente_udi_pk) {
        this.id_adolescente_udi_pk = id_adolescente_udi_pk;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
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

    public Boolean getRegistroSocial() {
        return registroSocial;
    }

    public void setRegistroSocial(Boolean registroSocial) {
        this.registroSocial = registroSocial;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(Integer numeroHijos) {
        this.numeroHijos = numeroHijos;
    }

    public String getConQuienVive() {
        return conQuienVive;
    }

    public void setConQuienVive(String conQuienVive) {
        this.conQuienVive = conQuienVive;
    }

    @Override
    public String toString() {
        return "AdolescenteInfractorUDI{" + "id_adolescente_udi_pk=" + id_adolescente_udi_pk + ", nombres=" + nombres + ", apellidos=" + apellidos + ", cedula=" + cedula + ", genero=" + genero + ", etnia=" + etnia + ", discapacidad=" + discapacidad + ", tipoDiscapacidad=" + tipoDiscapacidad + ", porcentajeDiscapacidad=" + porcentajeDiscapacidad + ", enfermedadesCatastroficasRaras=" + enfermedadesCatastroficasRaras + ", registroSocial=" + registroSocial + ", estadoCivil=" + estadoCivil + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", numeroHijos=" + numeroHijos + ", conQuienVive=" + conQuienVive + '}';
    }

}
