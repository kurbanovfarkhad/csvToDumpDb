package com.example.mapstructexample.mapper;

import com.example.mapstructexample.entity.ColourEntity;
import com.example.mapstructexample.entity.PersonEntity;
import com.example.mapstructexample.entity.PetEntity;
import com.example.mapstructexample.mapper.qualifier.StringToListQualifier;
import com.example.mapstructexample.model.PersonModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring"
        , injectionStrategy = InjectionStrategy.CONSTRUCTOR
//        , unmappedSourcePolicy = ReportingPolicy.ERROR // Error when the source field is unmapped
        , unmappedTargetPolicy = ReportingPolicy.ERROR // Error when the destination filed is unmapped
)
public interface PersonMapper extends BaseMapper<PersonEntity, PersonModel> {

    @Override
    @Mappings({
            @Mapping(target = "id", source = "form.id"),
            @Mapping(target = "surname", source = "form.name"),
            @Mapping(target = "test", ignore = true),
            @Mapping(target = "favoriteColour", source = "form.favoriteColour", qualifiedByName = "colourID"),
            @Mapping(target = "pets", ignore = true)
    })
    PersonEntity modelToEntity(PersonModel form);

    @Named("colourID")
    default ColourEntity colourMap(String value){
        final ColourEntity colourEntity = new ColourEntity();
        colourEntity.setId(value);
        return colourEntity;
    }
    @Named("colourID")
    default List<PetEntity> petMap(String value){
        final PetEntity colourEntity = new PetEntity();
        colourEntity.setId(value);
        return List.of(colourEntity);
    }
}
