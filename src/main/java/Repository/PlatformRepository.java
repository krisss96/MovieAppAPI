package Repository;

import Entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
     Platform getPlatformByName(String name);
     void deleteByName(String name);
     Platform findByMovies_Id(Long movieId);

}
