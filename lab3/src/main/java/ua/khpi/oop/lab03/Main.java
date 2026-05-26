package ua.khpi.oop.lab03;
public class Main {
    public static void main(String[] args) {

        Director director = new Director("D-01", "Олександр Петрович");

        Coordinator coord1 = new Coordinator("C-10", "Анна Іванова");
        Coordinator coord2 = new Coordinator("C-11", "Максим кач");

        director.hireCoordinator(coord1);
        director.hireCoordinator(coord2);

        Project ecoProject = coord1.createProject("P-100", "Очищення парку");

        Volunteer vol1 = new Volunteer("V-01", "Олег");
        Volunteer vol2 = new Volunteer("V-02", "Марія");

        coord1.hireVolunteer(ecoProject, vol1);
        coord1.hireVolunteer(ecoProject, vol2);

        System.out.println(director.result());
        System.out.println(coord1.result());
        System.out.println(ecoProject.result());

        ecoProject.complete();
        System.out.println(ecoProject.result());
    }
}