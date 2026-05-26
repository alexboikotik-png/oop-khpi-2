package ua.khpi.oop.lab12.model;

public class Achievement {
    private String title;
    private int points;

    public Achievement(String title, int points) {
        this.title = title;
        this.points = points;
    }

    public String getTitle() { return title; }
    public int getPoints() { return points; }

    public String toString() {
        return String.format("Досягнення %s    %d балів", title, points);
    }
}