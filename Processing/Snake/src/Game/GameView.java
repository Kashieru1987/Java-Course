package Game;

import Util.Cell;
import Util.QueueItem;
import processing.core.PApplet;

import java.util.function.Consumer;

public class GameView {
    private static final int gameWidth = Settings.GAME.WIDTH;
    private static final int gameHeight = Settings.GAME.HEIGHT;
    private static final int boardWidth = Settings.BLOCKS.TOTAL_WIDTH;
    private static final int boardHeight = Settings.BLOCKS.TOTAL_HEIGHT;
    private static final int boardBackgroundColor = Settings.BLOCKS.BACKGROUND_COLOR.getRGB();
    private static final int emptyBlockColor = Settings.BLOCKS.EMPTY_COLOR.getRGB();
    private static final int pivotX = gameWidth/2 - boardWidth/2;
    private static final int pivotY = gameHeight/2 - boardHeight/2;
    private static final int padding = Settings.BLOCKS.PADDING;
    private static final int wide = Settings.BLOCKS.COUNT_WIDE;
    private static final int high = Settings.BLOCKS.COUNT_HIGH;
    private static final int blockWidth = Settings.BLOCKS.DIAMETER;

    /**
     * Draws the borders around the game
     * @return
     */
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

    /**
     * Required to clear previous board state
     * @return
     */
    public static QueueItem<Consumer<PApplet>> drawEmptyBlocks() {
        return new QueueItem<> (
                panel -> {
                    panel.pushMatrix();
                    panel.translate(pivotX, pivotY);
                    panel.translate(padding, padding);

                    for(int i = 0; i < high; i++)
                        drawEmptyRow(panel, i);

                    panel.popMatrix();
                }, 1
        );
    }

    private static void drawEmptyRow(PApplet panel, int row) {
        panel.pushMatrix();

        for(int i = 0; i < wide; i++) {
            drawCell(panel, new Cell(i, row));

            if(!Settings.GAME.DEBUG_MODE)
                continue;
            final int rgb = Settings.BLOCKS.EMPTY_COLOR.getRGB();
            drawCell(panel, new Cell(i, row, rgb));
        }

        panel.popMatrix();
    }

    /**
     * draws a cell, requires pivoting to the start of the board before being called
     * @param panel
     * @param cell
     */
    private static void drawCell(PApplet panel, Cell cell) {
        panel.pushMatrix();

        final int factor = padding + blockWidth;
        final int x = factor * cell.getColumn();
        final int y = factor * cell.getRow();
        final int rgb = cell.getRGB();

        panel.fill(rgb);
        panel.rect(x, y, blockWidth, blockWidth);

        panel.popMatrix();
    }

}
