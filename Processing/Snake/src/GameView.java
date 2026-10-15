import Util.QueueItem;
import processing.core.PApplet;

import java.util.function.Consumer;

public class GameView {
    public static QueueItem<Consumer<PApplet>> drawGameBoard() {
        final int gameWidth = Settings.GAME.WIDTH;
        final int gameHeight = Settings.GAME.HEIGHT;
        final int boardWidth = Settings.BLOCKS.TOTAL_WIDTH;
        final int boardHeight = Settings.BLOCKS.TOTAL_HEIGHT;
        final int boardBackgroundcolor = Settings.BLOCKS.BACKGROUND_COLOR.getRGB();
        final int pivotX = gameWidth/2 - boardWidth/2;
        final int pivotY = gameHeight/2 - boardHeight/2;

        return new QueueItem<>(

                panel -> {
                    panel.pushMatrix();
                    panel.translate(pivotX, pivotY);
                    panel.fill(boardBackgroundcolor);
                    panel.rect(0, 0, boardWidth, boardHeight);
                    panel.popMatrix();
                }, 1
        );
    }
}
