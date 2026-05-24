package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Feeling {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true) // unique - names cannot be repeated
    private String feeling;

    @ManyToMany(mappedBy = "feelings")
    private List<Movie> movies;
}
