package Game;

import Util.QueueItem;
import processing.core.PApplet;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Panel extends PApplet {

    public volatile static Panel instance;
    private Queue<QueueItem<Consumer<PApplet>>> drawQueue;
    private InputHandler inputHandler;


    public void addToDrawQueue(Supplier<QueueItem<Consumer<PApplet>>> item) {
        addToDrawQueue(item.get());
    }

    public void addToDrawQueue(QueueItem<Consumer<PApplet>> item) {
        drawQueue.add(item);
    }

    public Panel() {
        this.drawQueue = new PriorityQueue<>(Comparator.comparingInt(QueueItem::getPriority));
        instance = this;
    }

    @Override
    public void draw() {
        Main.getInstance().getInputHandler().handleInputs();
        for(QueueItem<Consumer<PApplet>> event : this.drawQueue) {
            event.getItem().accept(this);
        }
    }

    @Override
    public void setup() {
        this.surface.setTitle(Settings.GAME.TITLE);
        this.frameRate(Settings.GAME.SNAKE_SPEED);
        this.background(Settings.GAME.BACKGROUND_COLOR.getRGB());
    }

    @Override
    public void settings() {
        this.size(Settings.GAME.WIDTH, Settings.GAME.HEIGHT);
    }

    public void keyPressed() {
        this.inputHandler.keyPressed(key);
    }

    public void keyReleased() {
        this.inputHandler.keyReleased(key);
    }

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

}
