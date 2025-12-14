package com.dheeraj.fileToolkit;

import com.dheeraj.fileToolkit.io.FileOpsUtil;
import com.dheeraj.fileToolkit.io.FileReaderUtil;
import com.dheeraj.fileToolkit.io.FileWriterUtil;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            FileOpsUtil.ensureWorkspaceFolder();
            System.out.println("Folder created");

            FileWriterUtil.writeNotesFile();
            System.out.println("Written a file");

            String content = FileReaderUtil.readNotesFile();
            System.out.println("Read notes.txt ✅");
            System.out.println("----- FILE CONTENT (before append) -----");
            System.out.print(content);
            System.out.println("================Appending started=============");
            FileWriterUtil.appendToNotesFile();
            String updatedContent = FileReaderUtil.readNotesFile();
            System.out.println("Updated Content" + updatedContent);

            System.out.println("Appended text");
        } catch (Exception e) {
            System.out.println("Something failed ❌: " + e.getMessage());
            e.printStackTrace();
        }
    }
}