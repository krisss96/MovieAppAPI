package Repository;

import Entity.Feeling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeelingRepository extends JpaRepository<Feeling, Long> {
    List<Feeling> findDistinctByMovies_Id(Long movieId);
    Feeling findByFeeling(String feeling);
    void deleteById(Long id);
    void deleteByFeeling(String feeling);
}
