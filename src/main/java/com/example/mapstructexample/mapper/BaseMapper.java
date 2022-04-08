package com.example.mapstructexample.mapper;

import com.example.mapstructexample.entity.BaseEntity;
import com.example.mapstructexample.model.BaseModel;

public interface BaseMapper<E extends BaseEntity, F extends BaseModel> {
    E modelToEntity(F form);
}
