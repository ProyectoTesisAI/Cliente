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
public class ItemInformePsicologia implements Serializable {

    private Integer idItemInformePsicologia;
    private Date duracion;
    private String desarrollo;
    private String objetivoEspecifico;
    private String materiales;

    private InformePsicologia idInformePsicologia;

    public ItemInformePsicologia() {
    }

    public ItemInformePsicologia(Integer idItemInformePsicologia) {
        this.idItemInformePsicologia = idItemInformePsicologia;
    }

    public Integer getIdItemInformePsicologia() {
        return idItemInformePsicologia;
    }

    public void setIdItemInformePsicologia(Integer idItemInformePsicologia) {
        this.idItemInformePsicologia = idItemInformePsicologia;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public String getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(String desarrollo) {
        this.desarrollo = desarrollo;
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

    public InformePsicologia getIdInformePsicologia() {
        return idInformePsicologia;
    }

    public void setIdInformePsicologia(InformePsicologia idInformePsicologia) {
        this.idInformePsicologia = idInformePsicologia;
    }

    @Override
    public String toString() {
        return "ItemInformePsicologia{" + "idItemInformePsicologia=" + idItemInformePsicologia + ", duracion=" + duracion + ", desarrollo=" + desarrollo + ", objetivoEspecifico=" + objetivoEspecifico + ", materiales=" + materiales + ", idInformePsicologia=" + idInformePsicologia + '}';
    }
    
}
