/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.agh.ftj.datamaining.wekaservice;

/**
 *
 * @author bat
 */
public interface IWekaService {

    public String[] getAlgorithms();

    public String setAlgorithm(int algorithmType, String id, String table, String[] options);

    public String runAlgorithm();

    public WekaAnswer getData();

}
