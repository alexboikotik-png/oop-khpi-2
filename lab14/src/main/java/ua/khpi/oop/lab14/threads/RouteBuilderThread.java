package ua.khpi.oop.lab14.threads;

import ua.khpi.oop.lab14.domain.Ticket;
import ua.khpi.oop.lab14.domain.Trip;

public class RouteBuilderThread extends Thread {
    private final Trip trip;

    public RouteBuilderThread(Trip trip) {
        super("Шлях");
        this.trip = trip;
    }

    public void run() {
        System.out.println(getName() + " розпочав аналіз маршруту");
        try {
            for (Ticket ticket : trip.getTickets()) {
                System.out.println(getName() + " Опрацювання квитка: " + ticket.getId());
                Thread.sleep(800); 
            }
            System.out.println(getName() + " Маршрут успішно побудовано");
        } catch (InterruptedException e) {
            System.out.println(getName() + " Роботу було перервано");
            Thread.currentThread().interrupt(); 
        }
    }
}