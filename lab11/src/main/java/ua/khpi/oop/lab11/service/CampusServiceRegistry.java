package ua.khpi.oop.lab11.service;

import ua.khpi.oop.lab11.model.*;
import java.util.*;
import java.util.stream.Collectors;

public class CampusServiceRegistry {
    private final List<Notice> notices = new ArrayList<>();
    private final Map<String, RoomBooking> bookingsId = new HashMap<>();
    private final Queue<ConsultationSlot> consultationQueue = new LinkedList<>();

    public void addNotice(Notice notice) {
        notices.add(notice);
    }

    public List<Notice> getAllNotices() {
        return Collections.unmodifiableList(notices);
    }

    public List<Notice> findNoticesKeyword(String keyword) {
        return notices.stream()
                .filter(n -> n.getMessage().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void addBooking(RoomBooking booking) {
        bookingsId.put(booking.getBookingId(), booking);
    }

    public RoomBooking getBooking(String bookingId) {
        return bookingsId.get(bookingId);
    }

    public RoomBooking removeBooking(String bookingId) {
        return bookingsId.remove(bookingId);
    }

    public Map<String, RoomBooking> getAllBookings() {
        return Collections.unmodifiableMap(bookingsId);
    }

    public void enqueueConsultation(ConsultationSlot slot) {
        consultationQueue.offer(slot);
    }

    public ConsultationSlot processNextConsultation() {
        return consultationQueue.poll();
    }
    
    public int getConsultationQueueSize() {
        return consultationQueue.size();
    }
}