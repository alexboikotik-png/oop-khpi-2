package ua.khpi.oop.lab05;

public class Volunteer extends Person {
    private String primarySkill;
    public Volunteer(String id, String name, String primarySkill) {
        super(id, name);
        this.primarySkill = primarySkill;
    }
    public String getPrimarySkill() { return primarySkill; }

    public String getDetails() {
        return super.getDetails() + " Volunteer навичка " + primarySkill + "";
    }
}