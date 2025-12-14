package com.dheeraj.fileToolkit.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileWriterUtil {

    public static Path notesFilePath() {
        return FileOpsUtil.inputDir().resolve("input.txt");
    }

    // Overwrite File
    public static void writeNotesFile() throws IOException {
        String content = String.join("\n",
                "Day 1: Streams practice",
                "Day 2: FlatMap practice",
                "Day 3: Reduce practice",
                "Reminder: Fix String equals bug",
                "Goal: Be confident in Java",
                "Small wins daily",
                "Keep code clean",
                "Refactor after it works") + "\n";

        Files.writeString(notesFilePath(), content, StandardCharsets.UTF_8, StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
    }

    //Append line
    public static void appendToNotesFile() throws IOException {
        String extra = String.join("\n", "Appended: Phase A done",
                "Appended: Next -> copy/move/list",
                "Appended: Learn buffered reading") + "\n";

        Files.writeString(notesFilePath(), extra, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    // Method to create a large file for testing

    public static Path createLargeFile(Path target, long lines) throws IOException {
        try (var writer = Files.newBufferedWriter(
                target,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        )) {
            for (long i = 0; i < lines; i++) {
                writer.write("This is line number " + i);
                writer.newLine();
            }
        }
        return target;
    }
}
