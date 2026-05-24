package Service;

import Controller.Resource.MovieResource;
import Repository.MovieRepository;

import java.util.List;

public interface MovieService {
    MovieResource save(MovieResource movieResource);
    void delete(MovieResource movieResource);
    List<MovieResource> findAll();
    MovieResource findByTitle(String title);
    List<MovieResource> findByMood(String mood);
}
