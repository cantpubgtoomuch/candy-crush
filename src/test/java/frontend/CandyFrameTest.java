package frontend;

import backend.CandyGame;
import backend.level.Level;
import backend.level.Level1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxRobotException;

import javafx.geometry.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class CandyFrameTest extends GameAppTest {
    FxRobot robot;
    @BeforeEach
    void setUp() {
        robot = new FxRobot();
    }

    @Test
    void playLevelTest() {
        robot.clickOn("Level 1");
        Point2D curClick = new Point2D(800, 600);
        Point2D curClick2 = new Point2D(805, 605);
        Point2D curClick3 = new Point2D(900, 500);
        robot.clickOn(curClick);
        robot.clickOn(curClick2);
        robot.clickOn(curClick3);
    }
}