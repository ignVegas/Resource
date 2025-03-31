package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class HexTile {
    private final Integer number; // Can be null for center tile

    public HexTile(Integer number) {
        this.number = number;
    }

    public void draw(GraphicsContext gc, double x, double y, int size) {
        double[] points = new double[12];

        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(60 * i);
            points[i * 2] = x + size * Math.cos(angle);
            points[i * 2 + 1] = y + size * Math.sin(angle);
        }

        // Draw hexagon
        gc.setFill(Color.LIGHTGRAY);
        gc.fillPolygon(points, points, 6);
        gc.setStroke(Color.BLACK);
        gc.strokePolygon(points, points, 6);

        // Draw number inside hexagon
        if (number != null) {
            gc.setFill(Color.BLACK);
            gc.setFont(new Font(20));
            gc.setTextAlign(TextAlignment.CENTER);
            gc.fillText(number.toString(), x, y + 7); // Adjust Y for centering
        }
    }
}
