package ua.khpi.oop.lab10.model;

public class GradeEntry {
    private Student student;
    private String subject;
    private int grade;

    public GradeEntry(Student student, String subject, int grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    public String toString() {
        return "Запис студент = " + student.getFullName() +" предмет = " + subject + " оцінка = " + grade;
    }
}