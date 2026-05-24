package Service;

import Controller.Resource.FeelingResource;
import Controller.Resource.MoodResource;

import java.util.List;

public interface FeelingService {
    FeelingResource save(FeelingResource feelingResource);
    void delete(FeelingResource feelingResource);
    List<FeelingResource> findAll();
    FeelingResource findById(long id);
    List<FeelingResource> findFeelingsForMovieByMovieId(long movieId);
}
