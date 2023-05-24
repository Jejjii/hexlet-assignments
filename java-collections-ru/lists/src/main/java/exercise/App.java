package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(char[] symbols, String word) {

        List <Character> charList = new ArrayList<>();
        for( char symbol: symbols) {
            charList.add(symbol);
        }
        List<Character> list = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        return list.contains(charList);
    }
}
//END
