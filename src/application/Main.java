package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main Menu UI
        Button startGameButton = new Button("Start Game");
        startGameButton.setOnAction(e -> primaryStage.setScene(GameScene.getGameScene(primaryStage)));

        VBox menuLayout = new VBox(20, startGameButton);
        menuLayout.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        Scene menuScene = new Scene(menuLayout, 600, 600);
        primaryStage.setScene(menuScene);
        primaryStage.setTitle("Hex Grid Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
