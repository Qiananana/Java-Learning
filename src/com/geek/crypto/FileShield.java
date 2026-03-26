package com.geek.crypto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Level 2: FileShredder
 * High-performance XOR-based file encryption module.
 */
public class FileShield {
    private final int secretKey;

    public FileShield(int secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Processes the source file and saves the XOR-transformed data to the destination.
     * Works for both encryption and decryption.
     */
    public void shred(String sourcePath, String destPath) {
        // Use try-with-resources to ensure streams are closed automatically
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {

            byte[] buffer = new byte[1024 * 4]; // 4KB buffer for better I/O performance
            int bytesRead;

            // Stream processing loop
            while ((bytesRead = fis.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    buffer[i] = (byte) (buffer[i] ^ secretKey);
                }
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("[OK] File processed successfully.");

        } catch (IOException e) {
            System.err.println("[Error] I/O failure: " + e.getMessage());
        }
    }
}