package mk.finki.ukim.mk.demo.service.impl;

import mk.finki.ukim.mk.demo.model.Location;
import mk.finki.ukim.mk.demo.repository.LocationRepository;
import mk.finki.ukim.mk.demo.service.LocationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    // implementacija na findAll
    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();  //gi vrakja site lokacii od repo
    }

    // implementacija na findById
    @Override
    public Optional<Location> findById(Long locationId) {
        return locationRepository.findById(locationId);  //vrakja lokacii po ID
    }
}
