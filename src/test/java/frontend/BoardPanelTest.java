package frontend;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardPanelTest extends GameAppTest {
    BoardPanel bp;
    String filePath = "images/blueCandy.png";
    ImageView[][] cells;
    @BeforeEach
    void setUp() {
        bp = new BoardPanel(9, 9, 65);
        cells = bp.getCells();
    }

    @Test
    void setImageTest() {
        Image blueCandy = new Image(filePath);
        bp.setImage(2,3, blueCandy);
        assertEquals(blueCandy, (cells[2][3].getImage()));
    }
}