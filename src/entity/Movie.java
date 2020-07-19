package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "movie_actors",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors = new HashSet<>();

    public Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
