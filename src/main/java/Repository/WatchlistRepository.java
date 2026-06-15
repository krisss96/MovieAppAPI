package Repository;

import Entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    Watchlist getWatchlistById(long id);
    void deleteById(long id);
    Watchlist findByMovie_Id(Long movieId);
}
