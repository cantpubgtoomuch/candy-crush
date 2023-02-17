package frontend;

import static org.testfx.api.FxAssert.verifyThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.matcher.base.WindowMatchers;

class AppMenuTest extends GameAppTest {
    FxRobot robot;
    @BeforeEach
    void setUp() {
        robot = new FxRobot();
    }

    @Test
    void exitTest() {
        robot.clickOn("Level 1").clickOn("Option").clickOn("Exit");
        verifyThat(window("Exit"), WindowMatchers.isShowing());
        robot.clickOn("Cancel");
    }

    @Test
    void backToMenuTest() {
        robot.clickOn("Option").clickOn("Menu");
        verifyThat(window("Menu"), WindowMatchers.isShowing());
        robot.clickOn("OK");
        robot.clickOn("Level 1").clickOn("Option").clickOn("Menu").clickOn("Cancel");
    }

    @Test
    void helpTest() {
        robot.clickOn("Help").clickOn("About");
        verifyThat(window("About"), WindowMatchers.isShowing());
        robot.clickOn("OK");
    }
}