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

    private AdolescenteInfractorCAI adolescenteInfractorCAI;
    private List<AdolescenteInfractorCAI> listadoAdolescentesInfractoresCAI;
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

        adolescenteInfractorCAI = new AdolescenteInfractorCAI();
        adolescenteInfractorCAI = (AdolescenteInfractorCAI) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_cai");

        if (adolescenteInfractorCAI != null) {
            AdolescenteInfractorCAI adolescenteInfractorUDIAux = servicio.obtenerAdolescenteInfractorCAI(adolescenteInfractorCAI.getIdAdolescenteCai());
            if (adolescenteInfractorUDIAux != null) {
                adolescenteInfractorCAI = adolescenteInfractorUDIAux;
                guardado = true;
            }
        } else {
            adolescenteInfractorCAI = new AdolescenteInfractorCAI();
        }
        listadoAdolescentesInfractoresCAI = new ArrayList<>();

        listadoAdolescentesInfractoresCAI = servicio.listaAdolescentesInfractoresCAI();

        provincias = servicioCAIPC.listarDatosProvinciaCanton();
    }

    public AdolescenteInfractorCAI getAdolescenteInfractorCAI() {
        return adolescenteInfractorCAI;
    }

    public void setAdolescenteInfractorCAI(AdolescenteInfractorCAI adolescenteInfractorCAI) {
        this.adolescenteInfractorCAI = adolescenteInfractorCAI;
    }

    public List<AdolescenteInfractorCAI> getListadoAdolescentesInfractoresCAI() {
        return listadoAdolescentesInfractoresCAI;
    }

    public void setListadoAdolescentesInfractoresCAI(List<AdolescenteInfractorCAI> listadoAdolescentesInfractoresCAI) {
        this.listadoAdolescentesInfractoresCAI = listadoAdolescentesInfractoresCAI;
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
        String provincia = adolescenteInfractorCAI.getProvinciaAdolescente();
        System.out.println("Provincia del adoles: "+provincia);
        if (provincia != null) {
            cantones = listarCantonesPorProvincia(provincia);
        } else {
            System.out.println("No hay provincia seleccionada");
        }
        return cantones;
    }

    //Métodos para invocar a los diferentes servicios web************
    public String guardarAdolescenteInfractor() {
        AdolescenteInfractorCAI ai_cai = servicio.guardarAdolescenteInfractorCAI(this.adolescenteInfractorCAI);
        if (ai_cai != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adolescente_infractor_cai", ai_cai);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha guardado correctamente el Adolescente ", "Aviso"));
            return "/paginas/cai/matriz/panel_crear_cai.com?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error, no se guardó el Adolescente Infractor", "Error"));
            return null;
        }
    }

    public String agregarInformacion(AdolescenteInfractorCAI ai_udi) {

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adolescente_infractor_cai", ai_udi);
        return "/paginas/cai/matriz/panel_crear_cai.com?faces-redirect=true";
    }

    public String editarAdolescenteInfractor(Integer id) {
        //return servicio.editarAdolescenteInfractorCAI(id);
        return null;
    }

    public String actualizarAdolescenteInfractor(AdolescenteInfractorCAI ai) {
        //return servicio.actualizarAdolescenteInfractorCAI(ai);
        return null;
    }

    public String verDatos(Integer id) {
        //return servicio.verDatos(id);
        return null;
    }

    public String eliminarAdolescenteInfractor(Integer id) {
        //return servicio.eliminarAdolescenteInfractor(id);
        return null;
    }

}
