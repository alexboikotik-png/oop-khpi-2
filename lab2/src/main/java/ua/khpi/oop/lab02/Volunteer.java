package ua.khpi.oop.lab02;

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

    public String result() {
        return "Волонтер [" + vId + "] - " + name;
    }
}