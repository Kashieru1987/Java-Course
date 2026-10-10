import Util.QueueItem;
import processing.core.PApplet;

import java.util.*;
import java.util.function.Consumer;

public class Panel extends PApplet {

    public volatile static Panel instance;
    private Queue<QueueItem<Consumer<PApplet>>> drawQueue;

    public void addToDrawQueue(QueueItem<Consumer<PApplet>> item) {
        drawQueue.add(item);
    }

    public Panel() {
        this.drawQueue = new PriorityQueue<>(Comparator.comparingInt(QueueItem::getPriority));
        System.out.println("i'm ran");
        instance = this;
    }

    @Override
    public void draw() {
        for(QueueItem<Consumer<PApplet>> event : this.drawQueue) {
            event.getItem().accept(this);
        }
    }

    @Override
    public void setup() {
        this.surface.setTitle(Settings.GAME.TITLE);
    }

    @Override
    public void settings() {
        this.size(Settings.GAME.WIDTH, Settings.GAME.HEIGHT);
    }

}
