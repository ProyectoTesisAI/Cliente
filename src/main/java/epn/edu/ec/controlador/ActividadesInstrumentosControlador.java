/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.controlador;

import epn.edu.ec.modelo.ActividadesInstrumentos;
import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.servicios.ActividadesInstrumentosServicio;
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
@Named(value = "actividadesInstrumentosControlador")
@ViewScoped
public class ActividadesInstrumentosControlador implements Serializable{

    private AdolescenteInfractorUDI adolescenteInfractorUDI;
    private ActividadesInstrumentos actividadesInstrumentos;
    private ActividadesInstrumentosServicio servicio;
    private boolean guardado;
    private EnlacesPrograma enlaces;
    
    
    @PostConstruct
    public void init(){
        
        
        enlaces= new EnlacesPrograma();
        servicio= new ActividadesInstrumentosServicio();
        
        actividadesInstrumentos= new ActividadesInstrumentos();
        guardado=false;
        
        adolescenteInfractorUDI= new AdolescenteInfractorUDI();
        AdolescenteInfractorUDI adolescenteInfractorUDIAux= (AdolescenteInfractorUDI)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");
        
        if(adolescenteInfractorUDIAux != null){
            
            adolescenteInfractorUDI=adolescenteInfractorUDIAux;
            
            ActividadesInstrumentos actividadesInstrumentosAux= servicio.obtenerActividadesInstrumentos(adolescenteInfractorUDI.getId_adolescente_udi_pk());
            if(actividadesInstrumentosAux!=null){
                actividadesInstrumentos=actividadesInstrumentosAux;
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

    public ActividadesInstrumentos getActividadesInstrumentos() {
        return actividadesInstrumentos;
    }

    public void setActividadesInstrumentos(ActividadesInstrumentos actividadesInstrumentos) {
        this.actividadesInstrumentos = actividadesInstrumentos;
    }

    
    public ActividadesInstrumentosServicio getServicio() {
        return servicio;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }
    
    /*********************Métodos para invocar a los diferentes servicios web******************/
    
    public String guardarActividadesInstrumentos(){
        
        this.actividadesInstrumentos.setIdActividadesInstrumentos(adolescenteInfractorUDI);

        ActividadesInstrumentos actividadesInstrumentosAux = servicio.guardarActividadesInstrumentos(actividadesInstrumentos);
        if(actividadesInstrumentosAux!=null){
            return enlaces.PATH_PANEL_UDI+"?faces-redirect=true";      
        }
        else{
            return null;
        }
    }

}
