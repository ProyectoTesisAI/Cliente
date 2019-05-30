/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author User
 */

public class ItemTallerPsicologia implements Serializable {

    private Integer idItemTallerPsicologia;
    private Date hora;
    private String actividad;
    private String objetivoEspecifico;
    private String materiales;
    private String responsable;
    private TallerPsicologia idTallerPsicologia;

    public ItemTallerPsicologia() {
    }

    public ItemTallerPsicologia(Integer idItemTallerPsicologia) {
        this.idItemTallerPsicologia = idItemTallerPsicologia;
    }

    public Integer getIdItemTallerPsicologia() {
        return idItemTallerPsicologia;
    }

    public void setIdItemTallerPsicologia(Integer idItemTallerPsicologia) {
        this.idItemTallerPsicologia = idItemTallerPsicologia;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getObjetivoEspecifico() {
        return objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public TallerPsicologia getIdTallerPsicologia() {
        return idTallerPsicologia;
    }

    public void setIdTallerPsicologia(TallerPsicologia idTallerPsicologia) {
        this.idTallerPsicologia = idTallerPsicologia;
    }

    @Override
    public String toString() {
        return "ItemTallerPsicologia{" + "idItemTallerPsicologia=" + idItemTallerPsicologia + ", hora=" + hora + ", actividad=" + actividad + ", objetivoEspecifico=" + objetivoEspecifico + ", materiales=" + materiales + ", responsable=" + responsable + ", idTallerPsicologia=" + idTallerPsicologia + '}';
    }
    
}
