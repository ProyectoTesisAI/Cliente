/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.controlador;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.modelo.CAI;
import epn.edu.ec.modelo.ItemTallerPsicologia;
import epn.edu.ec.modelo.RegistroAsistencia;
import epn.edu.ec.modelo.RegistroAsistenciaAdolescenteUDI;
import epn.edu.ec.modelo.TallerPsicologia;
import epn.edu.ec.modelo.UDI;
import epn.edu.ec.servicios.CaiServicio;
import epn.edu.ec.servicios.ItemTallerPsicologiaServicio;
import epn.edu.ec.servicios.RegistroAsistenciaAdolescenteUDIServicio;
import epn.edu.ec.servicios.RegistroAsistenciaServicio;
import epn.edu.ec.servicios.TallerPsicologiaServicio;
import epn.edu.ec.servicios.UdiServicio;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author User
 */
@Named(value = "tallerPsicologiaControlador")
@ViewScoped
public class TallerPsicologiaControlador implements Serializable{

    //////////variables usadas para el Taller Psicologia/////////
    TallerPsicologia tallerPsicologia;
    List<UDI> listaUdi; 
    List<CAI> listaCai;
    
    ItemTallerPsicologia item1;
    ItemTallerPsicologia item2;
    ItemTallerPsicologia item3;
    ItemTallerPsicologia item4;
    ItemTallerPsicologia item5;
    List<ItemTallerPsicologia> listaItemsTallerPsicologia;
    
    String tipoCentro;
    boolean esUzdi;
    Integer numeroParticipantes;
    
    TallerPsicologiaServicio controlador;
    CaiServicio controladorCai;
    UdiServicio controladorUdi;
    ItemTallerPsicologiaServicio controladroItemTaller;
    
    //////////////////////////////////////////variables usadas para el Registro Asistencia////////
    List<AdolescenteInfractorUDI> listaAdolescentesUzdi;
    RegistroAsistencia registroAsistencia;
    
    RegistroAsistenciaServicio controladorAsistencia;
    RegistroAsistenciaAdolescenteUDIServicio controladorAsistenciaUDI;  
    ///////////////////////////////////////////////////
    
    boolean tallerGuardado=false;
    boolean registroAsistenciaGuardado=true;
    
    int indiceTaller=0;
    
    @PostConstruct
    public void init(){
        
        controlador= new TallerPsicologiaServicio();
        controladorCai= new CaiServicio();
        controladorUdi= new UdiServicio();
        controladorAsistencia= new RegistroAsistenciaServicio();
        controladroItemTaller= new ItemTallerPsicologiaServicio();        
        controladorAsistenciaUDI= new RegistroAsistenciaAdolescenteUDIServicio();
        
        tallerPsicologia= new TallerPsicologia();
        registroAsistencia= new RegistroAsistencia();
        listaCai= new ArrayList<>();
        listaUdi= new ArrayList<>();
        listaAdolescentesUzdi= new ArrayList<>();
        
        listaCai=controladorCai.listaCai(); //muestro la lista de CAIs rescatadas de la base de datos
        listaUdi=controladorUdi.listaUdi(); //muestro la lista de UDIs rescatadas de la base de datos

        item1= new ItemTallerPsicologia();
        item2= new ItemTallerPsicologia();
        item3= new ItemTallerPsicologia();
        item4= new ItemTallerPsicologia();
        item5= new ItemTallerPsicologia();      
        listaItemsTallerPsicologia= new ArrayList<>();
        
        listaItemsTallerPsicologia.add(item1);
        listaItemsTallerPsicologia.add(item2);
        listaItemsTallerPsicologia.add(item3);
        listaItemsTallerPsicologia.add(item4);
        listaItemsTallerPsicologia.add(item5);
        
        if(isEsUzdi()){
            tipoCentro="UZDI";
        }
        else{
            tipoCentro="CAI";
        }
        
        //////////EN EL CASO DE QUE EL TALLER SE HAYA GUARDADO////////////////////77
        TallerPsicologia tallerAux= (TallerPsicologia)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("taller_psicologia");
        
        if(tallerAux != null){
            tallerPsicologia=tallerAux;
            tallerGuardado=true;
            registroAsistenciaGuardado=false;
            if(tallerAux.getIdCai()!=null){
                tipoCentro="CAI";
                
            }
            if(tallerAux.getIdUdi() != null){
                tipoCentro="UZDI";
                
            }
            
            List<ItemTallerPsicologia> itemsAux= controlador.obtenerItemsPorTalleresPsicologia(tallerPsicologia.getIdTallerPsicologia());
            if(itemsAux != null){
                listaItemsTallerPsicologia=itemsAux;
                generarRegistroAsistencia();
                indiceTaller=1;
            }
            
            RegistroAsistencia asistenciaAux= (RegistroAsistencia)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("registro_asistencia");
            //si la sesión del registro asistencia está vigente, ocurre cuando guardas el registro de asistencia
            if(asistenciaAux !=null){
                registroAsistencia= asistenciaAux;
                tallerGuardado=true;
                registroAsistenciaGuardado=true;
                
            }
            //en el caso de que no haya una sesión del registro de asistencia, ocurre cuando se desea ver el Taller a partir de otra página
            else{
                RegistroAsistencia registroAsistenciaAux= controlador.obtenerRegistroAsistenciaPorTaller(tallerPsicologia.getIdTallerPsicologia());
                if(registroAsistenciaAux!=null){
                    registroAsistencia=registroAsistenciaAux;
                    
                    registroAsistenciaGuardado=true;
                }
                else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AÚN NO HA GUARDADO EL REGISTRO DE ASISTENCIA","Aviso" ));
                }
            }
            
            
        }
    }

    public TallerPsicologia getTallerPsicologia() {
        return tallerPsicologia;
    }

    public void setTallerPsicologia(TallerPsicologia tallerPsicologia) {
        this.tallerPsicologia = tallerPsicologia;
    }

    public TallerPsicologiaServicio getControlador() {
        return controlador;
    }

    
    public String getTipoCentro() {       
        return tipoCentro;        
    }

    public void setTipoCentro(String tipoCentro) {
        this.tipoCentro = tipoCentro;
        if("UZDI".equals(tipoCentro)){
            System.out.println("Ha seleccionado UZDI");
            esUzdi=true;
        }
        else if("CAI".equals(tipoCentro)){
            System.out.println("Ha seleccionado CAI");
            esUzdi=false;
        }    
     }

    public boolean isEsUzdi() {
        if("UZDI".equals(tipoCentro)){
            esUzdi=true;
            
        }
        else if("CAI".equals(tipoCentro)){
            esUzdi=false;
        }    
        return esUzdi;
    }

    public List<UDI> getListaUdi() {
        return listaUdi;
    }

    public void setListaUdi(List<UDI> listaUdi) {
        this.listaUdi = listaUdi;
    }

    public List<CAI> getListaCai() {
        return listaCai;
    }

    public void setListaCai(List<CAI> listaCai) {
        this.listaCai = listaCai;
    }

    public CaiServicio getControladorCai() {
        return controladorCai;
    }

    public UdiServicio getControladorUdi() {
        return controladorUdi;
    }
    
    public Integer getNumeroParticipantes() {
        
        if(tallerPsicologia.getIdUdi()!=null){
            
            numeroParticipantes=controlador.obtenerNumeroAdolescentePorUdi(tallerPsicologia.getIdUdi());
            
        }
        else if(tallerPsicologia.getIdCai()!=null){
        
        }
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(Integer numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public List<AdolescenteInfractorUDI> getListaAdolescentesUzdi() {
        return listaAdolescentesUzdi;
    }

    public void setListaAdolescentesUzdi(List<AdolescenteInfractorUDI> listaAdolescentesUzdi) {
        this.listaAdolescentesUzdi = listaAdolescentesUzdi;
    }

    public RegistroAsistenciaServicio getControladorAsistencia() {
        return controladorAsistencia;
    }

    public ItemTallerPsicologia getItem1() {
        return item1;
    }

    public void setItem1(ItemTallerPsicologia item1) {
        this.item1 = item1;
    }

    public ItemTallerPsicologia getItem2() {
        return item2;
    }

    public void setItem2(ItemTallerPsicologia item2) {
        this.item2 = item2;
    }

    public ItemTallerPsicologia getItem3() {
        return item3;
    }

    public void setItem3(ItemTallerPsicologia item3) {
        this.item3 = item3;
    }

    public ItemTallerPsicologia getItem4() {
        return item4;
    }

    public void setItem4(ItemTallerPsicologia item4) {
        this.item4 = item4;
    }

    public ItemTallerPsicologia getItem5() {
        return item5;
    }

    public void setItem5(ItemTallerPsicologia item5) {
        this.item5 = item5;
    }

    public List<ItemTallerPsicologia> getListaItemsTallerPsicologia() {
        return listaItemsTallerPsicologia;
    }

    public void setListaItemsTallerPsicologia(List<ItemTallerPsicologia> listaItemsTallerPsicologia) {
        this.listaItemsTallerPsicologia = listaItemsTallerPsicologia;
    }

    public ItemTallerPsicologiaServicio getControladroItemTaller() {
        return controladroItemTaller;
    }

    public boolean isTallerGuardado() {
        return tallerGuardado;
    }

    public void setTallerGuardado(boolean tallerGuardado) {
        this.tallerGuardado = tallerGuardado;
    }

    public boolean isRegistroAsistenciaGuardado() {
        return registroAsistenciaGuardado;
    }

    public void setRegistroAsistenciaGuardado(boolean registroAsistenciaGuardado) {
        this.registroAsistenciaGuardado = registroAsistenciaGuardado;
    }

    public RegistroAsistenciaAdolescenteUDIServicio getControladorAsistenciaUDI() {
        return controladorAsistenciaUDI;
    }

    public void setControladorAsistenciaUDI(RegistroAsistenciaAdolescenteUDIServicio controladorAsistenciaUDI) {
        this.controladorAsistenciaUDI = controladorAsistenciaUDI;
    }

    public RegistroAsistencia getRegistroAsistencia() {
        return registroAsistencia;
    }

    public void setRegistroAsistencia(RegistroAsistencia registroAsistencia) {
        this.registroAsistencia = registroAsistencia;
    }

    public int getIndiceTaller() {
        return indiceTaller;
    }

    public void setIndiceTaller(int indiceTaller) {
        this.indiceTaller = indiceTaller;
    }
    
    
    
    /*****************************Eventos*********************************************/
    
    public String guardarTallerPsicologia(){
        
        try{
            int itemsGuardados=0;
            tallerPsicologia.setNumeroTotalParticipantes(numeroParticipantes);
            TallerPsicologia taller= controlador.guardarTallerPsicologia(tallerPsicologia);

            if(taller != null){
                for(ItemTallerPsicologia i : listaItemsTallerPsicologia){
                    i.setIdTallerPsicologia(taller);
                    controladroItemTaller.guardarItemTallerPsicologia(i);
                    itemsGuardados++;

                }
                
                if(itemsGuardados >0 && itemsGuardados==listaItemsTallerPsicologia.size()){
                    
                    tallerGuardado=true;
                    registroAsistenciaGuardado=false; 
                    indiceTaller=1;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("taller_psicologia", taller);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SE HA GUARDADO CORRECTAMENTE EL TALLER DE PSICOLOGÍA","Aviso" ));
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AHORA PUEDE GENERAR EL REGISTRO DE ASISTENCIA","Aviso" ));
                    generarRegistroAsistencia();
                    return "/paginas/psicologia/taller_psicologia.com?faces-redirect=true";
                }
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HA OCURRIDO UN ERROR AL GUARDAR EL TALLER DE PSICOLOGÍA","Aviso" ));
            }
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HA OCURRIDO UN ERROR AL GUARDAR EL TALLER DE PSICOLOGÍA","Aviso" ));       
        }  
        return null;
    }
    
    public void generarRegistroAsistencia(){
        
        if( tallerPsicologia.getIdUdi() == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "NO SE HA SELECCIONADO UNIDAD ZONAL ","Aviso" ));
        }
        else{
            List<AdolescenteInfractorUDI> registroAux = controladorAsistencia.listaAdolescentesInfractoresPorUzdi(tallerPsicologia.getIdUdi());
            if(registroAux==null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "NO HAY ADOLESCENTES INFRACTORES EN LA "+tallerPsicologia.getIdUdi().getUdi(),"Aviso" ));
            }
            else{
                if(registroAux.size()>0){
                    
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ADOLESCENTES INFRACTORES PERTENECIENTES A "+tallerPsicologia.getIdUdi().getUdi(),"Aviso" ));
                    listaAdolescentesUzdi=registroAux;
                }
            }

            
        }
        
    }

    public void guardarPDFAsistencia(){
        //retorna el path del archivo-->Retorna: "file:D:/User/Documents/NetBeansProjects/SistemaReeducacionAI/SistemaReeducacionAI/src/main/java/epn/edu/ec/reportes/RegistroAsistencia.jasper"
        String ruta=getClass().getClassLoader().getResource("/epn/edu/ec/reportes/RegistroAsistencia.jasper").toString();
        //elimino los 6 primeros caracteres, es decir elimino: "file:/", para obtener solo la ruta del archivo
        ruta= ruta.substring(6); 

        Map<String,Object> parametros= new HashMap<String,Object>();
	parametros.put("txtUDI","REGISTRO DE ASISTENCIA "+ tallerPsicologia.getIdUdi().getUdi());
			       
        try{
           
            
            File jasper = new File(ruta);       
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),parametros, new JRBeanCollectionDataSource(this.getListaAdolescentesUzdi()));
            
            FacesContext context = FacesContext.getCurrentInstance();
            Object response = context.getExternalContext().getResponse();
            if (response instanceof HttpServletResponse) {
                  HttpServletResponse hsr = (HttpServletResponse) response;
                  hsr.setContentType("application/pdf");
                  hsr.addHeader("Content-disposition","attachment; filename=jsfReporte.pdf");
                  try {
                        ServletOutputStream stream = hsr.getOutputStream();
                        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
                        stream.flush();
                  } catch (IOException ex) {
                        System.out.println("Error:  " + ex.getMessage());
                  }
                  context.responseComplete();
            }
            
            
            /*JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\User\\Desktop\\Registro Asistencia "+tallerPsicologia.getIdUdi().getUdi()+".pdf"); // 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SE HA GENERADO CORRECTAMENTE EL REGISTRO DE ASISTENCIA ","Aviso" ));*/
            
        }catch(Exception e){
            System.out.println("Error:  " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "NO SE HA GENERADO EL REGISTRO DE ASISTENCIA","ERROR" ));
        }
    }
    
    public void guardarRegistroAsistencia(){
    
        try{
            registroAsistencia.setFecha(tallerPsicologia.getFecha());
            registroAsistencia.setIdRegistroAsistencia(tallerPsicologia);
            RegistroAsistencia registroAsistenciaAux= controladorAsistencia.guardarRegistroAsistencia(registroAsistencia);
        
            if(registroAsistenciaAux!=null){
                
                int asistenciaAdolescentes=0;
                
                for(AdolescenteInfractorUDI a : listaAdolescentesUzdi){
                    RegistroAsistenciaAdolescenteUDI asistencia= new RegistroAsistenciaAdolescenteUDI();
                    asistencia.setIdAdolescenteUdi(a);
                    asistencia.setIdRegistroAsistencia(registroAsistenciaAux);
                    controladorAsistenciaUDI.guardarRegistroAsistenciaAdolescenteUDI(asistencia);
                    asistenciaAdolescentes++;
                }

                if(asistenciaAdolescentes>0 && asistenciaAdolescentes== listaAdolescentesUzdi.size()){
                    tallerGuardado=true;
                    registroAsistenciaGuardado=true;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("registro_asistencia", registroAsistenciaAux);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SE HA GUARDADO CORRECTAMENTE EL REGISTRO DE ASISTENCIA","Aviso" ));
                }
            }
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "HA OCURRIDO UN ERROR AL GUARDAR EL REGISTRO DE ASISTENCIA","ERROR" ));
        }
        
        
    }
 
}
