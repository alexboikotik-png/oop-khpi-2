package ua.khpi.oop.lab06;

public class AssemblyOrder extends WorkOrder {
    private final int partCount;

    public AssemblyOrder(String orderId, String description, double baseCost, int partCount) {
        super(orderId, description, baseCost);
        this.partCount = partCount;
    }

    public void processOrder() {
        System.out.println("Виконується збірка. Кількість деталей: " + partCount);
        System.out.println("Деталі успішно зібрані");
    }

    public double TotalCost() {

        return BaseCost() + (partCount * 5.0);
    }
}