/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.servicios;

import epn.edu.ec.modelo.InformePsicologia;
import epn.edu.ec.modelo.RegistroFotografico;
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
public class RegistroFotograficoServicio {
 
    private final Client cliente;
    public String URL_REGISTRO_FOTOGRAFICO=Constantes.URL_REGISTRO_FOTOGRAFICO;
    
    public RegistroFotograficoServicio(){
        cliente= ClientBuilder.newClient();
    }
    
    public RegistroFotografico guardarRegistroFotografico(RegistroFotografico registroFotografico){
        
        RegistroFotografico registroFotograficoAux=null;
        
        WebTarget webTarget=cliente.target(URL_REGISTRO_FOTOGRAFICO);        
        Invocation.Builder invocationBuilder=webTarget.request(MediaType.APPLICATION_JSON+";charset=UTF-8");     
        Response response =invocationBuilder.post(Entity.entity(registroFotografico, MediaType.APPLICATION_JSON+";charset=UTF-8"));
        if(response.getStatus()==200){
            registroFotograficoAux =response.readEntity(RegistroFotografico.class);
        }
        return registroFotograficoAux;

    }
}
