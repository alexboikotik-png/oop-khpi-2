package ua.khpi.oop.lab01;

public class Volunteer {
    private String vId;
    private String name;

    public Volunteer(String vId, String name) {
        this.vId = vId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Volunter{ID='" + vId + "', Name='" + name + "'}";
    }
}