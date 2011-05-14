package pl.edu.agh.ftj.datamining.weka.webservice.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.edu.agh.ftj.datamining.weka.algorithm.WekaAnswer;
import pl.edu.agh.ftj.datamining.weka.webservice.WekaService;

/**
 * JUnit Test do klasy WekaService
 * @author Szymon Skupień
 * @version 1.0
 */
public class WekaServiceTest {

    /**
     * Adres do webservisu Weki 
     */
    private final String WekaRESTServiceURI = "http://localhost:8080/WekaRESTService/rest";
    /**
     * Klasa klienta WebServisu
     */
    private WekaRESTServiceClient client;

    /**
     * Metoda wykonuje sie przed wykonaniem każdego testu
     * tworzy nowy obiekt klienta servisu
     */
    @Before
    public void before() {
        this.client = new WekaRESTServiceClient(WekaRESTServiceURI);
    }

    /**
     * Test of getAlgorithms method, of class WekaService.
     */
    @Test
    public void testGetAlgorithms() {

        String expResult = "<getAlgorithmsResponse xmlns=\"http://webservice/weka/datamaining/ftj/agh/edu/pl/xsd\"><return>SimpleKMeans</return><return>EM</return><return>HierarchicalClusterer</return><return>Cobweb</return></getAlgorithmsResponse>";

        String response = client.getAlgorithms();

        assertEquals(expResult, response);

    }

    /**
     * Test of runAlgorithm method, of class WekaService.
     */
    @Test
    public void testRunAlgorithm() {

        // WekaAnswer response = client.runAlgorithm(WekaAnswer.class, 1, "location", "id", "table", "opt");
        // WekaService expService = new WekaService();
        // WekaAnswer expResult = expService.runAlgorithm(1, "location", "id", "table", "opt");
        //    assertEquals(expResult.getAlgorithmName(), response.getAlgorithmName());
        WekaAnswer response = client.runAlgorithm(1, "location", "ïd", "table", "opt");
        WekaService expService = new WekaService();
      /*  byte[] byteResult = expService.runAlgorithm(1, "location", "id", "table", "opt");
        ByteArrayInputStream bis = new ByteArrayInputStream(byteResult);
        WekaAnswer expResult = null;
        try {
            ObjectInput in = new ObjectInputStream(bis);
            expResult = (WekaAnswer) in.readObject();
        } catch (IOException e) {
            //blad w ciagu bajtow
        } catch (ClassNotFoundException ex) {
            //blad w serializacji
        }
        if(response==null){
             System.out.println("#####################################");
        System.out.println(response.getAlgorithmName());
       
        }
         assertEquals(expResult.getAlgorithmName(), response.getAlgorithmName());
       *
       */
        assertTrue(false); //TODO
    }

    /**
     * Wykonuje się po każdym tescie
     * zamyka klienta i kasuje referencje objektu
     */
    @After
    public void after() {
        client.close();
        client = null;
    }
}
