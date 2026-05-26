package ua.khpi.oop.lab09.container;

import ua.khpi.oop.lab09.model.CloudItem;
import java.time.LocalDateTime;

public class CloudRecord<T extends CloudItem> {
    private final T item;
    private final String owner;
    private final LocalDateTime uploadTime;

    public CloudRecord(T item, String owner) {
        if (item == null) throw new IllegalArgumentException("Значення не може бути нульовим");
        this.item = item;
        this.owner = owner;
        this.uploadTime = LocalDateTime.now();
    }

    public T getItem() {
        return item;
    }

    public String getOwner() {
        return owner;
    }

    public long getRecordSize() {
        return item.getSizeKb();
    }

    public String toString() {
        return "Запис" + "Власник = " + owner + " Час = " + uploadTime + " Предмет = " + item;
    }
}