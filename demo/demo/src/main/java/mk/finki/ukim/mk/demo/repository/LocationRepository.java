package mk.finki.ukim.mk.demo.repository;

import mk.finki.ukim.mk.demo.bootstrap.DataHolder;
import mk.finki.ukim.mk.demo.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepository {

    public List<Location> findAll() {
        return DataHolder.locations;
    }
    public Optional<Location> findById(Long locationId) {
        // po ID prebaruvaj ja lokacijata
        return DataHolder.locations.stream()
                .filter(location -> location.getId().equals(locationId))
                .findFirst();
    }
}

