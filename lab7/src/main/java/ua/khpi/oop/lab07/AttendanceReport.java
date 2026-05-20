package ua.khpi.oop.lab07;

public class AttendanceReport implements Trackable {
    private final String studentId;
    private final int totalClasses;
    private final int attendedClasses;

    public AttendanceReport(String studentId, int totalClasses, int attendedClasses) {
        this.studentId = studentId;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public String TrackingDetails() {
        return String.format("Студент %s відвідав %d з %d занять", studentId, attendedClasses, totalClasses);
    }

    public double CompletionRate() {
        if (totalClasses == 0) return 0.0;
        return ((double) attendedClasses / totalClasses) * 100.0;
    }
}