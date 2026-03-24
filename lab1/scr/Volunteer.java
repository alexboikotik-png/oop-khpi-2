package lab1.scr;

/**
 * Клас, що представляє волонтера.
 */
public class Volunteer {
    private String volunteerId;
    private String fullName;

    public Volunteer(String volunteerId, String fullName) {
        this.volunteerId = volunteerId;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Volunteer{fullName='" + fullName + "'}";
    }
}