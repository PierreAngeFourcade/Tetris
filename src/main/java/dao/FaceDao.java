package dao;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;


public class FaceDao {
	
	 private final static String RESOURCES_PATH = "csv/";
	 private final static String FACES_FILE_NAME = "faces.csv";
	 private final static char SEPARATOR = ',';
	 private static CSVReader csvReader;
	 
    public List<Face> findFaces() throws IOException {
    	 File file = new File(RESOURCES_PATH + FACES_FILE_NAME);
         FileReader fr = new FileReader(file);
         csvReader = new CSVReader(fr, SEPARATOR);
         List<String[] > data = new ArrayList<String[] >();

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
         List<Face> faces = new ArrayList<Face>();
         for (String[] oneData : data) {
             String id = oneData[0];
             String nomFace = oneData[1];
             Face face = new Face(id, nomFace);
             faces.add(face);
         }

         return faces;
    }
}