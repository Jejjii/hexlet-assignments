package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import exercise.InMemoryKV;
public class App {

    public static void swapKeyValue(KeyValueStorage map) {
        KeyValueStorage swappedMap = new InMemoryKV(new HashMap<>());

        // Заполняем swappedMap, меняя местами ключи и значения из исходного map
        for (Map.Entry<String, String> entry : map.toMap().entrySet()) {
            String key = entry.getValue();
            String value = entry.getKey();
            swappedMap.set(key, value);
        }

        // Очищаем исходный map
        for (String key : map.toMap().keySet()) {
            map.unset(key);
        }

        // Заполняем исходный map значениями из swappedMap
        for (Map.Entry<String, String> entry : swappedMap.toMap().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            map.set(key, value);
        }
    }
}