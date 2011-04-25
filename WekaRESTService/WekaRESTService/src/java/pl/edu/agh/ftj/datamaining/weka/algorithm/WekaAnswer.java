package pl.edu.agh.ftj.datamaining.weka.algorithm;

import javax.xml.bind.annotation.*;
import weka.core.Capabilities;
import weka.core.DistanceFunction;
import weka.core.Instances;

/**
 * Klasa obiektu przechowującego dane wyprodukowane przez algorytmy Weki.
 * Obiekt ten będzie zwracany do silnika.
 * @author Bartek
 */
@XmlRootElement
public class WekaAnswer {

    /**
     * Typ algorytmu jaki ma zostac uzyty. Dostepne opcje: 1 - SimpleKMeans, 2 - EM, 3 - HierarchicalClusterer, 4 - Cobweb.
     */
  //  @XmlElement
    private int algorithmType;

    /**
     * Nazwa użytego algorytmu.
     */
   // @XmlElement
    private String algorithmName;

   // @XmlElement
    private int[] assignments;
    
   // @XmlElement
    private Capabilities capabilities;

   // @XmlElement
    private Instances clusterCentroids;

   // @XmlElement
    private int[][][] clusterNominalCounts;

   // @XmlElement
    private int[] clusterSizes;

   // @XmlElement
    private Instances clusterStandardDevs;

   // @XmlElement
    private DistanceFunction distanceFunction;

   // @XmlElement
    private int maxIterations;

   // @XmlElement
    private int numClusters;

   // @XmlElement
    private String[] options;

   // @XmlElement
    private String revision;

   // @XmlElement
    private double squaredError;

    //@XmlElement
    private int numberOfClusters;

   // @XmlElement
    private double[] clusterPriors;

   // @XmlElement
    private double[][][] clusterModelsNumericAtts;

   // @XmlElement
    private double minStdDev;

    public int[] getAssignments() {
        return assignments;
    }

    public void setAssignments(int[] assignments) {
        this.assignments = assignments;
    }

    @XmlAnyElement
    public Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    @XmlAnyElement
    public Instances getClusterCentroids() {
        return clusterCentroids;
    }

    public void setClusterCentroids(Instances clusterCentroids) {
        this.clusterCentroids = clusterCentroids;
    }

    public int[][][] getClusterNominalCounts() {
        return clusterNominalCounts;
    }

    public void setClusterNominalCounts(int[][][] clusterNominalCounts) {
        this.clusterNominalCounts = clusterNominalCounts;
    }

    public int[] getClusterSizes() {
        return clusterSizes;
    }

    public void setClusterSizes(int[] clusterSizes) {
        this.clusterSizes = clusterSizes;
    }

    @XmlAnyElement
    public Instances getClusterStandardDevs() {
        return clusterStandardDevs;
    }

    public void setClusterStandardDevs(Instances clusterStandardDevs) {
        this.clusterStandardDevs = clusterStandardDevs;
    }

    @XmlAnyElement
    public DistanceFunction getDistanceFunction() {
        return distanceFunction;
    }

    public void setDistanceFunction(DistanceFunction distanceFunction) {
        this.distanceFunction = distanceFunction;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    public int getNumClusters() {
        return numClusters;
    }

    public void setNumClusters(int numClusters) {
        this.numClusters = numClusters;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public int getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(int algorithmType) {
        this.algorithmType = algorithmType;
    }

    public int getNumberOfClusters() {
        return numberOfClusters;
    }

    public void setNumberOfClusters(int numberOfClusters) {
        this.numberOfClusters = numberOfClusters;
    }

    public double getSquaredError() {
        return squaredError;
    }

    public void setSquaredError(double squaredError) {
        this.squaredError = squaredError;
    }

    public double[][][] getClusterModelsNumericAtts() {
        return clusterModelsNumericAtts;
    }

    public void setClusterModelsNumericAtts(double[][][] clusterModelsNumericAtts) {
        this.clusterModelsNumericAtts = clusterModelsNumericAtts;
    }

    public double[] getClusterPriors() {
        return clusterPriors;
    }

    public void setClusterPriors(double[] clusterPriors) {
        this.clusterPriors = clusterPriors;
    }

    public double getMinStdDev() {
        return minStdDev;
    }

    public void setMinStdDev(double minStdDev) {
        this.minStdDev = minStdDev;
    }

    @Override
    public String toString() {
        return "Algorithm: " + algorithmType + "; Name: " + algorithmName;
    }

    /**
     * Ustawia nazwę algorytmu.
     * @param algorithmName Nazwa algorytmu.
     */
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

        /**
     * @return the algorithmName
     */
    public String getAlgorithmName() {
        return algorithmName;
    }
}
