package ua.khpi.oop.lab14.threads;

import ua.khpi.oop.lab14.domain.Booking;
import ua.khpi.oop.lab14.domain.Trip;

public class BookingCheckerTask implements Runnable {
    private final Trip trip;

    public BookingCheckerTask(Trip trip) {
        this.trip = trip;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "  розпочав перевірку бронювань");
        try {
            for (Booking booking : trip.getBookings()) {
                System.out.println(threadName + "  Зв'язок з готелем для: " + booking.getHotelName());
                Thread.sleep(1200); 
                booking.confirm();
                System.out.println(threadName + booking.getId() + " підтвердено");
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " Роботу було перервано");
            Thread.currentThread().interrupt();
        }
    }
}