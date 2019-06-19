/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.servicios;

import epn.edu.ec.modelo.InformePsicologia;
import epn.edu.ec.modelo.ItemInformePsicologia;
import epn.edu.ec.modelo.ItemTallerPsicologia;
import epn.edu.ec.modelo.RegistroFotografico;
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
public class InformePsicologiaServicio {
    
    private final Client cliente;
    public String URL_INFORME_PSICOLOGIA=Constantes.URL_INFORME_PSICOLOGIA;
    
    public InformePsicologiaServicio(){
        cliente= ClientBuilder.newClient();
    }
    
    public InformePsicologia guardarInformePsicologia(InformePsicologia informe){
        
        InformePsicologia informePsicologiaAux=null;
        
        WebTarget webTarget=cliente.target(URL_INFORME_PSICOLOGIA);        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");     
        Response response =invocationBuilder.post(Entity.entity(informe, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        if(response.getStatus()==200){
            informePsicologiaAux =response.readEntity(InformePsicologia.class);
        }
        
        return informePsicologiaAux;

    }
    
    public List<ItemInformePsicologia> obtenerItemsPorInformePsicologia(Integer idInformePsicologia){
        
        List<ItemInformePsicologia> listaItemsInformePsicologia=null;
        
        WebTarget webTarget=cliente.target(URL_INFORME_PSICOLOGIA+"/ItemsInformePsicologia").path(idInformePsicologia.toString());        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response =invocationBuilder.get();
        if(response.getStatus()==200){
            listaItemsInformePsicologia= response.readEntity(new GenericType<List<ItemInformePsicologia>>(){});
        }           
        return listaItemsInformePsicologia;
    }

    public List<InformePsicologia> listarInformePsicologia(){
        
        List<InformePsicologia> listaItemsInformePsicologia=null;
        
        WebTarget webTarget=cliente.target(URL_INFORME_PSICOLOGIA);        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");        
        Response response =invocationBuilder.get();
        if(response.getStatus()==200){
            listaItemsInformePsicologia= response.readEntity(new GenericType<List<InformePsicologia>>(){});
        }           
        return listaItemsInformePsicologia;
    }
    
}
