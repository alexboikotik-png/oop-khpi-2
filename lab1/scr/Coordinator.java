package lab1.scr;

import java.util.Objects;

public class Coordinator {
    private String coordinatorId;
    private String fullName;

    public Coordinator(String coordinatorId, String fullName) {
        this.coordinatorId = coordinatorId;
        this.fullName = fullName;
    }

    public String toString() {
        return coordinatorId + fullName ;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Coordinator other)) return false;
        return Objects.equals(coordinatorId, other.coordinatorId);
    }

    public int hashCode() {
        return Objects.hash(coordinatorId);
    }
}