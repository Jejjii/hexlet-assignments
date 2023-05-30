package exercise;

import java.util.HashMap;
import java.util.Map;

class App {

    public static Map<String, Integer> getWordCount(String sentence) {
        Map <String, Integer> wordCounts = new HashMap<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            if(wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1); // 2 параметр это значение ключа, он вернет сначала 1
                // и добавит еще +1, в значение
            } else {
                wordCounts.put(word, 1); //если слова нет, то значению ключа(word) присвоит 1
            }
        }
        return wordCounts;
    }

    public static String toString (Map<String,Integer> wordCounts) {
        StringBuilder strB = new StringBuilder("{");
        for(Map.Entry<String, Integer> entry :wordCounts.entrySet()) {
            strB.append(entry.getKey()).append(": ").append(entry.getValue());
            System.out.println();
        }
        strB.append("}");
        return strB.toString();
    }
}

