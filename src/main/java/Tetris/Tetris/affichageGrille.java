package Tetris.Tetris;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


import dao.Piece;
import dao.PieceDao;
 
public class affichageGrille extends JPanel {

	private static final long serialVersionUID = 1L;
	public final static int NB_LIGNES = 4;
	public final static int NB_COLONNES = 4;
	final PieceDao pieceDao = new PieceDao();
	final List<Piece> pieces = pieceDao.findPieces();
	private int[][] grid = new int[NB_LIGNES][NB_COLONNES];
	private Image[] images;
 
	public affichageGrille() throws IOException {
		final PieceDao pieceDao = new PieceDao();
		final List<Piece> pieces = pieceDao.findPieces();
		images = new Image[2];
		images[1] = lireImage("faces/"+pieces.get(1).getNomPiece()+".png");
		images[0] = lireImage("faces/blanc.png");
	}
 
	private Image lireImage(String string) {
 
		try {
 
			return ImageIO.read(new File(string));
 
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
 
	}
 
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawGrid(g);
	}
 

private void drawGrid(Graphics g) {
 
		int width = getWidth();
		int height = getHeight();
		int largeur = width / NB_COLONNES;
		int hauteur = height / NB_LIGNES;
		int k = 0;
		for (int i = 0; i < NB_LIGNES; i++) {
			for (int j = 0; j < NB_COLONNES; j++) {
				int x = j * largeur;
				int y = i * hauteur;
                Image image = images[grid[i][j]];
				char tableau[] = new char[16]; 
				tableau = pieces.get(1).getTab().toCharArray();
				
					if(tableau[k] == '0')
					{
						grid[i][j]=0;
						if ( image!=null ) { // on est sur au moins comme ça que si le fichier n'a pas été trouvé, on plante pas
	                    	 g.drawImage(image, x, y, largeur, hauteur, this); 
	                     }
					}else if(tableau[k] == '1'){
						grid[i][j]=1;
						if ( image!=null ) { // on est sur au moins comme ça que si le fichier n'a pas été trouvé, on plante pas
	                    	 g.drawImage(image, x, y, largeur, hauteur, this); 
	                     }
					}
				k++;
			}
		}
                for (int i = 0; i <= width; i += largeur) {  
                    g.drawLine(i, 0, i, height);  
                } 
                for (int i = 0; i <= height; i+=hauteur) { 
                   g.drawLine(0, i, width, i); 
                }
}
	
	
	
public static void main(String[] args) throws IOException {
	
	
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	affichageGrille grille = new affichageGrille();

	frame.setContentPane(grille);

	frame.setSize(200, 200);
	frame.setLocationRelativeTo(null);

	frame.setVisible(true);

}
 
}
