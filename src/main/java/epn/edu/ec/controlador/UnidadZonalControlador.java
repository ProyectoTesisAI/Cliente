package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.modelo.UDI;
import epn.edu.ec.modelo.UnidadZonal;
import epn.edu.ec.servicios.UdiServicio;
import epn.edu.ec.servicios.UnidadZonalServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "unidadZonalControlador")
@ViewScoped
public class UnidadZonalControlador implements Serializable{
    
    private AdolescenteInfractorUDI adolescenteInfractorUDI;
    
    private UnidadZonal unidadZonal;    
    private List<UnidadZonal> listaUnidadZonal;
    private UnidadZonalServicio servicio;
    private boolean guardado;
    
    private UDI udi; 
    private List<UDI> listaUDI;
    private UdiServicio servicioUDI;

    @PostConstruct
    public void init(){
        
        servicio = new UnidadZonalServicio();
        servicioUDI = new UdiServicio();
        guardado=false;
        
        unidadZonal = new UnidadZonal();    
        udi= new UDI();
        listaUnidadZonal = new ArrayList<>();
        listaUDI=new ArrayList<>();
        listaUDI=servicioUDI.listaUdi();
        
        adolescenteInfractorUDI= new AdolescenteInfractorUDI();
        adolescenteInfractorUDI= (AdolescenteInfractorUDI)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");
        
        if(adolescenteInfractorUDI != null){
            UnidadZonal unidadZonalAux= obtenerUnidadZonal(adolescenteInfractorUDI.getId_adolescente_udi_pk());
            if(unidadZonalAux!=null){
                unidadZonal=unidadZonalAux;
                udi=unidadZonalAux.getIdUdi();
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

    public UdiServicio getServicioUDI() {
        return servicioUDI;
    }
    
    public UnidadZonal getUnidadZonal() {
        return unidadZonal;
    }

    public void setUnidadZonal(UnidadZonal unidadZonal) {
        this.unidadZonal = unidadZonal;
    }

    public List<UnidadZonal> getListaUnidadZonal() {
        return listaUnidadZonal;
    }

    public void setListaUnidadZonal(List<UnidadZonal> listaUnidadZonal) {
        this.listaUnidadZonal = listaUnidadZonal;
    }

    public UnidadZonalServicio getServicio() {
        return servicio;
    }

    public List<UDI> getListaUDI() {
        return listaUDI;
    }

    public void setListaUDI(List<UDI> listaUDI) {
        this.listaUDI = listaUDI;
    }

    public UDI getUdi() {
        return udi;
    }

    public void setUdi(UDI udi) {
        this.udi = udi;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }
    
    /*********************Métodos para invocar a los diferentes servicios web******************/
    
    public String guardarUnidadZonal(){
        
        this.unidadZonal.setIdUdi(udi);
        this.unidadZonal.setIdUnidadZonal(adolescenteInfractorUDI);
        UnidadZonal uz= servicio.guardarUnidadZonal(unidadZonal);
        if(uz!=null){
            return "/paginas/inicio/udi.com?faces-redirect=true";     
        }
        else{
            return null;
        }
    }
    
    public UnidadZonal obtenerUnidadZonal(Integer id){
        UnidadZonal unidadZonalAux= servicio.obtenerUnidadZonal(id);
        return unidadZonalAux;
    }

}
