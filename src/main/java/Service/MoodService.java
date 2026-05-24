package Service;

import Controller.Resource.MoodResource;
import Entity.Mood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MoodService {
    MoodResource save(MoodResource moodResource);
    void delete(MoodResource moodResource);
    List<MoodResource> findAll();
    MoodResource findById(long id);
}
