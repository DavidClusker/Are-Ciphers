/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Cipher;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author peter
 */

public class NumCipher implements Cipher{//Peter Burke
    // This method will handle encryption
    @Override
    public String encrypt(String text, String key) {
        // We no longer need Scanner or user prompts here — GUI handles that part.
        // The encryption logic remains the same.
        
        StringBuilder cipher = new StringBuilder();
        
        // Convert all letters to uppercase
        String password = text.toUpperCase();
        
        // For loop to go through each character of the word
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            // if the character is a letter
            if (Character.isLetter(c)) {
                // Convert A = 1, B = 2, etc.
                int DonQuixote = c - 'A' + 1;
                cipher.append(DonQuixote).append(" ");
            } else {
                // For any non-letter characters, just add them as they are
                cipher.append(c).append(" ");
            }
        }
        // Return the cipher text (trimmed to remove trailing space)
        return cipher.toString().trim();
    }

    // This method will handle decryption
    @Override
    public String decrypt(String text, String key) {
        // Again, GUI provides the text to decrypt, so we don’t prompt the user here.
        // The decryption logic stays the same.
        
        StringBuilder decode = new StringBuilder();
        
        // Split the input numbers by spaces
        String[] encode = text.split(" ");
        
        // Loop through each number/string entered
        for (String var : encode) {
            try {
                int p = Integer.parseInt(var);
                // If the number corresponds to a valid letter (1–26)
                if (p >= 1 && p <= 26) {
                    decode.append((char) ('A' + p - 1));
                } else {
                    decode.append("invalid");
                }
            } catch (NumberFormatException e) {
                // If it's not a number, just add a space (same idea as original)
                decode.append(" ");
            }
        }
        // Return the decoded (original) message
        return decode.toString();
    }
}
