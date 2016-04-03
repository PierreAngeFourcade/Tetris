package controleur;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import modele.Board;
import modele.Piece;
import vue.Display;

public class Partie
{
	private Piece piece;
	private Board board;
	private Display display;
	private int[][] pieceTab = null;
	private int[][] boardTab = null;
	private int positionX; //= piece.getPositionX();
	private int positionY; //= piece.getPositionY();
	
	//int type = (int) (Math.random() * 7);
	
    public Partie(Piece piece, Board board){
    	this.piece = new Piece(pieceTab,0,3);
    	this.board= new Board();
    	pieceTab = piece.getForme();
    	boardTab = board.getBoard();
    	positionX = 0;
    	positionY = 3;
    }
    
    public int[][] getBoardTab() {
		return boardTab;
	}

	public void setBoardTab(int[][] boardTab) {
		this.boardTab = boardTab;
	}
	
	public int[][] getPieceTab() {
		return pieceTab;
	}

	public void setPieceTab(int[][] pieceTab) {
		this.pieceTab = pieceTab;
	}  

    private boolean isMovableRight(Piece piece){
    	for(int i = 0; i < 4 ; i++){
    		for(int j = 0; j < 4 ; j++){
    			if(pieceTab[i][j] != 0)
    			{
    				if(boardTab[i+positionX][j+positionY+1] != 0)
    				{
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
    
    private boolean isMovableLeft(Piece piece){
    	for(int i = 0; i < 4 ; i++){
    		for(int j = 0; j < 4 ; j++){
    			if(pieceTab[i][j] != 0)
    			{
    				if(boardTab[i+positionX][j+positionY-1] != 0)
    				{
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
    
    private boolean canBeRotated(Piece piece){
    	
		return false;
    	
    }
    
    private boolean isMovableDown(Piece piece){
    	for(int i = 0; i < 4 ; i++){
    		for(int j = 0; j < 4 ; j++){
    			if(pieceTab[i][j] != 0)
    			{
    				if(boardTab[i+positionX+1][j+positionY] != 0)
    				{
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
    
    public void saveBoard(int[][] boardTab, int[][] pieceTab){
    	for(int i = 0; i < 4 ; i++){
    		for(int j = 0; j < 4 ; j++){
    			if(pieceTab[i][j] != 0)
    			{
    				if(boardTab[i+positionX][j+positionY] != 0)
    				{
    					boardTab[i+positionX][j+positionY] = pieceTab[i][j];
    				}
    			}
    		}
    	}
    }
	
	public Collection<Character> getInput() {
        try {
            Collection<Character> result = new ArrayList<>();
            int read = RawConsoleInput.read(false);
            while (read != -2){
                result.add((char) read);
                read = RawConsoleInput.read(false);
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Impossible to read from the stdin", e);
        }
    }
    
    
    public void keyPressed(Collection<Character> result) {
	if(((ArrayList<Character>) result).isEmpty() == false){
		switch (((ArrayList<Character>) result).get(0)) {
			case 'q' :
				if(isMovableLeft(piece)) piece.moveLeft();	break;
			case 'd' : 
				if(isMovableRight(piece)) piece.moveRight();	break;
			case 'z' : 
				if(canBeRotated(piece)) piece.rotate();
			case 's' : 
				if(isMovableDown(piece)) piece.moveDown();	break;
			default :
				if(isMovableRight(piece)) piece.moveDown();	break;
		}
	}
}
    
	public static void main(String[] args) throws IOException {
      
	}


}
