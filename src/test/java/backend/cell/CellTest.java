package backend.cell;

import backend.Figure;
import backend.Grid;
import backend.element.Candy;
import backend.element.Wall;
import backend.element.WrappedCandy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell cell;
    private Cell up;
    private Cell down;
    private Cell left;
    private Cell right;
    private final Grid grid =Mockito.mock(Grid.class);
    @BeforeEach
    void setUp() {
        cell = new Cell(grid);
        up = new Cell(grid);
        down = new Cell(grid);
        left = new Cell(grid);
        right = new Cell(grid);
    }

    @Test
    void setAround() {
        cell.setAround(up, down, left, right);
    }

    @Test
    void hasFloor() {
        cell.setAround(up, down, left, right);
        assertFalse(cell.hasFloor());
        down.setContent(new Candy());
        assertTrue(cell.hasFloor());
    }

    @Test
    void isMovable() {
        assertFalse(cell.isMovable());
    }

    @Test
    void isEmpty() {
        assertTrue(cell.isEmpty());
    }

    @Test
    void getContent() {
        assertEquals("NOTHING", cell.getContent().getKey());
    }

    @Test
    void clearContent() {
        Mockito.doNothing().when(grid).cellExplosion(Mockito.any());
        cell.clearContent();
        assertEquals("NOTHING", cell.getContent().getKey());

        cell.setContent(new Wall());
        cell.clearContent();
        assertEquals("WALL", cell.getContent().getKey());

        Mockito.doNothing().when(grid).cellExplosion(Mockito.any());
        cell.setContent(new WrappedCandy());
        cell.setAround(up, down, left, right);
        cell.clearContent();
        assertEquals("NOTHING", cell.getContent().getKey());
    }

    @Test
    void getAndClearContent() {
        assertNull(cell.getAndClearContent());

        cell.setContent(new Candy());
        assertNotNull(cell.getAndClearContent());
    }

    @Test
    void fallUpperContent() {
        cell.setAround(up, down, left, right);
        up.setContent(new Candy());
        down.setContent(new Candy());
        Mockito.doNothing().when(grid).wasUpdated();
        Mockito.when(grid.tryRemove(Mockito.any())).thenReturn(Figure.F1);
        assertTrue(cell.fallUpperContent());
    }
}