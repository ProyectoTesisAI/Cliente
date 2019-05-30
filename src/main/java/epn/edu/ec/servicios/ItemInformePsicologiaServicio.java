/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.servicios;

import epn.edu.ec.modelo.ItemInformePsicologia;
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

/**
 *
 * @author User
 */
public class ItemInformePsicologiaServicio {
    
    private final Client cliente;
    public String URL_ITEM_INFORME_PSICOLOGIA=Constantes.URL_ITEM_INFORME_PSICOLOGIA;
    
    public ItemInformePsicologiaServicio(){
        cliente= ClientBuilder.newClient();
    }   
    
    public ItemInformePsicologia guardarItemInformePsicologia(ItemInformePsicologia itemInformePsicologia){
        
        ItemInformePsicologia itemInformePsicologiaAux=null;
                       
        WebTarget webTarget=cliente.target(URL_ITEM_INFORME_PSICOLOGIA);        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response = invocationBuilder.post(Entity.entity(itemInformePsicologia, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        
        if(response.getStatus()==200){
        
            itemInformePsicologiaAux=response.readEntity(ItemInformePsicologia.class);       
            
            if(itemInformePsicologiaAux!=null){
                return itemInformePsicologiaAux;          
            }
        } 
       
        return itemInformePsicologiaAux;
        
    }
    
}
