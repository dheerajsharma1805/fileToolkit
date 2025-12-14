package com.dheeraj.fileToolkit.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class FileOpsUtil {
    public static Path workspaceRoot() {
        return Paths.get("workspace");
    }

    public static Path inputDir() {
        return workspaceRoot().resolve("input");
    }

    public static Path outputDir() {
        return workspaceRoot().resolve("output");
    }

    public static Path backupDir() {
        return workspaceRoot().resolve("backup");
    }

    public static void ensureWorkspaceFolder() throws IOException {
        Files.createDirectories(workspaceRoot().resolve("input"));
        Files.createDirectories(workspaceRoot().resolve("output"));
        Files.createDirectories(workspaceRoot().resolve("backup"));
    }

    // Copy file
    public static Path copyToBackup(Path sourceFile, String backupFileName) throws IOException {
        Path target = backupDir().resolve(backupFileName);
        return Files.copy(sourceFile, target, StandardCopyOption.REPLACE_EXISTING);
    }

    // Move or Rename File
    public static Path moveToOutput(Path sourceFile, String newFileName) throws IOException {
        Path target = outputDir().resolve(newFileName);
        return Files.move(sourceFile, target, StandardCopyOption.REPLACE_EXISTING);
    }

    // List (non-recursive)
    public static void listDirectory(Path dir) throws IOException {
        try(Stream<Path> paths = Files.list(dir)) {
            paths.forEach(path -> System.out.println(path.toString()));
        }
    }

    // List (Recursive)
    public static void listDirectoryRecursive(Path dir) throws IOException {
        try(Stream<Path> paths = Files.walk(dir)) {
            paths.forEach(path -> System.out.println(path.toString()));
        }
    }

    public static boolean safeDelete(Path path) throws IOException {
        return Files.deleteIfExists(path);
    }
}
