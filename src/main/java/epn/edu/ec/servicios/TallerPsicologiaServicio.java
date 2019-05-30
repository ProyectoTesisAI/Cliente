/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.servicios;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.modelo.RegistroAsistencia;
import epn.edu.ec.modelo.CAI;
import epn.edu.ec.modelo.ItemTallerPsicologia;
import epn.edu.ec.modelo.TallerPsicologia;
import epn.edu.ec.modelo.UDI;
import epn.edu.ec.utilidades.Constantes;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
public class TallerPsicologiaServicio {
    
    private final Client cliente;
    public String URL_TALLER_PSICOLOGIA=Constantes.URL_TALLER_PSICOLOGIA;
    
    public TallerPsicologiaServicio(){
        cliente= ClientBuilder.newClient();
    }
    
    public TallerPsicologia guardarTallerPsicologia(TallerPsicologia taller){
        
        TallerPsicologia tallerPsicologiaAux=null;
        
        WebTarget webTarget=cliente.target(URL_TALLER_PSICOLOGIA);        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");     
        Response response =invocationBuilder.post(Entity.entity(taller, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        if(response.getStatus()==200){
            tallerPsicologiaAux =response.readEntity(TallerPsicologia.class);
        }
        
        return tallerPsicologiaAux;

    }
        
    public List<TallerPsicologia> listaTalleresPsicologia(){
        
        List<TallerPsicologia> listaActividadesAux=null;
        
        WebTarget webTarget=cliente.target(URL_TALLER_PSICOLOGIA);        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response =invocationBuilder.get();
        if(response.getStatus()==200){
            listaActividadesAux= response.readEntity(new GenericType<List<TallerPsicologia>>(){});
        }           
        return listaActividadesAux;
    }
    
    public Integer obtenerNumeroAdolescentePorUdi(UDI udi ){
        
        String cantidadAdolescente=null;
        Integer cantidadAdolescentesAux=null;
        WebTarget webTarget=cliente.target(Constantes.URL_TALLER_PSICOLOGIA+"/NumeroAdolescentesPorUzdi");        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response =invocationBuilder.post(Entity.entity(udi, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        if(response.getStatus()==200){
           
            cantidadAdolescente= response.readEntity(String.class);
                    
            if(cantidadAdolescente!=null){
                
                cantidadAdolescentesAux= Integer.parseInt(cantidadAdolescente);
            }
        }
        else if(response.getStatus()==204){
            cantidadAdolescentesAux=0;
        }
        
        return cantidadAdolescentesAux;
    }
    
    public Integer obtenerNumeroAdolescentePorCai(CAI cai ){
        
        String cantidadAdolescente=null;
        Integer cantidadAdolescentesAux=null;
        
        WebTarget webTarget=cliente.target(Constantes.URL_TALLER_PSICOLOGIA+"/NumeroAdolescentesPorCai");        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response =invocationBuilder.post(Entity.entity(cai, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        if(response.getStatus()==200){
           
            cantidadAdolescente= response.readEntity(String.class);
                    
            if(cantidadAdolescente!=null){
                
                cantidadAdolescentesAux= Integer.parseInt(cantidadAdolescente);
            }
        }
        else if(response.getStatus()==204){
            cantidadAdolescentesAux=0;
        }
        
        return cantidadAdolescentesAux;
    }
    
    public List<AdolescenteInfractorUDI> listaAdolescentesPorUzdi(UDI udi){
        
        List<AdolescenteInfractorUDI> asistenciaAux=null;
                
        WebTarget webTarget=cliente.target(Constantes.URL_TALLER_PSICOLOGIA+"/ListarAdolescentesPorUzdi");        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response =invocationBuilder.post(Entity.entity(udi, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        if(response.getStatus()==200){
            
            List<AdolescenteInfractorUDI> listaAsistenciaUdi= response.readEntity(new GenericType<List<AdolescenteInfractorUDI>>(){});
            if(listaAsistenciaUdi != null && listaAsistenciaUdi.size() >0){               
                
                asistenciaAux=listaAsistenciaUdi;
            }
        }
        return asistenciaAux;
    }
    
    public List<ItemTallerPsicologia> obtenerItemsPorTalleresPsicologia(Integer idTallerPsicologia){
        
        List<ItemTallerPsicologia> listaItemsTallerPsicologia=null;
        
        WebTarget webTarget=cliente.target(URL_TALLER_PSICOLOGIA+"/ItemsTallerPsicologia").path(idTallerPsicologia.toString());        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response =invocationBuilder.get();
        if(response.getStatus()==200){
            listaItemsTallerPsicologia= response.readEntity(new GenericType<List<ItemTallerPsicologia>>(){});
        }           
        return listaItemsTallerPsicologia;
    }
    
    public RegistroAsistencia obtenerRegistroAsistenciaPorTaller(Integer idTallerPsicologia){
        
        RegistroAsistencia registroAsistenciaAux =null;
        
        WebTarget webTarget=cliente.target(URL_TALLER_PSICOLOGIA+"/RegistroAsistencia").path(idTallerPsicologia.toString());        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response =invocationBuilder.get();
        if(response.getStatus()==200){
            registroAsistenciaAux= response.readEntity(RegistroAsistencia.class);
        }           
        return registroAsistenciaAux;
    }
}
