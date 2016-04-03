package modele;

public class Board {

	private int[][] board;
	
	public Board()
	{
		this.board = new int[21][10];
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}
	
	public boolean isFullLine(){
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				if(board[i][j]==0)
					return false;
					break;
			}
		}
		return true;
    }
	
	private void cleanFullLine(){
		for(int i = 0; i < 19; i++) {
			for (int l = 0; l<10; l++)
						board[i][l]=board[i-1][l];
				}				
		for(int j = 0; j < 10; j++)
			board[20][j]=0;
	}
}
