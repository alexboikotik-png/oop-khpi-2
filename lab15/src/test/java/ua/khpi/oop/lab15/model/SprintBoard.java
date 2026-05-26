package ua.khpi.oop.lab15.model;

public class SprintBoard {
    private int completedTasks = 0;
    private int totalEffort = 0;
    private final int maxTasksLimit;

    public SprintBoard(int maxTasksLimit) {
        this.maxTasksLimit = maxTasksLimit;
    }

    public synchronized void completeTask(int effort) {

        if (completedTasks >= maxTasksLimit) {
            throw new IllegalStateException("Перевищено ліміт");
        }
        if (effort < 0) {
            throw new IllegalArgumentException("Витрачений час не може бути від'ємним");
        }

        completedTasks++;
        totalEffort += effort;
    }

    public synchronized int getCompletedTasks() {
        return completedTasks;
    }

    public synchronized int getTotalEffort() {
        return totalEffort;
    }
}