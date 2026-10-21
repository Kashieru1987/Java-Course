package Game;

import processing.core.PApplet;

public class Main {

    private volatile static Main instance;
    private final InputHandler inputHandler;
    private final Panel panel;
    private final Snake snake;

    public Snake getSnake() {
        return this.snake;
    }

    public InputHandler getInputHandler() {
        return this.inputHandler;
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

        this.snake = new Snake();
        this.panel = Panel.instance;

        this.inputHandler = new InputHandler();
        this.panel.setInputHandler(inputHandler);

        panel.addToDrawQueue(GameView::drawGameBoard);
        panel.addToDrawQueue(GameView::drawEmptyBlocks);
        panel.addToDrawQueue(GameView::drawSnake);
    }

    public static void main(String[] args) {
        Main.getInstance();
    }
}