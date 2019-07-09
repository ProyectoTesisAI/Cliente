package epn.edu.ec.servicios;

import epn.edu.ec.modelo.RegistroAsistenciaAdolescenteCAI;
import epn.edu.ec.utilidades.Constantes;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RegistroAsistenciaAdolescenteCAIServicio {
    
    private final Client cliente;
    public String URL_REGISTRO_ASISTENCIA_ADOLESCENTE_CAI=Constantes.URL_REGISTRO_ASISTENCIA_ADOLESCENTE_CAI; 
    
    public RegistroAsistenciaAdolescenteCAIServicio(){
        cliente= ClientBuilder.newClient();
    }   
    
    public RegistroAsistenciaAdolescenteCAI guardarRegistroAsistenciaAdolescenteCAI(RegistroAsistenciaAdolescenteCAI registroAsistencia){
        
        RegistroAsistenciaAdolescenteCAI registroAsistenciaAux=null;
        
        WebTarget webTarget=cliente.target(URL_REGISTRO_ASISTENCIA_ADOLESCENTE_CAI);        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");     
        Response response =invocationBuilder.put(Entity.entity(registroAsistencia, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        if(response.getStatus()==200){
            registroAsistenciaAux =response.readEntity(RegistroAsistenciaAdolescenteCAI.class);
        }
        
        return registroAsistenciaAux;

    }
    
    public Integer eliminarListadoAsistencia(Integer registroAsistenciaTaller){
        Integer resultado=0;
        WebTarget webTarget=cliente.target(URL_REGISTRO_ASISTENCIA_ADOLESCENTE_CAI).path(registroAsistenciaTaller.toString());        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+ ";charset=UTF-8");        
        Response response=invocationBuilder.delete();
        return resultado;
    }
}
