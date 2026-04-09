package ua.khpi.oop.lab03;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private String pId;
    private String title;
    private boolean status;
    
    private List<Volunteer> volunteers;

    public Project(String pId, String title, boolean status) {
        this.pId = pId;
        this.title = title;
        this.status = status;
        this.volunteers = new ArrayList<>();
    }

    public void addVolunteer(Volunteer volunteer) {
        if (status == true) { 
            volunteers.add(volunteer);
            System.out.println("До проекту '" + title + "' додано волонтера: " + volunteer.getName());
        } else {
            System.out.println("Проект '" + title + "' вже завершено.");
        }
    }

    public void complete() {
        this.status = false;
        System.out.println("Проект '" + title + "' успішно завершено!");
    }

    public String result() {
        String statusText = status ? "Ативний" : "Завершений";
        return "Проект [" + pId + "] '" + title + "' (Статус: " + statusText + "). Кількість волонтерів: " + volunteers.size();
    }
}