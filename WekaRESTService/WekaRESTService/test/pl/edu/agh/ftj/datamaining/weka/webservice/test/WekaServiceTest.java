
package pl.edu.agh.ftj.datamaining.weka.webservice.test;

import org.junit.Test;
import pl.edu.agh.ftj.datamaining.weka.algorithm.WekaAlgorithm;
import static org.junit.Assert.*;
import pl.edu.agh.ftj.datamaining.weka.algorithm.WekaAnswer;
import pl.edu.agh.ftj.datamaining.weka.webservice.WekaService;

/**
 * JUnit Test do klasy WekaService
 * @author Szymon Skupień
 */
public class WekaServiceTest {

    /**
     * Test of getAlgorithms method, of class WekaService.
     */
    @Test
    public void testGetAlgorithms() {

        String expResult = "<getAlgorithmsResponse xmlns=\"http://webservice/weka/datamaining/ftj/agh/edu/pl/xsd\"><return>SimpleKMeans</return><return>EM</return><return>HierarchicalClusterer</return><return>Cobweb</return></getAlgorithmsResponse>";
        WekaRESTServiceClient client = new WekaRESTServiceClient();
        String response = client.getAlgorithms();
       
        client.close();
        assertEquals(expResult, response);
        
    }

    /**
     * Test of runAlgorithm method, of class WekaService.
     */
    @Test
    public void testRunAlgorithm() {
        
        WekaRESTServiceClient client = new WekaRESTServiceClient();
        WekaAnswer response = client.runAlgorithm(WekaAnswer.class, 1, "location", "id", "table");
        WekaService expService = new WekaService();
        WekaAnswer expResult = expService.runAlgorithm(1, "location", "id", "table");

        assertEquals(expResult.getAlgorithmName(), response.getAlgorithmName());
        

    }

}