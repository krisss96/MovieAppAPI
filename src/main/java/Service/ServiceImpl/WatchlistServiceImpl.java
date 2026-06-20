package Service.ServiceImpl;

import Controller.Resource.WatchlistResource;
import Entity.Movie;
import Entity.Watchlist;
import Repository.MovieRepository;
import Repository.WatchlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Service.WatchlistService;

import java.util.List;

import static Mapper.WatchlistMapper.WATCHLIST_MAPPER;
@Service
@RequiredArgsConstructor
public class WatchlistServiceImpl implements WatchlistService {
    private final WatchlistRepository watchlistRepository;
    private final MovieRepository movieRepository;

    @Override
    public WatchlistResource createWatchlist(WatchlistResource watchlistResource) throws Exception {
        if (watchlistResource.getMovieResource() == null || watchlistResource.getMovieResource().getTitle() == null) {
            throw new IllegalArgumentException("Movie title must be provided.");
        }

        String incomingTitle = watchlistResource.getMovieResource().getTitle();

        Movie tempMovie = movieRepository.getMovieByTitle(incomingTitle);
        if (tempMovie == null) {
            throw new Exception("Movie not found in database: " + incomingTitle);
        }

        Watchlist temp = WATCHLIST_MAPPER.resourceToWatchlistEntity(watchlistResource);
        temp.setMovie(tempMovie);

        boolean alreadyExists = watchlistRepository.existsByUIDAndMovie(temp.getUID(), tempMovie);
        if (alreadyExists) {
            throw new Exception("Movie already in watchlist");
        }

        temp = watchlistRepository.save(temp);
        return WATCHLIST_MAPPER.watchlistEntityToResource(temp);
    }
    @Override
    public List<WatchlistResource> getWatchlists() {
        List<Watchlist> result = watchlistRepository.findAll();
        return WATCHLIST_MAPPER.watchlistEntityToResource(result);
    }

    @Override
    public WatchlistResource getWatchlist(long id) {
        Watchlist result = watchlistRepository.getWatchlistById(id);
        return WATCHLIST_MAPPER.watchlistEntityToResource(result);
    }

    @Override
    public void deleteWatchlist(long id) {
        watchlistRepository.deleteById(id);
    }
}
