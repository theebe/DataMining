package pl.edu.agh.ftj.datamaining.weka.webservice;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import pl.edu.agh.ftj.datamaining.weka.algorithm.WekaAlgorithm;
import pl.edu.agh.ftj.datamaining.weka.algorithm.WekaAnswer;

/**
 * Klasa implementująca inferfejs Webservisu dla Weki
 * Służy jako "most" łączący Webservisy z biblioteką Weka.
 * Webservis stworzony dla REST
 * adres:  http://localhost:8080/WekaRESTService/rest/{nazwaMetody}?{parametr1=aaa&parametr2=bbb}
 * wadl:   http://localhost:8080/WekaRESTService/rest/application.wadl
 * @author Szymon Skupien
 */
@Path("/")
public class WekaService implements IWekaService {

   

    /**
     * Funkcja odpowiadajaca na rzadanie GET http://localhost:8080/WekaRESTService/rest/
     * @return Strona html przekierowujaca na adres http://prgzsp.ftj.agh.edu.pl/trac/P3-DataMining
     */
    @GET
    @Produces("text/html")
    public String hello(){
        //troche jak z czasow servletow, ale proste i dziala - przekierowanie
        return "<html><head><META HTTP-EQUIV=\"Refresh\" CONTENT=\"1; URL=http://prgzsp.ftj.agh.edu.pl/trac/P3-DataMining\"></head><body></body></html>";
    }

    /**
     * @return zwraca tablicę z nazwami dostępnych algorytmów (inaczej sie nie da,
     * trzeba zrobic klase opakowujaca String'a)
     */
    @GET
    @Produces("application/xml")
    @Path("/getAlgorithms")
    public String getAlgorithms() {
       
        String r = "<getAlgorithmsResponse xmlns=\"http://webservice/weka/datamaining/ftj/agh/edu/pl/xsd\">";
        for (int i = 0; i < WekaAlgorithm.getAlgorithms().length; i++) {
            r += "<return>" + WekaAlgorithm.getAlgorithms()[i] + "</return>";
        }
        r += "</getAlgorithmsResponse>";
        return r;
      
    }


    /**
     * Funkcja uruchamia dzialanie algorytmu
     * @param algorithmType wybiera typ algorytmu
     * @param location      adres URL do webservisu dbapi
     * @param id            id do danych (do webservisu dbapi)
     * @param table         table do danych (do webservisu dbapi)
     * @param options       opcje algorytmu
     * @return Zwraca przetworzone dane z Weki
     */
    @GET
    @Produces("application/xml")
    @Path("/runAlgorithm")
    public WekaAnswer runAlgorithm(@QueryParam("algorithmType") Integer algorithmType, @QueryParam("location") String location, @QueryParam("id") String id, @QueryParam("table") String table){
        WekaAlgorithm wekaAlgorithm = new WekaAlgorithm();
        wekaAlgorithm.setAlgorithmType(algorithmType);
        
        wekaAlgorithm.run();
        return wekaAlgorithm.getData();
    }



}
