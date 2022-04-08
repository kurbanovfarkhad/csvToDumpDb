package com.example.mapstructexample.mapper;

import com.example.mapstructexample.entity.PersonEntity;
import com.example.mapstructexample.entity.PetEntity;
import com.example.mapstructexample.model.PersonModel;
import com.example.mapstructexample.model.PetModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring"
        , injectionStrategy = InjectionStrategy.CONSTRUCTOR
        , unmappedSourcePolicy = ReportingPolicy.ERROR // Error when the source field is unmapped
        , unmappedTargetPolicy = ReportingPolicy.ERROR // Error when the destination filed is unmapped
)
public interface PetMapper extends BaseMapper<PetEntity, PetModel> {

    @Override
    @Mappings({
            @Mapping(target = "id", source = "form.id"),
            @Mapping(target = "name", source = "form.name"),
            @Mapping(target = "type", source = "form.type")
    })
    PetEntity modelToEntity(PetModel form);
}
