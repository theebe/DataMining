
package pl.edu.agh.ftj.datamaining.wekaservice;

import pl.edu.agh.ftj.datamaining.wekaalgorithm.WekaAlgorithm;
import pl.edu.agh.ftj.datamaining.wekaalgorithm.WekaAnswer;

/**
 * Klasa implementująca inferfejs Webservisu dla Weki
 * Służy jako "most" łączący Webservisy z biblioteką Weka.
 * Webservis stworzony dla Axis2
 * @author Szymon Skupien
 */
public class WekaService implements IWekaService {

    /**
     * w założeniu obiekt, w którym będzie obsługiwał biblioteke Weki.
     * Na razie nie dostałem jeszcze informacji o tym jak klasa będzie wyglądała.
     */
    private WekaAlgorithm wekaAlgorithm = new WekaAlgorithm();


    /**
     * @return zwraca tablicę z nazwami dostępnych algorytmów
     */
    public String[] getAlgorithms(){
        return wekaAlgorithm.getAlgorithms();
    }

    /**
     * Funkcja przygotowujaca algorytm Wei
     *
     * @param algorithmType wybiera typ algorytmu
     * @param location      adres URL do webservisu dbapi
     * @param id            id do danych (do webservisu dbapi)
     * @param table         table do danych (do webservisu dbapi)
     * @param options       opcje algorytmu 
     * @return              String z odpowiedzia czy operacja wykonala sie poprawnie
     */
    public String setAlgorithm(int algorithmType, String location, String id, String table, String[] options){
        //TODO: wyciaganie danych z webserwisu dbapi; ustawienie parametrow algorytmu; wyslanie odpowiedzi
        return "OKSet";
    }


    /**
     * Funkcja uruchamia dzialanie Weki
     * @return Odpowiedz czy algorytm zostal wykonany poprawnie
     */
    public String runAlgorithm(){
        //TODO: uruchomienie algorytmu, sprawdzenie czy wszystko OK
        return "OKRun";
    }


    /**
     * Funkcja pobierajaca obiekt z danymi przetworzonymi przez Weke
     * @return obiekt z danymi z Weki
     */
    public WekaAnswer getData(){
        return wekaAlgorithm.getData();
    }

}
