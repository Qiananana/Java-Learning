package com.geek.crypto;

public class SimpleShield {

    private int secretKey;

    public SimpleShield(int secretKey) {
        this.secretKey = secretKey;
    }

    public String xorTransform(String input) {
        StringBuilder result = new StringBuilder(); // Prepare a "container"
        char[] chars = input.toCharArray(); // Break down the input text

        // Traverse the array and perform "black box calculation"
        for (char c : chars) {
            char encryptedChar = (char) (c ^ secretKey);
            result.append(encryptedChar);
        }

        // Convert the StringBuilder to a regular String and return it
        return result.toString();
    }
}