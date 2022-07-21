package org.example.io.impl;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;

import org.example.io.StatisticsOutputService;
import org.example.statistics.model.TextStatistics;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileStatisticsOutputService implements StatisticsOutputService {
    private final static String OUTPUT_FILE_NAME = "statistics.json";

    @Override
    public void save(TextStatistics statistics) {
        // TODO
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(statistics);
            File file = new File(Paths.get("").toAbsolutePath().toString() + "/untitled/" + OUTPUT_FILE_NAME);
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new JsonFileStatisticsOutputService().save(new TextStatistics());
    }
}
