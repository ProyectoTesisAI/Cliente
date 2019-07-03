/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.modelo.DatosProvinciaCanton;
import epn.edu.ec.modelo.IdentificacionGeografica;
import epn.edu.ec.servicios.DatosProvinciaCantonServicio;
import epn.edu.ec.servicios.IdentificacionGeograficaServicio;
import epn.edu.ec.utilidades.EnlacesPrograma;
import epn.edu.ec.utilidades.Validaciones;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "identificacionGeograficaControlador")
@ViewScoped
public class IdentificacionGeograficaControlador implements Serializable {

    //mensajes que controlan las validaciones
    private String mensaje = "";
    //Objeto que contiene el codigo de las validaciones
    private Validaciones validacion;

    private AdolescenteInfractorUDI adolescenteInfractorUDI;
    private IdentificacionGeografica identificacionGeografica;
    private IdentificacionGeograficaServicio servicio;
    private boolean guardado;

    private List<DatosProvinciaCanton> provincias;
    private List<DatosProvinciaCanton> cantones;
    private DatosProvinciaCantonServicio servicioCAIPC;
    private EnlacesPrograma enlaces;

    @PostConstruct
    public void init() {

        validacion = new Validaciones();
        enlaces = new EnlacesPrograma();
        servicio = new IdentificacionGeograficaServicio();

        identificacionGeografica = new IdentificacionGeografica();
        guardado = false;

        provincias = new ArrayList<>();
        servicioCAIPC = new DatosProvinciaCantonServicio();

        adolescenteInfractorUDI = new AdolescenteInfractorUDI();
        AdolescenteInfractorUDI adolescenteInfractorUDIAux = (AdolescenteInfractorUDI) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");

        if (adolescenteInfractorUDIAux != null) {

            adolescenteInfractorUDI = adolescenteInfractorUDIAux;
            IdentificacionGeografica identificacionGeograficaAux = servicio.obtenerIdentificacionGeografica(adolescenteInfractorUDI.getId_adolescente_udi_pk());
            if (identificacionGeograficaAux != null) {
                identificacionGeografica = identificacionGeograficaAux;
                guardado = true;
            }
        }

        provincias = servicioCAIPC.listarDatosProvinciaCanton();

    }

    public AdolescenteInfractorUDI getAdolescenteInfractorUDI() {
        return adolescenteInfractorUDI;
    }

    public void setAdolescenteInfractorUDI(AdolescenteInfractorUDI adolescenteInfractorUDI) {
        this.adolescenteInfractorUDI = adolescenteInfractorUDI;
    }

    public IdentificacionGeografica getIdentificacionGeografica() {
        return identificacionGeografica;
    }

    public void setIdentificacionGeografica(IdentificacionGeografica identificacionGeografica) {
        this.identificacionGeografica = identificacionGeografica;
    }

    public IdentificacionGeograficaServicio getServicio() {
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
        String provincia = identificacionGeografica.getProvinciaAdolescente();
        //System.out.println("Provincia del adoles: "+provincia);
        if (provincia != null) {
            cantones = listarCantonesPorProvincia(provincia);
        } else {
            System.out.println("No hay provincia seleccionada");
        }
        return cantones;
    }

    /**
     * *******************Métodos para invocar a los diferentes servicios web*****************
     */
    public String guardarIdentificacionGeograficaAux() {

        this.identificacionGeografica.setIdIdentificacionGeografica(adolescenteInfractorUDI);

        IdentificacionGeografica identificacionGeograficaAux = servicio.guardarIdentificacionGeografica(identificacionGeografica);
        if (identificacionGeograficaAux != null) {
            return enlaces.PATH_PANEL_UDI + "?faces-redirect=true";
        } else {
            return null;
        }
    }

    public void limpiarMensajeNumeroContacto(AjaxBehaviorEvent evento) {
        String numero = identificacionGeografica.getTelefono();
        if (validacion.numeroContactoValida(numero)) {
            mensaje = "";
        } else {
            mensaje = "Número incorrecto";
        }
    }

    public void validarNumeroContacto(AjaxBehaviorEvent evento) {
        String numero = identificacionGeografica.getTelefono();
        if (validacion.numeroContactoValida(numero)) {
            mensaje = "Número correcto";
        } else {
            mensaje = "Número incorrecto";
        }
    }
}
