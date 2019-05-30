/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.modelo.EstadoCumplimientoMedida;
import epn.edu.ec.servicios.EstadoCumplimientoMedidaServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "estadoCumplimientoMedidaControlador")
@ViewScoped
public class EstadoCumplimientoMedidaControlador implements Serializable {

    private AdolescenteInfractorUDI adolescenteInfractorUDI;
    private EstadoCumplimientoMedida estadoCumplimientoMedida;
    private EstadoCumplimientoMedidaServicio servicio;
    private boolean guardado;
    private String estado;

    private boolean ActivarEjecucion;
    private boolean ActivarCulminada;
    private boolean ActivarDerivada;
    private boolean ActivarIncumplimiento;

    private boolean ejecucionGuardada;
    private boolean culminadaGuardada;
    private boolean derivadaGuardada;
    private boolean incumplimientoGuardada;

    @PostConstruct
    public void init() {
        servicio = new EstadoCumplimientoMedidaServicio();

        estadoCumplimientoMedida = new EstadoCumplimientoMedida();
        guardado = false;
        /*
        ejecucionGuardada=false;
        culminadaGuardada=false;
        derivadaGuardada=false;
        incumplimientoGuardada=false;
         */
        estado = "EN_EJECUCIÓN";
        System.out.println("estado init: " + estado);
        if (estado.equals("EN_EJECUCIÓN")) {
            System.out.println("ejecucion");
            ActivarEjecucion = true;
            ActivarCulminada = false;
            ActivarDerivada = false;
            ActivarIncumplimiento = false;
            System.out.println("ee: " + ActivarEjecucion);
            System.out.println("ec: " + ActivarCulminada);
            System.out.println("ed: " + ActivarDerivada);
            System.out.println("ei: " + ActivarIncumplimiento);
        } else if (estado.equals("CULMINADA")) {
            System.out.println("culminada");
            ActivarEjecucion = false;
            ActivarCulminada = true;
            ActivarDerivada = false;
            ActivarIncumplimiento = false;
            System.out.println("ce: " + ActivarEjecucion);
            System.out.println("cc: " + ActivarCulminada);
            System.out.println("cd: " + ActivarDerivada);
            System.out.println("ci: " + ActivarIncumplimiento);
        } else if (estado.equals("DERIVADA")) {
            System.out.println("derivada");
            ActivarEjecucion = false;
            ActivarCulminada = false;
            ActivarDerivada = true;
            ActivarIncumplimiento = false;
            System.out.println("de: " + ActivarEjecucion);
            System.out.println("dc: " + ActivarCulminada);
            System.out.println("dd: " + ActivarDerivada);
            System.out.println("di: " + ActivarIncumplimiento);
        } else if (estado.equals("INCUMPLIMIENTO")) {
            System.out.println("incumplimiento");
            ActivarEjecucion = false;
            ActivarCulminada = false;
            ActivarDerivada = false;
            ActivarIncumplimiento = true;
            System.out.println("ie: " + ActivarEjecucion);
            System.out.println("ic: " + ActivarCulminada);
            System.out.println("id: " + ActivarDerivada);
            System.out.println("ii: " + ActivarIncumplimiento);
        }

        adolescenteInfractorUDI = new AdolescenteInfractorUDI();
        adolescenteInfractorUDI = (AdolescenteInfractorUDI) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("adolescente_infractor_udi");

        if (adolescenteInfractorUDI != null) {
            EstadoCumplimientoMedida estadoCumplimientoMedidaAux = servicio.obtenerEstadoCumplimientoMedida(adolescenteInfractorUDI.getId_adolescente_udi_pk());
            if (estadoCumplimientoMedidaAux != null) {
                estadoCumplimientoMedida = estadoCumplimientoMedidaAux;
                guardado = true;
                if (estadoCumplimientoMedida.getSituacionActual().equals("EN_EJECUCIÓN")) {
                    ActivarEjecucion = true;
                    System.out.println("ee: " + ActivarEjecucion);
                } else if (estadoCumplimientoMedida.getSituacionActual().equals("CULMINADA")) {
                    ActivarCulminada = true;
                    System.out.println("ec: " + ActivarCulminada);
                } else if (estadoCumplimientoMedida.getSituacionActual().equals("DERIVADA")) {
                    ActivarDerivada = true;
                    System.out.println("ed: " + ActivarDerivada);
                } else if (estadoCumplimientoMedida.getSituacionActual().equals("INCUMPLIMIENTO")) {
                    ActivarIncumplimiento = true;
                    System.out.println("ei: " + ActivarIncumplimiento);
                }
            }
        }

    }

    public AdolescenteInfractorUDI getAdolescenteInfractorUDI() {
        return adolescenteInfractorUDI;
    }

    public void setAdolescenteInfractorUDI(AdolescenteInfractorUDI adolescenteInfractorUDI) {
        this.adolescenteInfractorUDI = adolescenteInfractorUDI;
    }

    public EstadoCumplimientoMedida getEstadoCumplimientoMedida() {
        return estadoCumplimientoMedida;
    }

    public void setEstadoCumplimientoMedida(EstadoCumplimientoMedida estadoCumplimientoMedida) {
        this.estadoCumplimientoMedida = estadoCumplimientoMedida;
    }

    public EstadoCumplimientoMedidaServicio getServicio() {
        return servicio;
    }

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        if (estado.equals("EN_EJECUCIÓN")) {
            System.out.println("ejecucion");
            ActivarEjecucion = true;
            ActivarCulminada = false;
            ActivarDerivada = false;
            ActivarIncumplimiento = false;
            System.out.println("ee: " + ActivarEjecucion);
            System.out.println("ec: " + ActivarCulminada);
            System.out.println("ed: " + ActivarDerivada);
            System.out.println("ei: " + ActivarIncumplimiento);
        } else if (estado.equals("CULMINADA")) {
            System.out.println("culminada");
            ActivarEjecucion = false;
            ActivarCulminada = true;
            ActivarDerivada = false;
            ActivarIncumplimiento = false;
            System.out.println("ce: " + ActivarEjecucion);
            System.out.println("cc: " + ActivarCulminada);
            System.out.println("cd: " + ActivarDerivada);
            System.out.println("ci: " + ActivarIncumplimiento);
        } else if (estado.equals("DERIVADA")) {
            System.out.println("derivada");
            ActivarEjecucion = false;
            ActivarCulminada = false;
            ActivarDerivada = true;
            ActivarIncumplimiento = false;
            System.out.println("de: " + ActivarEjecucion);
            System.out.println("dc: " + ActivarCulminada);
            System.out.println("dd: " + ActivarDerivada);
            System.out.println("di: " + ActivarIncumplimiento);
        } else if (estado.equals("INCUMPLIMIENTO")) {
            System.out.println("incumplimiento");
            ActivarEjecucion = false;
            ActivarCulminada = false;
            ActivarDerivada = false;
            ActivarIncumplimiento = true;
            System.out.println("ie: " + ActivarEjecucion);
            System.out.println("ic: " + ActivarCulminada);
            System.out.println("id: " + ActivarDerivada);
            System.out.println("ii: " + ActivarIncumplimiento);
        }
    }

    public boolean isActivarEjecucion() {
        return ActivarEjecucion;
    }

    public void setActivarEjecucion(boolean ActivarEjecucion) {
        this.ActivarEjecucion = ActivarEjecucion;
    }

    public boolean isActivarCulminada() {
        return ActivarCulminada;
    }

    public void setActivarCulminada(boolean ActivarCulminada) {
        this.ActivarCulminada = ActivarCulminada;
    }

    public boolean isActivarDerivada() {
        return ActivarDerivada;
    }

    public void setActivarDerivada(boolean ActivarDerivada) {
        this.ActivarDerivada = ActivarDerivada;
    }

    public boolean isActivarIncumplimiento() {
        return ActivarIncumplimiento;
    }

    public void setActivarIncumplimiento(boolean ActivarIncumplimiento) {
        this.ActivarIncumplimiento = ActivarIncumplimiento;
    }

    public boolean isEjecucionGuardada() {
        return ejecucionGuardada;
    }

    public void setEjecucionGuardada(boolean ejecucionGuardada) {
        this.ejecucionGuardada = ejecucionGuardada;
    }

    public boolean isCulminadaGuardada() {
        return culminadaGuardada;
    }

    public void setCulminadaGuardada(boolean culminadaGuardada) {
        this.culminadaGuardada = culminadaGuardada;
    }

    public boolean isDerivadaGuardada() {
        return derivadaGuardada;
    }

    public void setDerivadaGuardada(boolean derivadaGuardada) {
        this.derivadaGuardada = derivadaGuardada;
    }

    public boolean isIncumplimientoGuardada() {
        return incumplimientoGuardada;
    }

    public void setIncumplimientoGuardada(boolean incumplimientoGuardada) {
        this.incumplimientoGuardada = incumplimientoGuardada;
    }

    /**
     * *******************Métodos para invocar a los diferentes servicios
     * web*****************
     */
    public String guardarEstadoCumplimientoMedida() {

        this.estadoCumplimientoMedida.setIdEstadoCumplimientoMedida(adolescenteInfractorUDI);

        EstadoCumplimientoMedida estadoCumplimientoMedidaAux = servicio.guardarEstadoCumplimientoMedida(estadoCumplimientoMedida);
        if (estadoCumplimientoMedidaAux != null) {
            return "/paginas/inicio/udi.com?faces-redirect=true";
        } else {
            return null;
        }
    }

}
