package lab1.scr;

public class Main {
    public static void main(String[] args) {
        // Створюємо координаторів. Зверни увагу, що coord1 та coord2 мають однаковий ID.
        Coordinator coord1 = new Coordinator("C-01", "Олена Петрівна");
        Coordinator coord2 = new Coordinator("C-01", "Олена Петрівна"); 
        Coordinator coord3 = new Coordinator("C-02", "Іван Франко");

        // Створюємо волонтера
        Volunteer vol1 = new Volunteer("V-10", "Тарас Шевченко");

        // Використовуємо скорочений конструктор (проєкт одразу активний)
        VolunteerProject proj1 = new VolunteerProject("P-100", "Збір теплих речей", coord1);
        
        // Демонстрація предметних методів
        proj1.assignVolunteer(vol1);
        proj1.completeProject();

        System.out.println("\n--- Демонстрація методу toString() ---");
        System.out.println(proj1.toString());

        System.out.println("\n--- Демонстрація equals() та hashCode() ---");
        // Перевірка equals() - має повернути true, бо ID співпадають
        System.out.println("coord1.equals(coord2): " + coord1.equals(coord2)); 
        // Перевірка equals() - має повернути false
        System.out.println("coord1.equals(coord3): " + coord1.equals(coord3)); 

        System.out.println("hashCode coord1: " + coord1.hashCode());
        System.out.println("hashCode coord2: " + coord2.hashCode());
    }
}