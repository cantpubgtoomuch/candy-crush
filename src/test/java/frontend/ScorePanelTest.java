package frontend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScorePanelTest extends GameAppTest {
    private ScorePanel scorePanel;
    private String score = "0";
    private String updatedScore = "50";
    @BeforeEach
    void setUp() {
        scorePanel = new ScorePanel(score);
    }
    @Test
    void updateScore() {
        scorePanel.updateScore(updatedScore);
        assertEquals(updatedScore, scorePanel.getScore());
    }
}