package com.geek.crypto;

/**
 * Main entry point for the Crypto-Toolbox project.
 * Demonstrates the Basic XOR encryption (Level 1).
 */
public class Main {
    public static void main(String[] args) {

        // 1. Initialize the shield with a specific key
        // A 'Shield' is our encryption engine instance
        SimpleShield shield = new SimpleShield(42);

        // 2. The original message we want to protect
        String plainText = "Hello World!";
        System.out.println("Original: " + plainText);

        // 3. Encrypt the message
        // Using the same method for encryption/decryption due to XOR nature
        String cipherText = shield.xorTransform(plainText);
        System.out.println("Encrypted (Cipher): " + cipherText);

        // 4. Decrypt the message back to original
        String decryptedText = shield.xorTransform(cipherText);
        System.out.println("Decrypted: " + decryptedText);

    }
}