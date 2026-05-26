package ua.khpi.oop.lab11.model;

import java.util.Objects;

public class RoomBooking {
    private final String bookingId;
    private final String roomNumber;
    private final String bookedBy;

    public RoomBooking(String bookingId, String roomNumber, String bookedBy) {
        this.bookingId = bookingId;
        this.roomNumber = roomNumber;
        this.bookedBy = bookedBy;
    }

    public String getBookingId() { return bookingId; }
    public String getRoomNumber() { return roomNumber; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomBooking that = (RoomBooking) o;
        return Objects.equals(bookingId, that.bookingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId);
    }

    @Override
    public String toString() {
        return "Бронювання Кімната " + roomNumber + " Заброньовано " + bookedBy;
    }
}