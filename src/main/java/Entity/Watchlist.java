package Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class Watchlist {
    @Id
    @GeneratedValue
    private long id;

    @Getter
    @Setter
    @ManyToOne
    private Movie movie;
    private String UID;
}
