package Game;

import Util.Cell;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private volatile static Main instance;
    private Panel panel;
    private List<Cell> snake;

    private void setPanel(Panel panel) {
        this.panel = panel;
    }

    public List<Cell> getSnake() {
        return this.snake;
    }

    public static Main getInstance() {
        Main mainInstance = instance;
        if(mainInstance == null) {
            synchronized (Main.class) {
                mainInstance = instance;
                if(mainInstance == null) {
                    instance = mainInstance = new Main();
                }
            }
        }
        return mainInstance;
    }

    private Main() {
        System.setProperty("sun.java2d.uiScale", "1"); // fix processing hating scaling
        PApplet.main("Game.Panel");

        this.snake = new ArrayList<Cell>();
        snake.add(new Cell(4, 3, Settings.BLOCKS.SNAKE_COLOR.getRGB()));

        this.setPanel(Panel.instance);
        panel.addToDrawQueue(GameView::drawGameBoard);
        panel.addToDrawQueue(GameView::drawEmptyBlocks);
        panel.addToDrawQueue(GameView::drawSnake);
    }

    public static void main(String[] args) {
        Main.getInstance();
    }
}