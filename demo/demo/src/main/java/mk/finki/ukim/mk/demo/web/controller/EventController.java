package mk.finki.ukim.mk.demo.web.controller;

import mk.finki.ukim.mk.demo.model.Event;
import mk.finki.ukim.mk.demo.service.EventService;
import mk.finki.ukim.mk.demo.model.Location;
import mk.finki.ukim.mk.demo.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    //od baranje 7, get
    @GetMapping()
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
        List<Event> events = eventService.findAll();
        model.addAttribute("events", events);
        model.addAttribute("error", error);
        return "listEvents";
    }


    //baranje 11, za add-event.html
    @GetMapping("/add-form")
    public String showEventForm(@RequestParam(required = false) Long eventId, Model model) {
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);  // Проверете дали ова се вчитува во моделот

        Event event = eventId != null ? eventService.findById(eventId).orElse(null) : null;
        model.addAttribute("event", event);

        return "add-event";
    }


    //od baranje 7 i 11, za lokacijata so save
    @PostMapping("/add")
    public String saveEvent(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double popularityScore,
            @RequestParam Long locationId) {


        // stavi ja vo bazata
        eventService.saveEvent(name, description, popularityScore, locationId);

        // stavi ja vo eventite
        return "redirect:/events";
    }


    //ova e baranje 13
    @GetMapping("/edit-form/{id}")
    public String getEditEventForm(@PathVariable Long id, Model model) {
        Event event = eventService.findById(id).get();
        if (event == null) {
            model.addAttribute("error", "Event not found!");
            return "redirect:/events";
        }
        model.addAttribute("event", event);
        model.addAttribute("locations", locationService.findAll());
        return "add-event";
    }

    @PostMapping("/edit/{eventId}")
    public String updateEvent(
            @PathVariable Long eventId,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double popularityScore,
            @RequestParam Long locationId) {

        eventService.updateEvent(eventId, name, description, popularityScore, locationId);
        return "redirect:/events";
    }


    //od baranje 7, otkako ke se izbrise neka pokazuva na event listata so nastani
    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }
}
