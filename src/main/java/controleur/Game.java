package controleur;

public class Game {

	public static void main(String[] args){
    	Controleur c = new Controleur();
    	try{
    		c.run();
    	}catch(InterruptedException ie) {
    		ie.printStackTrace();
    	}
    }
	
}
