/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.modelo.EjeSaludUDI;
import epn.edu.ec.servicios.EjeSaludUDIServicio;
import epn.edu.ec.utilidades.EnlacesPrograma;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "ejeSaludUDIControlador")
@ViewScoped
public class EjeSaludUDIControlador implements Serializable{

    private AdolescenteInfractorUDI adolescenteInfractorUDI;
    private EjeSaludUDI ejeSaludUDI;
    private EjeSaludUDIServicio servicio;
    private boolean guardado;
    private boolean saludable;
    private EnlacesPrograma enlaces;
    
     @PostConstruct
    public void init(){
        
        enlaces= new EnlacesPrograma();
        servicio= new EjeSaludUDIServicio();
        
        ejeSaludUDI= new EjeSaludUDI();
        guardado=false;
        
        if (isSaludable()) {
            saludable = true;
        } else {
            saludable = false;            
        }
        
        adolescenteInfractorUDI= new AdolescenteInfractorUDI();
        AdolescenteInfractorUDI adolescenteInfractorUDIAux= (AdolescenteInfractorUDI)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");
        
        if(adolescenteInfractorUDIAux != null){
            
            adolescenteInfractorUDI=adolescenteInfractorUDIAux;
            EjeSaludUDI ejeSaludUDIAux= servicio.obtenerEjeSaludUDI(adolescenteInfractorUDI.getId_adolescente_udi_pk());
            if(ejeSaludUDIAux!=null){
                ejeSaludUDI=ejeSaludUDIAux;
                guardado=true;
                String saludableAux = ejeSaludUDIAux.getSituacionSalud();
                System.out.println("salud: "+saludableAux);
                if(saludableAux.equals("SALUDABLE")){
                    System.out.println("entro a saludable");
                    saludable=true;
                }else if(saludableAux.equals("NO SALUDABLE")){
                    System.out.println("no entro a saludable");
                    saludable=false;
                }
            }            
        }
        
    }

    public AdolescenteInfractorUDI getAdolescenteInfractorUDI() {
        return adolescenteInfractorUDI;
    }

    public void setAdolescenteInfractorUDI(AdolescenteInfractorUDI adolescenteInfractorUDI) {
        this.adolescenteInfractorUDI = adolescenteInfractorUDI;
    }

    public EjeSaludUDI getEjeSaludUDI() {
        return ejeSaludUDI;
    }

    public void setEjeSaludUDI(EjeSaludUDI ejeSaludUDI) {
        this.ejeSaludUDI = ejeSaludUDI;
    }

    public EjeSaludUDIServicio getServicio() {
        return servicio;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }
    
    public boolean isSaludable() {
        return saludable;
    }

    public void setSaludable(boolean saludable) {
        this.saludable = saludable;
        if(saludable==true){
            ejeSaludUDI.setSituacionSalud("SALUDABLE");
        }else if(saludable==false){
            ejeSaludUDI.setSituacionSalud("NO SALUDABLE");
        }
    }
    
        /*********************Métodos para invocar a los diferentes servicios web******************/
    
    public String guardarEjeSaludUDI(){
        
        this.ejeSaludUDI.setIdEjeSalud(adolescenteInfractorUDI);

        EjeSaludUDI ejeSaludUDIAux = servicio.guardarEjeSaludUDI(ejeSaludUDI);
        if(ejeSaludUDIAux!=null){
            return enlaces.PATH_PANEL_UDI+"?faces-redirect=true";       
        }
        else{
            return null;
        }
    }

    
}