package mk.finki.ukim.mk.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="events")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматско генерирање на уникатно ID
    private Long id;
    private String name;
    private String address;
    private String capacity;
    private String description;
    @OneToMany(mappedBy = "location") // mappedBy означува дека релацијата е дефинирана во Event класата преку полето "location"
    private List<Event> events;

    public Location(Long id, String name, String address, String capacity, String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
    }

    public Location() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
