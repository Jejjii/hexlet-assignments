package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static List<String> buildApartmentList(List<Home> objects, int n) {
        return objects.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(n)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
