package dao;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;


public class PieceDao {
	
	 private final static String RESOURCES_PATH = "src/main/resources";
	 private final static String PIECES_FILE_NAME = "pieces.csv";
	 private final static char SEPARATOR = ',';
	 private CSVReader csvReader;
	 
    public List<Piece> findPieces() throws IOException {
    	 File file = new File(RESOURCES_PATH + PIECES_FILE_NAME);
         FileReader fr = new FileReader(file);
         csvReader = new CSVReader(fr, SEPARATOR);
         List<String[]> data = new ArrayList<String[]>();

         String[] nextLine = null;
         while ((nextLine = csvReader.readNext()) != null) {
             int size = nextLine.length;

             // ligne vide
             if (size == 0) {
                 continue;
             }
             String debut = nextLine[0].trim();
             if (debut.length() == 0 && size == 1) {
                 continue;
             }

             // ligne de commentaire
             if (debut.startsWith("#")) {
                 continue;
             }
             data.add(nextLine);
         }
         List<Piece> pieces = new ArrayList<Piece>();
         for (String[] oneData : data) {
             String id = oneData[0];
             String nomPiece = oneData[1];
             String position1 = oneData[2];
             String position2 = oneData[3];
             String position3 = oneData[4];
             String position4 = oneData[5];
             Piece piece = new Piece(id, nomPiece,position1);
             pieces.add(piece);
         }
       
         return pieces;
    }
}