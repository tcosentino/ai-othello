package othello;

/**
 * Structure for the board object for our othello game.
 * 
 * @author Troy Cosentino
 */
public class Board {
	
	private Tile[][] tiles = new Tile[8][8];
	
	private int blackScore, whiteScore;
	
	/**
	 * Default constructor for the Board object.
	 */
	public Board() {
		
		// instantiate each of the tile objects
		for(int row = 0; row < tiles.length; row++) {
			for(int col = 0; col < tiles[row].length; col++) {
				tiles[row][col] = new Tile(row, col, "-");
			}
		}
		
		// change the ownership of the initial tiles
		tiles[3][3].setOwner("B");
		tiles[3][4].setOwner("W");
		tiles[4][3].setOwner("W");
		tiles[4][4].setOwner("B");
		
		calcScore();
		// black goes first
		//showValid("B");
	}
	
	/**
	 * calculates the current score of both players
	 */
	private void calcScore() {
		setBlackScore(0);
		setWhiteScore(0);
		for(int row = 0; row < this.tiles.length; row++) {
			for(int col = 0; col < this.tiles[0].length; col++) {
				if(this.tiles[row][col].getOwner() == "B") {
					setBlackScore(getBlackScore() + 1);
				} else if(this.tiles[row][col].getOwner() == "W") {
					setWhiteScore(getWhiteScore() + 1);
				}
			}
		}
	}
	
	/**
	 * prints the current board configuration
	 */
	public void print() {
		System.out.println();
		System.out.println("               A B C D E F G H");
		System.out.println();
		for(int row = 0; row < tiles.length; row++) {
			System.out.print("           " + row + "   ");
			for(int col = 0; col < tiles[row].length; col++) {
				if(tiles[row][col].isApproved()) {
					System.out.print(tiles[row][col].getOwner() + " ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
	
    /**
	 * consolidates all checkers and tells us if the move is valid
	 */
	public boolean isValid(int row, int col, String owner) {
            if(this.tiles[row][col].getOwner() != "-") {
                return false;
            }
            else {
                if(chkHorR(row, col, owner)) {
                    return true;
                }
                else if(chkHorL(row, col, owner)) {
                    return true;
                }
                else if(chkVerU(row, col, owner)) {
                    return true;
                }
                else if(chkVerD(row, col, owner)) {
                    return true;
                }
                else if(chkDiagUR(row, col, owner)) {
                    return true;
                }
                else if(chkDiagUL(row, col, owner)) {
                    return true;
                }
                else if(chkDiagDR(row, col, owner)) {
                    return true;
                }
                else if(chkDiagDL(row, col, owner)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        
        
        
        /**
		 * checks the horizontal validity to the right
		 */
        public boolean chkHorR(int row, int col, String owner) {
            int i;
            if(owner == "B" && col < 7) {
                i = col + 1;
                if(this.tiles[row][i].getOwner() == "B") {
                    return false;             
                }
                else if(this.tiles[row][i].getOwner() == "-") {
                    return false;                    
                }
                else if(this.tiles[row][i].getOwner() == "W") {
                    while(i <= 7) {
                        if(this.tiles[row][i].getOwner() == "B") {
                            i = 8;
                            return true;                          
                        }
                        else if(this.tiles[row][i].getOwner() == "W") {
                            i++;                            
                        } else {
                        	return false;
                        }
                    }
                }
            }
            else if(owner == "W" && col < 7) {
                i = col + 1;
                if(this.tiles[row][i].getOwner() == "W") {
                    return false;

                }
                else if(this.tiles[row][i].getOwner() == "-") {
                    return false;

                }
                else if(this.tiles[row][i].getOwner() == "B") {
                    while(i <= 7) {
                        if(this.tiles[row][i].getOwner() == "W") {
                            i = 8;
                            return true;
                        }
                        else if(this.tiles[row][i].getOwner() == "B") {
                            i++;
                        } else {
                        	return false;
                        }
                    }
                }
            }   
        return false;
        }
        
        /**
	 * checks the horizontal validity to the left
	 */
        public boolean chkHorL(int row, int col, String owner) {
            int i;
            if(owner == "B" && col > 0) {
                i = col - 1;
                if(this.tiles[row][i].getOwner() == "B") {
                    return false;             
                }
                else if(this.tiles[row][i].getOwner() == "-") {
                    return false;                    
                }
                else if(this.tiles[row][i].getOwner() == "W") {
                    while(i >= 0) {
                        if(this.tiles[row][i].getOwner() == "B") {
                            i = 0;
                            return true;                          
                        }
                        else if(this.tiles[row][i].getOwner() == "W") {
                            i--;                            
                        } else {
                        	return false;
                        }
                    }
                }
            }
            else if(owner == "W" && col > 0) {
                i = col - 1;
                if(this.tiles[row][i].getOwner() == "W") {
                    return false;
                }
                else if(this.tiles[row][i].getOwner() == "-") {
                    return false;
                }
                else if(this.tiles[row][i].getOwner() == "B") {
                    while(i >= 0) {
                        if(this.tiles[row][i].getOwner() == "W") {
                            i = 0;
                            return true;
                        }
                        else if(this.tiles[row][i].getOwner() == "B") {
                            i--;
                        } else {
                        	return false;
                        }
                    }
                }
            }   
            return false;
        }
        
        /**
	 * checks the upward validity
	 */
        public boolean chkVerU(int row, int col, String owner) {
           int i;
           if(owner == "B" && row > 0) {
               i = row - 1;
               if(this.tiles[i][col].getOwner() == "B") {
                   return false;             
               }
               else if(this.tiles[i][col].getOwner() == "-") {
                   return false;                    
               }
               else if(this.tiles[i][col].getOwner() == "W") {
                   while(i >= 0) {
                       if(this.tiles[i][col].getOwner() == "B") {
                           i = 0;
                           return true;                          
                       }
                       else if(this.tiles[i][col].getOwner() == "W") {
                           i--;                            
                       } else {
                       	return false;
                       }
                   }
               }
           }
           else if(owner == "W" && row > 0) {
               i = row - 1;
               if(this.tiles[i][col].getOwner() == "W") {
                   return false;
               }
               else if(this.tiles[i][col].getOwner() == "-") {
                   return false;
               }
               else if(this.tiles[i][col].getOwner() == "B") {
                   while(i >= 0) {
                       if(this.tiles[i][col].getOwner() == "W") {
                           i = 0;
                           return true;
                       }
                       else if(this.tiles[i][col].getOwner() == "B") {
                           i--;
                       } else {
                       	return false;
                       }
                   }
               }
           }   
       return false;
       }
       
       /**
	 * checks the downward validity
	 */ 
       public boolean chkVerD(int row, int col, String owner) {
           int i;
           if(owner == "B" && row < 7) {
               i = row + 1;
               if(this.tiles[i][col].getOwner() == "B") {
                   return false;             
               }
               else if(this.tiles[i][col].getOwner() == "-") {
                   return false;                    
               }
               else if(this.tiles[i][col].getOwner() == "W") {
                   while(i <= 7) {
                       if(this.tiles[i][col].getOwner() == "B") {
                           i = 8;
                           return true;                          
                       }
                       else if(this.tiles[i][col].getOwner() == "W") {
                           i++;                            
                       } else {
                       	return false;
                       }
                   } 
               }
           }
           else if(owner == "W" && row < 7) {
               i = row + 1;
               if(this.tiles[i][col].getOwner() == "W") {
                   return false;
               }
               else if(this.tiles[i][col].getOwner() == "-") {
                   return false;
               }
               else if(this.tiles[i][col].getOwner() == "B") {
                   while(i <= 7) {
                       if(this.tiles[i][col].getOwner() == "W") {
                           i = 8;
                           return true;
                       }
                       else if(this.tiles[i][col].getOwner() == "B") {
                           i++;
                       } else {
                       	return false;
                       }
                   }
               }
           }   
       return false;
       } 
       
       /**
	 * checks the upward diagonal validity to the right
	 */
       public boolean chkDiagUR(int row, int col, String owner) {
           int i, j;
           if(owner == "B" && row > 0 && col < 7) {
               i = row - 1;
               j = col + 1;
               if(this.tiles[i][j].getOwner() == "B") {
                   return false;             
               }
               else if(this.tiles[i][j].getOwner() == "-") {
                   return false;                    
               }
               else if(this.tiles[i][j].getOwner() == "W") {
                   while(i >= 0 && j <= 7) {
                       if(this.tiles[i][j].getOwner() == "B") {
                           j = 8;
                           return true;                          
                       }
                       else if(this.tiles[i][j].getOwner() == "W") {
                           i--;
                           j++;
                       } else {
                       	return false;
                       }
                   }
               }
           }
           else if(owner == "W" && row > 0 && col < 7) {
               i = row - 1;
               j = col + 1;
               if(this.tiles[i][j].getOwner() == "W") {
                   return false;
               }
               else if(this.tiles[i][j].getOwner() == "-") {
                   return false;
               }
               else if(this.tiles[i][j].getOwner() == "B") {
                   while(i >= 0 && j <= 7) {
                       if(this.tiles[i][j].getOwner() == "W") {
                           j = 8;
                           return true;
                       }
                       else if(this.tiles[i][j].getOwner() == "B") {
                           i--;
                           j++;
                       } else {
                       	return false;
                       }
                   }
               }
           }   
       return false;
       }
       
       /**
	 * checks the upward diagonal validity to the left
	 */
       public boolean chkDiagUL(int row, int col, String owner) {
           int i, j;
           if(owner == "B" && row > 0 && col > 0) {
               i = row - 1;
               j = col - 1;
               if(this.tiles[i][j].getOwner() == "B") {
                   return false;             
               }
               else if(this.tiles[i][j].getOwner() == "-") {
                   return false;                    
               }
               else if(this.tiles[i][j].getOwner() == "W") {
                   while(i >= 0 && j >= 0) {
                       if(this.tiles[i][j].getOwner() == "B") {
                           j = 0;
                           return true;                          
                       }
                       else if(this.tiles[i][j].getOwner() == "W") {
                           i--;
                           j--;
                       } else {
                       	return false;
                       }
                   }
               }
           }
           else if(owner == "W" && row > 0 && col > 0) {
               i = row - 1;
               j = col - 1;
               if(this.tiles[i][j].getOwner() == "W") {
                   return false;
               }
               else if(this.tiles[i][j].getOwner() == "-") {
                   return false;
               }
               else if(this.tiles[i][j].getOwner() == "B") {
                   while(i >= 0 && j >= 0) {
                       if(this.tiles[i][j].getOwner() == "W") {
                           j = 0;
                           return true;
                       }
                       else if(this.tiles[i][j].getOwner() == "B") {
                           i--;
                           j--;
                       } else {
                       	return false;
                       }
                   }
               }
           }   
       return false;
       }
       
       /**
	 * checks the downward diagonal validity to the right
	 */
       public boolean chkDiagDR(int row, int col, String owner) {
           int i, j;
           if(owner == "B" && row < 7 && col < 7) {
               i = row + 1;
               j = col + 1;
               if(this.tiles[i][j].getOwner() == "B") {
                   return false;             
               }
               else if(this.tiles[i][j].getOwner() == "-") {
                   return false;                    
               }
               else if(this.tiles[i][j].getOwner() == "W") {
                   while(i <= 7 && j <= 7) {
                       if(this.tiles[i][j].getOwner() == "B") {
                           j = 8;
                           return true;                          
                       }
                       else if(this.tiles[i][j].getOwner() == "W") {
                           i++;
                           j++;
                       } else {
                       	return false;
                       }
                   }
               }
           }
           else if(owner == "W" && row < 7 && col < 7) {
               i = row + 1;
               j = col + 1;
               if(this.tiles[i][j].getOwner() == "W") {
                   return false;
               }
               else if(this.tiles[i][j].getOwner() == "-") {
                   return false;
               }
               else if(this.tiles[i][j].getOwner() == "B") {
                   while(i <= 7 && j <= 7) {
                       if(this.tiles[i][j].getOwner() == "W") {
                           j = 8;
                           return true;
                       }
                       else if(this.tiles[i][j].getOwner() == "B") {
                           i++;
                           j++;
                       } else {
                       	return false;
                       }
                   }
               }
           }   
       return false;
       }
       
       /**
		 * checks the downward diagonal validity to the left
		 */
       public boolean chkDiagDL(int row, int col, String owner) {
           int i, j;
           if(owner == "B" && row < 7 && col > 0) {
               i = row + 1;
               j = col - 1;
               if(this.tiles[i][j].getOwner() == "B") {
                   return false;             
               }
               else if(this.tiles[i][j].getOwner() == "-") {
                   return false;                    
               }
               else if(this.tiles[i][j].getOwner() == "W") {
                   while(i <= 7 && j >= 0) {
                       if(this.tiles[i][j].getOwner() == "B") {
                           j = 0;
                           return true;                          
                       }
                       else if(this.tiles[i][j].getOwner() == "W") {
                           i++;
                           j--;
                       } else {
                       	return false;
                       }
                   }
               }
           }
           else if(owner == "W" && row < 7 && col > 0) {
               i = row + 1;
               j = col - 1;
               if(this.tiles[i][j].getOwner() == "W") {
                   return false;
               }
               else if(this.tiles[i][j].getOwner() == "-") {
                   return false;
               }
               else if(this.tiles[i][j].getOwner() == "B") {
                   while(i <= 7 && j >= 0) {
                       if(this.tiles[i][j].getOwner() == "W") {
                           j = 0;
                           return true;
                       }
                       else if(this.tiles[i][j].getOwner() == "B") {
                           i++;
                           j--;
                       } else {
                       	return false;
                       }
                   }
               }
           }   
       return false;
    }
        
       public void flipAfterTurn(int row, int col, String owner) {
    	   if(chkHorR(row, col, owner)) {
               flipHorR(row, col, owner);
           }
    	   if(chkHorL(row, col, owner)) {
               flipHorL(row, col, owner);
           }
    	   if(chkVerU(row, col, owner)) {
               flipVerU(row, col, owner);
           }
    	   if(chkVerD(row, col, owner)) {
               flipVerD(row, col, owner);
           }
    	   if(chkDiagUR(row, col, owner)) {
               flipDiagUR(row, col, owner);
           }
    	   if(chkDiagUL(row, col, owner)) {
               flipDiagUL(row, col, owner);
           }
    	   if(chkDiagDR(row, col, owner)) {
               flipDiagDR(row, col, owner);
           }
    	   if(chkDiagDL(row, col, owner)) {
               flipDiagDL(row, col, owner);
           }
       }
       
    private void flipDiagDL(int row, int col, String owner) {
    	int i = row+1;
    	int j = col-1;
		while(!(this.tiles[i][j].getOwner().equals(owner))) {
			flipTile(i, j);
			i++;
			j--;
		}
	}

	private void flipDiagDR(int row, int col, String owner) {
    	int i = row+1;
    	int j = col+1;
		while(!(this.tiles[i][j].getOwner().equals(owner))) {
			flipTile(i, j);
			i++;
			j++;
		}
	}

	private void flipDiagUL(int row, int col, String owner) {
    	int i = row-1;
    	int j = col-1;
		while(!(this.tiles[i][j].getOwner().equals(owner))) {
			flipTile(i, j);
			i--;
			j--;
		}
	}

	private void flipDiagUR(int row, int col, String owner) {
    	int i = row-1;
    	int j = col+1;
		while(!(this.tiles[i][j].getOwner().equals(owner))) {
			flipTile(i, j);
			i--;
			j++;
		}
	}

	private void flipVerD(int row, int col, String owner) {
    	int i = row+1;
		while(!(this.tiles[i][col].getOwner().equals(owner))) {
			flipTile(i, col);
			i++;
		}
	}

	private void flipVerU(int row, int col, String owner) {
    	int i = row-1;
		while(!(this.tiles[i][col].getOwner().equals(owner))) {
			flipTile(i, col);
			i--;
		}
	}

	private void flipHorL(int row, int col, String owner) {
    	int i = col-1;
		while(!(this.tiles[row][i].getOwner().equals(owner))) {
			flipTile(row, i);
			i--;
		}
	}

	private void flipHorR(int row, int col, String owner) {
    	int i = col+1;
		while(!(this.tiles[row][i].getOwner().equals(owner))) {
			flipTile(row, i);
			i++;
		}
	}

	public void flipTile(int row, int col) {
    	if(this.tiles[row][col].getOwner().equals("B")) {
    		this.tiles[row][col].setOwner("W");
    		this.tiles[row][col].setApproved(false);
    	} else if(this.tiles[row][col].getOwner().equals("W")) {
    		this.tiles[row][col].setOwner("B");
    		this.tiles[row][col].setApproved(false);
    	}
    }
       
    public boolean makeMove(int row, int col, String owner) {
		if(isValid(row, col, owner)) {
			flipAfterTurn(row, col, owner);
			
			this.tiles[row][col].setOwner(owner);
    		this.tiles[row][col].setApproved(false);
			
			calcScore();
			
			return true;
		} else {
			return false;
		}
	}
    
    public void approveAll() {
		for(int row = 0; row < this.tiles.length; row++) {
			for(int col = 0; col < this.tiles[0].length; col++) {
				this.tiles[row][col].setApproved(true);
			}
		}
    }
	
	// Getters and setters

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public int getWhiteScore() {
		return whiteScore;
	}

	public void setWhiteScore(int whiteScore) {
		this.whiteScore = whiteScore;
	}

	public int getBlackScore() {
		return blackScore;
	}

	public void setBlackScore(int blackScore) {
		this.blackScore = blackScore;
	}

	public boolean doesMoveExist(String owner) {
		for(int row = 0; row < this.tiles.length; row++) {
			for(int col = 0; col < this.tiles[0].length; col++) {
				if(isValid(row, col, owner)) {
					return true;
				} 
			}
		}
		return false;
	}
}
