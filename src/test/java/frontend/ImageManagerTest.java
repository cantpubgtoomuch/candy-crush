package frontend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import backend.element.*;
class ImageManagerTest extends GameAppTest {
    ImageManager imageManager;
    Candy candy;
    WrappedCandy wc;
    VerticalStripedCandy vc;
    HorizontalStripedCandy hc;
    @BeforeEach
    void setUp() {
        imageManager = new ImageManager();
        candy = new Candy(CandyColor.BLUE);
        wc = new WrappedCandy();
        vc = new VerticalStripedCandy();
        hc = new HorizontalStripedCandy();
        wc.setColor(CandyColor.PURPLE);
        vc.setColor(CandyColor.RED);
        hc.setColor(CandyColor.GREEN);
    }

    @Test
    void getImageTest() {
        assertNotNull(imageManager.getImage(candy));
        assertNotNull(imageManager.getImage(wc));
        assertNotNull(imageManager.getImage(vc));
        assertNotNull(imageManager.getImage(hc));
    }
}