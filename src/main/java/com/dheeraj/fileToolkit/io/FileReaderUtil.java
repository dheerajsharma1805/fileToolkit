package com.dheeraj.fileToolkit.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileReaderUtil {
    // Read whole file content
    public static String readNotesFile() throws IOException {
        return Files.readString(FileWriterUtil.notesFilePath(), StandardCharsets.UTF_8);
    }
}
