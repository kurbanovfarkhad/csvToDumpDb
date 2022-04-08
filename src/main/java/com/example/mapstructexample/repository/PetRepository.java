package com.example.mapstructexample.repository;

import com.example.mapstructexample.entity.ColourEntity;
import com.example.mapstructexample.entity.PetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, String> {
}
