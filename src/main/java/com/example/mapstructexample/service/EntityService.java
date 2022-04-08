package com.example.mapstructexample.service;

import com.example.mapstructexample.entity.PersonEntity;
import com.example.mapstructexample.mapper.BaseMapper;
import com.example.mapstructexample.model.ColourModel;
import com.example.mapstructexample.model.PersonModel;
import com.example.mapstructexample.util.CsvParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EntityService {

    private final CsvParser csvParser;
    private final BaseMapper mapper;


    public EntityService(CsvParser csvParser, BaseMapper<PersonEntity, PersonModel> mapper) {
        this.csvParser = csvParser;
        this.mapper = mapper;
    }

    public List<?> readFiles(Class<?> clazz) throws IOException {
        return ((List<PersonModel>) csvParser.csvToPojo("csv/person.json.csv", clazz))
                .stream()
                .map(el -> (PersonEntity) mapper.modelToEntity(el))
                .collect(Collectors.toList());
    }


}
