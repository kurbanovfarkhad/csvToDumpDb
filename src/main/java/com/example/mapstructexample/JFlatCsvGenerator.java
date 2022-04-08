package com.example.mapstructexample;

import com.github.opendevl.JFlat;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Generate csv by using json data
 */
public class JFlatCsvGenerator {
    public static void main(String[] args) throws Exception {
        final String resource = "src/main/resources/";
        final List<String> names = listFilesForFolder(new File(resource + "json"));
        for (String name : names) {
            System.out.println(name);
            final String s = new String(Files.readAllBytes(Paths.get(resource+"json/" +name)));
            new JFlat(s).json2Sheet().headerSeparator("_").write2csv(resource + "csv/" +name+".csv");
        }
    }

    public static List<String> listFilesForFolder(final File folder) {
        final ArrayList<String> strings = new ArrayList<>();
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                strings.add(fileEntry.getName());
            }
        }
        return strings;
    }
}
