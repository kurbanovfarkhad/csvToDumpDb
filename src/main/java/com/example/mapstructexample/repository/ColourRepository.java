package com.example.mapstructexample.repository;

import com.example.mapstructexample.entity.ColourEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColourRepository extends CrudRepository<ColourEntity, String> {
}
