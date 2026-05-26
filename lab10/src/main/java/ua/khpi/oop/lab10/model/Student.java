package ua.khpi.oop.lab10.model;

public class Student {
    private String fullName;
    private Group group;

    public Student(String fullName, Group group) {
        this.fullName = fullName;
        this.group = group;
    }

    public String getFullName() { return fullName; }
    public Group getGroup() { return group; }

    public String toString() {
        return "Студент ПІБ = " + fullName + group.getName();
    }
}