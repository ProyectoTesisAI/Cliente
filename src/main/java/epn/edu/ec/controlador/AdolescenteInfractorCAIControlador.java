package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorCAI;
import epn.edu.ec.modelo.DatosProvinciaCanton;
import epn.edu.ec.servicios.AdolescenteInfractorCAIServicio;
import epn.edu.ec.servicios.DatosProvinciaCantonServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "adolescenteInfractorCAIControlador")
@ViewScoped
public class AdolescenteInfractorCAIControlador implements Serializable {

    private AdolescenteInfractorCAI adolescenteInfractorCAIEditar;
    private AdolescenteInfractorCAI adolescenteInfractorCAICrear;
    private AdolescenteInfractorCAIServicio servicio;
    private boolean guardado;

    private List<DatosProvinciaCanton> provincias;
    private List<DatosProvinciaCanton> cantones;
    private DatosProvinciaCantonServicio servicioCAIPC;

    @PostConstruct
    public void init() {
        servicio = new AdolescenteInfractorCAIServicio();
        guardado = false;

        provincias = new ArrayList<>();
        servicioCAIPC = new DatosProvinciaCantonServicio();

        adolescenteInfractorCAICrear= new AdolescenteInfractorCAI();
        
        adolescenteInfractorCAIEditar = new AdolescenteInfractorCAI();
        AdolescenteInfractorCAI adolescenteInfractorCAIAux = (AdolescenteInfractorCAI) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_cai");

        if (adolescenteInfractorCAIAux != null) {
            adolescenteInfractorCAIEditar = adolescenteInfractorCAIAux;
            guardado = true;
            
        } 
        
        provincias = servicioCAIPC.listarDatosProvinciaCanton();
    }

    public AdolescenteInfractorCAI getAdolescenteInfractorCAICrear() {
        return adolescenteInfractorCAICrear;
    }

    public void setAdolescenteInfractorCAICrear(AdolescenteInfractorCAI adolescenteInfractorCAICrear) {
        this.adolescenteInfractorCAICrear = adolescenteInfractorCAICrear;
    }

    public List<DatosProvinciaCanton> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<DatosProvinciaCanton> provincias) {
        this.provincias = provincias;
    }
    
    

    public AdolescenteInfractorCAI getAdolescenteInfractorCAIEditar() {
        return adolescenteInfractorCAIEditar;
    }

    public void setAdolescenteInfractorCAIEditar(AdolescenteInfractorCAI adolescenteInfractorCAIEditar) {
        this.adolescenteInfractorCAIEditar = adolescenteInfractorCAIEditar;
    }

    public AdolescenteInfractorCAIServicio getServicio() {
        return servicio;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    public List<DatosProvinciaCanton> listarCantonesPorProvincia(String provincia) {
        List<DatosProvinciaCanton> cantonesAux = new ArrayList<>();

        for (DatosProvinciaCanton c : provincias) {
            if (provincia.equals(c.getProvincia())) {
                cantonesAux.add(c);
            }
        }
        return cantonesAux;
    }

    public List<DatosProvinciaCanton> getCantones() {
        cantones = new ArrayList<>();
        String provincia = adolescenteInfractorCAIEditar.getProvinciaAdolescente();
        
        if (provincia != null) {
            cantones = listarCantonesPorProvincia(provincia);
        }
        return cantones;
    }

    //Métodos para invocar a los diferentes servicios web************
    public String guardarAdolescenteInfractor() {
        AdolescenteInfractorCAI ai_cai = servicio.guardarAdolescenteInfractorCAI(this.adolescenteInfractorCAICrear);
        if (ai_cai != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adolescente_infractor_cai", ai_cai);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha guardado correctamente el Adolescente ", "Aviso"));
            return "/paginas/cai/matriz/panel_crear_cai.com?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error, no se guardó el Adolescente Infractor", "Error"));
            return null;
        }
    }

}
