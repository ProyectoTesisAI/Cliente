package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.servicios.AdolescenteInfractorUDIServicio;
import epn.edu.ec.utilidades.Validaciones;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "adolescenteInfractorUDIControlador")
@ViewScoped
public class AdolescenteInfractorUDIControlador implements Serializable {

    //mensajes que controlan las validaciones
    private String mensaje = "";
    private String mensaje1 = "";
    //Clase que contiene el codigo de ciertas validaciones
    private Validaciones validacion;

    private AdolescenteInfractorUDI adolescenteInfractorUDIEditar;
    private AdolescenteInfractorUDI adolescenteInfractorUDICrear;
    private AdolescenteInfractorUDIServicio servicio;
    private boolean guardado;

    @PostConstruct
    public void init() {
        servicio = new AdolescenteInfractorUDIServicio();
        guardado = false;
        validacion = new Validaciones();

        adolescenteInfractorUDICrear = new AdolescenteInfractorUDI();

        adolescenteInfractorUDIEditar = new AdolescenteInfractorUDI();
        AdolescenteInfractorUDI adolescenteInfractorUDIAux = (AdolescenteInfractorUDI) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");

        if (adolescenteInfractorUDIAux != null) {

            adolescenteInfractorUDIEditar = adolescenteInfractorUDIAux;
            guardado = true;

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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje1() {
        return mensaje1;
    }

    public void setMensaje1(String mensaje1) {
        this.mensaje1 = mensaje1;
    }
    
    /**
     * ****Métodos para invocar a los diferentes servicios web************
     */
    public String guardarAdolescenteInfractor() {

        AdolescenteInfractorUDI ai_udi = servicio.guardarAdolescenteInfractorUDI(this.adolescenteInfractorUDICrear);
        if (ai_udi != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adolescente_infractor_udi", ai_udi);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha guardado correctamente el Adolescente ", "Aviso"));
            return "/paginas/udi/matriz/panel_crear_udi.com?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ha ocurrido un error, no se guardó el Adolescente Infractor", "Error"));
            return null;
        }
    }
    
    public void limpiarMensajeCedula(AjaxBehaviorEvent evento) {
        String cedula = adolescenteInfractorUDICrear.getCedula();
        if (validacion.cedulaValida(cedula)) {
            mensaje = "";
        } else {
            mensaje = "cédula incorrecta";
        }
    }

    public void validarCedula(AjaxBehaviorEvent evento) {
        String cedula = adolescenteInfractorUDICrear.getCedula();
        if (validacion.cedulaValida(cedula)) {
            mensaje = "cédula correcta";
        } else {
            mensaje = "cédula incorrecta";
        }
    }
    
    public void limpiarMensajeFechaNacimiento(AjaxBehaviorEvent evento) {
        Date fecha = adolescenteInfractorUDICrear.getFechaNacimiento();
        if (validacion.verificarFechaNacimiento(fecha)) {
            mensaje1 = "";
        } else {
            mensaje1 = "Fecha incorrecta";
        }
    }

    public void validarFechaNacimiento(AjaxBehaviorEvent evento) {
        Date fecha = adolescenteInfractorUDIEditar.getFechaNacimiento();
        if (validacion.verificarFechaNacimiento(fecha)) {
            mensaje1 = "Fecha correcta";
        } else {
            mensaje1 = "Fecha corresponde a una persona mayor de 17 años";
        }
    }
    
    public void limpiarMensajeCedulaEditar(AjaxBehaviorEvent evento) {
        String cedula = adolescenteInfractorUDIEditar.getCedula();
        if (validacion.cedulaValida(cedula)) {
            mensaje = "";
        } else {
            mensaje = "cédula incorrecta";
        }
    }

    public void validarCedulaEditar(AjaxBehaviorEvent evento) {
        String cedula = adolescenteInfractorUDIEditar.getCedula();
        if (validacion.cedulaValida(cedula)) {
            mensaje = "cédula correcta";
        } else {
            mensaje = "cédula incorrecta";
        }
    }
    
    public void limpiarMensajeFechaNacimientoEditar(AjaxBehaviorEvent evento) {
        Date fecha = adolescenteInfractorUDIEditar.getFechaNacimiento();
        if (validacion.verificarFechaNacimiento(fecha)) {
            mensaje1 = "";
        } else {
            mensaje1 = "Fecha incorrecta";
        }
    }

    public void validarFechaNacimientoEditar(AjaxBehaviorEvent evento) {
        Date fecha = adolescenteInfractorUDIEditar.getFechaNacimiento();
        if (validacion.verificarFechaNacimiento(fecha)) {
            mensaje1 = "Fecha correcta";
        } else {
            mensaje1 = "Fecha corresponde a una persona mayor de 17 años";
        }
    }
}
