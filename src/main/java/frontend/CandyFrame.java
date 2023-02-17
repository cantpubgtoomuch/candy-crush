package frontend;

import backend.CandyGame;
import backend.GameListener;
import backend.cell.Cell;
import backend.element.Element;

import backend.level.Level;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.Optional;

public class CandyFrame extends VBox {

	public static final int CELL_SIZE = 65;

	private BoardPanel boardPanel;
	private ScorePanel scorePanel;
	private ImageManager images;
	private Point2D lastPoint;
	private final CandyGame game;
	private final GameApp app;

	public CandyFrame(CandyGame game, Level level, GameApp app){
		this.game = game;
		this.app = app;
		playLevel(level);
	}

	public Point2D getLastPoint() {
		return lastPoint;
	}
	public void playLevel(Level level) {

		getChildren().add(new AppMenu(app));
		images = new ImageManager();
		boardPanel = new BoardPanel(game.getSize(), game.getSize(), CELL_SIZE);
		getChildren().add(boardPanel);

		game.initGame(level);

		scorePanel = new ScorePanel(game().getDescription());
		getChildren().add(scorePanel);


		GameListener listener;
		game.addGameListener(listener = new GameListener() {
			@Override
			public void gridUpdated() {
				Timeline timeLine = new Timeline();
				Duration frameGap = Duration.millis(100);
				Duration frameTime = Duration.ZERO;
				for (int i = game().getSize() - 1; i >= 0; i--) {
					for (int j = game().getSize() - 1; j >= 0; j--) {
						int finalI = i;
						int finalJ = j;
						Cell cell = CandyFrame.this.game.get(i, j);
						Element element = cell.getContent();
						Image image = images.getImage(element);
						timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> boardPanel.setImage(finalI, finalJ, null)));
						timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> boardPanel.setImage(finalI, finalJ, image)));
					}
					frameTime = frameTime.add(frameGap);
				}
				timeLine.play();
			}
		});

		listener.gridUpdated();
		moveCandy();
	}

	private void moveCandy() {
		addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			Point2D newPoint = translateCoords(event.getX(), event.getY());
			if (lastPoint == null) {
				lastPoint = newPoint;
				System.out.println("Get first = " +  lastPoint);
			} else {
				if (newPoint != null) {
					System.out.println("Get second = " +  newPoint);
					game().tryMove((int)lastPoint.getX(), (int)lastPoint.getY(), (int)newPoint.getX(), (int)newPoint.getY());

					String message = game().getDescription();

					if (game().isFinished()) {
						if (game().playerWon()) {
							finishedGame("Finished - Player Won!", "Finished - Player Won!");
						} else {
							finishedGame("Finished - Loser!", "Finished - Loser!");
						}
					}
					scorePanel.updateScore(message);
					lastPoint = null;
				}
			}
		});
	}
	private CandyGame game() {
		return game;
	}

	private Point2D translateCoords(double x, double y) {
		double i = x / CELL_SIZE;
		double j = y / CELL_SIZE;
		return (i >= 0 && i < game.getSize() && j >= 0 && j < game.getSize()) ? new Point2D(j, i) : null;
	}

	private void finishedGame(String text, String message){
		scorePanel.updateScore(message);
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Game Over");
		alert.setHeaderText(text);
		alert.setContentText("Do you want to go back to the menu?");
		Optional<ButtonType> result = alert.showAndWait();
		if(result.isPresent()) {
			if (result.get() == ButtonType.OK) {
				app.backToMenu();
			} else {
				Platform.exit();
			}
		}
	}
}

