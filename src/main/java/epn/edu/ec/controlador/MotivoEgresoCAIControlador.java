package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorCAI;
import epn.edu.ec.modelo.CAI;
import epn.edu.ec.modelo.MotivoEgresoCAI;
import epn.edu.ec.servicios.CaiServicio;
import epn.edu.ec.servicios.MotivoEgresoCAIServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "motivoEgresoCAIControlador")
@ViewScoped
public class MotivoEgresoCAIControlador implements Serializable{
    private AdolescenteInfractorCAI adolescenteInfractorCAI;
    private MotivoEgresoCAI motivoEgresoCAI;
    private MotivoEgresoCAIServicio servicio;
    private boolean guardado;
    
    private CAI cai; 
    private List<CAI> listaCAI;
    private CaiServicio servicioCAI;
    
    @PostConstruct
    public void init(){
        servicio= new MotivoEgresoCAIServicio();
        servicioCAI=new CaiServicio();
        
        motivoEgresoCAI =new MotivoEgresoCAI();
        guardado=false;
        
        cai= new CAI();
        listaCAI=new ArrayList<>();
        listaCAI=servicioCAI.listaCai();
        
        adolescenteInfractorCAI= new AdolescenteInfractorCAI();
        adolescenteInfractorCAI= (AdolescenteInfractorCAI)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_cai");
        
        if(adolescenteInfractorCAI != null){
            MotivoEgresoCAI motivoEgresoCAIAux= servicio.obtenerMotivoEgresoCAI(adolescenteInfractorCAI.getIdAdolescenteCai());
            if(motivoEgresoCAIAux!=null){
                motivoEgresoCAI=motivoEgresoCAIAux;
                guardado=true;
            }            
        }
        
    }

    public AdolescenteInfractorCAI getAdolescenteInfractorCAI() {
        return adolescenteInfractorCAI;
    }

    public void setAdolescenteInfractorCAI(AdolescenteInfractorCAI adolescenteInfractorCAI) {
        this.adolescenteInfractorCAI = adolescenteInfractorCAI;
    }

    public MotivoEgresoCAI getMotivoEgresoCAI() {
        return motivoEgresoCAI;
    }

    public void setMotivoEgresoCAI(MotivoEgresoCAI motivoEgresoCAI) {
        this.motivoEgresoCAI = motivoEgresoCAI;
    }

    public MotivoEgresoCAIServicio getServicio() {
        return servicio;
    }

    public CAI getCai() {
        return cai;
    }

    public void setCai(CAI cai) {
        this.cai = cai;
    }

    public List<CAI> getListaCAI() {
        return listaCAI;
    }

    public void setListaCAI(List<CAI> listaCAI) {
        this.listaCAI = listaCAI;
    }

    public CaiServicio getServicioCAI() {
        return servicioCAI;
    }

    public void setServicioCAI(CaiServicio servicioCAI) {
        this.servicioCAI = servicioCAI;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

        /*********************Métodos para invocar a los diferentes servicios web******************/
    
    public String guardarMotivoEgresoCAI(){
        
        this.motivoEgresoCAI.setIdMotivoEgreso(adolescenteInfractorCAI);

        MotivoEgresoCAI motivoEgresoCAIAux = servicio.guardarMotivoEgresoCAI(motivoEgresoCAI);
        if(motivoEgresoCAIAux!=null){
            return "/paginas/inicio/udi.com?faces-redirect=true";     
        }
        else{
            return null;
        }
    }
}
