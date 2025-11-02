package com.jpmc.midascore;

import org.springframework.stereotype.Component;
import org.apache.commons.io.IOUtils;  // ✅ Correct import

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class FileLoader {
    public String[] loadStrings(String path) {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(path);
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found: " + path);
            }

            // Use StandardCharsets.UTF_8 for safety
            String fileText = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            return fileText.split(System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
