package pl.edu.agh.ftj.datamaining.weka.algorithm;

import weka.clusterers.Clusterer;
import weka.clusterers.Cobweb;
import weka.clusterers.EM;
import weka.clusterers.HierarchicalClusterer;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;


/**
 * Klasa odpowiedzialna za komunikacje z biblioteka Weki
 * @author Bartek
 */
public class WekaAlgorithm {

    /** 
     * Obiekt klasteryzatora inicjowany jako wybrany typ algorytmu.
     */
    private Clusterer clusterer = null;

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

    
    /**
     * Metoda zwracająca obiekt z danymi będącymi wynikiem działania algorytmu.
     * @return Obiekt z danymi.
     */
    public WekaAnswer getData() {
        return wekaAnswer;
    }

    public String[] getAlgorithms() {
        return algorithms;
    }


    public void run() {}
    public void setAlgorithmType(int algorithmType) {}
    public void setData(Instances Data) {}
    public void setOptions(String[] options) {}
}
