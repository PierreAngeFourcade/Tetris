package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import modele.Partie;

public class Controleur {
	private static Partie partie;
	private Collection<Character> result = null;

	public Controleur() {
		Controleur.partie = new Partie();
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
    	while(!partie.isGameOver()){
  			result=this.getInput();
    		this.keyPressed(result);
    	}
    }
}
