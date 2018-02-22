/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// You will need this
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Mehdi Oulmakki
 */
public class FileDemo {

    /**
     * 
     */
    public static void main(String[] args) {      

        // Feel fee to change this to any file on your computer
        // You should find a file called Copy_Of_{initial file name}
        // in your project folder, with the exact same content.
        copyFile("TestFile.txt");
    }
    
    // We want this method to create a new file, copying all the content
    // of some input file there.


    public static void copyFile(String fileName){
        // Remember to be polite! wrap your FileIO code in a try/catch block
        try {
            // In this problem, we do not care about the content of the file
            // We simply want to copy 0s and 1s from one location to another
            
            // Open the input file here 
            FileInputStream input = new FileInputStream(fileName);
            // Create and open the output file here
            FileOutputStream output = new FileOutputStream("Copy_Of_" + fileName);

            // Let's read the content of the file. note that the read() method of
            // FileInputStream returns an int 
            int content= input.read();

            // input.read() will return -1 once we are done with the file, so that
            // would be a good condition to end our loop
            while (content != -1){
                // copy the content
                output.write(content);
                // update the content variable
                // note here that internally, the FileInputStream object is tracking
                // how much we've read. so each call to the read() method will return
                // the next byte of data, until we finish the file.
                content = input.read();
           }

           // Be polite, close the files when you are done with them
           input.close();
           output.close();
        } catch (IOException e){
            // Basic catch, where we will just print the error
            System.out.println(e); 
        }
    }
}
