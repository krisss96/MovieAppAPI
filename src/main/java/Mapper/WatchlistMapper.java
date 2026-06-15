package Mapper;

import Controller.Resource.WatchlistResource;
import Entity.Watchlist;

import jakarta.persistence.Entity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WatchlistMapper {
    WatchlistMapper WATCHLIST_MAPPER = Mappers.getMapper(WatchlistMapper.class);

     Watchlist resourceToWatchlistEntity(WatchlistResource watchlistResource);
     WatchlistResource watchlistEntityToResource(Watchlist watchlist);
     List<Watchlist> resourceToWatchlistEntity(List<WatchlistResource> watchlistResources);
     List<WatchlistResource> watchlistEntityToResource(List<Watchlist> watchlists);
}
