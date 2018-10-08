package com.yari.files;

import com.yari.utils.ExceptionManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesUtils {

    public static String readAll(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            ExceptionManager.register(e);
            return "";
        }
    }

}
