package Service.ServiceImpl;

import Controller.Resource.PlatformResource;
import Entity.Platform;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import Service.PlatformService;
import Repository.PlatformRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static Mapper.PlatformMapper.PLATFORM_MAPPER;

@Service
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {
    private final PlatformRepository platformRepository;

    @Override
    @Transactional
    public PlatformResource save(PlatformResource platformResource) {
        Platform convertedPlatform = PLATFORM_MAPPER.toPlatformEntity(platformResource);
        platformRepository.save(convertedPlatform);
        return platformResource;
    }

    @Override
    @Transactional
    public void delete(PlatformResource platformResource) {
            Platform convertedPlatform = PLATFORM_MAPPER.toPlatformEntity(platformResource);
            platformRepository.deleteByName(convertedPlatform.getName());
    }

    @Override
    public List<PlatformResource> findAll() {
        return PLATFORM_MAPPER.toPlatformResourceList(platformRepository.findAll());
    }

    @Override
    public PlatformResource findById(long id) {
        Platform platform = platformRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Platform with id " + id + " not found"));
        return PLATFORM_MAPPER.toPlatformResource(platform);
    }

    @Override
    public PlatformResource findByMovieId(long movieId) {
        Platform platform = platformRepository.findByMovies_Id(movieId);
        if(platform == null){
            throw new RuntimeException("Movie is not on any platform.");
        }
        return PLATFORM_MAPPER.toPlatformResource(platform);
    }
}
