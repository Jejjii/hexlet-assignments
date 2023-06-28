package exercise;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> a, Map<String, Object> b) {
        Set<String> allKeys = new TreeSet<>(a.keySet());
        allKeys.addAll(b.keySet());

        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for(String key: allKeys) {
            if(b.containsKey(key) && !a.containsKey(key)) {
                result.put(key,"added");
            } else if( a.containsKey(key) && !b.containsKey(key)) {
                result.put(key,"deleted");
            } else if( a.containsKey(key) && b.containsKey(key) && a.get(key).equals(b.get(key))) {
                result.put(key, "unchanged");
            } else {
                result.put(key,"changed");
            }
        }

        return result;

    }
}
