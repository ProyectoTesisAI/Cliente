package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.servicios.AdolescenteInfractorUDIServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "adolescenteInfractorUDIControlador")
@ViewScoped
public class AdolescenteInfractorUDIControlador implements Serializable{

    private AdolescenteInfractorUDI adolescenteInfractorUDI;
    private List<AdolescenteInfractorUDI> listadoAdolescentesInfractoresUDI;
    private AdolescenteInfractorUDIServicio servicio;
    private boolean guardado;
    
    @PostConstruct
    public void init(){
        servicio = new AdolescenteInfractorUDIServicio();       
        guardado=false;
        
        adolescenteInfractorUDI = new AdolescenteInfractorUDI();
        adolescenteInfractorUDI= (AdolescenteInfractorUDI)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");
        
        if(adolescenteInfractorUDI != null){
            AdolescenteInfractorUDI adolescenteInfractorUDIAux= servicio.obtenerAdolescenteInfractorUDI(adolescenteInfractorUDI.getId_adolescente_udi_pk());
            if(adolescenteInfractorUDIAux != null){
                adolescenteInfractorUDI=adolescenteInfractorUDIAux;
                guardado=true;
            }            
        }
        listadoAdolescentesInfractoresUDI = new ArrayList<>();
        
        
        listadoAdolescentesInfractoresUDI=servicio.listaAdolescentesInfractoresUDI();
    }

    public AdolescenteInfractorUDI getAdolescenteInfractorUDI() {
        return adolescenteInfractorUDI;
    }

    public void setAdolescenteInfractorUDI(AdolescenteInfractorUDI adolescenteInfractorUDI) {
        this.adolescenteInfractorUDI = adolescenteInfractorUDI;
    }

    public List<AdolescenteInfractorUDI> getListadoAdolescentesInfractoresUDI() {
        return listadoAdolescentesInfractoresUDI;
    }

    public void setListadoAdolescentesInfractoresUDI(List<AdolescenteInfractorUDI> listadoAdolescentesInfractoresUDI) {
        this.listadoAdolescentesInfractoresUDI = listadoAdolescentesInfractoresUDI;
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
        AdolescenteInfractorUDI ai_udi= servicio.guardarAdolescenteInfractorUDI(this.adolescenteInfractorUDI);
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
    
    public String agregarInformacion(AdolescenteInfractorUDI ai_udi){
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adolescente_infractor_udi", ai_udi);
        return "/paginas/udi/matriz/panel_crear_udi.com?faces-redirect=true";
    }
    
    public String editarAdolescenteInfractor(Integer id){
        //return servicio.editarAdolescenteInfractorUDI(id);
        return null;
    }
    
    
    
    public String actualizarAdolescenteInfractor(AdolescenteInfractorUDI ai){
        //return servicio.actualizarAdolescenteInfractorUDI(ai);
        return null;
    }

    public String verDatos(Integer id){
        //return servicio.verDatos(id);
        return null;
    }
    
    public String eliminarAdolescenteInfractor(Integer id){
        //return servicio.eliminarAdolescenteInfractor(id);
        return null;
    }
    
    
}
