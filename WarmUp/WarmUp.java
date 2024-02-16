import java.util.Scanner;

/** 
 * Problem Set 1 
 * WarmUp.java
 * 
 * Repeats a given string n number of times
 *
 * @author Ira Goldstein
 * @version Spring 2024
 * 
 */
public class WarmUp {

    /**
    *
    * Reads in a positive integer n and a line of text, 
    * then prints the text the n number of times.
    * 
    * @param args are not used or checked
    * 
    */
    public static void main(String[] args) { 
        
        Scanner scanner = new Scanner(System.in);  // Create an input scanner from the standard input

        int repeat = scanner.nextInt();            // Get a positive integer
        if (repeat < 1 ) {                         // Check to make sure it is at least 1 
            System.out.println("Need to specify a positive integer");
            System.exit(1);
        }

        scanner.nextLine();                       // Need to "eat up" the carriage return from nextInt

        String inputText = scanner.nextLine();    // Text that will print repeat number of times

        for(int i=0; i< repeat; i++ ) {           // Loop and print
            System.out.println(inputText);
        }

    }
    
}
