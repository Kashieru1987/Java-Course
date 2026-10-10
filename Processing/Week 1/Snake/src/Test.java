import Util.QueueItem;
import processing.core.PApplet;

import java.util.function.Consumer;

public class Test {
    public static QueueItem<Consumer<PApplet>> drawSquare() {
        return new QueueItem<>(panel -> {
            panel.rect(0, 0, 100, 100);
        }, 0);
    }
    public static QueueItem<Consumer<PApplet>> drawCircle() {
        return new QueueItem<>(panel -> {
            panel.circle(0, 0, 100);
        }, 1);
    }
}