package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> list) {
        List<Map<String, String>> filteredList = list.stream()
                .filter(map -> "male".equals(map.get("gender")))
                .collect(Collectors.toList());
        filteredList.sort(Comparator.comparing(m -> m.get("birthday")));
        List<String> namesOfMans = filteredList.stream()
                .map(map -> map.get("name"))
                .collect(Collectors.toList());
        return namesOfMans;
    }
}




// END
