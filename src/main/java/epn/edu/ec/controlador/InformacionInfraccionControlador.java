/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.modelo.DatosProvinciaCanton;
import epn.edu.ec.modelo.InformacionInfraccion;
import epn.edu.ec.servicios.DatosProvinciaCantonServicio;
import epn.edu.ec.servicios.InformacionInfraccionServicio;
import epn.edu.ec.utilidades.EnlacesPrograma;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "informacionInfraccionControlador")
@ViewScoped
public class InformacionInfraccionControlador implements Serializable {

    private AdolescenteInfractorUDI adolescenteInfractorUDI;

    private InformacionInfraccion informacionInfraccion;
    private InformacionInfraccionServicio servicio;
    private boolean guardado;

    private List<DatosProvinciaCanton> provincias;
    private List<DatosProvinciaCanton> cantones;
    private DatosProvinciaCantonServicio servicioCAIPC;
    private EnlacesPrograma enlaces;

    @PostConstruct
    public void init() {
        
        enlaces= new EnlacesPrograma();
        servicio = new InformacionInfraccionServicio();

        informacionInfraccion = new InformacionInfraccion();
        guardado = false;
        
        provincias = new ArrayList<>();
        servicioCAIPC = new DatosProvinciaCantonServicio();

        adolescenteInfractorUDI = new AdolescenteInfractorUDI();
        AdolescenteInfractorUDI adolescenteInfractorUDIAux = (AdolescenteInfractorUDI) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");

        if (adolescenteInfractorUDIAux != null) {
            
            adolescenteInfractorUDI= adolescenteInfractorUDIAux;
            InformacionInfraccion informacionInfraccionAux = servicio.obtenerInformacionInfraccion(adolescenteInfractorUDI.getId_adolescente_udi_pk());
            if (informacionInfraccionAux != null) {
                informacionInfraccion = informacionInfraccionAux;
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

    public InformacionInfraccion getInformacionInfraccion() {
        return informacionInfraccion;
    }

    public void setInformacionInfraccion(InformacionInfraccion informacionInfraccion) {
        this.informacionInfraccion = informacionInfraccion;
    }

    public InformacionInfraccionServicio getServicio() {
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
        String provincia = informacionInfraccion.getProvinciaDetencion();
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
    public String guardarInformacionInfraccion() {

        this.informacionInfraccion.setIdInformacionInfraccion(adolescenteInfractorUDI);

        InformacionInfraccion informacionInfraccionAux = servicio.guardarInformacionInfraccion(informacionInfraccion);
        if (informacionInfraccionAux != null) {
            return enlaces.PATH_PANEL_UDI+"?faces-redirect=true";    
        } else {
            return null;
        }
    }
}
