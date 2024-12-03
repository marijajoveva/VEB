package mk.finki.ukim.mk.demo.service;

import mk.finki.ukim.mk.demo.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> findAll();
    Optional<Event> findById(Long eventId);
    void saveEvent(String name, String description, double popularityScore, Long locationId);
    void updateEvent(Long eventId, String name, String description, double popularityScore, Long locationId);
    void deleteEvent(Long eventId);
    List<Event> listAll();
    List<Event> specialSearch(String searchText, double rating);


}
