package backend.element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    Wall wall;
    @BeforeEach
    void setUp() {
        wall = new Wall();
    }

    @Test
    void isMovable() {
        assertFalse(wall.isMovable());
    }

    @Test
    void canBeCleared() {
        assertFalse(wall.canBeCleared());
    }

    @Test
    void getKey() {
        assertEquals("WALL", wall.getKey());
    }
}