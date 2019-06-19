/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.modelo.Representante;
import epn.edu.ec.servicios.RepresentanteServicio;
import epn.edu.ec.utilidades.EnlacesPrograma;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author User
 */
@Named(value = "representanteControlador")
@ViewScoped
public class RepresentanteControlador implements Serializable{

    private AdolescenteInfractorUDI adolescenteInfractorUDI;
    private Representante representante;
    private RepresentanteServicio servicio;
    private boolean guardado;
    private EnlacesPrograma enlaces;
    
    @PostConstruct
    public void init(){
        
        enlaces= new EnlacesPrograma();
        servicio= new RepresentanteServicio();
        
        representante= new Representante();
        guardado=false;
        
        adolescenteInfractorUDI= new AdolescenteInfractorUDI();
        adolescenteInfractorUDI= (AdolescenteInfractorUDI)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");
        
        if(adolescenteInfractorUDI != null){
            Representante representanteAux= servicio.obtenerRepresentante(adolescenteInfractorUDI.getId_adolescente_udi_pk());
            if(representanteAux!=null){
                representante=representanteAux;
                guardado=true;
            }            
        }
        
    }

    public AdolescenteInfractorUDI getAdolescenteInfractorUDI() {
        return adolescenteInfractorUDI;
    }

    public void setAdolescenteInfractorUDI(AdolescenteInfractorUDI adolescenteInfractorUDI) {
        this.adolescenteInfractorUDI = adolescenteInfractorUDI;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public RepresentanteServicio getServicio() {
        return servicio;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    
    /*********************Métodos para invocar a los diferentes servicios web******************/
    
    public String guardarRepresentante(){
        
        this.representante.setIdRepresentante(adolescenteInfractorUDI);

        Representante representanteAux = servicio.guardarRepresentante(representante);
        if(representanteAux!=null){
            return enlaces.PATH_PANEL_UDI+"?faces-redirect=true";    
        }
        else{
            return null;
        }
    }

    
}
