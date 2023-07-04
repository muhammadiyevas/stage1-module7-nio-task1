package com.epam.mjc.nio;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        Path path = Path.of(file.getPath());
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                if (line.startsWith("Name: ")) {
                    profile.setName(line.substring(6));
                } else if (line.startsWith("Age: ")) {
                    profile.setAge(Integer.parseInt(line.substring(5)));
                } else if (line.startsWith("Email: ")) {
                    profile.setEmail(line.substring(7));
                } else if (line.startsWith("Phone: ")) {
                    profile.setPhone(Long.parseLong(line.substring(7)));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile;
    }
}
