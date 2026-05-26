package ua.khpi.oop.lab15.model;

public class TaskCard {
    private final int storyPoints;
    public TaskCard(int storyPoints) {
        this.storyPoints = storyPoints;
    }

    public int getStoryPoints() {
        return storyPoints;
    }
}