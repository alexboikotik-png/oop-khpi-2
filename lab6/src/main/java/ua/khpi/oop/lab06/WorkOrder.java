package ua.khpi.oop.lab06;

public abstract class WorkOrder {

    private final String orderId;
    private final String description;
    protected final double baseCost; 

    public WorkOrder(String orderId, String description, double baseCost) {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalArgumentException("ID наряду не може бути порожнім");
        }
        this.orderId = orderId;
        this.description = description;
        this.baseCost = baseCost;
    }

    public String OrderId() { return orderId; }
    public String Description() { return description; }
    public double BaseCost() { return baseCost; }


    public abstract void processOrder();
    public abstract double TotalCost();
    public void printSummary() {
        System.out.printf("Наряд %s: %s        Базова вартість: %.2f%n", orderId, description, baseCost);
    }
}