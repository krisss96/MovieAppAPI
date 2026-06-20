package Mapper;

import Controller.Resource.WatchlistResource;
import Entity.Watchlist;

import jakarta.persistence.Entity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WatchlistMapper {
    WatchlistMapper WATCHLIST_MAPPER = Mappers.getMapper(WatchlistMapper.class);

    @Mapping(source = "movieResource", target = "movie")
    Watchlist resourceToWatchlistEntity(WatchlistResource watchlistResource);
    @Mapping(source = "movie", target = "movieResource")
    WatchlistResource watchlistEntityToResource(Watchlist watchlist);
    @Mapping(source = "movieResource", target = "movie")
    List<Watchlist> resourceToWatchlistEntity(List<WatchlistResource> watchlistResources);
    @Mapping(source = "movie", target = "movieResource")
    List<WatchlistResource> watchlistEntityToResource(List<Watchlist> watchlists);
}
