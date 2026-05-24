package Mapper;

import Controller.Resource.PlatformResource;
import Entity.Platform;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlatformMapper {
    PlatformMapper PLATFORM_MAPPER = Mappers.getMapper(PlatformMapper.class);

    PlatformResource toPlatformResource(Platform platform);
    Platform toPlatformEntity(PlatformResource platformResource);
    List<PlatformResource> toPlatformResourceList(List<Platform> platformList);
    List<Platform> toPlatformList(List<PlatformResource> platformResourceList);
}
