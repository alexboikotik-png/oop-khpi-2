package ua.khpi.oop.lab14.domain;

public class Ticket {
    private final String id;
    private final String from;
    private final String to;

    public Ticket(String id, String from, String to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getId() { return id; }
    
    @Override
    public String toString() {
        return "Квиток " + id + from + to;
    }
}