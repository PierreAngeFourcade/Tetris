package dao;

import java.io.IOException;
import java.util.List;

public class Piece {

		private String id;
		private String nomPiece;
		private String position1;
		private int choix;
		private int k;
		private int valeurMinI;
		private int valeurMaxI;
		private int valeurMinJ;
		private int valeurMaxJ;
		private int score;
		
		final PieceDao pieceDao = new PieceDao();
		char tableauPieceChar[] = new char[16];
		int tableauPiece[] = new int[16];
		
		public Piece(String id, String nomPiece, String position1) {
			this.id = id;
			this.nomPiece = nomPiece;
			this.position1 = position1;
			for (int i=0;i<16;i++) {
				tableauPiece[k]=0;
			}

		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id= id;
		}

		public String getNomPiece() {
			return nomPiece;
		}

		public void setNomPiece(String nomPiece) {
			this.nomPiece = nomPiece;
		}

		public String getPosition1() {
			return position1;
		}

		public void setPosition1(String position1) {
			this.position1= position1;
		}
		
		@Override
		public String toString() {
			return "Piece [numéro=" + id+ ", Nom=" + nomPiece + ", Position1=" + position1+ "]";
		}
		
		public void generationPiece() throws IOException {
			choix = (int) (Math.random() * 7);
			final List<Piece> pieces = pieceDao.findPieces();
			tableauPieceChar = pieces.get(choix).getPosition1().toCharArray();
			for(int elt : tableauPieceChar)
			tableauPiece[elt] = Character.getNumericValue(tableauPieceChar[elt]);
		}
		
		public void creationPiece(int[][] g) throws IOException{
			k=0;
			for (int i = valeurMinI; i < valeurMaxI; i++) {
				for (int j = valeurMinJ; j < valeurMaxJ; j++) {
					g[i][j]= tableauPiece[k];
					k++;
				}
			}
		}
		
		public void effacementPiece(int[][] g){
			k=0;
			for (int i = valeurMinI; i < valeurMaxI; i++) {
				for (int j = valeurMinJ; j < valeurMaxJ; j++) {
					if(tableauPiece[k] != 0)
						g[i][j]=0;
						k++;
				}
			}
		}
		
		public void descente(int[][] g) throws IOException{
			if(!bloqueDescente(g))
			{
				effacementPiece(g);
				valeurMinI++;
				valeurMaxI++;
				creationPiece(g);
			}else{
				lignePleine(g);
			}
		}
		
		public void deplacementGauche(int[][] g) throws IOException{
			if(!bloqueGauche(g))
			{
				effacementPiece(g);
				valeurMinJ--;
				valeurMaxJ--;
				creationPiece(g);
			}
		}
		
		public void deplacementDroite(int[][] g) throws IOException{
			if(!bloqueDroite(g))
			{
				effacementPiece(g);
				valeurMinJ++;
				valeurMaxJ++;
				creationPiece(g);
			}
		}
		
		public boolean bloqueDroite(int[][] g){
			for (int i = valeurMinI; i < valeurMaxI; i++) {
				if(g[i][valeurMaxJ] != 0 && g[i][valeurMaxJ+1] != 0)
					return true;
			}
			return false;
		}
		
		public boolean bloqueGauche(int[][] g){
			for (int i = valeurMinI; i < valeurMaxI; i++) {
				if(g[i][valeurMinJ] != 0 && g[i][valeurMinJ+1] != 0)
					return true;
			}
			return false;
		}
		
		public boolean bloqueDescente(int[][] g){
			for (int i = valeurMinI; i < valeurMaxI; i++) {
				for (int j = valeurMinI; j < valeurMaxI; j++) {
					if((g[valeurMaxI][j] != 0 && g[valeurMaxI+1][j] != 0) || (g[i][valeurMinJ] != 0 && g[i+1][valeurMinJ] != 0) || (g[i][valeurMaxJ] != 0 && g[i+1][valeurMinJ] != 0))
						return true;
				}
			}
			return false;
		}
		
		public void lignePleine(int[][] g){
			boolean pleine = true;
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 10; j++) {
					if(g[i][j]==0)
						pleine = false;
				}
				if(pleine==true){
					for(int k = i; k > 0; k++){
						for (int l = 0; l<10; l++)
							g[k][l]=g[k-1][l];
					}
					score++;
				}	
			}
		}
	}