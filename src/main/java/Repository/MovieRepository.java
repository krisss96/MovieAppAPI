package Repository;

import Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie getMovieByTitle(String title);
    void deleteById(Long id);
    void deleteByTitle(String title);

    Movie findByTitle(String title);
    List<Movie> findByMood_Name(String moodName);
}
