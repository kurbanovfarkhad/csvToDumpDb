package com.example.mapstructexample.service;

import com.example.mapstructexample.entity.ColourEntity;
import com.example.mapstructexample.entity.PersonEntity;
import com.example.mapstructexample.entity.PetEntity;
import com.example.mapstructexample.mapper.BaseMapper;
import com.example.mapstructexample.model.BaseModel;
import com.example.mapstructexample.model.ColourModel;
import com.example.mapstructexample.model.PersonModel;
import com.example.mapstructexample.model.PetModel;
import com.example.mapstructexample.repository.ColourRepository;
import com.example.mapstructexample.repository.PersonRepository;
import com.example.mapstructexample.repository.PetRepository;
import com.example.mapstructexample.util.CsvParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityService<E,T> {

    private final CsvParser csvParser;
    private final BaseMapper<PetEntity, PetModel> petMapper;
    private final BaseMapper<ColourEntity, ColourModel> colourMapper;
    private final BaseMapper<PersonEntity, PersonModel> personMapper;
    private final ColourRepository colourRepository;
    private final PetRepository petRepository;
    private final PersonRepository personRepository;


    public EntityService(CsvParser csvParser, BaseMapper<PetEntity, PetModel> petMapper, BaseMapper<ColourEntity, ColourModel> colourMapper, BaseMapper<PersonEntity, PersonModel> personMapper, ColourRepository colourRepository, PetRepository petRepository, PersonRepository personRepository) {
        this.csvParser = csvParser;
        this.petMapper = petMapper;
        this.colourMapper = colourMapper;
        this.personMapper = personMapper;
        this.colourRepository = colourRepository;
        this.petRepository = petRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public List<?> readColourFiles(Class<? extends BaseModel> clazz, String filePath) throws IOException {
        final List<?> objects = csvParser.csvToPojo(filePath, clazz);
        objects
                .stream()
                .map(el -> (ColourEntity)colourMapper.modelToEntity((ColourModel) el))
                .forEach(el ->{
                    colourRepository.save(el);
                });
        return objects;
    }

    @Transactional
    public List<?> readPetFiles(Class<? extends BaseModel> clazz, String filePath) throws IOException {
        final List<?> objects = csvParser.csvToPojo(filePath, clazz);
        objects
                .stream()
                .map(el -> {
                    return (PetEntity) petMapper.modelToEntity((PetModel) el);
                })
                .forEach(el ->{
                    petRepository.save(el);
                });
        return objects;
    }

    @Transactional
    public List<?> readPersonFiles(Class<? extends BaseModel> clazz, String filePath) throws IOException {
        final List<?> objects = csvParser.csvToPojo(filePath, clazz);
        objects
                .stream()
                .map(el -> {
                    return (PersonEntity) personMapper.modelToEntity((PersonModel) el);
                })
                .forEach(el ->{
                    final ColourEntity col = el.getFavoriteColour();
                    final ColourEntity colourEntity = colourRepository.findById(col.getId()).get();
                    final List<PetEntity> pets = el.getPets().stream()
                            .map(pet -> {
                                final String id = pet.getId();
                                return petRepository.findById(id).orElse(null);
                            })
                            .collect(Collectors.toList());
                    el.setFavoriteColour(colourEntity);
                    el.setPets(pets);
                    personRepository.save(el);
                });
        return objects;
    }


}
