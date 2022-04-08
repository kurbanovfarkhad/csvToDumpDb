package com.example.mapstructexample;

import com.example.mapstructexample.entity.PersonEntity;
import com.example.mapstructexample.model.PersonModel;
import com.example.mapstructexample.service.EntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
/**
 * first case: different fieldNames
 * - wil throw exception
 *   Unknown property "name" in result type PersonEntity. Did you mean "surname"?
 * annotation @Mapping determine target field and source field
 */
/**
 * second case: if unmapped field exist
 * - will throw exception "unmapped property"
 *   Unmapped field will trigger exception
 *   @Mapper Annotation arguments unmappedSourcePolicy and unmappedTargetPolicy will check all fields to be mapped
 */
/**
 *  third case:
 */
@SpringBootApplication
public class MapStructExampleApplication {

    private final EntityService entityService;

    public MapStructExampleApplication(EntityService entityService) {
        this.entityService = entityService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MapStructExampleApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStart() throws IOException {
        System.out.println(entityService.readFiles(PersonModel.class));
    }
}
