
package pl.edu.agh.ftj.datamaining.weka.algorithm;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Klasa z danymi otrzymanymi z Weki
 * Pisze ją ktoś inny z zespolu Weki
 * @author Szymon Skupien
 */
@XmlRootElement
public class WekaAnswer {

    @XmlElement
    public String answer = "odpowiedz";
    
}
