import java.util.Scanner;

/**
 * Problem Set 1
 * NameGame.java
 *
 * Prints the lyrics for a given name 
 * as specified by The Name Game
 * https://www.youtube.com/watch?v=5MJLi5_dyn0 
 * 
 * @author Ira Goldstein
 * @version Spring 2024
 *
 */
public class NameGame {

    static final String VOWELS = "aeiouAEIOU";

    /**
    *
    * Reads in a line of text and, following the rules of 
    * The Name Game, prints out the lyrics.
    * 
    * @param args are not used or checked
    * 
    */   
    public static void main(String[] args) { 
    
        // Initialize variables
        int vowelPosition = -1;
        char c = ' ';
    
        Scanner scanner = new Scanner(System.in);     // Create an input scanner from the standard input

        String name = scanner.nextLine();            // Get the name

        // Find the position of the first vowel
        try {    
            while ( VOWELS.indexOf(c) == -1 ) {
                vowelPosition++;
                c = name.charAt(vowelPosition);
            }
        }
		
        // Hack for names with just a Y
        catch (StringIndexOutOfBoundsException e) {
            vowelPosition = name.toLowerCase().indexOf('y');
        }
    
        // Trim the name so it starts at the first vowel, eliminating all starting
        // consonants, and make lower case
        String trimName = name.substring(vowelPosition).toLowerCase();
    
        char firstLetter = name.toLowerCase().charAt(0);    // Get inital letter to use with rules
    
        // Print the name twice and print the 'b' line
        System.out.print(name + ", " + name + ", bo-");
    
        if (firstLetter != 'b') {                        // Following rule for 'b' names
            System.out.println("b" + trimName + ",");
        }
        else {
            System.out.println(trimName + ",");
        }
    
        // Build and print the 'f' line
        System.out.print("Banana-fana fo-");
        if (firstLetter != 'f') {                        // Following rule for 'f' names
            System.out.println("f" + trimName + ",");
        }
        else {
            System.out.println(trimName+ "," );
        }
 
        // Build and print the 'm' line
        System.out.print("Fee-fi-mo-");
        if (firstLetter != 'm') {                        // Following rule for 'm' names
            System.out.println("m" + trimName + ".");
        }
        else {
            System.out.println(trimName+ "." );
        } 
 
        // Print the original name followed by !
        System.out.print(name + "!");
    }    
}
    
