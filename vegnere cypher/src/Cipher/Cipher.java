package Cipher;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author David
 */
public interface Cipher {
    String encrypt(String text, String key);
     String decrypt(String text, String key);
    
    
    
}
