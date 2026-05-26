package ua.khpi.oop.lab08.model;

import java.time.LocalDate;

public class ActivityDigest extends AnalyticsRecord {
    private String activityType;
    private int points;

    public ActivityDigest(String studentId, LocalDate recordDate, String activityType, int points) {
        super(studentId, recordDate);
        this.activityType = activityType;
        this.points = points;
    }

    public String toTextLine() {
        return "Активність" + studentId + recordDate.toString() + activityType + points;
    }

    public String toString() {
        return "Активність: " + studentId + activityType + "   Бали: " + points;
    }
}