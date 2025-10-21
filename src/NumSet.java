import java.util.ArrayList;


public class NumSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ROUND 1 tests
        */
        
        // Create a random int array of a given length, low and high end of range
        int[] randArray = randArray(15, 0, 100);
        
        // Create a random Integer ArrayList of given length, low and high range
        ArrayList<Integer> randArrL = randArrL(8, 5, 50);
        
        // How many similar elements are in a given array and ArrayList
        System.out.print("There are this many similar elements: ");
        System.out.println(compareNums(randArray, randArrL));
        
        // printPretty takes an int array and prints it out nicely
        printPretty(randArray);
        // printPretty takes an Integer ArrayList and prints it out nicely
        printPretty(randArrL);
        
        /*
        ROUND 2 tests
        */
        
        // shuffle randomizes an int array (then calls printPretty)
        shuffle(randArray);
        
        // shuffle randomizes an Integer ArrayList (then calls printPretty)
        shuffle(randArrL);
        
        // divide all numbers by two
        divByTwo(randArray);
        divByTwo(randArrL);
        
        //sumArray
        sumArray(randArray);
        sumArray(randArrL);
        
    }
    /*
    ROUND 1 code
    */
    
    // randArray
    public static int[] randArray(int length, int low, int high){
        int[] result = new int[length];
        for(int i = 0; i < result.length; i++){
            int rand = (int)(Math.random() * (high - low + 1)) + low;
            result[i] = rand;
        }
        return result;
    }
    
    // randArrL
    public static ArrayList<Integer> randArrL(int length, int low, int high){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random() * (high - low + 1)) + low;
            result.add(rand);
        }
        return result;
    }
    
    // compareNums
    public static int compareNums(int[] arr, ArrayList<Integer> arrL){
        int count = 0;
        
        //traverse array
        for (int num1 : arr){
            if(arrL.contains(num1)) count++;
        }
        return count;
    }
    
    // prettyPretty (overloaded)
    public static void prettyPretty(int[] arr){
        //traverse and print
        for(int cycle : arr){
            System.out.println(cycle + " ");
        }
        System.out.println();
    }

    public static void prettyPretty(ArrayList<Integer> arr){
        //traverse and print
        for(int hello : arr){
            System.out.println(hello + " ");
        }
        System.out.println();
    }


    /*
    ROUND 2 code
    */
    
    // shuffle array
    public static void shuffle(int[] arr){
        //traversal with a standard for loop
        //pick a random index location 0 -> arr.length
        //THREE PART SWAP
        //copy arr[random] to a temp
        //move arr[i] to arr[random]
        //move temp to arr[i]
        int location = (int)(Math.random())
    }
    
    // TODO: shuffle ArrayList
    
    
    // TODO: divByTwo (overloaded)
    
    
    // TODO: sumArray (overloaded)
}