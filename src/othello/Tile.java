package othello;

/**
 * Structure for the Tile object. The board is made up of several tiles
 * 
 * @author Troy Cosentino
 */
public class Tile {
	// owner stores who owns this tile (black, white, none)
	private String owner;
	// validMove keeps track if this is a valid move for the current player
	private boolean validMove;
	// row and col hold where on the board this tile belongs to
	private int row, col;
	// holds whether or not this tiles value is approved
	private boolean approved;
	
	/**
	 * Default constructor for the Tile object
	 */
	public Tile() {
		
	}
	
	public Tile(int row, int col, String owner) {
		this.row = row;
		this.col = col;
		this.owner = owner;
		this.approved = true;
	}
	
	/**
	 * Getter for the owner variable
	 * @return the owner of this tile
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Setter for the owner variable
	 * @param owner - the new owner of the tile
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Gets whether or not this tile is currently a valid move
	 * @return whether or not the tile is a valid move
	 */
	public boolean isValidMove() {
                return validMove;
	}

	/**
	 * Set whether or not this tile is currently a valid move
	 * @param validMove
	 */
	public void setValidMove(boolean validMove) {
		this.validMove = validMove;
		// TODO: do we need this setValid?
	}

	public int getColumn() {
		return col;
	}

	public void setColumn(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}
