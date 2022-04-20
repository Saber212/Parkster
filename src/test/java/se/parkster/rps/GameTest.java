package se.parkster.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    void test1() {
        Game game = new Game();
        assertEquals("Player one wins!", game.calculateResult(1,2));
        assertEquals("Player one wins!", game.calculateResult(3,1));
        assertEquals("Player one wins!", game.calculateResult(2,3));
    }

    @Test
    void test2() {
        Game game = new Game();

        assertEquals("Player two wins!", game.calculateResult(2,1));
        assertEquals("Player two wins!", game.calculateResult(1,3));
        assertEquals("Player two wins!", game.calculateResult(3,2));
    }

    @Test
    void test3() {
        Game game = new Game();
        assertEquals("It is a tie!", game.calculateResult(1,1));
        assertEquals("It is a tie!", game.calculateResult(3,3));
        assertEquals("It is a tie!", game.calculateResult(2,2));
    }

    @Test
    void test4() {
        Game game = new Game();
        assertEquals("Invalid input!", game.calculateResult(1,5));
        assertEquals("Invalid input!", game.calculateResult(3,4));
        assertEquals("Invalid input!", game.calculateResult(2,4));
        assertEquals("Invalid input!", game.calculateResult(0,0));

    }
}