import java.util.Scanner;

/** 
 * Problem Set 1 
 * Stratego.java
 * 
 * A java program that reads in two lines of text containing legal Stratego pieces,
 * an attacking piece first and then a defending piece.  
 * The program will then print out which piece(s) are removed, according to the rules of the game 
 *
 * @author Ira Goldstein
 * @version Spring 2024
 * 
 */
public class Stratego {
    
    private String pieceName;       // The name of the piece
    private int rank;               // The rank of the piece. A higher number can (generally) take a lower number
    private int overrideDefending;  // For the SPY and MINER:  The rank of the defending piece that can be taken by this piece
                                    // -1 is used if the piece does not have an override.

    /**
     * Construct a new Stratego object just using the piecename
     * 
     * @param pieceName  The name of the Stratego piece
     *
     */
    public Stratego(String pieceName) {

        this.pieceName = pieceName;
        this.overrideDefending = -1;            // A number not used for rank
        
        switch (pieceName) {
            case "BOMB":
                this.rank = 11;
                break;
            case "MARSHAL":
                this.rank = 10;
                break;
            case "GENERAL":
                this.rank = 9;
                break;
            case "COLONEL":
                this.rank = 8;
                break;
            case "MAJOR":
                this.rank = 7;
                break;
            case "CAPTAIN":
                this.rank = 6;
                break;
            case "LIEUTENANT":
                this.rank = 5;
                break;
            case "SERGEANT":
                this.rank = 4;
                break;
            case "MINER":
                this.rank = 3;
                this.overrideDefending = 11;    // Overrides BOMB
                break;
            case "SCOUT":
                this.rank = 2;
                break;
            case "SPY":
                this.rank = 1;
                this.overrideDefending = 10;    // Overrides MARSHAL
                break;
            case "FLAG":
                this.rank = 0;
                break;
        }
    }   

    /**
     * Construct a new Stratego object that can override the rank of one specific piece
     * 
     * @param pieceName  The name of the Stratego piece
     * @param rank       The rank of the piece. A higher number can (generally) take a lower number
     * @param overrideDefending        The rank of the defending piece that can be taken by this piece
     *
     */
    public Stratego(String pieceName, int rank,int overrideDefending ) {

        this.pieceName = pieceName;
        this.rank = rank;
        this.overrideDefending = overrideDefending;
    }    
   
    /**
     * Method to determine the winner of a battle
     * 
     * @param attacker   The attacking Stragego piece
     * @param defender   The defending Stragegopiece
     * @return              The name of the piece removed (or "BOTH")
     *
     */
    public static String battle(Stratego attacker, Stratego defender) {

        // Special case for MINER attacking BOMB and for SPY attacking MARSHAL
        if ( attacker.overrideDefending == defender.rank ) {
            return defender.pieceName;
        }
        
        // If both attacker and defender are the same, then remove BOTH
        if ( attacker.rank == defender.rank ) {
            return "BOTH";
        }
        
        // If attacker out ranks the defender, then remove the defender
        if ( attacker.rank > defender.rank ) {
            return defender.pieceName;
        }
        
        // Otherwise remove the attacker
            return attacker.pieceName;
    }   
   
    /**
    *
    * Reads in two a line of text, one for the attacking piece and one for the defending piece.
    * Following the rules of Stratego, prints out the results of a battle with the attacker and defender
    * 
    * @param args are not used or checked
    * 
    */   
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);    // Create an input scanner from the standard input
        
        String attacker = scanner.nextLine().toUpperCase();        // Get the attacker's name
        String defender = scanner.nextLine().toUpperCase();        // Get the defender's name
        
        Stratego attackerPiece = new Stratego(attacker);        // Create the attacker Stratego piece
        Stratego defenderPiece = new Stratego(defender);        // Create the defender Stratego piece
        
        String result = battle(attackerPiece, defenderPiece);     // Attacker battles defender
        
        System.out.println(result + " REMOVED");                // Print out the results

    }
    
}
