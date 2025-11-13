/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package encryptercc;


import javax.swing.JOptionPane;

/**
 *
 * @author s
 */
// The cipher is based on the default/basic ahh caeser cipher! (aka the public domain concept cuh)
public class EncrypterCC {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        //String to take the word
         String input;
         //how many letters forward to move the input
         int encryption;
         //not setting this  to 0 for some reason triggers the else choice, not sure why
         int choiceThing=0;
         
         //lets the user choose if they are encrypting or decrypting a message
        
         choiceThing = Integer.parseInt(JOptionPane.showInputDialog("Please enter if you would like to encrypt or decrypt the message\n 1=encrypt\n2=decrypt"));
         
         //encrypt
         if(choiceThing == 1){
             input = JOptionPane.showInputDialog("please enter the word");
             //set the input to lower case so I only need to use the 97 ASCII characters
            input = input.toLowerCase();
            encryption = Integer.parseInt(JOptionPane.showInputDialog("please enter the shift"));
            //calls encryption method
             StringBuffer result = encryptionMethod(input, encryption);
             //gives answer
             JOptionPane.showMessageDialog(null, "answer for your encryption is " + result);
             //decrypt
         }if(choiceThing==2){
             input = JOptionPane.showInputDialog("please enter the word");
             //sets it to lower case so I only need ASCII 97
            input = input.toLowerCase();
            encryption = Integer.parseInt(JOptionPane.showInputDialog("please enter the shift"));
            //calls the decryption method
             StringBuffer result = decryptionMethod(input, encryption);
             JOptionPane.showMessageDialog(null, "answer for your decryption is " + result);
             //choose something else
         }if(choiceThing!=1||choiceThing!=2){
             JOptionPane.showMessageDialog(null, "you dumbass didn't type 1 or 2, wtf is wrong with yout small little tiny sad brain you fucking moronic piece of shit, holy crap I HAVE NEVER seen someone as stupid, as idiotic, as totally cretonic as you have. Your family must be on the verge of suicide from your sheer incompetence in life and everything you do. you had 2 FUCKING CHOICES AND YOU PICKED NEITHER. you want to be so special huh? well, you are, specially fucking stupid, congrats take this idiot award you fucking idiot.");
         }
         
         
          
    }
    public static StringBuffer encryptionMethod(String input, int encryption){
        //makes a string buffer for the new String being encrypted
        StringBuffer result= new StringBuffer();
          //encrypts the message letter by letter
        for (int i=0; i<input.length(); i++)
        {
          char ch = (char)(((int)input.charAt(i)));  
          //checks if the letter is a letter or a special charracter
            if(Character.isLetter(ch)){
                //converts letter to ASCII code, then moved up and down depending on the amount in encryption
                char chr = (char)(((int)input.charAt(i) + encryption - 97) % 26 + 97);
                //adds the encrypted character to the StringBuffer
                result.append(chr);
            }else{
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
            char chr = (char)(((ch - 97 - encryption + 26) % 26) + 97);
            result.append(chr);
        } else {
            // adds special characters as they are, so they don't get decrypted
            result.append(ch);
        }
    }
    //gives back the decrypted message
    return result;
}
    
    
}
    
    
    


