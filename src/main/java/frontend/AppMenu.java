package frontend;

import javafx.application.Platform;
import javafx.scene.control.*;

import java.util.Optional;

public class AppMenu extends MenuBar {
    private Menu file;
    private MenuItem exitMenuItem;
    private MenuItem backMenuItem;
    private Menu help;
    private MenuItem aboutMenuItem;
    private GameApp app;
    public AppMenu(GameApp app) {
        this.app = app;
        file = new Menu("Option");
        help = new Menu("Help");
        exitMenuItem = new MenuItem("Exit");
        backMenuItem = new MenuItem("Menu");
        aboutMenuItem = new MenuItem("About");
        file.getItems().addAll( backMenuItem, exitMenuItem);
        help.getItems().add(aboutMenuItem);
        getMenus().addAll(file, help);
        exit();
        backToMenu();
        help();
    }
    public Menu getMenu() {
        return file;
    }
    public void exit() {
        exitMenuItem.setOnAction(event -> {
            String title = "Exit";
            String headerText = "Exit the application";
            String contentText = "Are you sure you want to exit the application?";
            Alert alert = createAlert(title, headerText, contentText);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()) {
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                }
            }
        });
    }

    public void backToMenu() {
        backMenuItem.setOnAction(event -> {
            String title = "Menu";
            String headerText = "Back to menu";
            String contentText = "Are you sure you want to return to the menu?";
            Alert alert = createAlert(title, headerText, contentText);
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isPresent()) {
                if (result.get() == ButtonType.OK) {
                    app.backToMenu();
                }
            }
        });
    }

    public void help() {
        aboutMenuItem.setOnAction(event -> {
            String title = "About";
            String headerText = "Candy Crush Version 1.0";
            String contentText = "";
            Alert alert = createAlert(title, headerText, contentText);
            alert.showAndWait();
        });
    }

    private Alert createAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        return alert;
    }
}
