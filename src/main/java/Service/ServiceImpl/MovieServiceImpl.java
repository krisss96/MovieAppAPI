package Service.ServiceImpl;

import Controller.Resource.MovieResource;
import Entity.Feeling;
import Entity.Movie;
import Entity.Mood;
import Entity.Platform;
import Mapper.FeelingMapper;
import Repository.FeelingRepository;
import Repository.MoodRepository;
import Repository.MovieRepository;
import Repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Service.MovieService;

import java.util.ArrayList;
import java.util.List;

import static Mapper.MovieMapper.MOVIE_MAPPER;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MoodRepository moodRepository;
    private final PlatformRepository platformRepository;
    private final FeelingRepository feelingRepository;

    @Override
    @Transactional
    public MovieResource save(MovieResource movieResource) {
        Movie movie = MOVIE_MAPPER.resourceToMovieEntity(movieResource);

        if (movie.getMood() != null && movie.getMood().getName() != null) {
            Mood mood = moodRepository.findByName(movie.getMood().getName());
            if (mood == null) {
                mood = moodRepository.save(movie.getMood());
            }
            movie.setMood(mood); // set- overwrite the mood in the movie with the managed entity
        }

        if (movie.getPlatform() != null && movie.getPlatform().getName() != null) {
            Platform platform = platformRepository.getPlatformByName(movie.getPlatform().getName());
            if (platform == null) {
                platform = platformRepository.save(movie.getPlatform());
            } else if (movie.getPlatform().getImagePath() != null) {
                platform.setImagePath(movie.getPlatform().getImagePath());
                platform = platformRepository.save(platform);
            }
            movie.setPlatform(platform);
        }

        if (movie.getFeelings() != null) {
            List<Feeling> managedFeelings = new ArrayList<>();
            for (Feeling feeling : movie.getFeelings()) {
                Feeling existingFeeling = feelingRepository.findByFeeling(feeling.getFeeling());
                managedFeelings.add(existingFeeling != null ? existingFeeling : feelingRepository.save(feeling));
            }
            movie.setFeelings(managedFeelings);
        }

        Movie savedMovie = movieRepository.save(movie);
        return MOVIE_MAPPER.movieEntityToResource(savedMovie);
    }

    @Override
    @Transactional
    public void delete(MovieResource movieResource) {
        movieRepository.deleteByTitle(movieResource.getTitle());
    }

    @Override
    public List<MovieResource> findAll() {
        return MOVIE_MAPPER.movieEntityToResourceList(movieRepository.findAll());
    }

    @Override
    public MovieResource findByTitle(String title) {
        return MOVIE_MAPPER.movieEntityToResource(movieRepository.findByTitle(title));
    }

    @Override
    public List<MovieResource> findByMood(String mood) {
        return MOVIE_MAPPER.movieEntityToResourceList(movieRepository.findByMood_Name(mood));
    }
}
