package labs.lab5;

import java.util.Arrays;

public class TicTacToeGame implements Game {
	
	private static enum Piece{
		x, o, EMPTY;
	}
	
	private Piece[][] board;
	private static final int ROW = 3;
	private static final int COL = 3;
	private char prevSymbol;
	private char firstPlayer;
	private int winner;
	
	public TicTacToeGame() {
		board = new Piece[ROW][COL];
		for(int i = 0; i < ROW; ++i) {
			Arrays.fill(board[i], Piece.EMPTY);
		}
		prevSymbol = '\0';
		firstPlayer = '\0';
		winner = 0;
	}
	
	public boolean isValidMove(String move) {
		if(
				(move.length() == 3) && 
				(Character.isDigit(move.charAt(0)) && Character.isDigit(move.charAt(1))) &&
				(Character.getNumericValue(move.charAt(0)) >= 0 && Character.getNumericValue(move.charAt(0)) < ROW) &&
				(Character.getNumericValue(move.charAt(1)) >= 0 && Character.getNumericValue(move.charAt(1)) < COL) &&
				(board[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] == Piece.EMPTY) &&
				(move.charAt(2) == 'x' || move.charAt(2) == 'o') || 
				(move.charAt(2) == 'X' || move.charAt(2) == 'O')) {
			
			if(prevSymbol != move.charAt(2)) {
				return true;
			}
		}
		return false;
	}

	public void executeMove(String move) {
		if(firstPlayer == '\0') {
			firstPlayer = move.charAt(2);
		}
		prevSymbol = move.charAt(2);
		switch(move.charAt(2)) {
		case 'x': {
			board[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = Piece.x;
			break;
		}
		case 'o': {
			board[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = Piece.o;
			break;
		}
		case 'X': {
			board[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = Piece.x;
			break;
		}
		case 'O': {
			board[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = Piece.o;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + move.charAt(2));
		}
	}

	public boolean gameOver() {
		boolean allFilled = true;
		boolean digRightWin = true, digLeftWin = true;
		for(int i = 0; i < ROW; ++i) {
			boolean rowWin = true, colWin = true;
			for(int j = 0; j < COL-1; ++j) {
				if(board[i][j] != Piece.EMPTY) 
					rowWin = rowWin && (board[i][j] == board[i][j+1]);
				else
					rowWin = false;	
				if(board[j][i] != Piece.EMPTY) 
					colWin = colWin && (board[j][i] == board[j+1][i]);
				else 
					colWin = false;
				if(allFilled && board[i][j] == Piece.EMPTY) 
					allFilled = false;
			}
			
			if(i+1 < ROW) 
				digLeftWin = digLeftWin && (board[i][i] == board[i+1][i+1]);
			else if(board[i][i] == Piece.EMPTY)
				digLeftWin = false;
			if(i+1 < ROW) 
				digRightWin = digRightWin && (board[i][ROW-i-1] == board[i+1][ROW-i-2]);
			else if(board[i][ROW-i-1] == Piece.EMPTY)
				digRightWin = false;
			if(rowWin) {
				if(board[i][COL-1].name().charAt(0) == firstPlayer)
					winner = 1;
				else 
					winner = 2;
				return true;
			}
			if(colWin) {
				if(board[COL-1][i].name().charAt(0)  == firstPlayer)
					winner = 1;
				else 
					winner = 2;
				return true;
			}
		}
		if(digLeftWin) {
			if(board[0][0].name().charAt(0) == firstPlayer)
				winner = 1;
			else 
				winner = 2;
			return true;
		}
		if(digRightWin) {
			if(board[0][COL-1].name().charAt(0) == firstPlayer) 
				winner = 1;
			else 
				winner = 2;
			return true;
		}
		return allFilled;
	}
	
	public String displayBoard() {
		StringBuilder result = new StringBuilder();
		char[] temp = new char[11];
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
		return winner != 0 ? winner : 0;
	}
	
}