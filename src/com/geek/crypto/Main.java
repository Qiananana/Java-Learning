package com.geek.crypto;

/**
 * Main Application: Entry point for Crypto-Toolbox.
 * Currently testing Level 2: FileShredder (XOR Binary Processing).
 */
public class Main {
    public static void main(String[] args) {

        // Initialize FileShield with a custom secret key (e.g., 66)
        FileShield fileShield = new FileShield(66);

        // Define file paths (Use forward slashes "/" for Java compatibility)
        String inputPath = "D:/test_data/demo.jpg";
        String encryptedPath = "D:/test_data/demo_encrypted.jpg";
        String recoveredPath = "D:/test_data/demo_recovered.jpg";

        System.out.println("--- [Level 2: File Shredder Started] ---");

        // --- TASK 1: ENCRYPTION ---
        // This will scramble the file bits, making the image unreadable.
        System.out.println("[*] Encrypting: " + inputPath);
        fileShield.shred(inputPath, encryptedPath);

        // --- TASK 2: DECRYPTION ---
        // Applying XOR again with the same key restores the original bits.
        System.out.println("[*] Decrypting: " + encryptedPath);
        fileShield.shred(encryptedPath, recoveredPath);

        System.out.println("--- [All Tasks Completed Successfully] ---");
        System.out.println("[Check] Look for 'demo_recovered.jpg' in your folder!");
    }
}