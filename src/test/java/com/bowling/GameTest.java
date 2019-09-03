package com.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;


    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void shouldExist() {

        assertNotNull(new Game());
    }

    @Test
    public void rollTest() {
        game.roll(4);
        game.roll(3);

        assertEquals(game.getNumOfKnockedPinsForFrame(0), 7);
    }

    @Test
    public void rollStrikeTest() {

        game.roll(10);

        game.roll(3);
        game.roll(2);

        rollMultiple(18, 0);

        assertEquals(game.score(), 20);

    }

    @Test
    public void rollSpareTest() {
        game.roll(4);
        game.roll(6);

        game.roll(3);

        rollMultiple(17, 0);

        assertEquals(game.score(), 16);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rollNegative() {
        game.roll(-1);
        rollMultiple(19, 0);
    }


    @Test
    public void scoreExampleTest() {
        //Frame 1
        game.roll(1);
        game.roll(4);

        //Frame 2
        game.roll(4);
        game.roll(5);

        //Frame 3
        game.roll(6);
        game.roll(4);

        //Frame 4
        game.roll(5);
        game.roll(5);

        //Frame 5
        game.roll(10);

        //Frame 6
        game.roll(0);
        game.roll(1);

        //Frame 7
        game.roll(7);
        game.roll(3);

        //Frame 8
        game.roll(6);
        game.roll(4);

        //Frame 9
        game.roll(10);

        //Frame 10
        game.roll(2);
        game.roll(8);
        game.roll(6);

        assertEquals(game.score(), 133);

    }

    public void rollMultiple(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

}
