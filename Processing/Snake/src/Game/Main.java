package Game;

import processing.core.PApplet;

public class Main {

    private volatile static Main instance;
    private Panel panel;

    private void setPanel(Panel panel) {
        this.panel = panel;
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
        this.setPanel(Panel.instance);
        panel.addToDrawQueue(GameView::drawGameBoard);
        panel.addToDrawQueue(GameView::drawEmptyBlocks);
    }

    public static void main(String[] args) {
        Main.getInstance();
    }
}