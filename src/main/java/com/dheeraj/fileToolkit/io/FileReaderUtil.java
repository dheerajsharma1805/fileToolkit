package com.dheeraj.fileToolkit.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderUtil {
    // Read whole file content
    public static String readNotesFile() throws IOException {
        return Files.readString(FileWriterUtil.notesFilePath(), StandardCharsets.UTF_8);
    }

    public static String readNotesFileFrom(Path path) throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    public static long countLinesStreaming(Path path) throws IOException {
        long count = 0;

        try(BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }

    public static long countLinesUsingFilesLines(Path path) throws IOException {
        try (var lines = Files.lines(path, StandardCharsets.UTF_8)) {
            return lines.count();
        }
    }
}
