package ua.khpi.oop.lab06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PolymorphismTest {

    @Test
    void test_Assembly_Cost_Calculation() {
        WorkOrder order = new AssemblyOrder("A1", "Test Assembly", 10.0, 4);
        double totalCost = order.TotalCost();
        assertEquals(30.0, totalCost, 0.001, "Вартість розрахована неправильно");
    }

    @Test
    void test_Maintenance_Order() {
        WorkOrder order = new MaintenanceOrder("M1", "Test Maintenance", 50.0, true);
        assertEquals(200.0, order.TotalCost(), 0.001);
    }

    @Test
    void test_Order_Polymorphism() {
        WorkOrder order = new QualityCheckOrder("Q1", "Test QC", 100.0, 3);
        assertEquals(130.0, order.TotalCost(), 0.001);
    }
    
    @Test
    void test_Abstract_Class_Instantiated() {
        WorkOrder order = new AssemblyOrder("ID-123", "Desc", 100.0, 1);
        assertEquals("ID-123", order.OrderId());
        assertEquals("Desc", order.Description());
    }
}