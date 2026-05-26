package ua.khpi.oop.lab02;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private String dId;
    private String name;
    
    private List<Coordinator> coordinators;

    public Director(String dId, String name) {
        this.dId = dId;
        this.name = name;
        this.coordinators = new ArrayList<>();
    }

    public void hireCoordinator(Coordinator coordinator) {
        coordinators.add(coordinator);
        System.out.println("Дректор " + this.name + " найняв координатора: " + coordinator.result());
    }

    public String result() {
        return "Директор [" + dId + "] - " + name + ". Підлеглих координаторів: " + coordinators.size();
    }
}