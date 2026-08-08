import java.util.Scanner;

public class NewsroomCopyEditor {

    /**
     * Finds the shortest and longest words in a given text string.
     * 
     * @param text The sentence or paragraph to analyze
     * @return String array where index 0 is the shortest word and index 1 is the longest word
     */
    public static String[] findShortestAndLongestWord(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new String[]{"", ""};
        }

        // Split text by non-word characters (spaces, punctuation, tabs, etc.)
        String[] words = text.trim().split("[^a-zA-Z0-9]+");

        if (words.length == 0) {
            return new String[]{"", ""};
        }

        String shortest = words[0];
        String longest = words[0];

        // Loop through all words to update shortest and longest
        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            if (word.length() < shortest.length()) {
                shortest = word;
            }

            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence or paragraph: ");
        String text = scanner.nextLine();

        String[] result = findShortestAndLongestWord(text);

        if (!result[0].isEmpty() && !result[1].isEmpty()) {
            System.out.println("Shortest: \"" + result[0] + "\" (" + result[0].length() + ") | " +
                               "Longest: \"" + result[1] + "\" (" + result[1].length() + ")");
        } else {
            System.out.println("No valid words found in the input.");
        }

        scanner.close();
    }
}