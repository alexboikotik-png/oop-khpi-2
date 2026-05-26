package ua.khpi.oop.lab13.service;

import ua.khpi.oop.lab13.model.CampusRecord;
import java.util.List;


public class ReportGenerator {

    public String generateReport(List<CampusRecord> records) {

        StringBuilder report = new StringBuilder();
        
        report.append("Звіт\n");
        report.append(String.format("Успішно оброблено записів: %d\n\n", records.size()));

        for (CampusRecord record : records) {
            report.append("Запис   ").append(record.getCode()).append("\n");
            report.append("Тип   ").append(record.getType()).append("\n");
            report.append("Час події   ").append(record.getTime()).append("\n");
            report.append("Опис   ").append(record.getDescription()).append("\n");
        }

        return report.toString();
    }
}