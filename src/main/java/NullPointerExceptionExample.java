public class NullPointerExceptionExample {




    public static void main(String[] args) {
        String text = null;
        System.out.println(text.length()); // This will throw a NullPointerException
    }



}

/**
 * ssue:
 *
 * The variable text is null, and we’re trying to call the length() method on it. This will throw a NullPointerException because you can’t call methods on a null object.
 *
 * Fix:
 *
 * Always check if an object is null before calling methods on it.
 * if (text != null) {
 *     System.out.println(text.length());
 * } else {
 *     System.out.println("Text is null!");
 * }
 *
 * or you can assign a default value to the variable text
 */