package mk.finki.ukim.mk.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматско генерирање на уникатно ID

    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double popularityScore;
    @ManyToOne
    private Location location;

    // konsturktorot bez id, bodejki samo se generira so random
    public Event(String name, String description, double popularityScore, Location location) {
        this.id = (long) (Math.random() * 1000);  // generira random id
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
    }

    public Event() {

    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPopularityScore() {
        return popularityScore;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPopularityScore(double popularityScore) {
        this.popularityScore = popularityScore;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
