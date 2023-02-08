package backend.cell;

import backend.Grid;
import backend.element.Candy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CandyGeneratorCellTest {
    private final Grid grid = Mockito.mock(Grid.class);
    CandyGeneratorCell candyGeneratorCell;
    @BeforeEach
    void setUp() {
        candyGeneratorCell = new CandyGeneratorCell(grid);
    }

    @Test
    void getContent() {
        assertNotNull(candyGeneratorCell.getContent());
    }

    @Test
    void isMovable() {
        assertTrue(candyGeneratorCell.isMovable());
    }

    @Test
    void isEmpty() {
        assertFalse(candyGeneratorCell.isEmpty());
    }

    @Test
    void getAndClearContent() {
        assertNotNull(candyGeneratorCell.getAndClearContent());
    }

    @Test
    void fallUpperContent() {
        assertThrows(IllegalStateException.class, () -> candyGeneratorCell.fallUpperContent());
    }

    @Test
    void setContent() {
        assertThrows(IllegalStateException.class, () -> candyGeneratorCell.setContent(new Candy()));
    }

    @Test
    void equals() {
        assertFalse(candyGeneratorCell.equals(new CandyGeneratorCell(grid)));
    }
}