/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Mehdi Oulmakki
 */
public class TweetHashMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, Integer> out = parseTweets("tweets.txt");
        
        System.out.println(out.size());
        
        // There are many ways to iterate over a HashMap
        // Check out the following Stack Overflow link for more info:
        // https://stackoverflow.com/a/35558955
        for(String word : out.keySet()){
            // print the word (that's our keys) followed by the number mapped to it
            System.out.println(word + " " + out.get(word));
        }
        
        // Let's see what happens between Mauritius and Rwanda
        System.out.println(out.getOrDefault("Mauritius", 0) + out.getOrDefault("#Mauritius", 0));
        System.out.println(out.getOrDefault("Rwanda", 0) + out.getOrDefault("#Rwanda", 0));
    }
    
    public static HashMap<String, Integer> parseTweets(String fileName){
        // We create our container
        HashMap<String, Integer> output = new HashMap();
        
        try {
            // We open our file
            FileReader temp = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(temp);
            
            // read a whole line from the file
            String line = reader.readLine();
            
            // readLine returns null when the file is over, so let's keep going 
            // while it is not null
            while (line != null){
                // At this point, line is a String that contains many words. 
                // Let's break it up:
                
                String[] words = line.split(" ");
                // Now we add each word to the output, but we need to be careful:
                for (String word : words){
                    if (output.containsKey(word)){
                        output.replace(word, output.get(word) + 1);
                    } else {
                        output.put(word, 1);
                    }
                }
                // update line
                line = reader.readLine();
            }
            
            // We are done reading, let's close the file
            reader.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return output;
    }
}
