package Mapper;

import Controller.Resource.FeelingResource;
import Entity.Feeling;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FeelingMapper {
    FeelingMapper FEELING_MAPPER = Mappers.getMapper(FeelingMapper.class);

     FeelingResource feelingEntityToResource(Feeling feeling);
     Feeling resourceToFeelingEntity(FeelingResource feelingResource);
     List<FeelingResource> feelingEntityListToResourceList(List<Feeling> feelings);
     List<Feeling> resourceListToFeelingEntityList(List<FeelingResource> feelingResources);
}
