package epn.edu.ec.servicios;

import epn.edu.ec.modelo.Personal;
import epn.edu.ec.utilidades.Constantes;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PersonalServicio {

    private final Client cliente;
    public static final String URL_PERSONAL = Constantes.URL_PERSONAL;

    public PersonalServicio() {
        this.cliente = ClientBuilder.newClient();
    }

    public String validarPersonal(Personal personal) {
        String url = null;
        Personal personalAux = null;
        System.out.println("Cedula: " + personal.getUsuario());
        System.out.println("Password: " + personal.getPassword());
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL_PERSONAL).path("login");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(personal, MediaType.APPLICATION_JSON));
        System.out.println(response);
        if (response.getStatus() == 200) {
            System.out.println("Login correcto");
            personal=response.readEntity(new GenericType<Personal>(){});
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("personalSesion", personal);
            url = "/paginas/inicio/udi.com?faces-redirect=true";
        } else {
            System.out.println("No existe el usuario");
        }
        return url;
    }
}
