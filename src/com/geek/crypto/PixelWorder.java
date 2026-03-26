package com.geek.crypto;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelWorder {

    /**
     * Embeds a secret message into an image's Least Significant Bit (LSB).
     */
    public void embed(String inputPath, String outputPath, String secret) throws IOException {
        BufferedImage image = ImageIO.read(new File(inputPath));
        // Append a terminator '#' to know where the message ends
        byte[] secretBytes = (secret + "#").getBytes();
        int bitIndex = 0;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if (bitIndex < secretBytes.length * 8) {
                    int rgb = image.getRGB(x, y);

                    // Get the specific bit (0 or 1) from our secret bytes
                    int currentByte = secretBytes[bitIndex / 8];
                    int bit = (currentByte >> (7 - (bitIndex % 8))) & 1;

                    // Surgery: Modify only the last bit of the RGB value
                    // rgb & 0xFFFFFFFE zeros the last bit, then | bit sets it
                    rgb = (rgb & 0xFFFFFFFE) | bit;

                    image.setRGB(x, y, rgb);
                    bitIndex++;
                }
            }
        }
        ImageIO.write(image, "png", new File(outputPath));
        System.out.println("[Level 3] Mission Complete: Message hidden in " + outputPath);
    }

    /**
     * Extracts the hidden message by reading the LSB of each pixel.
     */
    public String extract(String imagePath) throws IOException {
        BufferedImage image = ImageIO.read(new File(imagePath));
        StringBuilder result = new StringBuilder();
        int currentByte = 0;
        int bitCount = 0;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                int bit = rgb & 1; // Grab the last bit

                // Combine 8 bits into 1 byte
                currentByte = (currentByte << 1) | bit;
                bitCount++;

                if (bitCount == 8) {
                    char c = (char) currentByte;
                    if (c == '#') return result.toString(); // Stop at terminator
                    result.append(c);
                    currentByte = 0;
                    bitCount = 0;
                }
            }
        }
        return result.toString();
    }
}