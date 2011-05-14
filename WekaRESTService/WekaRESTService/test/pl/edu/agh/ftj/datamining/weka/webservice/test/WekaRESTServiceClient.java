package pl.edu.agh.ftj.datamining.weka.webservice.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import javax.ws.rs.core.MultivaluedMap;
import pl.edu.agh.ftj.datamining.weka.algorithm.WekaAnswer;

/** Jersey REST client generated for REST resource: WekaService [/]<br>
 *  USAGE:<pre>
 *        WekaRESTServiceClient client = new WekaRESTServiceClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author Szymon Skupien
 * @version 0.2
 */
public class WekaRESTServiceClient {

    private WebResource webResource;
    private Client client;
    /*
     * Podstawowy adres do WebServisu REST 
     */
    private String base_uri;

    /*
     * Konstruktor klienta, łączy się z webservisem
     * @param adres uri webservisu rest
     */
    public WekaRESTServiceClient(String base_uri) {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        this.base_uri = base_uri;
        webResource = client.resource(this.base_uri);
    }

    /*
     * Metoda wywołuje getAlgorithms z WebServisu
     * @return XML z dostępnymi algorytmami
     */
    public String getAlgorithms() throws UniformInterfaceException {
        return webResource.path("getAlgorithms").accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    /**
     * Uruchamia algorytm, w parametrach podaje się:
     * @param typ algorytmu
     * @param lokacja WS DBApi
     * @param id (DBApi)
     * @param table (DBApi)
     * @param options 
     * @return odpowiedz WekaAnswer
     */
    public WekaAnswer runAlgorithm(int algorithmType, String location, String id, String table, String options) {
        MultivaluedMap queryParams = new MultivaluedMapImpl();
        queryParams.add("algorithmType", String.valueOf(algorithmType));
        queryParams.add("location", location);
        queryParams.add("id", id);
        queryParams.add("table", table);
        queryParams.add("options", table);
        String odp = webResource.path("runAlgorithm").queryParams(queryParams).accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
        byte[] odpBytes = odp.getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(odpBytes);
        WekaAnswer wekaAns = null;
        try {
            ObjectInput in = new ObjectInputStream(bis);
            wekaAns = (WekaAnswer) in.readObject();
        }
        catch (IOException e) {
            System.out.println("blad w strumieniu bajtow");
        }
        catch(ClassNotFoundException ex){
            System.out.println("blad w serializacji");
        }

        return wekaAns;
    }

    /*
     * Zamyka połączenie
     */
    public void close() {
        client.destroy();
    }
}
