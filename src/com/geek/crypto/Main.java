package com.geek.crypto;

import java.util.Scanner;

/**
 * Personal Crypto-Toolbox: Level 1 Interactive Mode
 * This module handles user input and demonstrates XOR encryption.
 */
public class Main {
    public static void main(String[] args) {
        // Create a scanner instance to capture user input
        Scanner scanner = new Scanner(System.in);

        // Initialize our encryption engine with a secret key (e.g., 42)
        SimpleShield shield = new SimpleShield(42);

        // --- PHASE 1: User Interaction ---
        System.out.println("=== 🛡️ Personal Crypto-Toolbox Activated ===");
        System.out.print("[?] Enter the secret message: ");

        // Capture the entire line of input
        String plainText = scanner.nextLine();

        // --- PHASE 2: Encryption ---
        System.out.println("\n[*] Encrypting data...");
        String cipherText = shield.xorTransform(plainText);
        System.out.println("[+] Ciphertext (Hex-ish): " + cipherText);

        // --- PHASE 3: Decryption (Verification) ---
        System.out.println("\n[*] Testing decryption...");
        String decryptedText = shield.xorTransform(cipherText);

        // Final Output
        System.out.println("[✔] Decryption Success: " + decryptedText);
        System.out.println("===========================================");

        // Close the resource - A must-do for Java exams!
        scanner.close();
    }
}