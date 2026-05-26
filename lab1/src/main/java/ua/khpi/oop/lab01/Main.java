package ua.khpi.oop.lab01;

public class Main {
    public static void main(String[] args) {
  
        Coordinator lead = new Coordinator("C-01", "Олексiй");
        Coordinator leadDuplicate = new Coordinator("C-01", "Олексiй");
        
        Volunteer v1 = new Volunteer("V-10", "Марiя");
        VolunteerProject project = new VolunteerProject("P-55", "Допомога Тваринам", lead);

        System.out.println(project.toString());
        
        project.assignVolunteer(v1);
        project.completeProject();

        System.out.println("Координатори однаковi: " + lead.equals(leadDuplicate));
        System.out.println("HashCode1: " + lead.hashCode());
        System.out.println("HashCode2: " + leadDuplicate.hashCode());
    }
}