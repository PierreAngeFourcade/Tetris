package dao;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;


public class PieceDao {
	
	 private final static String RESOURCES_PATH = "csv/";
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
             String tableauPiece = oneData[2];
             Piece piece = new Piece(id, nomPiece, tableauPiece);
             pieces.add(piece);
         }
       
         return pieces;
    }
}