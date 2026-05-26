package ua.khpi.oop.lab14.domain;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private final String tripName;
    private final List<Ticket> tickets = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();
    private String finalPlan = "План не сформовано.";

    public Trip(String tripName) {
        this.tripName = tripName;
    }

    public void addTicket(Ticket ticket) { tickets.add(ticket); }
    public void addBooking(Booking booking) { bookings.add(booking); }

    public List<Ticket> getTickets() { return tickets; }
    public List<Booking> getBookings() { return bookings; }
    
    public String getTripName() { return tripName; }
    public String getFinalPlan() { return finalPlan; }
    public void setFinalPlan(String finalPlan) { this.finalPlan = finalPlan; }
}