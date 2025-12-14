package com.dheeraj.fileToolkit;

import com.dheeraj.fileToolkit.io.FileOpsUtil;
import com.dheeraj.fileToolkit.io.FileReaderUtil;
import com.dheeraj.fileToolkit.io.FileWriterUtil;

import java.nio.file.Path;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // ---- Phase A ----
            FileOpsUtil.ensureWorkspaceFolder();
            System.out.println("Created folders");

            FileWriterUtil.writeNotesFile();
            FileWriterUtil.appendToNotesFile();
            System.out.println("Wrote + appended notes.txt");

            // ---- Phase B: Copy ----
            Path notes = FileWriterUtil.notesFilePath();
            FileOpsUtil.copyToBackup(notes, "notes_backup.txt");
            System.out.println("Copied to backup");

            // ---- Phase B: Move/Rename ----
            Path moved = FileOpsUtil.moveToOutput(notes, "final_notes.txt");
            System.out.println("Moved to output as final_notes.txt");
            System.out.println("Moved file path: " + moved);

            // ---- Verify read moved file ----
            System.out.println("----- FINAL FILE CONTENT -----");
            System.out.print(FileReaderUtil.readNotesFileFrom(moved)); // add this method below

            // ---- Phase B: List ----
            System.out.println("\n===== LIST workspace (non-recursive) =====");
            FileOpsUtil.listDirectory(FileOpsUtil.workspaceRoot());

            System.out.println("\n===== LIST workspace (recursive) =====");
            FileOpsUtil.listDirectoryRecursive(FileOpsUtil.workspaceRoot());

            System.out.println("\n===== PHASE C: LARGE FILE =====");

            Path largeFile = FileOpsUtil.outputDir().resolve("big_file.txt");
            FileWriterUtil.createLargeFile(largeFile, 50_000);
            System.out.println("Large file created ✅");

            long lineCount = FileReaderUtil.countLinesStreaming(largeFile);
            System.out.println("Line count (streaming): " + lineCount);

// ---- Phase C: Safe delete ----
            System.out.println("\n===== PHASE C: SAFE DELETE =====");

            boolean deleted = FileOpsUtil.safeDelete(largeFile);
            System.out.println("Deleted big file? " + deleted);

            boolean deletedAgain = FileOpsUtil.safeDelete(largeFile);
            System.out.println("Deleted again? " + deletedAgain);


        } catch (Exception e) {
            System.out.println("Something failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}