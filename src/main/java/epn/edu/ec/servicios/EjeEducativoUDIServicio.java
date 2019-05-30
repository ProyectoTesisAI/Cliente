package epn.edu.ec.servicios;

import epn.edu.ec.modelo.EjeEducativoUDI;
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

public class EjeEducativoUDIServicio {
        
    private final Client cliente;
    public static final String URL_EJE_EDUCATIVO_UDI=Constantes.URL_EJE_EDUCATIVO_UDI;  
    
    public EjeEducativoUDIServicio(){
        cliente= ClientBuilder.newClient();
    }   

    public EjeEducativoUDI guardarEjeEducativoUDI(EjeEducativoUDI ejeEducativoUDI){
        
        EjeEducativoUDI ejeEducativoUDIAux=null;
                       
        WebTarget webTarget=cliente.target(URL_EJE_EDUCATIVO_UDI);        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response = invocationBuilder.put(Entity.entity(ejeEducativoUDI, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        
        if(response.getStatus()==200){        
            ejeEducativoUDIAux=response.readEntity(EjeEducativoUDI.class);       
        } 
       
        return ejeEducativoUDIAux;
        
    }

    public EjeEducativoUDI obtenerEjeEducativoUDI(Integer id){
        
        EjeEducativoUDI ejeEducativoUDIAux=null;
                       
        WebTarget webTarget=cliente.target(URL_EJE_EDUCATIVO_UDI).path(id.toString());        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response =invocationBuilder.get();
        if(response.getStatus()==200){
            ejeEducativoUDIAux= response.readEntity(EjeEducativoUDI.class);
        }           
        return ejeEducativoUDIAux;
        
    }
}
