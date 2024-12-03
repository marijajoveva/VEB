package mk.finki.ukim.mk.demo.service;

import mk.finki.ukim.mk.demo.model.EventBooking;

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
}
