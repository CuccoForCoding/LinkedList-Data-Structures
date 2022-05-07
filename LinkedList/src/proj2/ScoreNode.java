/**
 *
 * @author josephcucco
 * JoeyCucco
 * CIS2353
 * Winter2022
 * Project2
 */
package proj2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class ScoreNode {
    //ScoreNode name = new ScoreNode(); 
   // ScoreNode score = new ScoreNode();
    //how do I reference to another node?
    String name;
    int score;
            
    public ScoreNode next; 
    
    public ScoreNode(String otherName, int otherScore, ScoreNode next) {
        this.name = otherName;
        this.score = otherScore;
        this.next = next;
    }
}
