/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.edu.agh.ftj.datamaining.wekaservice;

/**
 *
 * @author bat
 */
public class WekaService implements IWekaService {


    private WekaAnswer wekaAnswer = new WekaAnswer();

    public String[] getAlgorithms(){
        String[] a = {"a", "b"};
        return a;
    }

    public String setAlgorithm(int algorithmType, String id, String table, String[] options){
        return "OKSet";
    }

    public String runAlgorithm(){
        return "OKRun";
    }

    public WekaAnswer getData(){
        return wekaAnswer;
    }

}
