package exercise;

import java.util.Arrays;
import java.util.stream.Stream;



// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] array) {
        int rows = array.length;
        int columns = array[0].length;

        String[][] enlargeArray = new String[rows * 2][columns * 2];

        Stream<String[]> rowStream = Arrays.stream(array);
        Stream<String> pixelStream = rowStream.flatMap(Arrays::stream);
        String[] pixels = pixelStream.toArray(String[]::new);
        return new String[][]{pixels};
    }
}
// END


