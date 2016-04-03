package modele;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import modele.Score;


public class ListeScore {
	//final List<Score> scores = ScoreDao.findScores();
	List<Score> liste = new ArrayList<Score>(); 

	public ListeScore(List<Score> liste ){
		this.liste = liste;
	}
	public List<Score> integreScore(List<Score> scores,String nom,int total){
		List<Score> tempListe = new ArrayList<Score>(); 
		Score score = new Score(nom,total);
		for(int i = 0; i < 5; i++) {
			int j = i;
			if(total > scores.get(i).getScore()){
				tempListe.add(score);
				while ( j < 5){
					tempListe.add(scores.get(j));
					j++;
				} break;
			}else{
				tempListe.add(scores.get(i));
			}
		}
		return tempListe;
	}
	
	public void save(List<Score> liste) throws FileNotFoundException {
		PrintWriter file = new PrintWriter(new FileOutputStream("src/main/resources/scores.csv"));
		for (Score score : liste)
			file.println(score.toString());
		file.close();
	}
	
	public List<Score> getListe() {
		return liste;
	}
	public void setListe(List<Score> liste) {
		this.liste = liste;
	}

	public boolean isHighScore(List<Score> scores, int total)
	{
		int lastScore = scores.get(4).getScore();
		if (total < lastScore)
			return true;
		else
			return false;
	}

}