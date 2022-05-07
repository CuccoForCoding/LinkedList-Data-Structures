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
import static java.lang.Integer.parseInt;
import java.nio.charset.StandardCharsets;

import java.util.*;

public class ScoreDemo {

    public static void main(String[] args) throws IOException {

        ScoreList sL = new ScoreList(); //Instance of ScoreList in Demo Class.
        Scanner scanner = new Scanner(System.in); //scanner for while loop and if blocks
        int x = 0;
        sL = sL.readFromFile();
        
        while (x == 0) {

            System.out.println("Would you like to add another (1), remove (2), or quit the program (3)?\n");
            System.out.println();
            int choice = scanner.nextInt();
            
            
            if (choice == 1) {
                
                
                System.out.println("Write the name followed by score");
                
                String line = scanner.next();
                int score = scanner.nextInt();
                sL.add(line,score);
                
                System.out.println("The new scores are:");
                sL.listItems();
                
            }
        
        
             if (choice == 2) {
                System.out.println("Write the name of the person you’d like to remove");
                String line = scanner.next();
                sL.remove("Nathan");
                System.out.println("The new scores are:");
                sL.listItems();
                
        }
             
             if (choice == 3) {
                 System.out.println("Thanks for using the program! Goodbye!");
                 System.exit(0);
        }
             
        }

        

        System.out.println("Write the name followed by score\n");

        System.out.println();

        System.out.println("The new scores are:");

        sL.add("Joey", 2000);
        sL.add("Josh", 305);
        sL.add("Bob", 500);
        sL.add("Heather", 315);
        sL.add("Fabio", 320);

        sL.sortList();

        sL.listItems();

    }
}

