package jeu;

import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import modele.Board;
import modele.Piece;

public class Partie
{
	private Piece piece;
	private Board board;
	private int[][] pieceTab = piece.getForme();
	private int[][] boardTab = board.getBoard();
	private int positionX = piece.getPositionX();
	private int positionY = piece.getPositionY();
	
	//int type = (int) (Math.random() * 7);
	
    public Partie(Piece piece, Board board){
    	this.piece = new Piece(0,0,3);
    	this.board= new Board();
    }
    
    private boolean checkPosition(Piece piece){
    	for(int i = 0; i < 4 ; i++){
    		for(int j = 0; j < 4 ; j++){
    			if(pieceTab[i][j] != 0)
    			{
    				if(boardTab[i+positionX][j+positionY] != 0)
    				{
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    private boolean lignePleine(Board board){
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				if(boardTab[i][j]==0)
					return false;
			}
		}
		return true;
    }
    
    private boolean checkRightMove(Piece piece){
    	for(int i = 0; i < 4 ; i++){
    		for(int j = 0; j < 4 ; j++){
    			if(pieceTab[i][j] != 0)
    			{
    				if(boardTab[i+positionX][j+positionY+1] != 0)
    				{
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    private boolean checkLeftMove(Piece piece){
    	for(int i = 0; i < 4 ; i++){
    		for(int j = 0; j < 4 ; j++){
    			if(pieceTab[i][j] != 0)
    			{
    				if(boardTab[i+positionX][j+positionY-1] != 0)
    				{
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    private boolean checkDownMove(Piece piece){
    	for(int i = 0; i < 4 ; i++){
    		for(int j = 0; j < 4 ; j++){
    			if(pieceTab[i][j] != 0)
    			{
    				if(boardTab[i+positionX+1][j+positionY] != 0)
    				{
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    private void saveBoard(Board board){
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
    
	public static void main(String[] args) throws IOException {
        	  System.out.println("Welcome to Tetris Bitch !\n");
        	  while(true){
        		  
        	  }
	}
}
