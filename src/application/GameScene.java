package application;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameScene {

    public static Scene getGameScene(Stage stage) {
        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create and render hex grid
        HexGrid hexGrid = new HexGrid();
        hexGrid.draw(gc);

        StackPane layout = new StackPane(canvas);
        return new Scene(layout, 600, 600);
    }
}
