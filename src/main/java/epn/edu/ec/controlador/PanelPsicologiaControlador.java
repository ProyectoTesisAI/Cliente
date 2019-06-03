package epn.edu.ec.controlador;

import epn.edu.ec.modelo.TallerPsicologia;
import epn.edu.ec.servicios.TallerPsicologiaServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "panelPsicologiaControlador")
@ViewScoped
public class PanelPsicologiaControlador implements Serializable {

    private List<TallerPsicologia> listaTalleresPsicologia;
    private TallerPsicologiaServicio servicio;

    @PostConstruct
    public void init() {

        servicio = new TallerPsicologiaServicio();

        listaTalleresPsicologia = new ArrayList<>();
        listaTalleresPsicologia = servicio.listaTalleresPsicologia();

    }

    public List<TallerPsicologia> getListaTalleresPsicologia() {
        return listaTalleresPsicologia;
    }

    public void setListaTalleresPsicologia(List<TallerPsicologia> listaTalleresPsicologia) {
        this.listaTalleresPsicologia = listaTalleresPsicologia;
    }

    public TallerPsicologiaServicio getServicio() {
        return servicio;
    }

    public String verTallerPsicologia(TallerPsicologia taller) {

        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("taller_psicologia", taller);
            return "/paginas/psicologia/taller_psicologia.com?faces-redirect=true";

        } catch (Exception ex) {
            return null;
        }
    }

    public String agregarInformePsicologia(TallerPsicologia taller) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("taller_psicologia", taller);
            return "/paginas/psicologia/informe_psicologia.com?faces-redirect=true";
        } catch (Exception e) {
            return null;
        }
    }
}
