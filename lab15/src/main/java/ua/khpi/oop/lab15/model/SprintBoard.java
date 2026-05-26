package ua.khpi.oop.lab15.model;


public class SprintBoard {
    private int completedTasks = 0;
    private int totalStoryPoints = 0;

    public void completeTaskUnsafe(TaskCard task) {
        int currentTasks = this.completedTasks;
        int currentPoints = this.totalStoryPoints;
        
        this.completedTasks = currentTasks + 1;
        this.totalStoryPoints = currentPoints + task.getStoryPoints();
    }

    public synchronized void completeTaskSafe(TaskCard task) {
        this.completedTasks++;
        this.totalStoryPoints += task.getStoryPoints();
    }

    public int getCompletedTasks() {
        return completedTasks;
    }

    public int getTotalStoryPoints() {
        return totalStoryPoints;
    }

    public void reset() {
        this.completedTasks = 0;
        this.totalStoryPoints = 0;
    }
}