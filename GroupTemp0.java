/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grouptemp0;

import java.util.Scanner;

/**
 *
 * @author peter
 */

public class GroupTemp0 {//Peter Burke
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println(" THE NUMERICAL CYPHER 20 8 5   14 21 13 5 18 9 3 1 12   3 25 16 8 5 18 ");
            System.out.println("press 1 to encrypt or 2 to decrypt ");
            int num;
            try{
                num=Integer.parseInt(input.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Error try again");
                continue;
            }
            switch (num) {
                case 1:
                    System.out.println("Input your word: ");
                    String password = input.nextLine().toUpperCase();
                    StringBuilder cipher = new StringBuilder();
                    for (int i = 0; i < password.length(); i++){
                        char c = password.charAt(i);
                        if(Character.isLetter(c)){
                            int DonQuixote = c - 'A' + 1;
                             cipher.append(DonQuixote).append(" ");
                        }else{
                            cipher.append(c).append(" ");
                        }
                    }
                    System.out.println("Numerical cipher: " + cipher.toString().trim());
                    break;
                case 2:
                    System.out.println("Enter the numbers with spaces between to distinguish");
                    String[] encode = input.nextLine().split(" ");
                    StringBuilder decode = new StringBuilder();
                    for (String var : encode) {
                        try{
                            int p = Integer.parseInt(var);
                            if(p >= 1 && p<=26){
                                decode.append((char)('A'+p-1));
                            }else{decode.append("invalid");}}
                        catch(NumberFormatException e){
                                decode.append(" ");
                                }
                        
                    }System.out.println("The coded word was "+ decode.toString());
                    break;
                  
                    default:
                    System.out.println("Please choose a valid option (1–3).");
                    
                    
            }
        }
      
            
        
    }
}
