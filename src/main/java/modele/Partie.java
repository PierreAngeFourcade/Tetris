package modele;

import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import vue.Display;

public class Partie
{
	private Piece piece;
	private Board board;
	private Score score;
	private int[][] pieceTab;
	private int[][] boardTab;
	private int positionX; 
	private int positionY;	
	
    public Partie(){
    	piece = new Piece(null, 0, 0);
    	this.pieceTab = piece.getForme();
    	board = new Board();
    	this.boardTab = board.getBoard();
    	this.piece = new Piece(pieceTab,0,3);
    	board.init();
    	this.score = new Score("Unknow", 0);
    	this.positionX = 0;
    	this.positionY = 3;
    }
    
    private void getNewPiece(){
    	piece.generatePiece();
    	positionX = 0 ;
    	positionY = 3 ;
    }
    
    private boolean isMovableRight(Piece piece){
    	for(int i = 0; i < 4 ; i++){
    		for(int j = 0; j < 4 ; j++){
    			if(pieceTab[i][j] != 0)
    			{
    				if(boardTab[i+positionX][j+positionY+1] != 0 || (j+positionY) > 9)
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
    				if(boardTab[i+positionX][j+positionY-1] != 0 || (j+positionY) < 0)
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
    				if(boardTab[i+positionX+1][j+positionY] != 0 || (i+positionX) < 21)
    				{
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
    
    public void moveDown(){
		this.positionX++;
		if (isMovableDown(piece))
			piece.moveDown();
	}
	
	public void moveLeft(){
		this.positionY--;
		if (isMovableLeft(piece))
			piece.moveLeft();
	}
	
	public void moveRight() {
		this.positionY++;
		if (isMovableRight(piece))
			piece.moveRight();
	}
	
	public void rotate(){
	    if(canBeRotated(piece))
	    	piece.rotate();
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
	
    private boolean isGameOver(Piece piece){
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

}
