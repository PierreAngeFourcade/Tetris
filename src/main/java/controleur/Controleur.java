package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import modele.Partie;

public class Controleur {
	private static Partie partie;
	private boolean gameOver;
	private Controleur controleur = new Controleur();
	private Collection<Character> result = null;

	public Controleur() {
		this.partie = new Partie();
		this.gameOver = false;
	}
	
	public Collection<Character> getInput() {
        try {
            Collection<Character> result = new ArrayList<>();
            int read = RawConsoleInput.read(false);
            while (read != -2){
                result.add((char) read);
                read = RawConsoleInput.read(false);
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Impossible to read from the stdin", e);
        }
    }
     
    public void keyPressed( Collection<Character> result ) {
    	if(((ArrayList<Character>) result).isEmpty() == false){
    		switch (((ArrayList<Character>) result).get(0)) {
				case 'q' :
					partie.moveLeft();	break;
				case 'd' : 
					partie.moveRight();	break;
				case 'z' : 
					partie.rotate();
				case 's' : 
					partie.moveDown();	break;
				default :
					partie.moveDown();	break;
    		}
    	}
    }
    
    public void run() throws InterruptedException{
    	while(!gameOver){
    		if(controleur != null)
  			  result=controleur.getInput();
    		controleur.keyPressed(result);
    		Thread.sleep(200);
    	}
    }

}
