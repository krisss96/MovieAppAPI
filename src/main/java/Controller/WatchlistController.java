package Controller;

import Controller.Resource.WatchlistResource;
import Service.WatchlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("finder/api/watchlist")
public class WatchlistController {
    private final WatchlistService watchlistService;

    @PostMapping("/add")
    public WatchlistResource addWatchlist(@RequestBody WatchlistResource watchlistResource) throws Exception {
        watchlistResource.setUID("123456789");
        return watchlistService.createWatchlist(watchlistResource);
    }

    @GetMapping("/{id}")
    public WatchlistResource getWatchlist(@PathVariable long id) throws Exception {
        return watchlistService.getWatchlist(id);
    }

    @GetMapping("/all")
    public List<WatchlistResource> getAllWatchlist() {
        return  watchlistService.getWatchlists();
    }

    @DeleteMapping("/delete/{uid}")
    public void deleteWatchlist(@PathVariable long uid) {
        watchlistService.deleteWatchlist(uid);
    }
}
