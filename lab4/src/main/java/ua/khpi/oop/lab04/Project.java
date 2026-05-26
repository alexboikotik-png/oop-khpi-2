package ua.khpi.oop.lab04;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private String pId;
    private String title;
    private boolean status;
    private List<Volunteer> volunteers;

    public Project(String pId, String title, boolean status) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва проекту не може бути порожньою!");
        }
        this.pId = pId;
        this.title = title;
        this.status = status;
        this.volunteers = new ArrayList<>();
    }

    public void addVolunteer(Volunteer volunteer) {
        if (status) { 
            volunteers.add(volunteer);
            System.out.println("До проєкту '" + title + "' додано волонтера: " + volunteer.getName());
        } else {
            System.out.println("Помилка! Проєкт '" + title + "' вже завершено.");
        }
    }

    public void complete() {
        this.status = false;
        System.out.println("Проєкт '" + title + "' успішно завершено!");
    }

    public String result() {
        String statusText = status ? "Активний" : "Завершений";
        return "Проект [" + pId + "] '" + title + "' (Статус: " + statusText + 
               "). Кількість волонтерів: " + volunteers.size();
    }
}