package org.example.io.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;

import org.example.io.TextInputService;

public class SampleFileTextInputService implements TextInputService {
    private static final String FILE_NAME = "book.txt";

    @Override
    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(FILE_NAME);
        try (FileReader fileReader = new FileReader(Paths.get("").toAbsolutePath().toString() + "/untitled/" + file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.lines().forEach(line -> stringBuilder.append(line + " "));

            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
