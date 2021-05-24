package com.herokuapp.restfulbooker.data;

import java.io.File;
import java.nio.file.Paths;

public enum Files {

    CREDENTIALS("credentials.json"),
    REQUEST("new-booking.json");

    private final File file;


    Files(String fileName) {
        this.file = Paths.get("src", "test", "resources", fileName).toFile();
    }

    public File getFile() {
        return file;
    }
}