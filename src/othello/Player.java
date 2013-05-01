package othello;

import java.awt.Point;
import java.util.Scanner;

public class Player {
	
	private String owner;
	private boolean isCPU;
	
	public Player(String owner, boolean isCPU) {
		this.setOwner(owner);
		this.setCPU(isCPU);
	}
	
	public Point getMove(Scanner in, Board board) {
		Point temp = new Point();
		String move;
		if(isCPU) {
			for(int row = 0; row < board.getTiles().length; row++) {
				for(int col = 0; col < board.getTiles()[0].length; col++) {
					if(board.isValid(row, col, owner)) {
						temp.x = row;
						temp.y = col;
					} 
				}
			}
			System.out.print("The CPU will now play at: ");
			switch(temp.y) {
			case 0:
				System.out.print("A");
				break;
			case 1:
				System.out.print("B");
				break;
			case 2:
				System.out.print("C");
				break;
			case 3:
				System.out.print("D");
				break;
			case 4:
				System.out.print("E");
				break;
			case 5:
				System.out.print("F");
				break;
			case 6:
				System.out.print("G");
				break;
			case 7:
				System.out.print("H");
				break;
			}
			System.out.print(temp.x);
			System.out.print(" (y to approve)");
			in.next();
		} else {
			System.out.print("Where would you ("+getOwner()+") like to play? ");
			move = in.next();
			temp = parseMove(move);
		}
		return temp;
	}
	
	/**
	 * converts a string formatted move to its row and col components 
	 * @param move - format "B2"
	 * @return a point in the format of x is row and y is col
	 */
	public Point parseMove(String move) {
		Point temp = new Point();
		
		if(move.substring(0, 1).equals("A")) {
			temp.y = 0;
		} else if(move.substring(0, 1).equals("B")) {
			temp.y = 1;
		} else if(move.substring(0, 1).equals("C")) {
			temp.y = 2;
		} else if(move.substring(0, 1).equals("D")) {
			temp.y = 3;
		} else if(move.substring(0, 1).equals("E")) {
			temp.y = 4;
		} else if(move.substring(0, 1).equals("F")) {
			temp.y = 5;
		} else if(move.substring(0, 1).equals("G")) {
			temp.y = 6;
		} else if(move.substring(0, 1).equals("H")) {
			temp.y = 7;
		}
		
		temp.x = Integer.parseInt(move.substring(1, 2));
		
		return temp;
	}

	// Getters and setters
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isCPU() {
		return isCPU;
	}

	public void setCPU(boolean isCPU) {
		this.isCPU = isCPU;
	}

}
