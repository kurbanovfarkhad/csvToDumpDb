package com.example.mapstructexample.util;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class CsvParser {
    public List<?> csvToPojo(String filePath, Class<?> clazz) throws IOException {
        final File csvFile = new ClassPathResource(filePath).getFile();
        CsvMapper csvMapper = new CsvMapper();

        CsvSchema csvSchema = csvMapper
                .typedSchemaFor(clazz)
                .withHeader()
                .withColumnSeparator(',')
                .withComments();

        return csvMapper
                .readerWithTypedSchemaFor(clazz)
                .with(csvSchema)
                .readValues(csvFile)
                .readAll();
    }
}
