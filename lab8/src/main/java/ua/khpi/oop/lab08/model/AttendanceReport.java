package ua.khpi.oop.lab08.model;

import java.time.LocalDate;

public class AttendanceReport extends AnalyticsRecord {
    private int presentDays;
    private int totalDays;

    public AttendanceReport(String studentId, LocalDate recordDate, int presentDays, int totalDays) {
        super(studentId, recordDate);
        this.presentDays = presentDays;
        this.totalDays = totalDays;
    }

    public String toTextLine() {
        return "Відвідуваність" + studentId + recordDate.toString() + presentDays + totalDays;
    }

    public String toString() {
        return "Відвідуваність: " + studentId + presentDays + totalDays + " днів";
    }
}