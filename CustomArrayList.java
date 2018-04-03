/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customarraylist;

/**
 * This class behaves like an ArrayList, but uses an Array in the background. 
 * This is used as an introduction to error handling, in order to dynamically grow
 * The size of our structure
 * @author Mehdi Oulmakki
 */
public class CustomArrayList {
    // Right now this only stores Integer objects. Can we make it more generic?
    private Integer[] innerArray;
    public int size = 0;
    // Constand for the initial size of the innerArray, only used in the default constructor
    final int DEFAULT_SIZE = 5;
    
    // Default constructor
    public CustomArrayList(){
        innerArray = new Integer[DEFAULT_SIZE];
    }
    
    // Custom initial size
    public CustomArrayList(int initialSize){
        innerArray = new Integer[initialSize];
    }
    
    // Custom exception class we have created for our custom ArrayList
    // This should trigger whenever someone tries to add an element
    // That already exists in the custom ArrayList.
    class CopyCatException extends Exception{
        CopyCatException(String msg){
            super(msg);
        }
    }

    // Adds an integer to the array, resizing if there is not enough room for it
    // will throw a CopyCatException if the element is already in the innerArray
    public void add(Integer element) throws CopyCatException{
       try {
           // Throws an exception if the input already exists
           if (this.contains(element)){
               throw new CopyCatException(element + " is already in the arrayList");
           }
           // Otherwise, insert the element, and increase the size
           innerArray[size] = element;
           size++;
       } catch (IndexOutOfBoundsException e){
           // If we run out of space in the innerArray, catch the error:
           Integer[] temp = new Integer[2*size];
           for(int i = 0; i < innerArray.length; i++){
               temp[i] = innerArray[i];
           }
           innerArray = temp;
           this.add(element);
           //alternatively 
           // innerArray[size] = element; size++;
       }
    }
    
    //Modify the add methods to throw an error
    // if we put in a duplicate
    private boolean contains(Integer element){
        for(int i = 0; i < size; i++){
            if (element.equals(innerArray[i])){
                return true;
            }
        }
        return false;
    }
    
    
    
    public static void main(String[] args){
        CustomArrayList test = new CustomArrayList();
        try {
            test.add(15);
            test.add(15);
        } catch(CopyCatException e){
            System.out.println(e);
        }
    }
    
  
}
