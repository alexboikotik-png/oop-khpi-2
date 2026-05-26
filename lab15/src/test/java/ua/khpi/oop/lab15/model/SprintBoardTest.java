package ua.khpi.oop.lab15.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SprintBoardTest {

    private SprintBoard board;

    @BeforeEach
    void setUp() {
        board = new SprintBoard();
    }

    @Test
    @DisplayName("Перевірка правильності зміни стану")
    void testSequentialStateChange() {

        TaskCard task1 = new TaskCard(3);
        TaskCard task2 = new TaskCard(5);

        board.completeTaskSafe(task1);

        assertEquals(1, board.getCompletedTasks(), "Має бути виконано 1 завдання");
        assertEquals(3, board.getTotalStoryPoints(), "Сума балів має дорівнювати 3");
        board.completeTaskSafe(task2);
        assertEquals(2, board.getCompletedTasks(), "Має бути виконано 2 завдання");
        assertEquals(8, board.getTotalStoryPoints(), "Сума балів має дорівнювати 8");
    }

    @Test
    @DisplayName("Неможливість порушити варіанти")
    void testInvariantProtectionNegativeStoryPoints() {
        TaskCard invalidTask = new TaskCard(-5);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> board.completeTaskSafe(invalidTask)
        );

        assertEquals("Біли не можуть бути від'ємними", exception.getMessage());
        assertEquals(0, board.getCompletedTasks(), "Стан дошки не повинен був змінитись");
    }

    @Test
    @DisplayName("Очікуваний фінальний результат")
    void testConcurrentSynchronizedAccess() throws InterruptedException {

        int threadsCount = 4;
        int iterationsPerThread = 100_000;
        int expectedTasks = threadsCount * iterationsPerThread;
        TaskCard standardTask = new TaskCard(2);
        int expectedPoints = expectedTasks * 2;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < iterationsPerThread; j++) {
                    board.completeTaskSafe(standardTask);
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }


        assertEquals(expectedTasks, board.getCompletedTasks(), 
            "Синхронізований метод не повинен втрачати оновлення лічильника задач");
        assertEquals(expectedPoints, board.getTotalStoryPoints(), 
            "Синхронізований метод не повинен втрачати оновлення балів");
    }
}