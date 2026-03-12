import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method 1: Iterative Approach
    public static boolean isPalindromeIterative(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Method 2: Recursive Approach
    public static boolean isPalindrome(String str, int start, int end) {

        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return isPalindrome(str, start + 1, end - 1);
    }

    // Method 3: Reverse String Method
    public static boolean isPalindromeReverse(String str) {

        String reversed = new StringBuilder(str).reverse().toString();

        return str.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Iterative Method Timing
        long startTime1 = System.nanoTime();
        boolean result1 = isPalindromeIterative(input);
        long endTime1 = System.nanoTime();

        // Recursive Method Timing
        long startTime2 = System.nanoTime();
        boolean result2 = isPalindrome(input, 0, input.length() - 1);
        long endTime2 = System.nanoTime();

        // Reverse Method Timing
        long startTime3 = System.nanoTime();
        boolean result3 = isPalindromeReverse(input);
        long endTime3 = System.nanoTime();

        System.out.println("\nResults:");

        System.out.println("Iterative Method: " + result1 +
                " | Time: " + (endTime1 - startTime1) + " ns");

        System.out.println("Recursive Method: " + result2 +
                " | Time: " + (endTime2 - startTime2) + " ns");

        System.out.println("Reverse Method: " + result3 +
                " | Time: " + (endTime3 - startTime3) + " ns");

        scanner.close();
    }
}