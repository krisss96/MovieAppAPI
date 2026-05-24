package Service.ServiceImpl;

import Controller.Resource.FeelingResource;
import Entity.Feeling;
import Entity.Movie;
import Repository.FeelingRepository;
import Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Service.FeelingService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static Mapper.FeelingMapper.FEELING_MAPPER;

@Service
@RequiredArgsConstructor
public class FeelingServiceImpl implements FeelingService {
    private final FeelingRepository feelingRepository;
    private final MovieRepository movieRepository;
    @Override
    @Transactional
    public FeelingResource save(FeelingResource feelingResource) {
        feelingRepository.save(FEELING_MAPPER.resourceToFeelingEntity(feelingResource));
        return feelingResource;
    }

    @Override
    @Transactional
    public void delete(FeelingResource feelingResource) {
        Feeling feeling = feelingRepository.findByFeeling(feelingResource.getFeeling());
        if (feeling == null) {
            throw new RuntimeException("Feeling " + feelingResource.getFeeling() + " not found");
        }
        feelingRepository.deleteById(feeling.getId());
    }

    @Override
    public List<FeelingResource> findAll() {
        return FEELING_MAPPER.feelingEntityListToResourceList(feelingRepository.findAll());
    }

    @Override
    public FeelingResource findById(long id) {
        Feeling feeling = feelingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feeling with id " + id + " not found"));
        return FEELING_MAPPER.feelingEntityToResource(feeling);
    }

    @Override
    public List<FeelingResource> findFeelingsForMovieByMovieId(long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie with id " + movieId + " not found"));
        List<Feeling> feelingsOfMovie = feelingRepository.findDistinctByMovies_Id(movie.getId());
        return  FEELING_MAPPER.feelingEntityListToResourceList(feelingsOfMovie);
    }
}
