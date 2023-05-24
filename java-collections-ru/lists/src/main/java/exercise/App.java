package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
// BEGIN
public class App {
    public static boolean scrabble(String tiles, String word) {
        char[] tileChars = tiles.toLowerCase().toCharArray();
        char[] wordChars = word.toLowerCase().toCharArray();

        int[] tileCounts = new int[26];

        for (char tileChar : tileChars) {
            tileCounts[tileChar - 'a']++;
        }

        for (char wordChar : wordChars) {
            if (tileCounts[wordChar - 'a'] <= 0) {
                return false;
            }
            tileCounts[wordChar - 'a']--;
        }

        return true;
    }
}
//END
