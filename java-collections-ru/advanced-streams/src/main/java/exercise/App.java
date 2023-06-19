package exercise;

import java.util.stream.Collectors;
import  java.util.stream.Stream;
public class App {
    public static String getForwardedVariables(String content) {
        return Stream.of(content.split("\n"))
                .filter(line -> line.startsWith("environment="))
                .map(line -> line.replace("environment=", ""))
                .map(line -> line.replaceAll("\"", ""))
                .flatMap(line -> Stream.of(line.split(",")))
                .map(String::trim)
                .filter(pair -> pair.startsWith("X_FORWARDED_"))
                .map(pair -> pair.substring("X_FORWARDED_".length()))
                .collect(Collectors.joining(","));
    }
}


