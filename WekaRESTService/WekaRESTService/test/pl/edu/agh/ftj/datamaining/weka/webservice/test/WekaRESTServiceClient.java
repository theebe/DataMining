package pl.edu.agh.ftj.datamaining.weka.webservice.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javax.ws.rs.core.MultivaluedMap;

/** Jersey REST client generated for REST resource: WekaService [/]<br>
 *  USAGE:<pre>
 *        WekaRESTServiceClient client = new WekaRESTServiceClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Szymon Skupien
 */
public class WekaRESTServiceClient {


    private WebResource webResource;
    private Client client;
    
    /*
     * Podstawowy adres do WebServisu REST 
     */
    private static final String BASE_URI = "http://localhost:8080/WekaRESTService/rest";

    /*
     * Konstruktor klienta, łączy się z webservisem
     */
    public WekaRESTServiceClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI);
    }



    /*
     * Metoda wywołuje getAlgorithms z WebServisu
     * @return XML z dostępnymi algorytmami
     */
    public String getAlgorithms() throws UniformInterfaceException {
        return webResource.path("getAlgorithms").accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }


    /*
     * Uruchamia algorytm, w parametrach podaje się:
     * WekaAnswer.class, typ algorytmu, lokacja WS DBApi, id, table
     * @return odpowiedz WekaAnswer
     */
    public <T> T runAlgorithm(Class<T> responseType, int algorithmType, String location, String id, String table) throws UniformInterfaceException {
        MultivaluedMap queryParams = new MultivaluedMapImpl();
        queryParams.add("algorithmType", String.valueOf(algorithmType));
        queryParams.add("location", location);
        queryParams.add("id", id);
        queryParams.add("table", table);

        return webResource.path("runAlgorithm").queryParams(queryParams).accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /*
     * Zamyka połączenie
     */
    public void close() {
        client.destroy();
    }
}
