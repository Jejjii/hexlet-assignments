package exercise;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        if( sentence.length() == 0) wordCount.clear();

        return wordCount;
    }

    public static String toString(Map<String, Integer> wordCount) {
        StringBuilder result = new StringBuilder();
        if (wordCount.size() == 0) return "{}";
        result.append("{\n");

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            result.append("  ").append(word).append(": ").append(count).append("\n");
        }

        result.append("}");

        return result.toString();
    }
}

