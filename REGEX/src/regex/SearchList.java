/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;
import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Tayyip
 */
public class SearchList {
    File file_pt = null;

    public SearchList() 
    {
            file_pt = new File(System.getProperty("user.dir").replace("\\", "/")+"/src/regex/W_out/out.txt");
    }
    
    private Scanner scannerCreator()
    {
        Scanner file = null;
        try 
        {
            file = new Scanner(file_pt);
        }
        catch (Exception e) 
        {
            System.err.println("Error :"+e);
            System.exit(1);
        }
        
        return file;
    }
    
    public long lineFinder()
    {
        long counter = 0;
        Scanner file = scannerCreator();
        while(file.hasNext() == true)
        {
            file.nextLine();
            counter++;
        }
        file.close();
        return counter;
    }
    
    public long wordFinder()
    {
        Scanner file = scannerCreator();
        long count = 0;
        while (file.hasNext() == true) 
        {

            String[] s = file.next().split(" ");

            for (int i = 0; i < s.length; i++) {
                if (!s[i].isEmpty()){
                    count++;
                }   
            }           
        }
        file.close();
       return count;
    }
    
    public long charFinder()
    {
        Scanner file = scannerCreator();
        long count = 0;
        while (file.hasNext() == true) 
        {
            String s = file.nextLine();
            count += s.length();    
        }
        file.close();
       return count;
    }
    
    public long lastFourCounter()
    {
        Scanner file = scannerCreator();
        long count = 0;
        
        while (file.hasNext() == true) 
        {

            String[] s = file.next().trim().split(" ");

            for (int i = 0; i < s.length; i++) 
            {
                if (s[i].matches(".*ness|.*less")){
                    System.out.println(s[i]);
                    count++;
                }   
            }           
        }
        file.close();
       return count;
    }
    
    public long indexFourCounter()
    {
        Scanner file = scannerCreator();
        long count = 0;
        
        while (file.hasNext() == true) 
        {

            String[] s = file.next().trim().split(" ");

            for (int i = 0; i < s.length; i++) 
            {
                if (s[i].matches("^...[abc].*")){
                    System.out.println(s[i]);
                    count++;
                }   
            }           
        }
        file.close();
       return count;
    }
    
    private boolean isPalindrome(String str) 
    {
    if(str.length() < 3)
        return false;
    return str.equals(new StringBuilder(str).reverse().toString());
    }
    
    public long palindromeCounter()
    {
        Scanner file = scannerCreator();
        long count = 0;
        while (file.hasNext() == true) 
        {

            String[] s = file.next().split(" ");

            for (int i = 0; i < s.length; i++) {
                if (isPalindrome(s[i])){
                    count++;
                }   
            }           
        }
        file.close();
       return count;
    }
    
    
    
    
    
    
    
    public void mostFrequent()
    {
       Scanner file = scannerCreator();
       
       Map<String,Double> words_count = new HashMap<String,Double>();
       while (file.hasNext() == true) 
       {
           String temp = file.nextLine().replace(".","");
           temp = temp.substring(0, 1).toLowerCase(Locale.ENGLISH) + temp.substring(1);
           String[] words = temp.split("\\s+");
            for(int i=0;i<words.length;i++)
            {
                String s = words[i];
                if(words_count.keySet().contains(s))
                {
                    Double count = words_count.get(s) + 1;
                    words_count.put(s, count);
                }
                    else
                    words_count.put(s, 1.0);
            }
       }
       
         Double frequency = null;
         String mostFrequent = null;
         for(String s : words_count.keySet())
         {
             Double i = words_count.get(s);
             if(frequency == null)
                  frequency = i;
             if(i > frequency)
             {
                  frequency = i;
                  mostFrequent = s;
             }
         }
       
       System.out.println("The most frequent word ["+ mostFrequent +"] occurred {"+ (String.format("%.0f",(frequency))) +"} times.");
        file.close();
    }
    
    public void mostFrequentChar()
    {
       Scanner file = scannerCreator();
       
       Map<Character,Double> words_count = new HashMap<Character,Double>();
       while (file.hasNext() == true) 
       {
           String temp = file.nextLine().replace(".","");
           temp = temp.substring(0, 1).toLowerCase(Locale.ENGLISH) + temp.substring(1);
           String[] words = temp.split("\\s+");
            for(int i=0;i<words.length;i++)
            {
                String s = words[i];
                for (int j = 0; j < words[i].length(); j++) {
                    Character word = words[i].charAt(j);
                    if(words_count.keySet().contains(word))
                {
                    Double count = words_count.get(word) + 1;
                    words_count.put(word, count);
                }
                    else
                    words_count.put(word, 1.0);
                }
                }
                
       }
       
         Double[] frequency = {0.0,0.0,0.0};
         Character[] mostFrequent = new Character[3];
         for(Character s : words_count.keySet())
         {
             Double i = words_count.get(s);
             for (int j = 0; j < frequency.length; j++) {
                 if(i > frequency[j])
             {
                  frequency[j] = i;
                  mostFrequent[j] = s;
                  break;
             }
                 
             }
             
         }
       
       System.out.println("The most frequent 1. char ["+ mostFrequent[0]+"] occurred {"+ (String.format("%.0f",(frequency[0]))) +"} times.");
       System.out.println("The most frequent 2. char ["+ mostFrequent[1]+"] occurred {"+ (String.format("%.0f",(frequency[1]))) +"} times.");
       System.out.println("The most frequent 3. char ["+ mostFrequent[2]+"] occurred {"+ (String.format("%.0f",(frequency[2]))) +"} times.");
        file.close();
    }
    
    
 
}
