package ua.khpi.oop.lab05;
import java.util.Objects;

public class Person {
    private String id;
    private String name;
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDetails() {
        return "Person ID " + id + ", Name " + name + "";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    public int hashCode() {
        return Objects.hash(id);
    }
}