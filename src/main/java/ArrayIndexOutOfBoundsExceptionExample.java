public class ArrayIndexOutOfBoundsExceptionExample {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[3]); // This will throw an ArrayIndexOutOfBoundsException
    }

}


/**
 *
 * Issue:
 *
 * The array numbers has only 3 elements (indices 0, 1, and 2). Trying to access numbers[3] throws an ArrayIndexOutOfBoundsException because the index is out of range.
 *
 * Fix:
 *
 * Always ensure the index is within the bounds of the array.
 *
 *if (numbers.length > 3) {
 *     System.out.println(numbers[3]);
 * } else {
 *     System.out.println("Index out of bounds!");
 * }
 */