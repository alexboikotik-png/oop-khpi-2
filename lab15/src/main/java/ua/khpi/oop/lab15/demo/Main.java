package ua.khpi.oop.lab15.demo;

import ua.khpi.oop.lab15.model.SprintBoard;
import ua.khpi.oop.lab15.model.TaskCard;
import ua.khpi.oop.lab15.task.BoardUpdateTask;

public class Main {
    private static final int THREADS_COUNT = 4;
    private static final int ITERATIONS_PER_THREAD = 100_000;
    private static final int EXPECTED_TOTAL_TASKS = THREADS_COUNT * ITERATIONS_PER_THREAD;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Кількість активних потоків розробників: " + THREADS_COUNT);
        System.out.println("Кількість завдань на один потік: " + ITERATIONS_PER_THREAD);
        System.out.println("Математично очікуваний підсумок: " + EXPECTED_TOTAL_TASKS + " завдань\n");

        SprintBoard board = new SprintBoard();

        runSequential(board);
        runParallel(board, false, "Паралельне небезпечне виконання");
        runParallel(board, true, "Паралельне безпечне виконання");
    }

    private static void runSequential(SprintBoard board) {
        board.reset();
        long startTime = System.currentTimeMillis();

        TaskCard task = new TaskCard(2);
        for (int i = 0; i < EXPECTED_TOTAL_TASKS; i++) {
            board.completeTaskUnsafe(task);
        }

        long endTime = System.currentTimeMillis();
        printStats("Послідовний сценарій", board, endTime - startTime);
    }

    private static void runParallel(SprintBoard board, boolean isSafe, String testName) throws InterruptedException {
        board.reset();
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new BoardUpdateTask(board, ITERATIONS_PER_THREAD, isSafe));
        }

        long startTime = System.currentTimeMillis();

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long endTime = System.currentTimeMillis();
        printStats(testName, board, endTime - startTime);
    }

    private static void printStats(String testName, SprintBoard board, long durationMs) {
        int lostUpdates = EXPECTED_TOTAL_TASKS - board.getCompletedTasks();
        System.out.println(testName);
        System.out.println("Загальний час розрахунку: " + durationMs + " мс");
        System.out.println("Викоані задачі: " + board.getCompletedTasks());
        System.out.println("Кількість втрачених оновлень даних: " + lostUpdates);
        System.out.println("Підсумок: " + board.getTotalStoryPoints() + "\n");
    }
}