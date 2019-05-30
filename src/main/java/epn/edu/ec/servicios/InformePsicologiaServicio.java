/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.servicios;

import epn.edu.ec.modelo.InformePsicologia;
import epn.edu.ec.utilidades.Constantes;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
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
}
