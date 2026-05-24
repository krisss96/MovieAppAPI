package Mapper;

import Controller.Resource.MovieResource;
import Entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {MoodMapper.class, PlatformMapper.class, FeelingMapper.class})
public interface MovieMapper {
    MovieMapper MOVIE_MAPPER = Mappers.getMapper(MovieMapper.class);

    Movie resourceToMovieEntity(MovieResource movieResource);
    MovieResource movieEntityToResource(Movie movie);
    List<Movie> resourceToMovieEntityList(List<MovieResource> resource);
    List<MovieResource> movieEntityToResourceList(List<Movie> movies);
}
