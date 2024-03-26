
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * The purpose of this class is to solve for any given n, output the sequence of corners visited along a walk of the
 * n-dimensional hypercube
 *
 * The main method runs some tests.
 *
 */

public class Hypercube {

    private static int n;
    private static int o;
    private static boolean initialCase = true;
    static ArrayDeque<Integer> current = new ArrayDeque<>();

    /**
     * Prompts the user to set the dimension of the hypercube and validates the input.

     */
    public static void setHypercube(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Please enter the desired Hypercube dimension (ex. 3): ");
            int hypercubeDimension = scanner.nextInt();
            o = hypercubeDimension - 1;

            if (hypercubeDimension >= 3 && hypercubeDimension <= 5){
                // Data input check, validating it's within parameters specified.
                n = hypercubeDimension;
                break;
            }

            else{
                System.out.println(" Hypercube dimensions must be between 3 and 5");
            }
        }
        scanner.close();
    }


    public class Corner{
        public Corner(){

        }
    }
    /**
     * This method initiates the recursive exploration of the n-dimensional hypercube.
     *
     * @param n The dimension of the hypercube being explored.
     */
    private static void recursiveWalk(int n){
        System.out.println("Recursive Walk for n = " + n);
        // Call to helper method.
        recursiveWalkHelper(current, n);
    }

    /**
     * This method is a recursive helper for exploring the corners of an n-dimensional hypercube.

     * @param current The current state of the hypercube being explored.
     * @param n The dimension of the hypercube being explored.
     */
    private static void recursiveWalkHelper(ArrayDeque<Integer> current, int n){
        if (n == 0) {
            recursiveWalkHelperTwo(current, o, initialCase);
            Output(current);
        } else {
            current.add(0);
            recursiveWalkHelper(current, n - 1); // Recursive case 1
            current.removeLast();

            current.add(1);
            recursiveWalkHelper(current, n - 1); // Recursive case 2
            current.removeLast();
        }
    }

    /**
     * This method recursively converts the binary representation of the current state of the hypercube
     * into Gray code.
     *
     * @param current The current state of the hypercube being converted to Gray code.
     * @param o The dimension of the hypercube being converted.
     * @param initialCase A flag indicating whether the conversion is in its initial case.
     */
    public static void recursiveWalkHelperTwo(ArrayDeque<Integer> current, int o, boolean initialCase){

        if(initialCase){
            current.addLast(current.peekFirst()); // Add front to last.
            initialCase = false;
        }

        if (o == 0){
            current.removeFirst();
        }
        else{
            int first = current.removeFirst(); // Remove first element
            current.addLast(first ^ current.peekFirst()); // XOR
            recursiveWalkHelperTwo(current, o - 1, initialCase); // Recursive case
        }
    }

    /**
     * This method initiates the iterative exploration of the n-dimensional hypercube.
     *
     * @param n The dimension of the hypercube being explored.
     */
    private static void iterativeWalk(int n) {

        System.out.println("Iterative Walk for n = " + n);

        ArrayDeque<Integer> current = new ArrayDeque<>();
        // Modification of bits to output coordinates based on n dimension cube.
        for (int i = 0; i < Math.pow(2, n); i++) {
            for (int j = n - 1; j >= 0; j--) {
                int bit = (i >> j) & 1;
                current.add(bit);
            }

            if (current.size() == n) {
                // Call the binary to Gray conversion function
                iterativeWalkHelper(current);
                Output(current);
                int currentSize = current.size();
                for(int k = 0; currentSize > k; k++){
                    current.removeFirst();
                }
            }
        }
    }

    /**
     * This method iteratively converts the binary representation of the current state of the hypercube
     * into Gray code.
     *
     * @param current The current state of the hypercube being converted to Gray code.
     */
    private static void iterativeWalkHelper(ArrayDeque<Integer> current){

        current.addLast(current.peekFirst()); //Add front to last

        for(int i = 0; i < current.size() - 2; i++){
            int first = current.removeFirst(); // Remove first element
            current.addLast(first ^ current.peekFirst()); // XOR
        }
        current.removeFirst();
    }
    /**
     * This method prints the current state of the hypercube as a sequence of corners.
     *
     * @param current The current state of the hypercube to be printed.
     */
    private static void Output(ArrayDeque<Integer> current){

        for(int path : current){
            System.out.print(path);
        }
        System.out.println();
    }

    /**
     * Running some tests
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        setHypercube();
        recursiveWalk(n);
        iterativeWalk(n);
    }
}