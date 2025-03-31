package application;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.Collections;

public class HexGrid {
    private static final int HEX_SIZE = 50;
    private static final double WIDTH = 600;
    private static final double HEIGHT = 600;
    private final HexTile[] hexTiles = new HexTile[13];

    public HexGrid() {
        ArrayList<Integer> diceSums = new ArrayList<>();
        for (int i = 2; i <= 12; i++) {
            diceSums.add(i);
        }
        
        diceSums.add(7);
        Collections.shuffle(diceSums);

        int index = 0;
        for (int i = 0; i < 13; i++) {
            if (i == 6) {
                hexTiles[i] = new HexTile(null); 
            } else {
                hexTiles[i] = new HexTile(diceSums.get(index++));
            }
        }
    }

    public void draw(GraphicsContext gc) {
        double centerX = WIDTH / 2;
        double centerY = HEIGHT / 2;

        int[][] hexPositions = {
            {0, -2}, {1, -1}, {2, -1}, {2, 0}, {1, 1}, {0, 2}, 
            {-1, 1}, {-2, 1}, {-2, 0}, {-1, -1}, {0, -1}, {1, -2}, {2, -2}
        };

        for (int i = 0; i < hexTiles.length; i++) {
            double x = centerX + hexPositions[i][0] * (HEX_SIZE * 1.5);
            double y = centerY + hexPositions[i][1] * (HEX_SIZE * Math.sqrt(3));

            hexTiles[i].draw(gc, x, y, HEX_SIZE);
        }
    }
}
