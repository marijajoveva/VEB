package mk.finki.ukim.mk.demo.service;

import mk.finki.ukim.mk.demo.model.Location;
import java.util.List;
import java.util.Optional;

public interface LocationService {

    // gi vrakja site lokacii
    List<Location> findAll();

    // vrakja lokacii po ID
    Optional<Location> findById(Long locationId);
}
