package ua.khpi.oop.lab14.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TripDomainTest {
    
    private Trip trip;

    @BeforeEach
    void setUp() {
        trip = new Trip("Тестова поїздка");
    }

    @Test
    void test_Add_Ticket() {
        Ticket t = new Ticket("T01", "Львів", "Рим");
        trip.addTicket(t);
        
        assertEquals(1, trip.getTickets().size());
        assertEquals("Львів", trip.getTickets().get(0).getFrom());
    }

    @Test
    void test_Booking_Confirmation() {
        Booking b = new Booking("B01", "Хілтон");
        assertFalse(b.isConfirmed(), "Бронювання має бути не підтвердженим при створенні");
        
        b.confirm();
        assertTrue(b.isConfirmed(), "Бронювання має бути підтвердженим");
    }

    @Test
    void test_Final_Plan_Storage() {
        trip.setFinalPlan("Згенерований план");
        assertEquals("Згенерований план", trip.getFinalPlan());
    }
}