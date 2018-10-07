package com.yari.core;

import com.yari.files.FilesUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Header {

    private volatile static short MAJOR_VERSION = 0;
    private volatile static short VERSION = 2;
    private static short MINOR_VERSION = 2;


    static void show() throws Exception {
        System.out.println("      ___           ___           ___                 \n" +
                "     |\\__\\         /\\  \\         /\\  \\          ___   \n" +
                "     |:|  |       /::\\  \\       /::\\  \\        /\\  \\  \n" +
                "     |:|  |      /:/\\:\\  \\     /:/\\:\\  \\       \\:\\  \\ \n" +
                "     |:|__|__   /::\\~\\:\\  \\   /::\\~\\:\\  \\      /::\\__\\\n" +
                "     /::::\\__\\ /:/\\:\\ \\:\\__\\ /:/\\:\\ \\:\\__\\  __/:/\\/__/\n" +
                "    /:/~~/~    \\/__\\:\\/:/  / \\/_|::\\/:/  / /\\/:/  /   \n" +
                "   /:/  /           \\::/  /     |:|::/  /  \\::/__/    \n" +
                "   \\/__/            /:/  /      |:|\\/__/    \\:\\__\\    \n" +
                "                   /:/  /       |:|  |       \\/__/    \n" +
                "                   \\/__/         \\|__|                \n" +
                "\n");

        updateVersion();

    }

    private static void updateVersion() throws Exception {

        Path sourcePath = Paths.get(new File("src/com/yari/core/Header.java").getAbsolutePath());

        String source = FilesUtils.readAll(sourcePath.toString());

        source = source.replace("MINOR_VERSION = " + MINOR_VERSION, "MINOR_VERSION = " + (++MINOR_VERSION));

        if (!source.isEmpty())
            Files.write(sourcePath, source.getBytes());

    }

}
