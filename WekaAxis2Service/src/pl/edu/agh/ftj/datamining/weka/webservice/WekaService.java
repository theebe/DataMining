package pl.edu.agh.ftj.datamining.weka.webservice;


import java.util.logging.Level;
import java.util.logging.Logger;


import pl.edu.agh.ftj.datamining.weka.algorithm.WekaAlgorithm;
import pl.edu.agh.ftj.datamining.weka.algorithm.WekaAnswer;

/**
 * Klasa implementująca inferfejs Webservisu dla Weki
 * Służy jako "most" łączący Webservisy z biblioteką Weka.
 * Webservis stworzony dla REST
 * adres:  http://localhost:8080/axis2/services/WekaService/{nazwaMetody}?{parametr1=aaa&parametr2=bbb}
 * wsdl:   http://localhost:8080/axis2/services/WekaService?wsdl
 * @author Szymon Skupien
 */
public class WekaService implements IWekaService {

    
    private static final Logger log  = Logger.getLogger("WekaAxis2Log");
   

    /**
     * @return zwraca tablicę z nazwami dostępnych algorytmów (inaczej sie nie da,
     * trzeba zrobic klase opakowujaca String'a)
     */
   
    public String[] getAlgorithms() {
       return WekaAlgorithm.getAlgorithms();
    }


    /**
     * Funkcja uruchamia dzialanie algorytmu
     * @param algorithmType wybiera typ algorytmu
     * @param location      adres URL do webservisu dbapi
     * @param id            id do danych (do webservisu dbapi)
     * @param table         table do danych (do webservisu dbapi)
     * @param options       opcje algorytmu w postaci stringu
     * @return Zwraca przetworzone dane z Weki
     */
  
    public WekaAnswer runAlgorithm(Integer algorithmType, String location, String id, String table, String options){
        WekaAlgorithm wekaAlgorithm = new WekaAlgorithm();
        
        /* Nie ma jeszcze klienta do webservisu Janka DBApi
         * funkcja korzysta z lokalnego pliku w celu przetestowania poprawnosci
         */
      /*   DataSource source = null;
        Instances data = null;

        try {
            source = new DataSource("pogoda.arff");
        } catch (Exception e) {
            log.log(Level.ALL, "nie ma pliku");
            e.printStackTrace();
        }

        try {
            data = source.getDataSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        String[] opt = new String[1];
        opt[0] = "-O";
        */
         wekaAlgorithm.setAlgorithmType(algorithmType);
        
        wekaAlgorithm.run();
       log.log(Level.INFO, "Jestem");
        return wekaAlgorithm.getData();
    }

}
