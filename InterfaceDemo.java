
/**
 * Basic demonstration of interface usage.
 * @author Mehdi Oulmakki
 */

// This is our basic interface. It implements no default behavior,
// but sets a contract for us: All classes that implement it MUST have a print() method.
interface Printable{
    void print();
}

// Demo1 implements Printable.
// Demo1 objects can also dance!
class Demo1 implements Printable {
    public void dance(){
       System.out.println("I'm dancing!");
    }
    public void print(){
       System.out.println("Hello this is demo 1");
   } 
}

// Demo2 implements Printable.
// Demo2 objects can also sing!
class Demo2 implements Printable {
    public void sing(){
        System.out.println("I'm singing!");
    }
    public void print(){
        System.out.println("This is demo 2");
    }
}

// Demo3 implements Printable.
class Demo3 implements Printable {
    public void print(){
        System.out.println("This is demo 3");
    }
}

// This is where we dome our code: 

public class InterfaceDemo {
    public static void main(String[] args){
        // x is a Demo1 object. It can print, and it can dance
        Demo1 x = new Demo1();
        x.print();
        x.dance();
        
        // y is declared as a Printable, but we use the Demo2 constructor!
        // This is legal, and we can make y print
        Printable y = new Demo2();
        y.print();
        // Uncomment the line below, and see what happens though
        // y.sing();
        
        // we declare Printable z, but use the Demo3 constructor
        Printable z = new Demo3();
        
        // We can even have a Printable array to put all these objects in.
        Printable[] printableArray = {y, z};
        
        // We can then print each element in the array, even if at the end of the day, they
        // are all different classes
        printableArray[0].print();
        printableArray[1].print();
    
    }
}
