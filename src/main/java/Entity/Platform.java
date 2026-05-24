package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Platform {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private String imagePath;

    @OneToMany(mappedBy = "platform", cascade = CascadeType.ALL)
    private List<Movie> movies;
}
