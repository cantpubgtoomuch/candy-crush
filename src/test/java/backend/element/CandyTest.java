package backend.element;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandyTest {

    private Candy candy;
    private Candy anotherCandy;

    @BeforeEach
    void setUp() {
        candy = new Candy(CandyColor.BLUE);
        anotherCandy = new Candy(CandyColor.BLUE);
    }

    @Test
    void getColor() {
        assertEquals(CandyColor.BLUE, candy.getColor());
    }

    @Test
    void setColor() {
        candy.setColor(CandyColor.RED);
        assertEquals(CandyColor.RED, candy.getColor());
    }

    @Test
    void isMovable() {
        assertTrue(candy.isMovable());
    }

    @Test
    void testHashCode() {
        assertNotEquals(0,candy.hashCode());
        candy.setColor(null);
        assertEquals(0, candy.hashCode());
    }

    @Test
    void testEquals() {
        assertTrue(candy.equals(candy));
        assertTrue(anotherCandy.equals(candy));
    }

    @Test
    void testNotEquals() {
        anotherCandy.setColor(CandyColor.GREEN);
        anotherCandy = new Candy();
        assertFalse(anotherCandy.equals(candy));

        assertFalse(candy.equals(CandyColor.BLUE));
    }

    @Test
    void getFullKey() {
        assertEquals("BLUE-CANDY", candy.getFullKey());
    }

    @Test
    void getKey() {
        assertEquals("CANDY", anotherCandy.getKey());
    }

    @Test
    void getScore() {
        assertEquals(50, candy.getScore());
    }
}