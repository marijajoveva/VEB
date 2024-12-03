package mk.finki.ukim.mk.demo.repository;

import mk.finki.ukim.mk.demo.bootstrap.DataHolder;
import mk.finki.ukim.mk.demo.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EventRepository {
    public List<Event> findAll(){
        return DataHolder.events;
    }
    public List<Event> searchEvents(String text){
        return DataHolder.events.stream().filter(i->i.getName().contains(text) || i.getDescription().contains(text)).collect(Collectors.toList());
    }
    public List<Event> specialSearch(String text,double rating){
        return DataHolder.events.stream().filter(i->i.getName().contains(text) && i.getPopularityScore()>=rating).collect(Collectors.toList());
    }


    public void deleteById(Long eventId) {
        DataHolder.events.removeIf(r->r.getId().equals(eventId));
    }

    public void save(Event event){
        DataHolder.events.removeIf(r->r.getId().equals(event.getId()));
        DataHolder.events.add(event);
    }

    public Optional<Event> findById(Long eventId) {
        return DataHolder.events.stream().filter(r->r.getId().equals(eventId)).findFirst();
    }
}
