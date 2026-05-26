package ua.khpi.oop.lab01;
import java.util.Objects;

public class Coordinator {
    private String cId;
    private String name;

    public Coordinator(String cId, String name) {
        this.cId = cId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Coordinator{ID='" + cId + "', Name='" + name + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinator that = (Coordinator) o;
        return Objects.equals(cId, that.cId);
    }

    public int hashCode() {
        return Objects.hash(cId);
    }
}