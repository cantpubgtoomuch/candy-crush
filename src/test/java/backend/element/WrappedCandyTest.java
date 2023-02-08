package backend.element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrappedCandyTest {

    WrappedCandy wrappedCandy;
    @BeforeEach
    void setUp() {
        wrappedCandy = new WrappedCandy();
    }

    @Test
    void getKey() {
        assertEquals("WRAPPED-CANDY", wrappedCandy.getKey());
    }

    @Test
    void getFullKey() {
        wrappedCandy.setColor(CandyColor.RED);
        assertEquals("WRAPPED-RED-CANDY", wrappedCandy.getFullKey());
    }

    @Test
    void explode() {
        assertEquals(4, wrappedCandy.explode().length);
    }

    @Test
    void getScore() {
        assertEquals(60,wrappedCandy.getScore());
    }
}