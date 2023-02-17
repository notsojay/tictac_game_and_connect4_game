package labs.lab5.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import labs.lab5.*;


public class Lab5TicTacToeMoveTest {
    private Game game;

    @Before
    public void setup() {
        game = new TicTacToeGame();
    }

    @Test
    public void testMove_TicTacToeGame_1() {
        assertFalse(game.isValidMove("aaa"));
    }

    @Test
    public void testMove_TicTacToeGame_2() {
        assertFalse(game.isValidMove("33x"));
    }

    @Test
    public void testMove_TicTacToeGame_3() {
        assertFalse(game.isValidMove("000"));
    }

    @Test
    public void testMove_TicTacToeGame_4() {
        game.executeMove("10x");
        //System.out.println(game.isValidMove("11x"));
        assertFalse(game.isValidMove("11x")); // Same player play twice
    }

    @Test
    public void testMove_TicTacToeGame_5() {
        game.executeMove("10x");
        assertFalse(game.isValidMove("10o")); // Try to put on a taken place
    }
}

