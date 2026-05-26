package ua.khpi.oop.lab11.model;

import java.time.LocalDateTime;

public class Notice {
    private final String id;
    private final String message;
    private final LocalDateTime postedAt;

    public Notice(String id, String message) {
        this.id = id;
        this.message = message;
        this.postedAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getMessage() { return message; }
    public LocalDateTime getPostedAt() { return postedAt; } 

    @Override
    public String toString() {
        return "Повідомлення " + " id = " + id + " Меседж " + message + " Публікація " + postedAt;
    }
}