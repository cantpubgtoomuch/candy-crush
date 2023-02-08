package backend.element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerticalStripedCandyTest {
    VerticalStripedCandy verticalStripedCandy;

    @BeforeEach
    void setUp() {
        verticalStripedCandy = new VerticalStripedCandy();
    }

    @Test
    void getKey() {
        assertEquals("VERT-STRIPED-CANDY", verticalStripedCandy.getKey());
    }

    @Test
    void getFullKey() {
        verticalStripedCandy.setColor(CandyColor.RED);
        assertEquals("VERT-STRIPED-RED-CANDY", verticalStripedCandy.getFullKey());
    }

    @Test
    void explode() {
        assertEquals(2, verticalStripedCandy.explode().length);
    }

    @Test
    void getScore() {
        assertEquals(80, verticalStripedCandy.getScore());
    }
}