package com.dheeraj.fileToolkit.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOpsUtil {
    public static Path workspaceRoot() {
        return Paths.get("workspace");
    }

    public static void ensureWorkspaceFolder() throws IOException {
        Files.createDirectories(workspaceRoot().resolve("input"));
        Files.createDirectories(workspaceRoot().resolve("output"));
        Files.createDirectories(workspaceRoot().resolve("backup"));
    }
}
