/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.modelo.EjeEducativoUDI;
import epn.edu.ec.servicios.EjeEducativoUDIServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author User
 */
@Named(value = "ejeEducativoUDIControlador")
@ViewScoped
public class EjeEducativoUDIControlador implements Serializable{

    private AdolescenteInfractorUDI adolescenteInfractorUDI;
    private EjeEducativoUDI ejeEducativoUDI;
    private EjeEducativoUDIServicio servicio;
    private boolean guardado;
    private boolean estudia;
    
     @PostConstruct
    public void init(){
        servicio= new EjeEducativoUDIServicio();
        
        ejeEducativoUDI=new EjeEducativoUDI();
        guardado=false;
        
        adolescenteInfractorUDI= new AdolescenteInfractorUDI();
        adolescenteInfractorUDI= (AdolescenteInfractorUDI)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");
        
        if(isEstudia()){
            estudia=true;
        }
        else{
            estudia=false;
        }
        
        
        if(adolescenteInfractorUDI != null){
            EjeEducativoUDI ejeEducativoUDIAux= servicio.obtenerEjeEducativoUDI(adolescenteInfractorUDI.getId_adolescente_udi_pk());
            if(ejeEducativoUDIAux!=null){
                ejeEducativoUDI=ejeEducativoUDIAux;
                guardado=true;
                estudia=ejeEducativoUDI.getEstudia();
            }            
        }
        
    }

    public AdolescenteInfractorUDI getAdolescenteInfractorUDI() {
        return adolescenteInfractorUDI;
    }

    public void setAdolescenteInfractorUDI(AdolescenteInfractorUDI adolescenteInfractorUDI) {
        this.adolescenteInfractorUDI = adolescenteInfractorUDI;
    }

    public EjeEducativoUDI getEjeEducativoUDI() {
        return ejeEducativoUDI;
    }

    public void setEjeEducativoUDI(EjeEducativoUDI ejeEducativoUDI) {
        this.ejeEducativoUDI = ejeEducativoUDI;
    }

    public EjeEducativoUDIServicio getServicio() {
        return servicio;
    }
    
    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    public boolean isEstudia() {
        return estudia;
    }

    public void setEstudia(boolean estudia) {
        this.estudia = estudia;
        if(estudia==true){
            ejeEducativoUDI.setEstudia(true);
        }
        else if(estudia==false){
            ejeEducativoUDI.setEstudia(false);
        }
        
    }

    
        /*********************Métodos para invocar a los diferentes servicios web******************/
    
    public String guardarEjeEducativoUDI(){
        
        this.ejeEducativoUDI.setIdEjeEducativo(adolescenteInfractorUDI);
        
        EjeEducativoUDI ejeEducativoUDIAux = servicio.guardarEjeEducativoUDI(ejeEducativoUDI);
        if(ejeEducativoUDIAux!=null){
            return "/paginas/inicio/udi.com?faces-redirect=true";     
        }
        else{
            return null;
        }
    }

    
}
