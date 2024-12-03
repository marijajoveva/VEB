package mk.finki.ukim.mk.demo.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.demo.model.Event;
import mk.finki.ukim.mk.demo.model.Location;
import mk.finki.ukim.mk.demo.repository.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events;
    private final LocationRepository locationRepository;
    public static List<Location> locations;


    public DataHolder(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @PostConstruct
    public void init() {
        events =new ArrayList<>();
        locations = new ArrayList<>();

        // Initializing 5 Location instances
        locations.add(new Location(1L, "Stadium", "Partizanska", "5000", "Outdoor stadium"));
        locations.add(new Location(2L, "Concert Hall", "Balzakova", "1000", "Indoor concert hall"));
        locations.add(new Location(3L, "Amphitheater", "Turisticka", "2000", "Open air amphitheater"));
        locations.add(new Location(4L, "Club", "Ruzveltova", "500", "Nightclub with live music"));
        locations.add(new Location(5L, "Arena", "Bulevar JS", "8000", "Indoor arena"));



        events.add(new Event("E1", "Rock and roll", 10, locations.get(0)));
        events.add(new Event("E2", "Blues", 9, locations.get(1)));
        events.add(new Event("E3", "Jazz", 8, locations.get(2)));
        events.add(new Event("E4", "RnB", 6, locations.get(3)));
        events.add(new Event("E5", "RnB", 7.3, locations.get(4)));
        events.add(new Event("E6", "Rock and roll", 1, locations.get(0)));
        events.add(new Event("E7", "Jazz", 4, locations.get(1)));
        events.add(new Event("E8", "Jazz", 6, locations.get(2)));
        events.add(new Event("E9", "RnB", 9, locations.get(3)));
        events.add(new Event("E10", "Blues", 1, locations.get(4)));
    }
}
