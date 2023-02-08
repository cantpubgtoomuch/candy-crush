package backend.element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NothingTest {

    Nothing nothing;
    @BeforeEach
    void setUp() {
        nothing = new Nothing();
    }

    @Test
    void isMovable() {
        assertFalse(nothing.isMovable());
    }

    @Test
    void isSolid() {
        assertFalse(nothing.isSolid());
    }

    @Test
    void canBeCleared() {
        assertTrue(nothing.canBeCleared());
    }

    @Test
    void getKey() {
        assertEquals("NOTHING", nothing.getKey());
    }
}