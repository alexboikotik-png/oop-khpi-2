package ua.khpi.oop.lab14.threads;

import ua.khpi.oop.lab14.domain.Booking;
import ua.khpi.oop.lab14.domain.Ticket;
import ua.khpi.oop.lab14.domain.Trip;

public class PlanGeneratorTask implements Runnable {
    private final Trip trip;

    public PlanGeneratorTask(Trip trip) {
        this.trip = trip;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " генерація фінального плану");
        try {
            Thread.sleep(500);
            StringBuilder plan = new StringBuilder();
            plan.append("План подорожі").append(trip.getTripName()).append("    \n");
            plan.append("Маршрут:\n");
            for (Ticket t : trip.getTickets()) {
                plan.append("  ").append(t.getFrom()).append("  ").append(t.getTo()).append("\n");
            }
            plan.append("Проживання:\n");
            for (Booking b : trip.getBookings()) {
                plan.append(" - ").append(b.getHotelName())
                    .append(" Статус: ").append(b.isConfirmed() ? "ОК" : "Помилка").append("\n");
            }
            trip.setFinalPlan(plan.toString());
            System.out.println(threadName + " План успішно створено");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}