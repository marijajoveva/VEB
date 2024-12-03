package mk.finki.ukim.mk.demo.service.impl;

import mk.finki.ukim.mk.demo.model.EventBooking;
import mk.finki.ukim.mk.demo.service.EventBookingService;

import java.util.List;

public class EventBookingImpl implements EventBookingService {
    List<EventBooking> eventBookings;

    public EventBookingImpl(List<EventBooking> eventBookings) {
        this.eventBookings = eventBookings;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        EventBooking tmp = new EventBooking(eventName,attendeeName,attendeeAddress,(long)numberOfTickets);
        eventBookings.add(tmp);
        return tmp;
    }
}
