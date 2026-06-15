package Controller.Resource;

import Entity.Movie;
import lombok.Data;
import lombok.Getter;

@Data
public class WatchlistResource {
    @Getter
    private MovieResource movieResource;
    private String UID;
}
