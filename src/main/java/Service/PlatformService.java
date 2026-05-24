package Service;

import Controller.Resource.MoodResource;
import Controller.Resource.PlatformResource;

import java.util.List;

public interface PlatformService {
    PlatformResource save(PlatformResource platformResource);
    void delete(PlatformResource platformResource);
    List<PlatformResource> findAll();
    PlatformResource findById(long id);
    PlatformResource findByMovieId(long movieId);
}
