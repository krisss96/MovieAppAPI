package Service.ServiceImpl;

import Controller.Resource.WatchlistResource;
import Entity.Watchlist;
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

    @Override
    public WatchlistResource createWatchlist(WatchlistResource watchlistResource) throws Exception {
        for(WatchlistResource temp : WATCHLIST_MAPPER.watchlistEntityToResource(watchlistRepository.findAll())) {
            //remove when adding accounts
            if(temp.getMovieResource() == watchlistResource.getMovieResource()) {
                throw new Exception("Movie already in watchlist");
            }
        }
        Watchlist temp = WATCHLIST_MAPPER.resourceToWatchlistEntity(watchlistResource);
        watchlistRepository.save(temp);
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
