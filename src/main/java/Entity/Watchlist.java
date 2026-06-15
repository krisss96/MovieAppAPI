package Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Data
public class Watchlist {
    @Id
    @GeneratedValue
    private long id;

    @Getter
    @ManyToMany
    private List<Movie> movie;
    private String UID;
}
