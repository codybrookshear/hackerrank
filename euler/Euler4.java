import java.util.Stack;

public class Euler4 {
    
    public static void main(String[] args) {
        System.out.println("largestPalindromeFromTwo3DigitNumbers: " + largestPalindromeFromTwo3DigitNumbers());
    }

    private static boolean isPalindrome(String s) {
        
        int halfLength = s.length() / 2;
        String firstHalf = s.substring(0, halfLength);
        String lastHalf;

        if (s.length() % 2 == 0) {
            // even length string splits evenly of course
            lastHalf = s.substring(halfLength);
        }
        else {
            // start one past middle if it's an odd length value
            lastHalf = s.substring(halfLength+1);
        }

        String lastHalfReversed = reverseString(lastHalf);

        if (firstHalf.compareTo(lastHalfReversed) == 0)
            return true;
        else
            return false;
    }

    private static String reverseString(String forward) {
        StringBuilder ss = new StringBuilder(forward);
        ss.reverse();
        return ss.toString();
    }

    private static String largestPalindromeFromTwo3DigitNumbers() {
        int largest = 0;
        int product;

        for (int i = 999; i > 0; i--) {
            for (int j = 999; j > 0; j--) {
                product = i * j;
                if (isPalindrome(Integer.toString(product))) {
                    if (product > largest)
                        largest = product;
                }
            }
        }

        return Integer.toString(largest);
    }
}
