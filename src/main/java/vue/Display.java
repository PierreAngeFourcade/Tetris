package vue;
	
import java.util.List;

import controleur.Partie;
import modele.Piece;
import modele.Score;
import modele.Board;
	 
	
	public class Display{
		
		private Piece piece;
		private Board board;
		private Partie partie;
		private int[][] tabBoard;
		private int[][] tabPiece;
		
		public Display() {
	    	this.piece = new Piece(tabPiece,0,3);
	    	this.board = new Board();
	    	this.partie = new Partie(piece,board);
	    	this.tabBoard = partie.getBoardTab();
	    	this.tabPiece = partie.getPieceTab();
		}
		
		public void showGrid() {
			//partie.saveBoard(board);
			for(int i = 0; i < 20; i++){
				for(int j = 0; j < 10; j++){
					System.out.print(tabBoard[i][j]);
				}
				System.out.println();
			}
			System.out.println();

			for(int i = 0; i < 4; i++){
				for(int j = 0; j < 4; j++){
					System.out.print(tabPiece[i][j]);
				}
				System.out.println();
			}
		}
		
		public void showListScore(List<Score> scores) {
			int i = 0;
			System.out.println("Highscores :");
			while (i < 5){
				System.out.println(scores.get(i).getScore()+" "+scores.get(i).getScore());
				i++;
			}
		}
		
}

