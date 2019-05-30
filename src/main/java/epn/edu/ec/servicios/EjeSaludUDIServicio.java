package epn.edu.ec.servicios;

import epn.edu.ec.modelo.EjeSaludUDI;
import epn.edu.ec.utilidades.Constantes;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EjeSaludUDIServicio {
        
    private final Client cliente;
    public static final String URL_EJE_SALUD_UDI=Constantes.URL_EJE_SALUD_UDI;  
    
    public EjeSaludUDIServicio(){
        cliente= ClientBuilder.newClient();
    }   

    public EjeSaludUDI guardarEjeSaludUDI(EjeSaludUDI ejeSaludUDI){
        
        EjeSaludUDI ejeSaludUDIAux=null;
                       
        WebTarget webTarget=cliente.target(URL_EJE_SALUD_UDI);        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response = invocationBuilder.put(Entity.entity(ejeSaludUDI, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        
        if(response.getStatus()==200){        
            ejeSaludUDIAux=response.readEntity(EjeSaludUDI.class);       
        } 
       
        return ejeSaludUDIAux;
        
    }

    public EjeSaludUDI obtenerEjeSaludUDI(Integer id){
        
        EjeSaludUDI ejeSaludUDIAux=null;
                       
        WebTarget webTarget=cliente.target(URL_EJE_SALUD_UDI).path(id.toString());        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response =invocationBuilder.get();
        if(response.getStatus()==200){
            ejeSaludUDIAux= response.readEntity(EjeSaludUDI.class);
        }           
        return ejeSaludUDIAux;
        
    }
}
