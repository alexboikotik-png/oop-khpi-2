package ua.khpi.oop.lab01;

public class VolunteerProject {
    private String pId;
    private String title;
    private boolean active;
    private Coordinator coordinator;

    public VolunteerProject(String pId, String title, boolean active, Coordinator coordinator) {
        this.pId = pId;
        this.title = title;
        this.active = active;
        this.coordinator = coordinator;
    }
 
    public VolunteerProject(String pId, String title, Coordinator coordinator) {
        this(pId, title, true, coordinator);
    }

    public void completeProject() {
        this.active = false;
        System.out.println("Проект '[" + pId + "] '" + title + "' завершено.");
    }

    public void assignVolunteer(Volunteer v) {
        System.out.println("Волонтера " + v.getName() + " залучено до проєкту '" + title + "'.");
    }

    public String toString() {
        return "Проект: " + title + " (Активність: " + active + "), Лідер: " + coordinator.getName();
    }
}