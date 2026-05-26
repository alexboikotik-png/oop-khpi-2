package ua.khpi.oop.lab15.task;

// Імпортуємо моделі з сусіднього пакету для побудови взаємодії класів
import ua.khpi.oop.lab15.model.SprintBoard;
import ua.khpi.oop.lab15.model.TaskCard;

/**
 * Клас, що реалізує інтерфейс Runnable. Описує повторювану роботу 
 * розробника в команді, який інтенсивно закриває завдання на спільній дошці.
 */
public class BoardUpdateTask implements Runnable {
    // Посилання на спільну дошку спринту
    private final SprintBoard board;
    
    // Кількість ітерацій (операцій оновлення лічильника), які має виконати цей потік
    private final int iterations;
    
    // Прапорець, що визначає, чи використовувати безпечний синхронізований метод
    private final boolean useSafeMethod;

    /**
     * Конструктор завдання потоку.
     */
    public BoardUpdateTask(SprintBoard board, int iterations, boolean useSafeMethod) {
        this.board = board;
        this.iterations = iterations;
        this.useSafeMethod = useSafeMethod;
    }

    /**
     * Точка входу в логіку виконання окремого обчислювального потоку.
     */
    @Override
    public void run() {
        // Створюємо шаблонне завдання вагою в 2 Story Points, яке потік буде імітувати в циклі
        TaskCard dummyTask = new TaskCard(2);
        
        // Цикл інтенсивної висококонкурентної модифікації даних спільного ресурсу
        for (int i = 0; i < iterations; i++) {
            if (useSafeMethod) {
                // Виклик потокобезпечного методу із блокуванням монітора
                board.completeTaskSafe(dummyTask);
            } else {
                // Виклик несинхронізованого методу зі штучним ризиком race condition
                board.completeTaskUnsafe(dummyTask);
            }
        }
    }
}