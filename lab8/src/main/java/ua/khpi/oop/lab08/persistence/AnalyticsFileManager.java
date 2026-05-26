package ua.khpi.oop.lab08.persistence;

import ua.khpi.oop.lab08.exception.InvalidAnalyticsDataException;
import ua.khpi.oop.lab08.model.*;
import ua.khpi.oop.lab08.service.LearningAnalyticsRegistry;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class AnalyticsFileManager {
    public void saveAsText(LearningAnalyticsRegistry registry, Path path) throws IOException {
        ensureDirectory(path);
        List<String> lines = registry.Records().stream()
                .map(AnalyticsRecord::toTextLine)
                .toList();
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    public LearningAnalyticsRegistry loadFromText(Path path) throws IOException, InvalidAnalyticsDataException {
        LearningAnalyticsRegistry registry = new LearningAnalyticsRegistry();
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        
        int lineNumber = 1;
        for (String line : lines) {
            if (line.isBlank()) {
                lineNumber++;
                continue;
            }
            try {
                registry.addRecord(parseLine(line));
            } catch (Exception e) {
                throw new InvalidAnalyticsDataException("Помилка формату у рядку " + lineNumber + line, e);
            }
            lineNumber++;
        }
        return registry;
    }

    public void serialize(LearningAnalyticsRegistry registry, Path path) throws IOException {
        ensureDirectory(path);
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(registry);
        }
    }
    public LearningAnalyticsRegistry deserialize(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            return (LearningAnalyticsRegistry) ois.readObject();
        }
    }

    private AnalyticsRecord parseLine(String line) throws InvalidAnalyticsDataException {
        String[] parts = line.split(";", -1);
        if (parts.length < 5) {
            throw new InvalidAnalyticsDataException("Недостатньо даних");
        }

        String type = parts[0];
        String studentId = parts[1];
        LocalDate date = LocalDate.parse(parts[2]);

        return switch (type) {
            case "GRADE" -> {
                int grade = Integer.parseInt(parts[4]);
                if (grade < 0 || grade > 100) throw new InvalidAnalyticsDataException("Оцінка поза межами: " + grade);
                yield new GradeSnapshot(studentId, date, parts[3], grade);
            }
            case "ATTENDANCE" -> {
                int present = Integer.parseInt(parts[3]);
                int total = Integer.parseInt(parts[4]);
                if (present > total || present < 0) throw new InvalidAnalyticsDataException("Некоректні дні: " + present);
                yield new AttendanceReport(studentId, date, present, total);
            }
            case "ACTIVITY" -> {
                int points = Integer.parseInt(parts[4]);
                if (points < 0) throw new InvalidAnalyticsDataException("Бали не можуть бути від'ємними");
                yield new ActivityDigest(studentId, date, parts[3], points);
            }
            default -> throw new InvalidAnalyticsDataException("Невідомий тип запису: " + type);
        };
    }

    private void ensureDirectory(Path path) throws IOException {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
    }
}