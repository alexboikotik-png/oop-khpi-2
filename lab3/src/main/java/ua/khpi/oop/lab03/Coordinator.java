package ua.khpi.oop.lab03;

import java.util.Objects;

public class Coordinator {
    private String cId;
    private String name;

    public Coordinator(String cId, String name) {
        this.cId = cId;
        this.name = name;
    }

    public Project createProject(String pId, String title) {
        System.out.println("Координатор " + this.name + " створив новий проект: " + title);
        return new Project(pId, title, true);
    }

    public void hireVolunteer(Project project, Volunteer volunteer) {
        System.out.println("Координатор " + this.name + " призначає волонтера " + volunteer.getName() + " на проект.");
        project.addVolunteer(volunteer); 
    }

    public String result() {
        return "Координатор [" + cId + "] - " + name;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinator other = (Coordinator) obj;
        return Objects.equals(cId, other.cId);
    }

    public int hashCode() {
        return Objects.hash(cId);
    }
}