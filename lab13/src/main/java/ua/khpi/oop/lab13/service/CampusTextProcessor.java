package ua.khpi.oop.lab13.service;

import ua.khpi.oop.lab13.model.CampusRecord;
import ua.khpi.oop.lab13.model.RecordType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CampusTextProcessor {
    private static final String CODE_REGEX = "^[A-Z]{3}-\\d{3}$";
    private static final Pattern TIME_PATTERN = Pattern.compile("\\b(?:[01]?\\d|2[0-3]):[0-5]\\d\\b");


    public List<CampusRecord> processLines(List<String> rawLines) {
        List<CampusRecord> validRecords = new ArrayList<>();

        for (String line : rawLines) {
            if (line == null || line.trim().isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\.");
            if (parts.length < 3) {
                System.out.println("Помилка формату рядка: " + line);
                continue;
            }

            String rawCode = parts[0].trim();
            String rawType = parts[1].trim();
            String rawDescription = parts[2].trim();

            if (!rawCode.matches(CODE_REGEX)) {
                System.out.println("Відхилено: " + rawCode);
                continue;
            }

            RecordType type;
            try {
                type = RecordType.valueOf(rawType.toUpperCase());
            } catch (IllegalArgumentException e) {
                type = RecordType.UNKNOWN;
            }

            String cleanDescription = rawDescription.replaceAll("\\s+", " ");
            String time = "Не вказано";
            Matcher timeMatcher = TIME_PATTERN.matcher(cleanDescription);
            if (timeMatcher.find()) {
                time = timeMatcher.group();
            }

            validRecords.add(new CampusRecord(rawCode, type, time, cleanDescription));
        }

        return validRecords;
    }
}