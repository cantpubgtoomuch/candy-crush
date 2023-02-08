package backend.element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {
    Element element;
    @BeforeEach
    void setUp() {
        element = Mockito.mock(Element.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(element.isMovable()).thenReturn(true);
        Mockito.when(element.getKey()).thenReturn("ELEMENT");
    }

    @Test
    void canBeCleared() {
        assertTrue(element.canBeCleared());
    }

    @Test
    void getFullKey() {
        assertEquals("ELEMENT",element.getFullKey());
    }

    @Test
    void isSolid() {
        assertTrue(element.isSolid());
    }

    @Test
    void explode() {
        assertNull(element.explode());
    }

    @Test
    void getScore() {
        assertEquals(0, element.getScore());
    }
}