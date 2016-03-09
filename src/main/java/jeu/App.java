package jeu;

import java.io.*;

public class App 
{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello World ! \n");
          try
          {
              new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      		System.out.println("Hello World ! \n");

          }
          catch(Exception e)
          {
                  System.out.println("Erreur d'execution");
          }
	}
}
