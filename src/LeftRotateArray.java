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

        try {
            //test 1
            int[] array1 = {1, 2, 3, 4, 5, 6, 7};

            System.out.println("Test 1.");
            rotateArray(array1, 2);
            System.out.println("The array with 2 positions to rotate is "+Arrays.toString(array1));
            System.out.println();

            //test 2
            int[] array2 = {1, 2, 3, 4, 5, 6, 7};

            System.out.println("Test 2.");
            rotateArray(array2, 8);
            System.out.println("The array with 8 positions to rotate is "+Arrays.toString(array2));
            System.out.println();

            //test 3
            int[] array3 = {1, 2, 3, 4, 5, 6, 7};
            System.out.println("Test 3.");
            rotateArray(array3, 2147483647); //highest int value - 2147483647
            System.out.println("The array with 2147483647 positions to rotate is "+Arrays.toString(array3));
            System.out.println();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Rotates the input integer array to the left by the given number of positions.
     * @param array The integer array to be rotated.
     * @param rotationCount The number of positions by which the array should be rotated to the left.
     * @throws IllegalArgumentException If rotationCount is negative or the input array is empty.
     */
    public static void rotateArray(int[] array, int rotationCount) {

        if (rotationCount < 0) {
            throw  new IllegalArgumentException("The positions to rotate cannot be negative. Please try again with a non-negative value.");
        }

        if (array.length == 0) {
           throw  new IllegalArgumentException("The array cannot be empty. Please try again with valid input array.");
        }

        //the number of rotations we need to perform,
        // after each array.length number of rotations,
        // array.length+1 th rotation is same as 1st rotation.
        rotationCount = rotationCount % array.length;

        if (rotationCount == array.length)
            return; //no need to perform rotation

        //reverse array to the rotationCount index
        reverseArray(0, rotationCount - 1, array);

        //reverse the remaining array
        reverseArray(rotationCount, array.length - 1, array);

        //reverse the entire array
        reverseArray(0, array.length - 1, array);

    }

    /**
     * Reverses the portion of the input integer array between the start and end indices (inclusive).
     * @param start The index at which to start reversing the array.
     * @param end The index at which to stop reversing the array.
     * @param array The integer array to be reversed.
     * @throws IllegalArgumentException If start or end index is invalid (less than 0 or greater than the array length)
     */
    public static void reverseArray(int start, int end, int[] array) {
        //swap each element of the array starting
        // from left with element starting from right
        while (start < end) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            end--;
            start++;
        }
    }

}