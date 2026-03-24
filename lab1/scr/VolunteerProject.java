package lab1.scr;

public class VolunteerProject {
    private String projectId;
    private String title;
    private boolean isActive;
    private Coordinator coordinator;

    public VolunteerProject(String projectId, String title, boolean isActive, Coordinator coordinator) {
        this.projectId = projectId;
        this.title = title;
        this.isActive = isActive;
        this.coordinator = coordinator;
    }

    public VolunteerProject(String projectId, String title, Coordinator coordinator) {
        this(projectId, title, true, coordinator);
    }

    public void assignVolunteer(Volunteer volunteer) {
        if (volunteer != null && isActive) {
            System.out.println("Волонтер " + volunteer.getFullName() + " успішно долучився до проєкту '" + title + "'.");
        } else {
            System.out.println("Неможливо долучити волонтера: проєкт закритий або дані некоректні.");
        }
    }

    public void completeProject() {
        this.isActive = false;
        System.out.println("Проєкт '" + title + "' успішно завершено.");
    }

    public String toString() {
        return "VolunteerProject{" +
                "projectId='" + projectId + '\'' +
                ", title='" + title + '\'' +
                ", isActive=" + isActive +
                ", coordinator=" + coordinator +
                '}';
    }
}