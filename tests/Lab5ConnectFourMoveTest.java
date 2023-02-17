package labs.lab5.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import labs.lab5.*;


public class Lab5ConnectFourMoveTest {
    private Game game;

    @Before
    public void setup() {
        game = new ConnectFourGame();
    }

    @Test
    public void testMove_ConnectFour_1() {
        assertFalse(game.isValidMove("10x"));
    }

    @Test
    public void testMove_ConnectFour_2() {
        assertFalse(game.isValidMove("07r"));
    }

    @Test
    public void testMove_ConnectFour_3() {
        assertFalse(game.isValidMove("00x"));
    }

    @Test
    public void testMove_ConnectFour_4() {
        assertFalse(game.isValidMove("rr"));
    }

    @Test
    public void testMove_ConnectFour_5() {
        assertFalse(game.isValidMove("3a"));
    }

    @Test
    public void testMove_ConnectFour_6() {
        assertTrue(game.isValidMove("1r"));
    }

    @Test
    public void testMove_ConnectFour_7() {
        assertTrue(game.isValidMove("2y"));
    }

    @Test
    public void testMove_ConnectFour_8() {
        game.executeMove("2y");
        assertFalse(game.isValidMove("3y"));
    }

    @Test
    public void testMove_ConnectFour_9() {
        assertFalse(game.isValidMove("aaa"));
    }

    @Test
    public void testMove_ConnectFour_10() {
        assertFalse(game.isValidMove("22"));
    }
}
