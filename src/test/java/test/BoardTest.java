package test;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Assert.*;

import modele.Board;

public class BoardTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		Board b = new Board();
		assertFalse(b.isFullLine());
		int[][] board = new int[21][10];
		for(int i = 0; i < 20; i++) {
			for (int l = 0; l<10; l++)
						board[i][l]=0;
				}
		for(int j = 0; j < 10; j++)
			board[0][j]=1;
		b.setBoard(board);
	    assertTrue(b.isFullLine());
	}
}