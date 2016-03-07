package Tetris.Tetris;

import java.io.IOException;
import javax.swing.JFrame;

public class App 
{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paintGrille grille = new paintGrille();

		frame.setContentPane(grille);

		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}
}
