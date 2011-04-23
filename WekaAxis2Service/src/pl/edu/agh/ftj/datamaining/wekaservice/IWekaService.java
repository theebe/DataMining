package pl.edu.agh.ftj.datamaining.wekaservice;

import pl.edu.agh.ftj.datamaining.wekaalgorithm.WekaAnswer;

/**
 * Interfejs do Webservisu udostępniającego funkcjonalność Weki
 * @author Szymon Skupien
 */
public interface IWekaService {

    /**
     * @return zwraca tablicę z nazwami dostępnych algorytmów
     */
    public String[] getAlgorithms();

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
    public String setAlgorithm(int algorithmType, String location, String id, String table, String[] options);

    /**
     * Funkcja uruchamia dzialanie Weki
     * @return Odpowiedz czy algorytm zostal wykonany poprawnie
     */
    public String runAlgorithm();

    /**
     * Funkcja pobierajaca obiekt z danymi przetworzonymi przez Weke
     * @return obiekt z danymi z Weki
     */
    public WekaAnswer getData();
}
