package ua.khpi.oop.lab08.service;

import ua.khpi.oop.lab08.model.AnalyticsRecord;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LearningAnalyticsRegistry implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final List<AnalyticsRecord> records = new ArrayList<>();

    public void addRecord(AnalyticsRecord record) {
        records.add(record);
    }

    public List<AnalyticsRecord> Records() {
        return List.copyOf(records);
    }

    public Optional<AnalyticsRecord> findStudentId(String studentId) {
        return records.stream()
                .filter(r -> r.StudentId().equalsIgnoreCase(studentId))
                .findFirst();
    }
}