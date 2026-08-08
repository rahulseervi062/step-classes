 import java.util.Scanner;

public class UniqueLetterHunt {

    /**
     * Finds the first character in the input string that does not repeat.
     * 
     * @param text The input string to scan
     * @return The first non-repeating character, or '\0' if none exists
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        int[] charCounts = new int[256];

        // Step 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            charCounts[ch]++;
        }

        // Step 2: Scan left to right for the first unique character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (charCounts[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String input = scanner.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        scanner.close();
    }
}