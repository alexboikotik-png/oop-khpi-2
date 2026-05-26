package ua.khpi.oop.lab11.model;

public class ConsultationSlot {
    private final String studentName;
    private final String professorName;

    public ConsultationSlot(String studentName, String professorName) {
        this.studentName = studentName;
        this.professorName = professorName;
    }

    public String getStudentName() { return studentName; }

    public String toString() {
        return "Консультація " + studentName + " з професіоналом " + professorName;
    }
}