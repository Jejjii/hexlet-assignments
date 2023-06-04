package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> criteria) {
        List<Map<String, String>> result = new ArrayList<>();
        boolean hasMatch = false;
        for (Map<String, String> book : books) {
            if (book.entrySet().containsAll(criteria.entrySet())) {
                result.add(book);
                hasMatch = true;
            }
        }

        if (!hasMatch) {
            return Collections.emptyList();
        }
        return result;
    }
}
// END
