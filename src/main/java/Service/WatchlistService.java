package Service;

import Controller.Resource.WatchlistResource;
import Entity.Watchlist;

import java.util.List;

public interface WatchlistService {
    WatchlistResource createWatchlist(WatchlistResource watchlistResource) throws Exception;
    List<WatchlistResource> getWatchlists();
    WatchlistResource getWatchlist(long id);
    void deleteWatchlist(long id);
}
