import java.util.Scanner;

public class PalindromeCheckerToolkit {

    /**
     * Approach 1: Iterative Comparison
     * Uses two pointers moving toward the center.
     * Time Complexity: O(n) | Space Complexity: O(1)
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive Comparison
     * Helper method wrapper for clean recursive bounds.
     * Time Complexity: O(n) | Space Complexity: O(n) call stack
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return recursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean recursiveHelper(String text, int left, int right) {
        // Base case: converged or crossed mid-point
        if (left >= right) {
            return true;
        }
        // Base case: mismatch found
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        // Recursive step: shrink bounds
        return recursiveHelper(text, left + 1, right - 1);
    }

    /**
     * Approach 3: Array Reversal
     * Converts to char array, reverses it manually, and compares.
     * Time Complexity: O(n) | Space Complexity: O(n) for new array
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        // Fill reversed array
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        // Compare original string with reversed array contents
        return text.equals(new String(reversed));
    }

    /**
     * Normalizes text by removing non-alphanumeric characters and lowercasing.
     * Essential for evaluating phrases like "A man, a plan, a canal: Panama".
     */
    public static String normalize(String input) {
        if (input == null) return "";
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("   QA Text Verification Toolkit: Palindromes ");
        System.out.println("=========================================\n");

        System.out.print("Enter text to verify: ");
        String rawInput = scanner.nextLine();

        // Sanitize input for fair evaluation
        String sanitized = normalize(rawInput);

        // Execute all 3 checks
        boolean resIterative = isPalindromeIterative(sanitized);
        boolean resRecursive = isPalindromeRecursive(sanitized);
        boolean resArrayRev = isPalindromeArrayReversal(sanitized);

        // Format single-line output
        String iterLabel = resIterative ? "Palindrome" : "Not Palindrome";
        String recurLabel = resRecursive ? "Palindrome" : "Not Palindrome";
        String arrayLabel = resArrayRev ? "Palindrome" : "Not Palindrome";

        System.out.printf("\nIterative: %s | Recursive: %s | Array Reversal: %s\n",
                iterLabel, recurLabel, arrayLabel);

        // QA Assert Logic
        boolean allAgree = (resIterative == resRecursive) && (resRecursive == resArrayRev);
        System.out.println("---------------------------------------------------------");
        System.out.println("Verification Status: " + (allAgree ? "PASSED (All approaches agree)" : "FAILED (Mismatch detected)"));
        System.out.println("=========================================");

        scanner.close();
    }
}