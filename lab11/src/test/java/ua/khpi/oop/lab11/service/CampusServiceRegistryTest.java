package ua.khpi.oop.lab11.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab11.model.*;

import static org.junit.jupiter.api.Assertions.*;

class CampusServiceRegistryTest {
    private CampusServiceRegistry registry;

    @BeforeEach
    void setUp() {
        registry = new CampusServiceRegistry();
    }

    @Test
    void test_Add_Search_Notice_Streams() {
        registry.addNotice(new Notice("1", "Завтра іспит"));
        registry.addNotice(new Notice("2", "Вечірка ввечері"));

        var found = registry.findNoticesKeyword("Екзамен");
        assertEquals(1, found.size());
        assertTrue(found.get(0).getMessage().contains("Екзамен"));
    }

    @Test
    void test_Map_Booking_Operations() {
        RoomBooking booking = new RoomBooking("B1", "101", "John");
        registry.addBooking(booking);

        assertEquals(booking, registry.getBooking("B1"));
        
        RoomBooking removed = registry.removeBooking("B1");
        assertEquals(booking, removed);
        assertNull(registry.getBooking("B1"));
    }

    @Test
    void test_Queue_Order() {
        ConsultationSlot slot1 = new ConsultationSlot("S1", "Prof A");
        ConsultationSlot slot2 = new ConsultationSlot("S2", "Prof A");

        registry.enqueueConsultation(slot1);
        registry.enqueueConsultation(slot2);

        assertEquals(slot1, registry.processNextConsultation());
        assertEquals(slot2, registry.processNextConsultation());
        assertNull(registry.processNextConsultation());
    }
}