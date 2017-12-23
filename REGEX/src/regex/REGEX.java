/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tayyip
 */
public class REGEX {

    public static void main(String[] args) 
    {
        int temp = 0;
        Scanner sc = new Scanner(System.in);
        do
        {
            printMenu();
            temp = sc.nextInt();
            cases(temp);
            System.out.println("\nWaiting 3 sec...\n");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ex) {
                Logger.getLogger(REGEX.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(temp != -1);
        
        /*
        System.out.println("////////Started\\\\\\\\\\\\\\\\");
        
        WordList wr = new WordList("wordlist.txt");
        wr.makeFile(1);
        
        
        SearchList sl = new SearchList();
        
        System.out.println("Number of line in file out.txt :"+sl.lineFinder());
        System.out.println("Number of words in file out.txt :"+sl.wordFinder());
        sl.mostFrequent();
        System.out.println("Number of chars(without blanks) in file out.txt :"+sl.charFinder());
        sl.mostFrequentChar();
        System.out.println("Number of word ends with -ness || -less in file out.txt :"+sl.lastFourCounter());
        System.out.println("Number of words which has a or b or c on fourth character in file out.txt :"+sl.indexFourCounter());
        System.out.println("Number of palindrome words in file out.txt :"+sl.palindromeCounter());
        */
        
        
    }
    
    
    
   public static void printMenu()
   {
       System.out.println("Hello World!");
       System.out.println("--Please input a number--");
       System.out.println("0.Create the file");
       System.out.println("1.Count number of lines in the file");
       System.out.println("2.Count number of words in the file");
       System.out.println("3.Count number of chars(without blanks) in the file");
       System.out.println("4.Count and print number of word ends with -ness || -less in the file");
       System.out.println("5.Count and print number of words which has a or b or c on fourth character in the file");
       System.out.println("6.Count number of Palindrome words in the file");
       System.out.println("7.Count most frequent word and its frequency in the file");
       System.out.println("8.Count most three frequent characters and their frequency in the file");
       System.out.println("-1.Exit");
       System.out.println("Number:");
  }
  
   public static void cases(int i)
   {
       if(i == 0)
       {
           WordList wr = new WordList("wordlist.txt");
           Scanner sc = new Scanner(System.in);
           System.out.println("File size in MB :");
           
           wr.makeFile(sc.nextInt());
           System.out.println("\\\\\\\\\\\\\\\\Finished////////");
           return;
       }else
       if(i == 1)
       {
           System.out.println("////////Started\\\\\\\\\\\\\\\\");
           SearchList sl = new SearchList();
           System.out.println("Number of line in file out.txt :"+sl.lineFinder());
           System.out.println("\\\\\\\\\\\\\\\\Finished////////");
           return;
       }else
       if(i == 2)
       {
           System.out.println("////////Started\\\\\\\\\\\\\\\\");
           SearchList sl = new SearchList();
           System.out.println("Number of words in file out.txt :"+sl.wordFinder());
           System.out.println("\\\\\\\\\\\\\\\\Finished////////");
           return;
       }else
       if(i == 3)
       {
           System.out.println("////////Started\\\\\\\\\\\\\\\\");
           SearchList sl = new SearchList();
           System.out.println("Number of chars(without blanks) in file out.txt :"+sl.charFinder());
           System.out.println("\\\\\\\\\\\\\\\\Finished////////");
           return;
       }else
       if(i == 4)
       {
           System.out.println("////////Started\\\\\\\\\\\\\\\\");
           SearchList sl = new SearchList();
           System.out.println("Number of word ends with -ness || -less in file out.txt :"+sl.lastFourCounter());
           System.out.println("\\\\\\\\\\\\\\\\Finished////////");
           return;
       }else
       if(i == 5)
       {
           System.out.println("////////Started\\\\\\\\\\\\\\\\");
           SearchList sl = new SearchList();
           System.out.println("Number of words which has a or b or c on fourth character in file out.txt :"+sl.indexFourCounter());
           System.out.println("\\\\\\\\\\\\\\\\Finished////////");
           return;
       }else
       if(i == 6)
       {
           System.out.println("////////Started\\\\\\\\\\\\\\\\");
           SearchList sl = new SearchList();
           System.out.println("Number of palindrome words in file out.txt :"+sl.palindromeCounter());
           System.out.println("\\\\\\\\\\\\\\\\Finished////////");
           return;
       }else
       if(i == 7)
       {
           System.out.println("////////Started\\\\\\\\\\\\\\\\");
           SearchList sl = new SearchList();
           sl.mostFrequent();
           System.out.println("\\\\\\\\\\\\\\\\Finished////////");
           return;
       }else
       if(i == 8)
       {
           System.out.println("////////Started\\\\\\\\\\\\\\\\");
           SearchList sl = new SearchList();
           sl.mostFrequentChar();
           System.out.println("\\\\\\\\\\\\\\\\Finished////////");
           return;
       }
       return;
   }
    
}
