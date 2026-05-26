package ua.khpi.oop.lab14.domain;

public class Booking {
    private final String id;
    private final String hotelName;
    private boolean confirmed;

    public Booking(String id, String hotelName) {
        this.id = id;
        this.hotelName = hotelName;
        this.confirmed = false;
    }

    public String getId() { return id; }
    public String getHotelName() { return hotelName; }
    public boolean isConfirmed() { return confirmed; }
    
    public void confirm() { this.confirmed = true; }
    public String toString() {
        return "Бронювання " + id + hotelName + " статус: " + (confirmed ? "Підтвердено" : "Очікування");
    }
}