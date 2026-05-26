package ua.khpi.oop.lab08.demo;

import ua.khpi.oop.lab08.exception.InvalidAnalyticsDataException;
import ua.khpi.oop.lab08.model.*;
import ua.khpi.oop.lab08.persistence.AnalyticsFileManager;
import ua.khpi.oop.lab08.service.LearningAnalyticsRegistry;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        LearningAnalyticsRegistry registry = new LearningAnalyticsRegistry();
        AnalyticsFileManager fileManager = new AnalyticsFileManager();
        
        Path textPath = Paths.get("data", "analytics.txt");
        Path binaryPath = Paths.get("data", "analytics.bin");

        registry.addRecord(new GradeSnapshot("ID001", LocalDate.now(), "Java OOP", 95));
        registry.addRecord(new AttendanceReport("ID002", LocalDate.now(), 18, 20));
        registry.addRecord(new ActivityDigest("ID003", LocalDate.now(), "Forum Post", 15));

        System.out.println("Початкові дані");
        registry.Records().forEach(System.out::println);

        try {
            fileManager.saveAsText(registry, textPath);
            System.out.println("\nДані збережено" + textPath);
            LearningAnalyticsRegistry loadedTextRegistry = fileManager.loadFromText(textPath);
            System.out.println("\nДані відновлені");
            loadedTextRegistry.Records().forEach(System.out::println);

            fileManager.serialize(registry, binaryPath);
            System.out.println("\nКолекцію серіалізовано" + binaryPath);

            LearningAnalyticsRegistry loadedBinaryRegistry = fileManager.deserialize(binaryPath);
            System.out.println("\nДані після десеріалізації");
            loadedBinaryRegistry.Records().forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }

        System.out.println("\nПерехоплення винятку");
        try {
            Path badPath = Paths.get("data", "bad_analytics.txt");
            java.nio.file.Files.writeString(badPath, "ID004   2026-05-22 25 20");
            
            fileManager.loadFromText(badPath);
        } catch (InvalidAnalyticsDataException e) {
            System.err.println("Виняток домену: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Інша помилка: " + e.getMessage());
        }
    }
}