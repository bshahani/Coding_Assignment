import java.util.Arrays;

/**
 * The class provides a method to rotate an integer array to the left by a given number of positions.
 * It also includes some test cases to demonstrate the usage of the method.
 * @author Bhavika Shahani
 */
public class LeftRotateArray {

    /**
     * main() method that runs the test cases to demonstrate the usage of the rotateArray method.
     * @param args An array of command-line arguments
     */
    public static void main(String[] args) {

        //test 1
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Test 1.");
        rotateArray(array, 2);
        System.out.println("The array with 2 positions to rotate is "+Arrays.toString(array));
        System.out.println();

        //test 2
        System.out.println("Test 2.");
        rotateArray(array, 8);
        System.out.println("The array with 8 positions to rotate is "+Arrays.toString(array));
        System.out.println();

        //test 3
        System.out.println("Test 3.");
        rotateArray(array, 2147483647); //highest int value - 2147483647
        System.out.println("The array with 2147483647 positions to rotate is "+Arrays.toString(array));
        System.out.println();
    }

    /**
     * rotateArray() method takes an integer array and a rotation count as input,
     * and rotates the array to the left by the given number of positions.
     * If the rotation count is negative or the array is empty,
     * the method prints an error message and returns without performing any operations.
     * @param array The integer array to be rotated.
     * @param rotationCount The number of positions by which the array should be rotated to the left.
     *
     */
    public static void rotateArray(int[] array, int rotationCount) {

        if (rotationCount < 0) {
            System.out.println("The positions to rotate cannot be negative. Please try again with a non-negative value.");
            return;
        }

        if (array.length == 0) {
            System.out.println("The array cannot be empty. Please try again with valid input array.");
            return;
        }

        //the number of rotations we need to perform,
        // after each array.length number of rotations,
        // array.length+1 th rotation is same as 1st rotation.
        rotationCount = rotationCount % array.length;

        for (int k = 0; k < rotationCount; k++) {
            int firstElement = array[0];
            for (int i = 0; i < array.length-1; i++) {
                array [i] = array[i + 1];
            }
            array[array.length - 1] = firstElement;
        }
    }

}