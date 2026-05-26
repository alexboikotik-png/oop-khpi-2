package ua.khpi.oop.lab14;

import ua.khpi.oop.lab14.domain.Booking;
import ua.khpi.oop.lab14.domain.Ticket;
import ua.khpi.oop.lab14.domain.Trip;
import ua.khpi.oop.lab14.threads.BookingCheckerTask;
import ua.khpi.oop.lab14.threads.PlanGeneratorTask;
import ua.khpi.oop.lab14.threads.RouteBuilderThread;

public class Main {
    public static void main(String[] args) {

        Trip myTrip = new Trip("Літні канікули в Європі");
        myTrip.addTicket(new Ticket("T1", "Київ", "Варшава"));
        myTrip.addTicket(new Ticket("T2", "Варшава", "Париж"));
        myTrip.addBooking(new Booking("B1", "Готель Варшава"));
        myTrip.addBooking(new Booking("B2", "Готель Париж"));

        RouteBuilderThread routeThread = new RouteBuilderThread(myTrip);
        
        Thread bookingThread = new Thread(new BookingCheckerTask(myTrip), "Бронування");
        Thread planThread = new Thread(new PlanGeneratorTask(myTrip), "План");

        try {
            System.out.println("Запуск фонові завдання");
            routeThread.start();
            bookingThread.start();

            System.out.println("Очікування на перевірку та побудову маршрутів\n");
            routeThread.join();
            bookingThread.join();

            System.out.println("\nПідготовка завершена");
            planThread.start();
            planThread.join();

        } catch (InterruptedException e) {
            System.err.println("Головний потік перервано");
        }
        System.out.println("\nРобота завершена");
        System.out.println(myTrip.getFinalPlan());
    }
}