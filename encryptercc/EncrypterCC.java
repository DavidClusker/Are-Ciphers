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
// The cipher logic is based on the classical shift cipher (public domain concept).
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
         //used to take the input
         String verify;
         //tests if the input is actually what needed
         boolean tested;
         
         
         //lets the user choose if they are encrypting or decrypting a message
         verify = JOptionPane.showInputDialog("Please enter if you would like to encrypt or decrypt the message\n 1=encrypt\n2=decrypt");
         // checks if the input is 1 or 2
         tested = verifyThis(verify);
         //if statement to see if the veirification is good, if good sets the option
         if(tested){
             choiceThing = Integer.parseInt(verify);
         }else{
             //tells the user that the code is not working
             JOptionPane.showMessageDialog(null,"Please enter a NUMBER greater than 0.");
         }
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
             
         }if(tested == true){
             //extra bit of code to not show the message when inputing a string instead of int
         if(choiceThing!=1 && choiceThing!=2){
             JOptionPane.showMessageDialog(null, "Should have picked 1 or 2. Dumbass.");
         }
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
//verify the input is an int rather than string
    private static Boolean verifyThis(String verify) {
       //have to set this as true bc otherwise I get red line on return :(
        Boolean verified = true;
        
        //checks the entire thing is an int, and no letter snuck in
        for(int i = 0; i < verify.length() ; i++){
            //verificatiooooooooooonnnnnnnn
            char num = verify.charAt(i);
            if(Integer.parseInt(verify)==0){
                    //makes 0 being invalid bc that number sucks
            verified = false;
            return verified;
                }
            if(Character.isDigit(num)){
                
                    //other numbers are fine or smth, so yh
                verified = true;
                
            }else{
                //none numbers getting DENIED YHH WE HATING
                verified = false;
                break;
            }
        }
        //sends back the boolean
        return verified;
    }
    
    
    
}




