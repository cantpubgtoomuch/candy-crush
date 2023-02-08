package backend.element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandyColorTest {

    @Test
    void values() {
        assertEquals(6,CandyColor.values().length);
    }

    @Test
    void valueOf() {
        assertNotNull(CandyColor.valueOf("BLUE"));
    }
}