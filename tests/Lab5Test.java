package labs.lab5.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import labs.lab5.*;


public class Lab5Test {
    @Test
    public void testTicTacToeGame() {
        Game game = new TicTacToeGame();
        assertTrue(game.isValidMove("02o"));
        assertFalse(game.gameOver());
        game.executeMove("02o");

        String board = "   |   | o " + System.lineSeparator() +
                "-----------" + System.lineSeparator() +
                "   |   |   " + System.lineSeparator() +
                "-----------" + System.lineSeparator() +
                "   |   |   " + System.lineSeparator();
        assertEquals(board, game.displayBoard());

        game.executeMove("11x");
        game.executeMove("20o");
        game.executeMove("00x");
        game.executeMove("22o");
        game.executeMove("21x");
        game.executeMove("12o");
        assertEquals(1, game.determineWinner());
    }

    @Test
    public void testConnectFourGame() {
        Game game = new ConnectFourGame();
        assertFalse(game.isValidMove("10y"));
        game.executeMove("3y");
        game.executeMove("4r");
        assertEquals(game.determineWinner(), 0);
        game.executeMove("4y");
        game.executeMove("3r");
        game.executeMove("2y");
        game.executeMove("1r");
        game.executeMove("4y");
        game.executeMove("2r");
        game.executeMove("4y");
        game.executeMove("1r");
        game.executeMove("4y");
        assertTrue(game.gameOver());

        String board = "   |   |   |   |   |   |   " + System.lineSeparator() +
                "---------------------------" + System.lineSeparator() +
                "   |   |   |   | y |   |   " + System.lineSeparator() +
                "---------------------------" + System.lineSeparator() +
                "   |   |   |   | y |   |   " + System.lineSeparator() +
                "---------------------------" + System.lineSeparator() +
                "   |   |   |   | y |   |   " + System.lineSeparator() +
                "---------------------------" + System.lineSeparator() +
                "   | r | r | r | y |   |   " + System.lineSeparator() +
                "---------------------------" + System.lineSeparator() +
                "   | r | y | y | r |   |   " + System.lineSeparator();
        assertEquals(board, game.displayBoard());
    }
}

