package frontend;

import org.junit.jupiter.api.BeforeAll;
import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;


class GameAppTest extends ApplicationTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
        ApplicationTest.launch(GameApp.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }
}