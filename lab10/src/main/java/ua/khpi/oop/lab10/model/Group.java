package ua.khpi.oop.lab10.model;

public class Group {
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public String toString() {
        return "Група: " + name;
    }
}