/*
 * Problem Set 1
 * LoopTheLoop.java
 *
 * Prints a multiplication table 
 * 
 * @author Ira Goldstein
 * @version Spring 2024
 *
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class LoopTheLoop {
   
    /**
    *
    * Reads in two integers and then prints a multiplication
    * table from the smaller number to the larger number
    * Input values will be 300 or less.
    * 
    * @param args are not used or checked
    * 
    */   

    static final String DASHES = "-------";         // String to use for our heading underline
	
    public static void main(String[] args) { 

		// Initialize variables used in the "try"
        int low = 0;
        int high = 0;
		
        Scanner scanner = new Scanner(System.in);  // Create an input scanner from the standard input
				
        // Make sure that we get integers
        try {
            low = scanner.nextInt();
            high = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Need to specify an integer");
            System.exit(1);
        }
		
        // Switch the two numbers if finish is smaller than start
        if (high < low) {
            int temp = low;
            low = high;
            high = temp;
        } 
		
		// Cheick to make sure that we do not go above 300
		if ( high > 300 ) {
            System.out.println("Both values need to be 300 or less");
            System.exit(1);
        }		

		// Print the top line of the heading
        System.out.printf("%5s", "X");
        for (int i = low; i <= high; i++) {
            System.out.printf("%7d", i);
		}
		System.out.println();

		// Print the line between the heading and the body of the table
        System.out.printf("%5s", "-----");
        for (int i = low; i <= high; i++) {
            System.out.printf("%7s", DASHES);
		}
		System.out.println();
		
		// Print the body of the table
        for (int i = low; i <= high; i++) {
            System.out.printf("%5d", i);         // Print left "heading"
            for (int j = low; j <= high; j++){
                System.out.printf("%7d", i*j);   // Print the product
            }
            System.out.println();
        }

	}    
}
