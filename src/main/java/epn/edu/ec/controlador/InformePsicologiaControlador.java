/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.controlador;

import epn.edu.ec.modelo.CAI;
import epn.edu.ec.modelo.InformePsicologia;
import epn.edu.ec.modelo.ItemInformePsicologia;
import epn.edu.ec.modelo.TallerPsicologia;
import epn.edu.ec.modelo.UDI;
import epn.edu.ec.servicios.CaiServicio;
import epn.edu.ec.servicios.InformePsicologiaServicio;
import epn.edu.ec.servicios.ItemInformePsicologiaServicio;
import epn.edu.ec.servicios.TallerPsicologiaServicio;
import epn.edu.ec.servicios.UdiServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author User
 */
@Named(value = "informePsicologiaControlador")
@ViewScoped
public class InformePsicologiaControlador implements Serializable{

    InformePsicologia informePsicologia;
    TallerPsicologia tallerPsicologia;
    
    ItemInformePsicologia item1;
    ItemInformePsicologia item2;
    ItemInformePsicologia item3;
    ItemInformePsicologia item4;
    ItemInformePsicologia item5;
    List<ItemInformePsicologia> itemsInformePsicologia;
    
    InformePsicologiaServicio controlador;
    ItemInformePsicologiaServicio controladorItemInforme;
    TallerPsicologiaServicio controladorTaller;
    
    boolean informeGuardado=false;
    boolean registroAsistenciaGuardado=true;
    
    int indiceInforme=0;
    
    @PostConstruct
    public void init(){
        controlador= new InformePsicologiaServicio();
        controladorItemInforme= new ItemInformePsicologiaServicio();
        controladorTaller= new TallerPsicologiaServicio();
        
        informePsicologia= new InformePsicologia();
        tallerPsicologia= new TallerPsicologia();
        
        item1= new ItemInformePsicologia();
        item2= new ItemInformePsicologia();
        item3= new ItemInformePsicologia();
        item4= new ItemInformePsicologia();
        item5= new ItemInformePsicologia();
        
        itemsInformePsicologia= new ArrayList<>();
        itemsInformePsicologia.add(item1);
        itemsInformePsicologia.add(item2);
        itemsInformePsicologia.add(item3);
        itemsInformePsicologia.add(item4);
        itemsInformePsicologia.add(item5);
        
        
        InformePsicologia informePsicologiaAux= (InformePsicologia)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informe_psicologia");
        
        if(informePsicologiaAux != null){
            informePsicologia=informePsicologiaAux;
            informeGuardado=true;
            registroAsistenciaGuardado=false;
        }

    }

    public InformePsicologia getInformePsicologia() {
        return informePsicologia;
    }

    public void setInformePsicologia(InformePsicologia informePsicologia) {
        this.informePsicologia = informePsicologia;
    }

    public TallerPsicologia getTallerPsicologia() {
        return tallerPsicologia;
    }

    public void setTallerPsicologia(TallerPsicologia tallerPsicologia) {
        this.tallerPsicologia = tallerPsicologia;
    }
    
    public ItemInformePsicologia getItem1() {
        return item1;
    }

    public void setItem1(ItemInformePsicologia item1) {
        this.item1 = item1;
    }

    public ItemInformePsicologia getItem2() {
        return item2;
    }

    public void setItem2(ItemInformePsicologia item2) {
        this.item2 = item2;
    }

    public ItemInformePsicologia getItem3() {
        return item3;
    }

    public void setItem3(ItemInformePsicologia item3) {
        this.item3 = item3;
    }

    public ItemInformePsicologia getItem4() {
        return item4;
    }

    public void setItem4(ItemInformePsicologia item4) {
        this.item4 = item4;
    }

    public ItemInformePsicologia getItem5() {
        return item5;
    }

    public void setItem5(ItemInformePsicologia item5) {
        this.item5 = item5;
    }

    public List<ItemInformePsicologia> getItemsInformePsicologia() {
        return itemsInformePsicologia;
    }

    public void setItemsInformePsicologia(List<ItemInformePsicologia> itemsInformePsicologia) {
        this.itemsInformePsicologia = itemsInformePsicologia;
    }

    public InformePsicologiaServicio getControlador() {
        return controlador;
    }


    public ItemInformePsicologiaServicio getControladorItemInforme() {
        return controladorItemInforme;
    }

    public TallerPsicologiaServicio getControladorTaller() {
        return controladorTaller;
    }


    public void guardarInformePsicologia(){
        
        try{
            int itemsGuardados=0;
            informePsicologia.setIdTallerPsicologia(tallerPsicologia);
            InformePsicologia informePsicologiaAux= controlador.guardarInformePsicologia(this.informePsicologia);

            if(informePsicologiaAux != null){
                for(ItemInformePsicologia i : itemsInformePsicologia){
                    i.setIdInformePsicologia(informePsicologiaAux);
                    controladorItemInforme.guardarItemInformePsicologia(i);
                    itemsGuardados++;

                }
                
                if(itemsGuardados >0 && itemsGuardados==itemsInformePsicologia.size()){
                    
                    informeGuardado=true;
                    registroAsistenciaGuardado=false; 
                    indiceInforme=1;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("informe_psicologia", informePsicologiaAux);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SE HA GUARDADO CORRECTAMENTE EL INFORME DE PSICOLOGÍA","Aviso" ));
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AHORA PUEDE GUARDAR EL REGISTRO DE ASISTENCIA","Aviso" ));
                    
                }
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HA OCURRIDO UN ERROR AL GUARDAR EL TALLER DE PSICOLOGÍA","Aviso" ));
            }
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HA OCURRIDO UN ERROR AL GUARDAR EL TALLER DE PSICOLOGÍA","Aviso" ));
        }  
    }
    
}
