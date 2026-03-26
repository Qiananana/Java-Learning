package com.geek.crypto;

import java.io.IOException;

/**
 * Main Application: Testing Steganography (Level 3)
 */
public class Main {
    public static void main(String[] args) {
        PixelWorder pixelWorder = new PixelWorder();

        // Define paths for Level 3
        String originalPng = "D:/test_data/cover.png";
        String stegoPng = "D:/test_data/secret_image.png";
        String mySecret = "Java is the best language!";

        try {
            System.out.println("--- [Level 3: Steganography Mission Started] ---");

            // Step 1: Hide the message into the pixels of the image
            System.out.println("[*] Embedding secret message...");
            pixelWorder.embed(originalPng, stegoPng, mySecret);

            // Step 2: Extract the hidden message from the stego-image
            System.out.println("[*] Extracting message from pixels...");
            String discovered = pixelWorder.extract(stegoPng);

            // Output the result
            System.out.println("[Result] The hidden message was: " + discovered);
            System.out.println("--- [Mission Accomplished] ---");

        } catch (IOException e) {
            // Handle file access errors
            System.err.println("[Error] Failed to process image: " + e.getMessage());
        }
    }
}