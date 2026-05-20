package ua.khpi.oop.lab06;

public class QualityCheckOrder extends WorkOrder {
    private final int inspectionPoints;

    public QualityCheckOrder(String orderId, String description, double baseCost, int inspectionPoints) {
        super(orderId, description, baseCost);
        this.inspectionPoints = inspectionPoints;
    }

    public void processOrder() {
        System.out.println("Проводиться перевірка якості");
        System.out.printf("%d перевірено, відхилень не знайдено.%n", inspectionPoints);
    }

    public double TotalCost() {
        return BaseCost() + (inspectionPoints * 10.0);
    }
}