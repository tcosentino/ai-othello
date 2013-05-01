/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author Sam Cutler
 */
public class Othello {

    private static Scanner input;
    private static Board board;
    private static Player black, white, currentPlayer;
    private static String color;
	
    private static void initGame() {
    	System.out.println("Welcome to Sam and Troy's wonderful world of othello!");
    	System.out.println("To get started,");
		
    	// create two players to play the game
		System.out.print("Do you (p) want to be black or white? (b/w) ");
		color = input.next();
		if(color.equals("b")) {
			black = new Player("B", false);
			white = new Player("W", true);
		} else if(color.equals("w")) {
			black = new Player("B", true);
			white = new Player("W", false);
		}
			
		// Space it out
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
			
		//the first player to play is black
		// TODO: find out if this works like a pointer
		currentPlayer = black;
	}
    
    
    private static void printScore() {
		System.out.print("Score:  ");
		System.out.print("black: ");
		System.out.print(board.getBlackScore());
		System.out.print("   ");
		System.out.print("white: ");
		System.out.println(board.getWhiteScore());
	}
    
    private static void switchCurrentPlayer() {
    	if(currentPlayer == black) {
    		currentPlayer = white;
    	} else {
    		currentPlayer = black;
    	}
    }
     
    
    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
    	System.out.println("\u001B31;1mHello World!");
        // TODO code application logic here
        
        // scanner used for input
		input = new Scanner(System.in);
			
		// create a board to play the game on
		board = new Board();
			
	    // begin the game
		initGame();
			
		
		Point move = new Point();
		while(board.doesMoveExist("B") || board.doesMoveExist("W")) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			// print the score board
			printScore();
				
			// print the status of the board
			board.print();
			
			if(board.doesMoveExist(currentPlayer.getOwner())) {
				move = currentPlayer.getMove(input, board);
			
				while(!board.makeMove(move.x, move.y, currentPlayer.getOwner())) {
					System.out.println("Invalid move, choose again.");
					move = currentPlayer.getMove(input, board);
				}
			} else {
				System.out.print("Sorry, the current player ("+currentPlayer.getOwner()+") has no moves. (type y to continue)");
				input.next();
			}

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			board.print();
			System.out.println();
			System.out.println("Does this look correct? (type y to continue) ");
			input.next();
			board.approveAll();
			
			switchCurrentPlayer();
		}
		

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		// print the score board
		printScore();
			
		// print the status of the board
		board.print();

		System.out.println();
		System.out.print("Game is over! ");
		if(board.getBlackScore() > board.getWhiteScore()) {
			System.out.print("B");
		} else {
			System.out.print("W");
		}
		System.out.println(" wins!");
    
    }
}
