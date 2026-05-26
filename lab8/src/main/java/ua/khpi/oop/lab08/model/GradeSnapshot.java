package ua.khpi.oop.lab08.model;

import java.time.LocalDate;

public class GradeSnapshot extends AnalyticsRecord {
    private String courseName;
    private int grade;

    public GradeSnapshot(String studentId, LocalDate recordDate, String courseName, int grade) {
        super(studentId, recordDate);
        this.courseName = courseName;
        this.grade = grade;
    }

    public String toTextLine() {
        return "Оцінка;" + studentId + recordDate.toString() + courseName + grade;
    }

    public String toString() {
        return "Оцінка: " + studentId + courseName + " Оцінка: " + grade;
    }
}