/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cipher;

import javax.swing.JOptionPane;
    
/**
 *
 * @author simon
 */
public class CeaserCipher implements Cipher {
@Override
    public String encrypt(String input, String key) {
        //set the input to lower case so I only need to use the 97 ASCII characters
        input = input.toLowerCase();
        int encryption = 0;

        try {
            encryption = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            //if the key isn’t valid, return an error message
            return "Invalid shift key (must be a number).";
        }

        //calls encryption method
        StringBuffer result = encryptionMethod(input, encryption);
        //gives back the answer
        return result.toString();
    }

    //decrypt
    @Override
    public String decrypt(String input, String key) {
        //sets it to lower case so I only need ASCII 97
        input = input.toLowerCase();
        int encryption = 0;

        try {
            encryption = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            //if the key isn’t valid, return an error message
            return "Invalid shift key (must be a number).";
        }

        //calls the decryption method
        StringBuffer result = decryptionMethod(input, encryption);
        //gives back the decrypted message
        return result.toString();
    }

    public static StringBuffer encryptionMethod(String input, int encryption) {
        //makes a string buffer for the new String being encrypted
        StringBuffer result = new StringBuffer();
        //encrypts the message letter by letter
        for (int i = 0; i < input.length(); i++) {
            char ch = (char) (((int) input.charAt(i)));
            //checks if the letter is a letter or a special charracter
            if (Character.isLetter(ch)) {
                //converts letter to ASCII code, then moved up and down depending on the amount in encryption
                char chr = (char) (((int) input.charAt(i) + encryption - 97) % 26 + 97);
                //adds the encrypted character to the StringBuffer
                result.append(chr);
            } else {
                //special characters get added without encryption
                result.append(ch);
            }
        }
        //gives back the encrypted message
        return result;
    }

    public static StringBuffer decryptionMethod(String input, int encryption) {
        // convert everything to lowercase
        input = input.toLowerCase();
        //new StringBuffer
        StringBuffer result = new StringBuffer();
        //goes through letter by letter
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            //checks if the character being decrypted is a letter
            if (Character.isLetter(ch)) {
                char chr = (char) (((ch - 97 - encryption + 26) % 26) + 97);
                result.append(chr);
            } else {
                // adds special characters as they are, so they don't get decrypted
                result.append(ch);
            }
        }
        //gives back the decrypted message
        return result;
    }

    //verify the input is an int rather than string
    private static Boolean verifyThis(String verify) {
        //have to set this as true bc otherwise I get red line on return :(
        Boolean verified = true;

        //checks the entire thing is an int, and no letter snuck in
        for (int i = 0; i < verify.length(); i++) {
            //verificatiooooooooooonnnnnnnn
            char num = verify.charAt(i);
            if (Integer.parseInt(verify) == 0) {
                //makes 0 being invalid bc that number sucks
                verified = false;
                return verified;
            }
            if (Character.isDigit(num)) {

                //other numbers are fine or smth, so yh
                verified = true;

            } else {
                //none numbers getting DENIED YHH WE HATING
                verified = false;
                break;
            }
        }
        //sends back the boolean
        return verified;
    }
}
    

