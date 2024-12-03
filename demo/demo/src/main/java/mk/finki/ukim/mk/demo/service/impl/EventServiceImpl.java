package mk.finki.ukim.mk.demo.service.impl;

import mk.finki.ukim.mk.demo.model.Event;
import mk.finki.ukim.mk.demo.model.Location;
import mk.finki.ukim.mk.demo.repository.EventRepository;
import mk.finki.ukim.mk.demo.repository.LocationRepository;
import mk.finki.ukim.mk.demo.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> findById(Long eventId) {
        return this.eventRepository.findById(eventId);
    }

    @Override
    public void saveEvent(String name, String description, double popularityScore, Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        Event event = new Event(name, description, popularityScore, location);
        eventRepository.save(event);
    }

    @Override
    public void updateEvent(Long eventId, String name, String description, double popularityScore, Long locationId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);

//        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> specialSearch(String searchText, double rating) {
        return eventRepository.findAll().stream()
                .filter(event -> event.getDescription().toLowerCase().contains(searchText.toLowerCase()) &&
                        event.getPopularityScore() >= rating)
                .collect(Collectors.toList());
    }
}
