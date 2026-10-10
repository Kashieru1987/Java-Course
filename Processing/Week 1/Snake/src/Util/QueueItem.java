package Util;

import org.jspecify.annotations.NonNull;

import java.util.Comparator;

public class QueueItem<T> {
    private final T item;
    private final int priority;

    public T getItem() {
        return this.item;
    }

    public int getPriority() {
        return this.priority;
    }

    public QueueItem(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

}
