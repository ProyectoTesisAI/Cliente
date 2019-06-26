package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.servicios.AdolescenteInfractorUDIServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "adolescenteInfractorUDIControlador")
@ViewScoped
public class AdolescenteInfractorUDIControlador implements Serializable{

    private AdolescenteInfractorUDI adolescenteInfractorUDIEditar;
    private AdolescenteInfractorUDI adolescenteInfractorUDICrear;
    private AdolescenteInfractorUDIServicio servicio;
    private boolean guardado;
    
    @PostConstruct
    public void init(){
        servicio = new AdolescenteInfractorUDIServicio();       
        guardado=false;
        
        adolescenteInfractorUDICrear= new AdolescenteInfractorUDI();
        
        adolescenteInfractorUDIEditar = new AdolescenteInfractorUDI();
        AdolescenteInfractorUDI adolescenteInfractorUDIAux= (AdolescenteInfractorUDI)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");
        
        if(adolescenteInfractorUDIAux != null){
            
            adolescenteInfractorUDIEditar=adolescenteInfractorUDIAux;
            guardado=true;
                      
        }
    }

    public AdolescenteInfractorUDI getAdolescenteInfractorUDICrear() {
        return adolescenteInfractorUDICrear;
    }

    public void setAdolescenteInfractorUDICrear(AdolescenteInfractorUDI adolescenteInfractorCrear) {
        this.adolescenteInfractorUDICrear = adolescenteInfractorCrear;
    }

    
    public AdolescenteInfractorUDI getAdolescenteInfractorUDIEditar() {
        return adolescenteInfractorUDIEditar;
    }

    public void setAdolescenteInfractorUDIEditar(AdolescenteInfractorUDI adolescenteInfractorUDIEditar) {
        this.adolescenteInfractorUDIEditar = adolescenteInfractorUDIEditar;
    }

    public AdolescenteInfractorUDIServicio getServicio() {
        return servicio;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }
    
    
    
    /******Métodos para invocar a los diferentes servicios web*************/
    
    public String guardarAdolescenteInfractor(){
        
        AdolescenteInfractorUDI ai_udi= servicio.guardarAdolescenteInfractorUDI(this.adolescenteInfractorUDICrear);
        if(ai_udi!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adolescente_infractor_udi", ai_udi);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha guardado correctamente el Adolescente ","Aviso" ));
            return "/paginas/udi/matriz/panel_crear_udi.com?faces-redirect=true";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error, no se guardó el Adolescente Infractor","Error" ));
            return null;
        }        
    }
}
