package Mapper;

import Controller.Resource.MoodResource;
import Entity.Mood;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MoodMapper {
    MoodMapper MOOD_MAPPER = Mappers.getMapper(MoodMapper.class);

    MoodResource moodEntityToResource(Mood mood);
    Mood resourceToMood(MoodResource resource);
    List<Mood> resourceToMoodList(List<MoodResource> resource);
    List<MoodResource> moodEntityToResourceList(List<Mood> resource);
}
