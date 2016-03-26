package modele;

import java.io.IOException;
import java.util.List;

public class Piece {

		private int type;
		private int[][] forme;
		private int positionX;
		private int positionY;
		
		public Piece(int type, int positionX, int positionY) {
			this.forme = generationPiece(type);
			this.positionX = positionX;
			this.positionY = positionY;
		}
		
		
		public int[][] getForme() {
			return forme;
		}


		public void setForme(int[][] forme) {
			this.forme = forme;
		}


		public int getPositionX() {
			return positionX;
		}

		private void setPositionX(Integer positionX) {
			this.positionX= positionX;
		}
		
		public int getPositionY() {
			return positionY;
		}

		private void setPositionY(Integer positionY) {
			this.positionY = positionY;
		}
		
		private int[][] generationPiece(int type) {
			switch (type) {
            case 0:   forme = new int[][] {{0,1,0,0},{0,1,1,0},{0,0,1,0},{0,0,0,0}}; break;
            case 1:   forme = new int[][] {{0,2,2,0},{0,2,2,0},{0,0,0,0},{0,0,0,0}}; break;
            case 2:   forme = new int[][] {{0,3,0,0},{0,3,0,0},{0,3,0,0},{0,3,0,0}}; break;
            case 3:   forme = new int[][] {{0,0,4,0},{0,4,4,0},{0,4,0,0},{0,0,0,0}}; break;
            case 4:   forme = new int[][] {{0,5,0,0},{0,5,5,0},{0,5,0,0},{0,0,0,0}}; break;
            case 5:   forme = new int[][] {{0,0,6,0},{0,0,6,0},{0,6,6,0},{0,0,0,0}}; break;
            case 6:   forme = new int[][] {{0,7,0,0},{0,7,0,0},{0,7,7,0},{0,0,0,0}}; break;
			} 
			return forme;
		}

		private void descente(){
			positionX++;
		}
		
		private void deplacementGauche(){
			positionY--;
		}
		
		private void deplacementDroite() {
			positionY++;
		}
		
		private void rotation(){
		    for( int i = 0 ; i < 4 ; i++){
		    	for(int j =0; j < 4; j++){
					//formeTmp[i][j]=forme[4-1-j][i];
		    	}
		    }
		}
	}