/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.servicios;

import epn.edu.ec.modelo.AdolescenteInfractorUDI;
import epn.edu.ec.modelo.RegistroAsistenciaAdolescenteUDI;
import epn.edu.ec.modelo.UDI;
import epn.edu.ec.utilidades.Constantes;
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
public class RegistroAsistenciaAdolescenteUDIServicio {
    
    private final Client cliente;
    public String URL_REGISTRO_ASISTENCIA_ADOLESCENTE_UDI=Constantes.URL_REGISTRO_ASISTENCIA_ADOLESCENTE_UDI; 
    
    public RegistroAsistenciaAdolescenteUDIServicio(){
        cliente= ClientBuilder.newClient();
    }   
    
    public RegistroAsistenciaAdolescenteUDI guardarRegistroAsistenciaAdolescenteUDI(RegistroAsistenciaAdolescenteUDI registroAsistencia){
        
        RegistroAsistenciaAdolescenteUDI registroAsistenciaAux=null;
        
        WebTarget webTarget=cliente.target(URL_REGISTRO_ASISTENCIA_ADOLESCENTE_UDI);        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");     
        Response response =invocationBuilder.put(Entity.entity(registroAsistencia, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        if(response.getStatus()==200){
            registroAsistenciaAux =response.readEntity(RegistroAsistenciaAdolescenteUDI.class);
        }
        
        return registroAsistenciaAux;

    }
    
    public Integer eliminarListadoAsistencia(Integer registroAsistenciaTaller){
        Integer resultado=0;
        WebTarget webTarget=cliente.target(URL_REGISTRO_ASISTENCIA_ADOLESCENTE_UDI).path(registroAsistenciaTaller.toString());        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+ ";charset=UTF-8");        
        Response response=invocationBuilder.delete();
        return resultado;
    }
}
