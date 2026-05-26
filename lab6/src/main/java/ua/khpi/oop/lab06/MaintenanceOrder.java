package ua.khpi.oop.lab06;

public class MaintenanceOrder extends WorkOrder {
    private final boolean PartsReplacement;

    public MaintenanceOrder(String orderId, String description, double baseCost, boolean PartsReplacement) {
        super(orderId, description, baseCost);
        this.PartsReplacement = PartsReplacement;
    }

    public void processOrder() {
        System.out.println("Технічне обслуговування обладнання");
        if (PartsReplacement) {
            System.out.println("Заміна зношених деталей виконана");
        } else {
            System.out.println("Заміна деталей не знадобилася");
        }
    }

    public double TotalCost() {
        return PartsReplacement ? BaseCost() + 150.0 : BaseCost();
    }
}