/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuredemos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mehdi Oulmakki
 */
public class TweetArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> out = parseTweets("tweets.txt");
        
        System.out.println(out.size());
        
        for(String word : out){
            System.out.println(word);
        }
    }
    
    public static ArrayList<String> parseTweets(String fileName){
        // We create our container
        ArrayList<String> output = new ArrayList();
        
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
                    if (!output.contains(word)){
                        output.add(word);
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
