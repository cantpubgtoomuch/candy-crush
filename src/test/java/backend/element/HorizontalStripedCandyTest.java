package backend.element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorizontalStripedCandyTest {

    HorizontalStripedCandy horizontalStripedCandy;
    @BeforeEach
    void setUp() {
        horizontalStripedCandy = new HorizontalStripedCandy();
    }

    @Test
    void getKey() {
        assertEquals("HORIZ-STRIPED-CANDY", horizontalStripedCandy.getKey());
    }

    @Test
    void getFullKey() {
        horizontalStripedCandy.setColor(CandyColor.BLUE);
        assertEquals("HORIZ-STRIPED-BLUE-CANDY", horizontalStripedCandy.getFullKey());
    }

    @Test
    void explode() {
        assertEquals(2, horizontalStripedCandy.explode().length);
    }

    @Test
    void getScore() {
        assertEquals(80, horizontalStripedCandy.getScore());
    }
}