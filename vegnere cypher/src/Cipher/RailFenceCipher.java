/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cipher;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Dev
 */
public class RailFenceCipher implements Cipher {
  @Override
    public String encrypt(String inputText, String key) {
        int inputKey;
        try {
            inputKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            return "Invalid key (must be a number).";
        }

        // We make a 2D array table to act as the "rails" and columns
        // We then set the key to rows and the input text as the columns
        char[][] railTable = new char[inputKey][inputText.length()];

        // Loop to fill the rail matrix in order to separate full spaces from blank ones
        for (int i = 0; i < inputKey; i++)
            Arrays.fill(railTable[i], '\n');

        boolean moveDown = false; // boolea to check the direction of the flow, if true move down and if false then... don't move down.
        int lat = 0, lon = 0; // latitude longitude for tables (lat = rows, long = columns

        for (int i = 0; i < inputText.length(); i++) {
            // We check the direction of the flow and if it's hitting the top or bottom row we flip the direction.
            if (lat == 0 || lat == inputKey - 1)
                moveDown = !moveDown;

            // fill the corresponding letters
            railTable[lat][lon++] = inputText.charAt(i);

            if (moveDown)
                lat++;
            else
                lat--;
        }

        // Now we have the rows and everything we can actually start using them for encryption.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputKey; i++)
            for (int j = 0; j < inputText.length(); j++)
                if (railTable[i][j] != '\n') // if the space isn't empty,
                    result.append(railTable[i][j]); // append the letter at that space.

        return result.toString(); // we then turn the whole thing back into a String.
    }

    // This is the decrypt function which needs the same key as the encryption in order to print out the original text as a String
    // and returns said String as text in the output box
    @Override
    public String decrypt(String outputCypher, String key) {
        int inputKey;
        try {
            inputKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            return "Invalid key (must be a number).";
        }

        // we're doing the exact same thing with the decryption as the encryption.
        // using different variable names because I don't want anything to interfere with anything else.
        // deRail for decrypt rail and shift down for.. shifting down.
        char[][] deRail = new char[inputKey][outputCypher.length()];

        // FILL THE MATRIX AGAIN YOU'VE SEEN ALL OF THIS BEFORE
        for (int i = 0; i < inputKey; i++)
            Arrays.fill(deRail[i], '\n');

        // shift down if true don't shift down if false
        boolean shiftDown = true;

        int row = 0, col = 0;

        // mark different saces
        for (int i = 0; i < outputCypher.length(); i++) {
            // check the direction and shift accordingly
            if (row == 0)
                shiftDown = true;
            if (row == inputKey - 1)
                shiftDown = false;

            // we use * as a marker ehre
            deRail[row][col++] = '*';

            // find the next row by checking the direction and then shifting
            if (shiftDown)
                row++;
            else
                row--;
        }

        // now the table is done and we can do the actual decrypting
        int index = 0;
        for (int i = 0; i < inputKey; i++)
            for (int j = 0; j < outputCypher.length(); j++)
                if (deRail[i][j] == '*'
                        && index < outputCypher.length())
                    deRail[i][j] = outputCypher.charAt(index++); // move letters to the marked spaces

        StringBuilder result = new StringBuilder();

        row = 0;
        col = 0;
        for (int i = 0; i < outputCypher.length(); i++) {
            // check direction
            if (row == 0)
                shiftDown = true;
            if (row == inputKey - 1)
                shiftDown = false;

            // place said marker to mark the thing
            if (deRail[row][col] != '*')
                result.append(deRail[row][col++]);

            // FIND THE NEXT ROW
            if (shiftDown)
                row++;
            else
                row--;
        }
        return result.toString();
    }
}


    

