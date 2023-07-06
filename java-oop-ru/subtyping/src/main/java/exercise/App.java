package exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import exercise.InMemoryKV;
public class App {

    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> originalMap = storage.toMap()   ;
        Map<String, String> swappedMap = new HashMap<>();

        for (Map.Entry<String, String> entry : originalMap.entrySet()) {
            String key = entry.getValue();
            String value = entry.getKey();
            swappedMap.put(key, value);
        }

        for (String key : originalMap.keySet()) {
            storage.unset(key);
        }

        for (Map.Entry<String, String> entry : swappedMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            storage.set(key, value);
        }
    }

}
