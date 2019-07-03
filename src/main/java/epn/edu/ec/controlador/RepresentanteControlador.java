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
import epn.edu.ec.utilidades.Validaciones;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author User
 */
@Named(value = "representanteControlador")
@ViewScoped
public class RepresentanteControlador implements Serializable{

    //mensajes que controlan las validaciones
    private String mensaje = "";
    //Objeto que contiene el codigo de las validaciones
    private Validaciones validacion;
    
    private AdolescenteInfractorUDI adolescenteInfractorUDI;
    private Representante representante;
    private RepresentanteServicio servicio;
    private boolean guardado;
    private EnlacesPrograma enlaces;
    
    @PostConstruct
    public void init(){
        
        validacion = new Validaciones();
        enlaces= new EnlacesPrograma();
        servicio= new RepresentanteServicio();
        
        representante= new Representante();
        guardado=false;
        
        adolescenteInfractorUDI= new AdolescenteInfractorUDI();
        AdolescenteInfractorUDI adolescenteInfractorUDIAux= (AdolescenteInfractorUDI)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");
        
        if(adolescenteInfractorUDIAux != null){
            
            adolescenteInfractorUDI=adolescenteInfractorUDIAux;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

    public void limpiarMensajeCedula(AjaxBehaviorEvent evento) {
        String cedula = representante.getCedula();
        if (validacion.cedulaValida(cedula)) {
            mensaje = "";
        } else {
            mensaje = "cédula incorrecta";
        }
    }

    public void validarCedula(AjaxBehaviorEvent evento) {

        String cedula = representante.getCedula();
        if (validacion.cedulaValida(cedula)) {
            mensaje = "cédula correcta";
        } else {
            mensaje = "cédula incorrecta";
        }
    }
}
