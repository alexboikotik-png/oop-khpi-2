package ua.khpi.oop.lab06;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<WorkOrder> orders = new ArrayList<>();
        orders.add(new AssemblyOrder("101", "Збірка серверного шкафу", 50.0, 15));
        orders.add(new MaintenanceOrder("202", "Планове ТО кондиціонера", 80.0, true));
        orders.add(new MaintenanceOrder("203", "Перевірка мастила генератора", 40.0, false));
        orders.add(new QualityCheckOrder("305", "Аудит безпеки мережі", 100.0, 5));

        for (WorkOrder order : orders) {

            order.printSummary();
            order.processOrder();
            
            System.out.printf("Підсумкова вартість: %.2f%n", order.TotalCost());
        }
    }
}