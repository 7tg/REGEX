/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

/**
 *
 * @author Tayyip
 */
public class REGEX {

    public static void main(String[] args) {
        System.out.println("////////Program Started\\\\\\\\\\\\\\\\");
        WordList wr = new WordList("C:/Users/Tayyip/Desktop/Java Ödev Regular Expressions/wordlist.txt","C:/Users/Tayyip/Desktop/Java Ödev Regular Expressions/out.txt");
        wr.makeFile(100);
    }
    
}
