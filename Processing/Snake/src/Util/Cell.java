package Util;

import Game.Settings;

public class Cell {
    private final int column;
    private final int row;
    private final int rgb;

    public Cell(int column, int row) {
        this(column, row, Settings.BLOCKS.BACKGROUND_COLOR.getRGB());
    }

    public Cell(int column, int row, int rgb) {
        this.column = column;
        this.row = row;
        this.rgb = rgb;
    }

}
