package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Mood {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String moodCoverPath;

    @OneToMany(mappedBy = "mood", cascade = CascadeType.ALL)
    private List<Movie> movies;
}
