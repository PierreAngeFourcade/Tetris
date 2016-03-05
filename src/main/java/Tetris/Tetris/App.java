package Tetris.Tetris;

import java.io.IOException;
import java.util.List;
import dao.Face;
import dao.FaceDao;

public class App 
{
/*	
public static char[][] initTableau(char[][] paramTableau) {
		
		for(int i = 0; i < 20; i++) {
            for(int j =0; j < 10 ; j++) { 
                paramTableau[i][j] = '0';
            }
        }
	return paramTableau;
}

public static char[][] incTableau(char[][] paramTableau,int i) {
             
            paramTableau[i][4] = '1';
            paramTableau[i][5] = '1';
      
return paramTableau;
}

	public static char[][] afficheTableau(char[][] paramTableau) {

        //Parcourt le tableau et l'affiche
        for(int i = 0; i < 20; i++) {
            for(int j =0; j < 10 ; j++) {
                System.out.print("" + paramTableau[i][j] );
            }
            System.out.println("");
        }
        return paramTableau;
    }
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

final FaceDao faceDao = new FaceDao();
final List<Face> faces = faceDao.findFaces();

for(Face face: faces) {
    System.out.println(face);
}

	}
}
