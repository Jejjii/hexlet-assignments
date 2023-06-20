import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static <T> LinkedHashMap<String, String> genDiff(Map<String, T> a, Map<String, T> b) {
        Set<String> allKeys = a.keySet();
        allKeys.addAll(b.keySet());

        return allKeys.stream()
                .collect(Collectors.toMap(
                        key -> key,
                        key -> {
                            if (!a.containsKey(key)) {
                                return "added";
                            } else if (!b.containsKey(key)) {
                                return "deleted";
                            } else if (a.get(key).equals(b.get(key))) {
                                return "unchanged";
                            } else {
                                return "changed";
                            }
                        },
                        (oldValue, newValue) -> newValue,
                        LinkedHashMap::new
                ));
    }
}

