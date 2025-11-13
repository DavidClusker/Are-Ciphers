package Cipher;

import java.util.ArrayList;
import java.util.List;

// this code uses the letters and unicode of those letters to function
//it is always using A as the letter/ number to bounce off
// the unicode number for A is 65, the unicode number for k is 75 as the letter A is the start and lowest value it will never go below zero
//so the mathamaticle logic behind the code is e.g. 75-65=10 or K-A= shift value
// you are always left with a range of 0-25
//this is the logic behind my VigenereCipher hope i made it correctly

public class VigenereCipher implements Cipher{
 @Override
    public String encrypt(String message, String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return "Keyword cannot be empty!";
        }

        // Remove non-letter characters and convert to uppercase
        message = message.replaceAll("[^A-Za-z]", "").toUpperCase();
        keyword = keyword.replaceAll("[^A-Za-z]", "").toUpperCase();

        // Create shift values from the keyword (b=0, a=1,c=2,d=7 etc)
        //Example for the Keyword key, we get the shift values 10,4,24
        //meaning k=10, e=4, and y= 24
        List<Integer> shiftValues = new ArrayList<>();
        for (char k : keyword.toCharArray()) {//depending on the keyword the shift values will chnage according to 
            //which ever character in the keyword come first
            shiftValues.add(k - 'A');
        }

        StringBuilder ciphertext = new StringBuilder();

        // Encrypt each character
        for (int i = 0; i < message.length(); i++) {
            char p = message.charAt(i);
            int shift = shiftValues.get(i % shiftValues.size());
            char c = (char) (((p - 'A' + shift) % 26) + 'A');
            ciphertext.append(c);
        }

        return ciphertext.toString();
    }

    @Override
    // logic behind the decryption is straight forward enough
    //you decrypt by shifting backwards in the alphabet
    public String decrypt(String ciphertext, String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return "Keyword cannot be empty!";
        }

        ciphertext = ciphertext.toUpperCase();
        keyword = keyword.toUpperCase();

        StringBuilder plaintext = new StringBuilder();
        int keyIndex = 0;

        // Decrypt each character matches accordenig too how many shifts were needed
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);

            if (Character.isLetter(c)) {
                char k = keyword.charAt(keyIndex % keyword.length());
                int shift = k - 'A';
                char p = (char) (((c - 'A' - shift + 26) % 26) + 'A');// shifting backwards in the alphabet 
                plaintext.append(p);
                keyIndex++;
            } else {
                plaintext.append(c);
            }
        }

        return plaintext.toString();
    }
}

/*

public class VigenereCipher {
    public String encrypt(String plaintext, String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return "Keyword cannot be empty!";
        }

        // Remove non-letter characters and convert to uppercase
        plaintext = plaintext.replaceAll("[^A-Za-z]", "").toUpperCase();
        keyword = keyword.replaceAll("[^A-Za-z]", "").toUpperCase();

        // Create shift values from the keyword (b=0, a=1,c=2,d=7 etc)
        // Example for the Keyword key, we get the shift values 10,4,24
        // meaning k=10, e=4, and y=24
        List<Integer> shiftValues = new ArrayList<>();
        for (char k : keyword.toCharArray()) { 
            // depending on the keyword the shift values will change according to 
            // whichever character in the keyword comes first
            shiftValues.add(k - 'A');
        }

        StringBuilder ciphertext = new StringBuilder();

        // Encrypt each character
        for (int i = 0; i < plaintext.length(); i++) {
            char p = plaintext.charAt(i);
            int shift = shiftValues.get(i % shiftValues.size());
            char c = (char) (((p - 'A' + shift) % 26) + 'A');
            ciphertext.append(c);
        }

        return ciphertext.toString();
    }

    // logic behind the decryption is straightforward enough
    // you decrypt by shifting backwards in the alphabet
    public String decrypt(String ciphertext, String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return "Keyword cannot be empty!";
        }

        ciphertext = ciphertext.toUpperCase();
        keyword = keyword.toUpperCase();

        StringBuilder plaintext = new StringBuilder();
        int keyIndex = 0;

        // Decrypt each character matches according to how many shifts were needed
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);

            if (Character.isLetter(c)) {
                char k = keyword.charAt(keyIndex % keyword.length());
                int shift = k - 'A';
                char p = (char) (((c - 'A' - shift + 26) % 26) + 'A'); // shifting backwards in the alphabet 
                plaintext.append(p);
                keyIndex++;
            } else {
                plaintext.append(c);
            }
        }

        return plaintext.toString();
    }
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VigenereCipher cipher = new VigenereCipher();

        System.out.print("Enter the message to encrypt: ");
        String plaintext = scanner.nextLine();

        System.out.print("Enter the keyword: ");
        String keyword = scanner.nextLine();

        // Encrypt the message
        String encrypted = cipher.encrypt(plaintext, keyword);
        System.out.println("\nEncrypted Message: " + encrypted);

        
        String decrypted = cipher.decrypt(encrypted, keyword);
        System.out.println("Decrypted Message: " + decrypted);

        scanner.close();
    }
*/
