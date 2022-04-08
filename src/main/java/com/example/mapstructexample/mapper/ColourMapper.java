package com.example.mapstructexample.mapper;

import com.example.mapstructexample.entity.ColourEntity;
import com.example.mapstructexample.model.ColourModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring"
        , injectionStrategy = InjectionStrategy.CONSTRUCTOR
        , unmappedSourcePolicy = ReportingPolicy.ERROR // Error when the source field is unmapped
        , unmappedTargetPolicy = ReportingPolicy.ERROR // Error when the destination filed is unmapped
)
public interface ColourMapper extends BaseMapper<ColourEntity, ColourModel>{
    @Override
    @Mappings({
            @Mapping(target = "id", source = "form.id"),
            @Mapping(target = "colour", source = "form.colour")
    })
    ColourEntity modelToEntity(ColourModel form);
}
