package ua.khpi.oop.lab07;

public class GradeSnapshot implements Exportable {
    private final String studentId;
    private final double averageGrade;

    public GradeSnapshot(String studentId, double averageGrade) {
        this.studentId = studentId;
        this.averageGrade = averageGrade;
    }

    public String exportData(String format) {
        if ("JSON".equalsIgnoreCase(format)) {
            return String.format("\"studentId\": \"%s\", \"averageGrade\": %.2f", studentId, averageGrade);
        }
        return studentId + averageGrade;
    }
}