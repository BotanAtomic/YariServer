package com.yari.core;

import com.yari.files.FilesUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Header {

    private volatile static short MAJOR_VERSION = 0;
    private volatile static short VERSION = 2;
    private static short MINOR_VERSION = 16;


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

        System.out.println("Version : " + (MAJOR_VERSION + "." + VERSION + "." + MINOR_VERSION));

        System.out.println();

        System.out.println("OS name : " + System.getProperty("os.name"));
        System.out.println("OS architecture : " + System.getProperty("os.arch"));
        System.out.println("OS version : " + System.getProperty("os.version"));

        System.out.println();

        System.out.println("Java version : " + System.getProperty("java.version"));
        System.out.println("Java vendor : " + System.getProperty("java.vendor"));
        System.out.println("Java home : " + System.getProperty("java.home"));
        System.out.println("Java Virtual Machine version : " + System.getProperty("java.vm.version"));

        System.out.println();

        System.out.println("Available processors (cores) : " + Runtime.getRuntime().availableProcessors());
        System.out.println("Free memory : " + Runtime.getRuntime().freeMemory() / 1000 + " MB");

        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Maximum memory : " + (maxMemory == Long.MAX_VALUE ? "unlimited" : maxMemory / 1000 + " MB"));

        System.out.println("Total memory available to JVM : " + Runtime.getRuntime().totalMemory() / 1000 + " MB\n");

        System.out.println("___________________________________________\n");
    }

    private static void updateVersion() throws Exception {
        Path sourcePath = Paths.get(new File("src/com/yari/core/Header.java").getAbsolutePath());

        String source = FilesUtils.readAll(sourcePath.toString());

        source = source.replace("MINOR_VERSION = " + MINOR_VERSION, "MINOR_VERSION = " + (++MINOR_VERSION));

        if (!source.isEmpty())
            Files.write(sourcePath, source.getBytes());

    }

}
