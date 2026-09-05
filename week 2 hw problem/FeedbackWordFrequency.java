import java.util.*;

public class FeedbackWordFrequency {

    static void printFilteredWordFrequency(String feedback) {
        String[] stopWordArray = {"the", "was", "and", "a", "is", "of", "in"};
        Set<String> stopWords = new HashSet<>(Arrays.asList(stopWordArray));

        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(".", "").replace(",", "");

        String[] words = cleaned.split("\\s+");

        Map<String, Integer> countMap = new LinkedHashMap<>();

        for (String word : words) {
            if (word.trim().isEmpty()) continue;
            if (stopWords.contains(word)) continue;

            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(countMap.entrySet());
        sortedEntries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
        // great: 2
        // mentor: 1
        // session: 1
        // clear: 1
    }
}