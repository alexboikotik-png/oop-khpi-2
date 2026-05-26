package ua.khpi.oop.lab13;

import ua.khpi.oop.lab13.model.CampusRecord;
import ua.khpi.oop.lab13.service.CampusTextProcessor;
import ua.khpi.oop.lab13.service.ReportGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("src/main/resources/campus_data.txt");
        
        CampusTextProcessor processor = new CampusTextProcessor();
        ReportGenerator reportGenerator = new ReportGenerator();

        try {
            System.out.println("Зчитування файлу: " + filePath.toAbsolutePath());
            List<String> rawLines = Files.readAllLines(filePath);
            
            System.out.println("\nОбробка даних");
            List<CampusRecord> processedRecords = processor.processLines(rawLines);
            
            System.out.println("\nЗвіт");
            String finalReport = reportGenerator.generateReport(processedRecords);
            System.out.println(finalReport);
            
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}