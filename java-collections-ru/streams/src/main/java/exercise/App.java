package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        List<String> freeEmails = emails.stream()
                .filter(email -> email.contains("@gmail.com") || email.contains("@yandex.ru")
                        || email.contains("@hotmail.com"))
                .collect(Collectors.toList());
        return freeEmails.size();

    }



























    /*
     Способы получения обьекта Stream

        list.stream()
        map.entrySet().stream()
        Arrays.stream(array)
        Stream.of(1,2,3)

     Операторы

       -промежуточные (конвейерные: map, filter, ...) может быть сколько угодно

        -терминальные (forEach , collect ...) может быть один
    */

}
// END
