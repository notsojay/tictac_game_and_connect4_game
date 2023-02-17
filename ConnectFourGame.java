package labs.lab5;

import java.util.Arrays;

class Pair<A, B> {
	private A first;
	private B second;

	public Pair() {
		this.first = null;
		this.second = null;
	}
	
	public Pair(A first, B second) {
		this.first = first;
		this.second = second;
	}
	
	public A getFirst() {
		return first;
	}

	public void setFirst(A first) {
		this.first = first;
	}

	public B getSecond() {
		return second;
	}

	public void setSecond(B second) {
		this.second = second;
	}
}

public class ConnectFourGame implements Game {
	
	private static enum Piece{
		r, y, EMPTY
	}
	
	private Piece[][] board;
	private final int ROW = 6;
	private final int COL = 7;
	private char prevSymbol;
	private int firstPlayer;
	private int winner;
	boolean isEnd;
	private Pair<Integer, Integer> currAvailablePos;
	
	public ConnectFourGame() {
		board = new Piece[ROW][COL];
		for(int i = 0; i < ROW; ++i) {
			Arrays.fill(board[i], Piece.EMPTY);
		}
		prevSymbol = '\0';
		firstPlayer = '\0';
		winner = 0;
		isEnd = false;
		currAvailablePos = new Pair<Integer, Integer>();
	}
	
	public boolean isValidMove(String move) {
		if((move.length() == 2)
				&& (Character.isDigit(move.charAt(0)))
				&& (Character.getNumericValue(move.charAt(0)) >= 0 && Character.getNumericValue(move.charAt(0)) < COL)
				&& (isThereAnyAvailableYAxis(Character.getNumericValue(move.charAt(0))))
				&& ((move.charAt(1) == 'r' || move.charAt(1) == 'R')
				|| (move.charAt(1) == 'y' || move.charAt(1) == 'Y'))) {
				
				if(prevSymbol != move.charAt(1)) {
					return true;
				}
			}
			return false;
	}
	
	private boolean isThereAnyAvailableYAxis(int xAxis) {
		int i = 0;
		for(; i < ROW; ++i) {
			if(board[i][xAxis] != Piece.EMPTY) {
				if(i > 0) {
					currAvailablePos.setFirst(Integer.valueOf(i-1));
					currAvailablePos.setSecond(Integer.valueOf(xAxis));
					return true;
				}
				else if(i == 0){
					return false;
				}
			}
		}
		currAvailablePos.setFirst(Integer.valueOf(i-1));
		currAvailablePos.setSecond(Integer.valueOf(xAxis));
		return true;
	}
	
	public void executeMove(String move) {
		isValidMove(move);
		if(firstPlayer == '\0') {
			firstPlayer = move.charAt(1);
		}
		prevSymbol = move.charAt(1);
		switch(move.charAt(1)) {
		case 'r': {
			board[currAvailablePos.getFirst()][currAvailablePos.getSecond()] =  Piece.r;
			break;
		}
		case 'R': {
			board[currAvailablePos.getFirst()][currAvailablePos.getSecond()] =  Piece.r;
			break;
		}
		case 'y': {
			board[currAvailablePos.getFirst()][currAvailablePos.getSecond()] =  Piece.y;
			break;
		}
		case 'Y': {
			board[currAvailablePos.getFirst()][currAvailablePos.getSecond()] =  Piece.y;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + move.charAt(1));
		}
	}


	public boolean gameOver() {
		for(int i = 0; i < ROW; i++){
			for (int j = 0; j < COL-3; j++){
				if(
						board[i][j] != Piece.EMPTY   	&& 
						board[i][j+1] != Piece.EMPTY  	&&
						board[i][j+2] != Piece.EMPTY  	&&
						board[i][j+3] != Piece.EMPTY  	&&
						board[i][j] == board[i][j+1] 	&&
						board[i][j+1] == board[i][j+2] 	&&
						board[i][j+2] == board[i][j+3]) {
					if(board[i][j].name().charAt(0) == firstPlayer)
						winner = 1;
					else 
						winner = 2;
					return true;
				}
			}			
		}
	
		for(int i = 0; i < ROW - 3; i++){
			for(int j = 0; j < COL; j++){
				if(
						board[i][j] != Piece.EMPTY   	&& 
						board[i+1][j] != Piece.EMPTY  	&&
						board[i+2][j] != Piece.EMPTY  	&&
						board[i+3][j] != Piece.EMPTY  	&&
						board[i][j] == board[i+1][j] 	&&
						board[i+1][j] == board[i+2][j] 	&&
						board[i+2][j] == board[i+3][j]) {
					if(board[i][j].name().charAt(0) == firstPlayer)
						winner = 1;
					else 
						winner = 2;
					//System.out.print("1");
					return true;
				}
			}
		}

		for(int i = 3; i < ROW; i++){
			for(int j = 0; j < COL - 3; j++){
				if(
						board[i][j] != Piece.EMPTY   	&& 
						board[i-1][j+1] != Piece.EMPTY  	&&
						board[i-2][j+2] != Piece.EMPTY  	&&
						board[i-3][j+3] != Piece.EMPTY  	&&
						board[i][j] == board[i-1][j+1] 	&&
						board[i-1][j+1] == board[i-2][j+2] 	&&
						board[i-2][j+2] == board[i-3][j+3]) {
					if(board[i][j].name().charAt(0) == firstPlayer)
						winner = 1;
					else 
						winner = 2;
					return true;
				}
			}
		}

		for(int i = 0; i < ROW - 3; i++){
			for(int j = 0; j < COL - 3; j++){
				if(
						board[i][j] != Piece.EMPTY   	&& 
						board[i+1][j+1] != Piece.EMPTY  &&
						board[i+2][j+2] != Piece.EMPTY  &&
						board[i+3][j+3] != Piece.EMPTY  &&
						board[i][j] == board[i+1][j+1] 	&&
						board[i+1][j+1] == board[i+2][j+2] 	&&
						board[i+2][j+2] == board[i+3][j+3]) {
					if(board[i][j].name().charAt(0) == firstPlayer)
						winner = 1;
					else 
						winner = 2;
					return true;
				}
			}
		}
		for(int i = 0; i < ROW; ++i) {
			for(int j = 0; j < COL; ++j) {
				if(board[i][j] == Piece.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}


	public String displayBoard() {
		StringBuilder result = new StringBuilder();
		char[] temp = new char[27];
		Arrays.fill(temp, '-');
		final String LINES = new String(temp);
		
		for(int i = 0; i < ROW; ++i) {
			for(int j = 0; j < COL; ++j) {
				if(board[i][j] == Piece.EMPTY) result.append("   ");
				else result.append(" " + board[i][j].name() + " ");
				if(j+1 != COL) result.append('|');
			}
			if(i+1 != ROW) result.append("\n" + LINES + "\n");
			else result.append("\n");
		}
		return result.toString();
	}


	public int determineWinner() {
		gameOver();
		return winner;
	}

}
