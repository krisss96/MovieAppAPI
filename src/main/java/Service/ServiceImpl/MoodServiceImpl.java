package Service.ServiceImpl;

import Controller.Resource.MoodResource;
import Entity.Mood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Service.MoodService;
import Repository.MoodRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static Mapper.MoodMapper.MOOD_MAPPER;

@Service
@RequiredArgsConstructor
public class MoodServiceImpl implements MoodService {
    private final MoodRepository moodRepository;
    @Override
    @Transactional
    public MoodResource save(MoodResource moodResource) {
        if (moodResource.getMoodCoverPath() != null && moodResource.getMoodCoverPath().startsWith("/static/")) {
            moodResource.setMoodCoverPath(moodResource.getMoodCoverPath().substring("/static".length()));
        }
        moodRepository.save(MOOD_MAPPER.resourceToMood(moodResource));
        return moodResource;
    }

    @Override
    @Transactional
    public void delete(MoodResource moodResource) {
        moodRepository.deleteByName(moodResource.getName());
    }

    @Override
    public List<MoodResource> findAll() {
        return MOOD_MAPPER.moodEntityToResourceList(moodRepository.findAll());
    }

    @Override
    public MoodResource findById(long id) {
        Mood mood = moodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mood with id " + id + " not found"));
        return MOOD_MAPPER.moodEntityToResource(mood);
    }
}
