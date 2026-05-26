package ua.khpi.oop.lab11;

import ua.khpi.oop.lab11.model.*;
import ua.khpi.oop.lab11.service.CampusServiceRegistry;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CampusServiceRegistry registry = new CampusServiceRegistry();

        // 1. Демонстрація List (Оголошення)
        registry.addNotice(new Notice("N1", "Water shutdown in Dorm 4"));
        registry.addNotice(new Notice("N2", "Exam schedule published"));
        
        System.out.println("=== Усі оголошення (for-each обхід) ===");
        for (Notice notice : registry.getAllNotices()) { // Обхід через for-each [cite: 63]
            System.out.println(notice);
        }

        // 2. Демонстрація Map (Бронювання)
        registry.addBooking(new RoomBooking("B-001", "Room 204", "Alice"));
        registry.addBooking(new RoomBooking("B-002", "Conference Hall", "Bob"));

        System.out.println("\n=== Бронювання (обхід через entrySet) ===");
        for (Map.Entry<String, RoomBooking> entry : registry.getAllBookings().entrySet()) { // Обхід Map [cite: 63]
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }
        
        System.out.println("Швидкий пошук B-001: " + registry.getBooking("B-001"));

        // 3. Демонстрація Queue (Черга на консультацію)
        registry.enqueueConsultation(new ConsultationSlot("Alice", "Dr. Smith"));
        registry.enqueueConsultation(new ConsultationSlot("Charlie", "Dr. Smith"));

        System.out.println("\n=== Обробка черги консультацій ===");
        while (registry.getConsultationQueueSize() > 0) {
            ConsultationSlot slot = registry.processNextConsultation(); // FIFO обробка
            System.out.println("Обслуговується: " + slot);
        }
    }
}