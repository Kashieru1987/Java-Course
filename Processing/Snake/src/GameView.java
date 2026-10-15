import Util.QueueItem;
import androidx.compose.material.icons.sharp._10kKt;
import processing.core.PApplet;

import java.util.function.Consumer;

public class GameView {
    public static final int gameWidth = Settings.GAME.WIDTH;
    public static final int gameHeight = Settings.GAME.HEIGHT;
    public static final int boardWidth = Settings.BLOCKS.TOTAL_WIDTH;
    public static final int boardHeight = Settings.BLOCKS.TOTAL_HEIGHT;
    public static final int boardBackgroundColor = Settings.BLOCKS.BACKGROUND_COLOR.getRGB();
    public static final int emptyBlockColor = Settings.BLOCKS.EMPTY_COLOR.getRGB();
    public static final int pivotX = gameWidth/2 - boardWidth/2;
    public static final int pivotY = gameHeight/2 - boardHeight/2;
    public static final int padding = Settings.BLOCKS.PADDING;
    public static final int wide = Settings.BLOCKS.COUNT_WIDE;
    public static final int high = Settings.BLOCKS.COUNT_HIGH;
    public static final int blockWidth = Settings.BLOCKS.DIAMETER;

    public static QueueItem<Consumer<PApplet>> drawGameBoard() {
        return new QueueItem<>(
                panel -> {
                    panel.pushMatrix();
                    panel.translate(pivotX, pivotY);
                    panel.fill(boardBackgroundColor);
                    panel.rect(0, 0, boardWidth, boardHeight);
                    panel.popMatrix();
                }, 1
        );
    }

    public static QueueItem<Consumer<PApplet>> drawEmptyBlocks() {
        return new QueueItem<> (
                panel -> {
                    panel.pushMatrix();
                    panel.translate(pivotX, pivotY);
                    panel.translate(padding, padding);
                    panel.fill(emptyBlockColor);
                    for(int i = 0; i < high; i++)
                        drawRow(panel, i*(blockWidth + padding));
                    panel.popMatrix();
                }, 1
        );
    }

    private static void drawRow(PApplet panel, int y) {
        panel.pushMatrix();
        panel.translate(0, y);

        for(int i = 0; i < wide; i++) {
            int x = i * (padding + blockWidth);
            panel.rect(x, 0, blockWidth, blockWidth);
        }

        panel.popMatrix();
    }

}
