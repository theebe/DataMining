package pl.edu.agh.ftj.datamaining.wekaalgorithm;

/**
 *
 * @author Szymon Skupien
 */
public class WekaAlgorithm {

    /**
     * Obiekt zawierajace dane zwracajane przez Weke
     */
    private WekaAnswer wekaAnswer = new WekaAnswer();

    /**
     * Tablica z nazwami udostępnianych algorytmów
     */
    private String[] algorithms = {
        "SimpleKMeans",
        "EM",
        "HierarchicalClusterer",
        "Cobweb"
    };

    public WekaAnswer getData() {
        return wekaAnswer;
    }

    public String[] getAlgorithms(){
        return algorithms;
    }
}
