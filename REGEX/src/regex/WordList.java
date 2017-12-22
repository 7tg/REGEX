/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author Tayyip
 */
public class WordList {
    //Initilazing
    private long count = 0;
    
    Scanner dictionary = null;
    
    StringBuilder dictionaryBuilder = null;
    
    PrintWriter  out = null;
    
    File dic = null;

public WordList(String dic_file_location,String out_file_location) {
        dic = new File(dic_file_location);
        try{
        out = new PrintWriter(out_file_location,"UTF-8");
        dictionary = new Scanner(dic);
        dictionaryBuilder = new StringBuilder();
        }catch(Exception e)
        {
            System.err.println("Error :"+e);
            System.exit(1);
        }   
}
private String[] makeDic()
{
    System.out.println("+++Generating Dictionary+++");
    String[] Dictionary = null;
    while(dictionary.hasNext() == true)
        {
            try
            {
                dictionaryBuilder.append(dictionary.nextLine());
                dictionaryBuilder.append(System.lineSeparator());
            }catch(Exception e)
            {
                System.err.println("Error!!");
            }       
        }
    System.out.println("---Finished dictionary file reading---");
    String temp = dictionaryBuilder.toString();
    Dictionary = temp.split("\n");
    System.out.println("+++Dictionary completed+++");
    return Dictionary;
}

public boolean makeFile(long file_size)
{
   file_size = file_size*(1024*1024);
   String[] dictionary = makeDic();
   
   System.out.println("\n+++File creation started+++");
   
   int counter = 1;
   for (; count <= file_size;)
   {
   int random = ((int)(20*Math.random()+10));
   StringBuilder sb = new StringBuilder();
   for (int i = 0; i < random; i++) {
        String temp = dictionary[(int)(dictionary.length*Math.random())].trim();
        count += temp.length();
        
        
        
        if(i == 0)
        {
        temp = temp.substring(0, 1).toUpperCase(Locale.ENGLISH) + temp.substring(1);
        sb.append(temp+" ");
        count += 1;
        }
        else if (i == random-1)
        {
        sb.append(temp+"."+System.lineSeparator());
        count += 2;
        }
        else
        {
        sb.append(temp+" ");
        count += 1;
        }
        
        if((((count/(1024*1024)) % (100*counter)) == 0) && (count >= (1024*1024)))
        {
            System.out.println("---Checkpoint file is "+(count/(1024*1024))+"MB---");
            counter++;
        }
        
    }
   String cumle = sb.toString();
   out.print(cumle);
   }
   out.close();
    System.out.println("+++Creating file is OK+++");
    return true; 
}
    
    
    
    
}