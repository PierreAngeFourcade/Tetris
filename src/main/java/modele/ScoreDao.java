package modele;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;	
import java.util.List;
import com.opencsv.CSVReader;


public class ScoreDao {
	
	 private final static String RESOURCES_PATH = "src/main/resources/";
	 private final static String PIECES_FILE_NAME = "scores.csv";
	 private final static char SEPARATOR = ',';
	 private static CSVReader csvReader;
	 
    public static List<Score> findScores() throws IOException {
    	 File file = new File(RESOURCES_PATH + PIECES_FILE_NAME);
         FileReader fr = new FileReader(file);
         csvReader = new CSVReader(fr, SEPARATOR);
         List<String[]> data = new ArrayList<String[]>();

         String[] nextLine = null;
         while ((nextLine = csvReader.readNext()) != null) {

             if (nextLine.length == 0) {
                 continue;
             }
             String debut = nextLine[0].trim();
             if (debut.length() == 0 && nextLine.length == 1) {
                 continue;
             }

             if (debut.startsWith("#")) {
                 continue;
             }
             data.add(nextLine);
         }
         List<Score> scores = new ArrayList<Score>();
         for (String[] oneData : data) {
             String id = oneData[0];
             int total = Integer.parseInt(oneData[1]);
             Score score = new Score(id,total);
             scores.add(score);
         }
       
         return scores;
    }

}